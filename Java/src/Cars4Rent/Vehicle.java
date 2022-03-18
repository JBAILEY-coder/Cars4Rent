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
    public String toString(){
        return "License Plate Number: " + licensePlateNumber +
                "\nBrand: " + brand +
                "\nModel: " + model +
                "\nYear: " + year +
                "\nColor: " + color +
                "\nEngine Size: " + engineSize +
                "\nFuel Type: " + fuelType +
                "\nTransmission Type: " + transmissionType +
                "\nMileage: " + mileage +
                "\nSeating Capacity: " + seatingCapacity +
                "\nRental Status: " + rentalStatus;
    }
}
