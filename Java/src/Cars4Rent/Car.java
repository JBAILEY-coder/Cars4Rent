package Cars4Rent;

public class Car extends Vehicle{
    private String interiorType;

    public Car(String licensePlateNumber, String brand, String model, String year, String color, String engineSize, String fuelType, String transmissionType, String mileage, String seatingCapacity, String rentalStatus, int ratePerDay, String interiorType) {
        super(licensePlateNumber, brand, model, year, color, engineSize, fuelType, transmissionType, mileage, seatingCapacity, rentalStatus, ratePerDay);
        this.interiorType = interiorType;
    }
    public void setInteriorType(String interiorType){
        this.interiorType = interiorType;
    }
    public String getInteriorType(){
        return interiorType;
    }
    public String toString(){
        return super.toString() + "Interior Type: " + interiorType + "\n";
    }

}
