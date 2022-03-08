package Cars4Rent;

public class Bike extends Vehicle{
    private int numberOfHelmets;


    public Bike(String licensePlateNumber, String brand, String model, String year, String color, String engineSize, String fuelType, String transmissionType, String mileage, String seatingCapacity, String rentalStatus, int ratePerDay, int numberOfHelmets) {
        super(licensePlateNumber, brand, model, year, color, engineSize, fuelType, transmissionType, mileage, seatingCapacity, rentalStatus, ratePerDay);
        this.numberOfHelmets = numberOfHelmets;
    }
    public void setNumberOfHelmets(int numberOfHelmets){
        this.numberOfHelmets = numberOfHelmets;
    }
    public int getNumberOfHelmets(){
        return numberOfHelmets;
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
                "Number Of Helmets: " + numberOfHelmets + "\n";
    }
}
