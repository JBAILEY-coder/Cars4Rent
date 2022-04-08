/*
String Module = "Object Oriented Programming";
String Occurrence = "UE2";
String Tutor = "Tyrone Edwards";
Dictionary Programmers = new Hashtable();
Programmers.put("2008135", "J'Nelle Bailey");
Programmers.put("2005741", "Kayla Mullings");
Programmers.put("2008217", "Janique Graham");
Programmers.put("1800902", "Nicholas Thomas");
*/
package Cars4Rent;

import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

//methods with Input Mismatch Exceptions prompt the user to enter an integer, if a string is entered the exception is thrown therefore it is caught at a higher level method
public class Main {
    static String[] dates = null; //dates array that is going to contain the date the vehicle was borrowed
    static LinkedList<Vehicle> car = new LinkedList<>(); //object list for cars
    static LinkedList<Vehicle> truck = new LinkedList<>(); //object list for trucks
    static LinkedList<Vehicle> bike = new LinkedList<>(); //object list for bikes
    static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //days array that contains the number of days in each month

    //--------------------------------------------------------------------------
    static String viewVehicle() {
        String nice = null;
        try {
            Scanner input = new Scanner(System.in);
            car.clear(); //clears the lists
            bike.clear();
            truck.clear();
            int rowCount;
            File file1 = new File("Vehicles.xlsx");
            FileInputStream data1 = new FileInputStream(file1);
            XSSFWorkbook wb = new XSSFWorkbook(data1);
            XSSFSheet sheet = wb.getSheetAt(0);
            rowCount = sheet.getFirstRowNum();
            for (Row ignored : sheet) {//counts and iterates the rows, ignored is used as the variable is not accessed but used
                if (rowCount == 17) { //17 rows in the Excel file, any more iteration creates a null error
                    break;
                }
                Cell typeOfVehicle = sheet.getRow(rowCount).getCell(1); //gets the vehicle type
                Cell rented = sheet.getRow(rowCount).getCell(15); //gets the rental status
                if (!String.valueOf(rented).equals("Rented")) { //if the status is "Not Rented" then call the add to object list function so that the user may rent a vehicle
                    addToObjectList(typeOfVehicle, rowCount);
                }
                data1.close();
                wb.close();
                ++rowCount;
            }
            nice = outputVehicles();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nice;
    }

    //--------------------------------------------------------------------------
    static void addToObjectList(Cell typeOfVehicle, int rowCount) { //function to add the objects to their lists
        try {
            String[] property = new String[16];
            File file1 = new File("Vehicles.xlsx");
            FileInputStream data1 = new FileInputStream(file1);
            XSSFWorkbook wb = new XSSFWorkbook(data1);
            XSSFSheet sheet = wb.getSheetAt(0);
            Vehicle vehicle;
            if (String.valueOf(typeOfVehicle).equals("Car")) { //if the type of vehicle Cell is equal to the word Car
                for (int i = 0; i < 16; i++) {//17 columns exist in the Excel file therefore the index goes from 0 to 16
                    Cell fileInformation = sheet.getRow(rowCount).getCell(i); //Gets each column from the cell and places it in file information
                    property[i] = (String.valueOf(fileInformation)); //places a string copy of file information into the property array
                }
                //uses polymorphism to create a new car object
                vehicle = new Car(property[0], property[2], property[3], property[4], property[5], property[6], property[7], property[8], property[9], property[10], property[15], (int) Double.parseDouble(property[11]), new InteriorType(property[14])); //not rented and leather are placeholders
                car.add(vehicle); //adds the object to the car list
            }
            if (String.valueOf(typeOfVehicle).equals("Truck")) {
                for (int i = 0; i < 16; i++) {
                    Cell fileInformation = sheet.getRow(rowCount).getCell(i);
                    property[i] = (String.valueOf(fileInformation));
                }
                //uses polymorphism to create a new Truck object
                vehicle = new Truck(property[0], property[2], property[3], property[4], property[5], property[6], property[7], property[8], property[9], property[10], property[15], (int) Double.parseDouble(property[11]), new InteriorType(property[14]), property[12]);
                truck.add(vehicle); //adds the object to the truck list
            }
            if (String.valueOf(typeOfVehicle).equals("Bike")) {
                for (int i = 0; i < 16; i++) {
                    Cell fileInformation = sheet.getRow(rowCount).getCell(i);
                    property[i] = (String.valueOf(fileInformation));
                }
                //uses polymorphism to create a new Bike object
                vehicle = new Bike(property[0], property[2], property[3], property[4], property[5], property[6], property[7], property[8], property[9], property[10], property[15], (int) Double.parseDouble(property[11]), (int) Double.parseDouble(property[13]));
                bike.add(vehicle); //adds the object to the bike list
            }
            data1.close();
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //---------------------------------------------------- ----------------------
    /*static void searchVehicle() {
        Scanner input = new Scanner(System.in);
        int choice;
        String criteria, licensePlateNumber;
        System.out.println("How would you like to search for the vehicle?\n1. License Plate #\n2. Brand\n3. Model\n4. Year\n5. Interior\n");
        choice = input.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("Enter the license plate number: \n");
                input.nextLine(); //clears the buffer
                criteria = input.nextLine().toUpperCase();
                findVehicle(criteria, choice);
                outputVehicles();
                //adds the vehicle to the rental file and change the status in the excel file to rented
                System.out.println("Are you renting this vehicle? ");
                String answer = input.nextLine().toLowerCase();
                if(answer.equals("yes")){
                    try{
                        //rentVehicle(criteria);
                    }catch(InputMismatchException e){
                        System.out.println("Error! Invalid Input");
                    }
                }
            }
            case 2,3,4,5 -> {
                if(choice == 2){
                    System.out.println("Enter the brand of the vehicle: ");
                }else if(choice == 3){
                    System.out.println("Enter the vehicle model: ");
                }else if(choice == 4){
                    System.out.println("Enter the vehicle year: ");
                }else if(choice == 5){
                    System.out.println("Enter the vehicle's interior: ");
                }
                input.nextLine();

                if(choice == 4){
                    criteria = input.nextLine() + ".0"; //add .0 to the end of the user input
                }else{
                    criteria = input.nextLine();
                    criteria = criteria.substring(0, 1).toUpperCase() + criteria.substring(1).toLowerCase(); //gets the first letter of the word and converts it to uppercase, gets the rest of the letters and converts them to lowercase
                }

                choice++;
                //System.out.println(criteria);
                findVehicle(criteria, choice);
                outputVehicles();
                System.out.println("Are you renting a vehicle? ");
                String answer = input.nextLine().toLowerCase();
                if(answer.equals("yes")){
                    System.out.println("Enter the license Plate of the vehicle to be rented: ");
                    licensePlateNumber = input.nextLine().toUpperCase();
                    try{
                        //rentVehicle(licensePlateNumber);
                    }catch(InputMismatchException e){
                        System.out.println("Error! Invalid Input");
                    }
                }
            }
        }
    }*/
    //--------------------------------------------------------------------------
    static int myRental(String customerName) {
        int check = 0;
        try {
            File file = new File("rental.ctb");
            FileInputStream data = new FileInputStream(file);
            InputStreamReader stream = new InputStreamReader(data);
            BufferedReader read = new BufferedReader(stream);
            String line;
            String[] line1;
            car.clear(); //clears the lists
            bike.clear();
            truck.clear();
            while ((line = read.readLine()) != null) {
                line1 = line.split("\t"); //contains the line
                if (line1[1].toUpperCase().equals(customerName)) {
                    check = 1;
                    try {
                        int rowCount;
                        File file1 = new File("Vehicles.xlsx");
                        FileInputStream data1 = new FileInputStream(file1);
                        XSSFWorkbook wb = new XSSFWorkbook(data1);
                        XSSFSheet sheet = wb.getSheetAt(0);
                        rowCount = sheet.getFirstRowNum();
                        for (Row ignored : sheet) {//counts and iterates the rows
                            if (rowCount == 17) {
                                break;
                            }
                            Cell cell2Search = sheet.getRow(rowCount).getCell(0); //search the columns
                            Cell typeOfVehicle = sheet.getRow(rowCount).getCell(1);
                            if (line1[0].equals(String.valueOf(cell2Search))) {
                                addToObjectList(typeOfVehicle, rowCount);
                                break;
                            }
                            ++rowCount;
                        }
                        data1.close();
                        wb.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            data.close();
            stream.close();
            read.close();
        } catch (IOException e) {
            System.out.println("Error! File does not exist");
        } catch (NullPointerException e) {
            System.out.println("Error! Null Value exists");
        }
        return check;
    }

    //--------------------------------------------------------------------------
    static String[] returnVehicle(String licensePlate, String returnDate, String currentMile) throws InputMismatchException, ArrayIndexOutOfBoundsException { //Returns the vehicle to the Excel file and removes it from the rental file
        String[] values = new String[5];
        String[] dates1 = null;
        String[] returnDate1;
        int currentMileage;
        int check = 0;
        int sum = 0, sum1 = 0;
        Scanner input = new Scanner(System.in);
        returnDate1 = returnDate.split("/");
        currentMileage = Integer.parseInt(currentMile);
        int deposit = 0;
        String st, ratePerDay = null;
        try {
            File file = new File("rental.ctb");
            FileInputStream data = new FileInputStream(file);
            InputStreamReader stream = new InputStreamReader(data);
            BufferedReader read = new BufferedReader(stream);
            String[] words, time;
            while ((st = read.readLine()) != null) {
                words = st.split("\t"); //contains the line
                if (words[0].equals(licensePlate)) {
                    deposit = Integer.parseInt(words[6]);
                    check = 1;
                    dates = words[4].split("/"); //places the date the vehicle was borrowed into the array format 0,1,2
                    dates1 = words[5].split("/"); //places the date that the vehicle is expected to be returned into an array with / delimiter
                    read.close();
                    stream.close();
                    data.close();
                    try {
                        //only entered if the vehicle is found in the rental file
                        int rowCount;
                        File file1 = new File("Vehicles.xlsx");
                        FileInputStream data1 = new FileInputStream(file1);
                        XSSFWorkbook wb = new XSSFWorkbook(data1);
                        XSSFSheet sheet = wb.getSheetAt(0);
                        rowCount = sheet.getFirstRowNum();
                        for (Row ignored : sheet) {//counts and iterates the rows
                            if (rowCount == 17) {
                                break;
                            }
                            Cell update = sheet.getRow(rowCount).getCell(9); //mileage in the file
                            Cell cell2Update = sheet.getRow(rowCount).getCell(0); //the column to be searched
                            Cell update1 = sheet.getRow(rowCount).getCell(15); //gets the rental status of the row
                            if (licensePlate.equals(String.valueOf(cell2Update))) { //if the License Plate that the user provided matches the License Plate in the Excel file
                                Cell rate = sheet.getRow(rowCount).getCell(11); //gets the rate Per day of the vehicle
                                ratePerDay = String.valueOf(rate); //converts the rate to a string from the data type cell
                                update.setCellValue(currentMileage); //updates the current Mileage cell
                                //update rental status here as well
                                update1.setCellValue("Not Rented");
                                data1.close();
                                FileOutputStream outFile = new FileOutputStream(file1);
                                wb.write(outFile); //writes the new information to the Excel file
                                outFile.close();
                                wb.close();
                                break;
                            }
                            ++rowCount;
                        }
                        data1.close();
                    } catch (IOException e) {
                        System.out.println("Error! File does not exist");
                        break;
                    } catch (NullPointerException e) {
                        //e.printStackTrace();
                        System.out.println("Null Value Exists");
                        break;
                    } catch (Exception e) {
                        System.out.println("Error! Unknown error occurred");
                        break;
                    }
                    break; //finds the car in the rental file
                }
            }
            if (check == 0) {
                read.close();
                stream.close();
                data.close();
            } else { //if the vehicle was found, calculate the days the vehicle was supposed to be rented
                for (int i = Integer.parseInt(dates[1]); i < Integer.parseInt(dates1[1]); i++) { //gets the days between the borrowed date and the expected return date
                    if ((leapYear(Integer.parseInt(dates[2]))) == 1) { //if the year is a leap year, dates[2] which holds the numbers of days for february is now 29 instead of 28
                        days[1] = 29;
                    }
                    if (i == Integer.parseInt(dates[1])) { //if i is equal to the borrowed date day, subtract the borrowed day from the total days in the month, that is our starting value
                        sum = days[i - 1] - Integer.parseInt(dates[0]) + 1;
                    } else {
                        sum += days[i - 1]; //else, add the days in the rest of the month except for the month the vehicle was returned
                    }
                    if (i == (Integer.parseInt(dates1[1]) - 1)) { //if i is equal to the month the vehicle was returned, the final sum is equal to the days leading up to the month, plus the amount of days in the month until the vehicle was returned
                        sum += Integer.parseInt(dates1[0]);
                    }
                }
                //if car is returned before
                //dates = borrowed
                //dates1 = returned
                //return date = today's date
                if (((Integer.parseInt(dates1[1])) >= (Integer.parseInt(returnDate1[1]))) && (((Integer.parseInt(dates1[0])) >= (Integer.parseInt(returnDate1[0]))) || ((Integer.parseInt(dates1[0])) <= (Integer.parseInt(returnDate1[0]))))) { //if the month is less or the day in the month is less
                    sum = 0; //disregard the sum up until the expected return date and starts over
                    for (int i = Integer.parseInt(dates[1]); i <= Integer.parseInt(returnDate1[1]); i++) { //while the borrowed month is less than the returned month
                        if (Integer.parseInt(returnDate1[1]) == Integer.parseInt(dates[1])) { //if the return day month is equal to the borrowed month
                            sum = Integer.parseInt(returnDate1[0]) - Integer.parseInt(dates[0]); //then the total days is the days subtracted and the program breaks
                            break;
                        }
                        if ((leapYear(Integer.parseInt(dates[2]))) == 1) {
                            days[1] = 29;
                        }
                        if (i == Integer.parseInt(dates[1])) { //If i is equal to the borrowed month
                            sum = days[i - 1] - Integer.parseInt(dates[0]); //sum is equal to the days in the month subtracted from the borrowed day
                        } else {
                            if (i == (Integer.parseInt(returnDate1[1]))) { //if i is equal to the month the vehicle was returned
                                sum += Integer.parseInt(returnDate1[0]); //add the number of days left and break the program
                                break;
                            } else { //else add the days in the months
                                sum += days[i - 1]; //otherwise, add the days in the months
                            }
                        }
                        if (i == (Integer.parseInt(dates1[1]) - 1)) { //if i is equal to the month the car was returned then add the days left and break the program
                            sum += Integer.parseInt(returnDate1[0]);
                            break;
                        }
                    }
                }
                //if car is returned after (DAYS LATE)
                if ((Integer.parseInt(returnDate1[1]) >= Integer.parseInt(dates1[1])) && ((Integer.parseInt(returnDate1[0]) >= Integer.parseInt(dates1[0]))) || ((Integer.parseInt(returnDate1[1]) >= Integer.parseInt(dates1[1])) && (Integer.parseInt(returnDate1[0]) >= Integer.parseInt(dates1[0])))) { //return Date is when it was returned, Dates1 is when it was expected
                    for (int i = Integer.parseInt(dates1[1]); i <= Integer.parseInt(returnDate1[1]); i++) { //counts from the month it was suppose to be returned until the month it was returned
                        if ((Integer.parseInt(dates1[0])) == Integer.parseInt(returnDate1[0]) && (Integer.parseInt(dates1[1])) == Integer.parseInt(returnDate1[1])) { //if the day and the month are the same
                            sum1 += 0; //late sum is 0 and the program breaks
                            break;
                        }
                        if ((Integer.parseInt(dates1[1]) == Integer.parseInt(returnDate1[1])) && ((Integer.parseInt(dates1[0])) < (Integer.parseInt(returnDate1[0])))) { //if the month are the same but the actual return day is greater than the expected return day
                            sum1 += Integer.parseInt(returnDate1[0]) - Integer.parseInt(dates1[0]);
                            break;
                        }
                        if (i == (Integer.parseInt(dates1[1]))) {  //if i is equal to the expected return month
                            sum1 += days[i - 1] - Integer.parseInt(dates1[0]); //subtract the total days in the month by the expected return day (begins counting after)
                        } else {//if not
                            sum1 += days[i - 1]; //add the days in the month
                        }
                        if (i == (Integer.parseInt(returnDate1[1]) - 1)) { //if i is equal to 1 less than the actual return date
                            sum1 += Integer.parseInt(returnDate1[0]); //it doesn't add the days of the month but instead counts up to the day it was returned
                            break;
                        }
                    }
                }
                //if car is returned on the day it was borrowed
                if ((Integer.parseInt(dates[0]) == Integer.parseInt(returnDate1[0])) && (Integer.parseInt(dates[1]) == Integer.parseInt(returnDate1[1]))) {
                    sum = 1;
                }
                try {
                    FileInputStream data1 = new FileInputStream(file);
                    InputStreamReader stream1 = new InputStreamReader(data1);
                    BufferedReader read1 = new BufferedReader(stream1);
                    String checkFile;
                    File file2 = new File("temp.ctb"); //creates a temporary file
                    FileWriter sOutfile = new FileWriter(file2, false); //false because I am not appending but re-writing
                    while ((checkFile = read1.readLine()) != null) { //while checkFile (which has the rental file is not null
                        time = checkFile.split("\t"); //separates the line by the tab delimiter
                        if (!time[0].equals(licensePlate)) { //aslong as the license plate number in the line is not equal to the license plate being returned it writes to the file
                            sOutfile.write(time[0] + "\t" + time[1] + "\t" + time[2] + "\t" + time[3] + "\t" + time[4] + "\t" + time[5] + "\t" + time[6] + "\n"); //writes the information to the file
                        }
                    }
                    stream1.close();
                    read1.close();
                    sOutfile.close();
                    file.delete(); //delete the original rental.ctb file
                    file2.renameTo(file); //rename the temporary file to rental.ctb
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            data.close();
            stream.close();
            read.close();
        } catch (IOException e) {
            System.out.println("Error! File does not exist");
        } catch (NullPointerException e) {
            System.out.println("Error! Null value exists");
        }
        values[0] = String.valueOf(check);
        values[1] = String.valueOf(sum);
        values[2] = String.valueOf(sum1);

        values[3] = String.valueOf(ratePerDay);
        values[4] = String.valueOf(deposit);
        return values;
    }

    //--------------------------------------------------------------------------
    static String outputVehicles() { //output the objects from their respective lists
        String text = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        if (car.size() > 0) { //if car size is greater than 0 then the list has cars in it
            text = ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Cars~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            text = text + "\n" + ("|License Plate Number |\tBrand       |\tModel        |\tYear        |       Color     | Engine Size|      Fuel Type     | Transmission Type |    Mileage(km) | Seating Capacity| Rental Status| Rate Per Day| Interior Type|");
        }
        for (Vehicle value : car) { //runs for the amount of information that is in the list, an outputs that information, for example if three cars are in the list it runs 3 times and outputs all three
            text = text + "\n" + value;
        }
        if (truck.size() > 0) {
            text = text + "\n" + ("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Trucks~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            text = text + "\n" + ("|License Plate Number |\tBrand       |\tModel        |\tYear        |       Color     | Engine Size|      Fuel Type     | Transmission Type |    Mileage(km) | Seating Capacity| Rental Status| Rate Per Day| Interior Type| Towing Capacity(kg)|");
        }
        for (Vehicle value : truck) {
            text = text + "\n" + value;
        }
        if (bike.size() > 0) {
            text = text + "\n" + ("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Bikes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            text = text + "\n" + ("|License Plate Number |\tBrand       |\tModel        |\tYear        |       Color     | Engine Size|      Fuel Type     | Transmission Type |    Mileage(km) | Seating Capacity| Rental Status| Rate Per Day| Number of Helmets|");
        }
        for (Vehicle value : bike) {
            text = text + "\n" + value;
        }
        if (car.size() == 0 && truck.size() == 0 && bike.size() == 0) {
            text = "No";
        }
        return text;
    }

    //--------------------------------------------------------------------------
    static int leapYear(int year) { //this function output if a year is a leap year
        if ((year % 4 == 0) || (year % 400 == 0)) {
            return 1;
        } else {
            return 0;
        }
    }

    //--------------------------------------------------------------------------
    static String receipt(int daysRented, int daysLate, double ratePerDay, int firstDeposit) { //this function calculates the receipt
        String receipt;
        Date date = new Date(); //creates a date object
        SimpleDateFormat date1 = new SimpleDateFormat("dd.MM.yyyy"); //creates a simple date format object
        int deposit, lateFee, finalCost;
        deposit = (int) (daysRented * ratePerDay);
        lateFee = daysLate * 2500;
        finalCost = deposit + lateFee;
        receipt = ("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Cars4Rent Receipt~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\n" + "~~~~" + date1.format(date)); //places the date in the indicated format
        receipt = receipt + ("\n~~~~Deposit " + ratePerDay + " x " + daysRented + " = " + deposit); //formats the information to be specific spaces apart
        receipt = receipt + ("\n~~~~Late Fee " + 2500 + " x " + daysLate + " = " + lateFee);
        receipt = receipt + ("\n               ----------------------");
        if (firstDeposit > finalCost) {
            receipt = receipt + ("\n~~~~Change = " + (firstDeposit - finalCost));
        } else {
            receipt = receipt + ("~~~~Final Cost =" + (finalCost - firstDeposit));
        }
        return receipt;
    }

    //--------------------------------------------------------------------------
    static void findVehicle(String criteria, int choice) { //searches through the excel file for the vehicle and add them to their linked list
        try {
            car.clear(); //clears the list to that the data is not repeated
            bike.clear();
            truck.clear();
            int rowCount;
            File file1 = new File("Vehicles.xlsx");
            FileInputStream data1 = new FileInputStream(file1);
            XSSFWorkbook wb = new XSSFWorkbook(data1);
            XSSFSheet sheet = wb.getSheetAt(0);
            rowCount = sheet.getFirstRowNum();
            for (Row ignored : sheet) {//counts and iterates the rows, ignored is used as the variable is not accessed but used
                if (rowCount == 17) { //17 rows in the Excel file, any more iteration creates a null error
                    break;
                }
                Cell cellToGet = sheet.getRow(rowCount).getCell(choice - 1); //gets the column by their choice minus 1 (which is the index in the file)
                Cell typeOfVehicle = sheet.getRow(rowCount).getCell(1); //gets the vehicle type from the cell
                Cell rented = sheet.getRow(rowCount).getCell(15); //checks the rental status of the vehicle
                if ((String.valueOf((cellToGet))).equals(criteria)) { //if the cell that is called matches the criteria (for example information in column 3 matches the criteria Honda)
                    if (!String.valueOf(rented).equals("Rented")) { //If the status is not equal to rented
                        addToObjectList(typeOfVehicle, rowCount); //call the function to add the vehicle to their respective list
                    }
                    data1.close();
                }
                ++rowCount;
            }
        } catch (IOException e) {
            System.out.println("Error! File does not exist");
        }
    }

    //--------------------------------------------------------------------------
    static void updateStatus(String licensePlateNumber) {//Function to update the rental status in the excel file
        try {
            int rowCount;
            File file = new File("Vehicles.xlsx");
            FileInputStream data = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(data); //creates an excel workbook with the Vehicles.xlsx information
            XSSFSheet sheet = wb.getSheetAt(0); //creates a sheet in the workbook and gets the first sheet in the workbook
            rowCount = sheet.getFirstRowNum(); //gets the first row in the sheet
            for (Row ignored : sheet) {//counts and iterates the rows, ignored is used as the variable is not accessed but still used
                if (rowCount == 17) { //if the rowCount is saying it creates a Null Error therefore the program is set to break
                    break;
                }
                Cell cellToSearch = sheet.getRow(rowCount).getCell(0); //in every row, it gets the License Plate column to search
                Cell update1 = sheet.getRow(rowCount).getCell(15); //gets the column to update the rental status in the excel file
                if (licensePlateNumber.equals(String.valueOf(cellToSearch))) {//if the License Plate Number of the vehicle that is being rented matches the column Value
                    update1.setCellValue("Rented"); //set the rental status of that row to Rented
                    data.close();
                    FileOutputStream outFile = new FileOutputStream(file);
                    wb.write(outFile); //write the final changes (rental status) to the excel file
                    outFile.close();
                    wb.close();
                    System.out.println("Car was successfully rented");
                    break;
                }
                ++rowCount;
            }
            data.close();
        } catch (IOException e) {
            System.out.println("Error! File does not exist");
        } catch (NullPointerException e) {
            System.out.println("Error! Null Value Exists");
        } catch (Exception e) {
            System.out.println("Error! Unknown error occurred");
        }
    }

    //--------------------------------------------------------------------------
    static int rentVehicle(String licensePlateNumber, String customerName, String homeAddress, String phoneNumber, String dateRented, String expectedReturnDate, String depositPaid) throws InputMismatchException { //Function to rent a vehicle and place it in the rental file, this function also calls the update status function to change the rental status in the excel file
        Scanner input = new Scanner(System.in);
        customerName = customerName.toUpperCase();
        licensePlateNumber = licensePlateNumber.toUpperCase();
        int nameCount = 0;
        try {
            if ((car.size() > 0) || (bike.size() > 0) || (truck.size() > 0)) { //only enters if there are vehicles in the list
                File file = new File("rental.ctb");
                if (!file.exists()) { //if the file does not exist, instead of stopping the program to create the file, it creates it and continues
                    file.createNewFile();
                }
                FileInputStream data = new FileInputStream(file);
                InputStreamReader stream = new InputStreamReader(data);
                BufferedReader read = new BufferedReader(stream);
                String[] line;
                String fileLine;

                while ((fileLine = read.readLine()) != null) { //while the file is not null
                    line = fileLine.split("\t"); //places the line in the file into an array, by the tab delimiter
                    if (line[1].equals(customerName)) { //searches for the customer's name and increments (this checks to ensure they have not borrowed more than 3 vehicles)
                        nameCount++;//checks the amount of times the customer rented
                    }
                }
                if (nameCount < 3) { //if they rented less than 3 vehicles
                    data.close(); //close the file reader for rental file
                    stream.close();
                    read.close();
                    String[] returnDate1 = dateRented.split("/");
                    while ((Integer.parseInt(returnDate1[1]) > 12) || (Integer.parseInt(returnDate1[0]) > days[Integer.parseInt(returnDate1[1]) - 1]) || (Integer.parseInt(returnDate1[0]) < 0)) {
                        System.out.println("Error! Incorrect date...Please re-enter the date");
                        dateRented = input.nextLine();
                        returnDate1 = dateRented.split("/");
                    }
                    String[] returnDate = expectedReturnDate.split("/"); //places the date into an array by the / delimiter
                    while ((Integer.parseInt(returnDate[1]) > 12) || (Integer.parseInt(returnDate[0]) > days[Integer.parseInt(returnDate[1]) - 1]) || (Integer.parseInt(returnDate[0]) < 0)) {
                        System.out.println("Error! Incorrect date...Please re-enter the date");
                        expectedReturnDate = input.nextLine();
                        returnDate = expectedReturnDate.split("/");
                    }
                    FileWriter write = new FileWriter(file, true); //appends to the file
                    PrintWriter save = new PrintWriter(write); //writes to the appended file
                    save.println(licensePlateNumber + "\t" + customerName + "\t" + homeAddress + "\t" + phoneNumber + "\t" + dateRented + "\t" + expectedReturnDate + "\t" + depositPaid);
                    updateStatus(licensePlateNumber.toUpperCase());
                    save.close();
                }
                if (nameCount == 3) { //if they rented 3 times, they have reached their limit
                    System.out.println("Vehicle cannot be rented, you have reached your limit");
                    read.close();
                    stream.close();
                    data.close();
                }
            } else {
                System.out.println("No vehicle was found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nameCount;
    }

    //--------------------------------------------------------------------------
    public static void main(String[] args) {
        new GuiApplication();
    }
}