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

import java.io.PrintStream;

public class Vehicle {
    protected String licensePlateNumber;
    protected String brand;
    protected String model;
    protected String year;
    protected String color;
    protected String engineSize;
    protected String fuelType;
    protected String transmissionType;
    protected String mileage;
    protected String seatingCapacity;
    protected String rentalStatus;
    protected int ratePerDay;

    public Vehicle(String licensePlateNumber, String brand, String model, String year, String color, String engineSize, String fuelType, String transmissionType, String mileage, String seatingCapacity, String rentalStatus, int ratePerDay){
        this.licensePlateNumber = licensePlateNumber;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.engineSize = engineSize;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.mileage = mileage;
        this.seatingCapacity = seatingCapacity;
        this.rentalStatus = rentalStatus;
        this.ratePerDay = ratePerDay;
    }
    public void setLicensePlateNumber(String licensePlateNumber){
        this.licensePlateNumber = licensePlateNumber;
    }
    public String getLicensePlateNumber(){
        return licensePlateNumber;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getBrand(){
        return brand;
    }
    public void setModel(String model){
        this.model = model;
    }
    public String getModel(){
        return model;
    }
    public void setYear(String year){
        this.year = year;
    }
    public String getYear(){
        return year;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    public void setEngineSize(String engineSize){
        this.engineSize = engineSize;
    }
    public String getEngineSize(){
        return engineSize;
    }
    public void setFuelType(String fuelType){
        this.fuelType = fuelType;
    }
    public String getFuelType(){
        return fuelType;
    }
    public void setTransmissionType(String transmissionType){
        this.transmissionType = transmissionType;
    }
    public String getTransmissionType(){
        return transmissionType;
    }
    public void setMileage(String mileage){
        this.mileage = mileage;
    }
    public String getMileage(){
        return mileage;
    }
    public void setSeatingCapacity(String seatingCapacity){
        this.seatingCapacity = seatingCapacity;
    }
    public String getSeatingCapacity(){
        return seatingCapacity;
    }
    public void setRentalStatus(String rentalStatus){
        this.rentalStatus = rentalStatus;
    }
    public String getRentalStatus(){
        return rentalStatus;
    }
    public void setRatePerDay(int ratePerDay){
        this.ratePerDay = ratePerDay;
    }
    public double getRatePerDay(){
        return ratePerDay;
    }
    public String toString(){
        String out;
        out = String.format("%-40s  %-20s  %-20s  %-18s  %-20s  %-11s  %-21s        %-25s  %-12s       %-17s  %-15s    $%-18s",licensePlateNumber,brand,model,year,color,engineSize,fuelType,transmissionType,mileage,seatingCapacity,rentalStatus,ratePerDay);
        //out = String.valueOf(System.out.printf("%-23s",licensePlateNumber));
        //out = String.valueOf(System.out.printf("%-23s %-11s %-10s %-8s %-12s %-8s %-16s %-12s %-17s %-11s %-17s %-8s",licensePlateNumber,brand,model,year,color,engineSize,fuelType,transmissionType,mileage,seatingCapacity,rentalStatus,ratePerDay));
        //System.out.println(out);
        return out;

    }
    /*public String toString(){
        return
                licensePlateNumber +
                System.out.format("%11s",brand)+
                "\t\t\t\t\t" + brand +
                "\t" + model +
                "\t" + year +
                "\t" + color +
                "\t" + engineSize +
                "\t\t" + fuelType +
                "\t\t\t\t" + transmissionType +
                "\t\t\t" + mileage +
                "\t" + seatingCapacity +
                "\t\t\t\t\t" + rentalStatus +
                "\t\t\t" + ratePerDay;
    }*/
}
