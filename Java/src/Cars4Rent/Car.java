package Cars4Rent;

public class Car extends Vehicle{
    protected String interiorType;

    public Car(String licensePlateNumber, String brand, String model, String year, String color, String engineSize, String fuelType, String transmissionType, String mileage, String seatingCapacity, String rentalStatus, int ratePerDay, String interiorType) {
        super(licensePlateNumber, brand, model, year, color, engineSize, fuelType, transmissionType, mileage, seatingCapacity, rentalStatus, ratePerDay);
        this.interiorType = interiorType;
    }
    public void setInteriorType(){
        this.interiorType = interiorType;
    }
    public String getInteriorType(){
        return interiorType;
    }
    public String toString(){
        return "License Plate Number: " + licensePlateNumber +
                "Brand: " + brand +
                "Model: " + model +
                "Year: " + year +
                "Color: " + color +
                "Engine Size: " + engineSize +
                "Fuel Type: " + fuelType +
                "Transmission Type: " + transmissionType +
                "Mileage: " + mileage +
                "Seating Capacity: " + seatingCapacity +
                "Rental Status: " + rentalStatus +
                "Interior Type: " + interiorType + "\n";
    }

}
