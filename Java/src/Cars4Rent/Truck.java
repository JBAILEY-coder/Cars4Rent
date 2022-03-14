package Cars4Rent;
public class Truck extends Vehicle{
    private String interiorType;
    private String towingCapacity;

    public Truck(String licensePlateNumber, String brand, String model, String year, String color, String engineSize, String fuelType, String transmissionType, String mileage, String seatingCapacity, String rentalStatus, int ratePerDay, String interiorType, String towingCapacity) {
        super(licensePlateNumber, brand, model, year, color, engineSize, fuelType, transmissionType, mileage, seatingCapacity, rentalStatus, ratePerDay);
        this.interiorType = interiorType;
        this.towingCapacity = towingCapacity;
    }
    public void setInteriorType(String interiorType){
        this.interiorType = interiorType;
    }
    public String getInteriorType(){
        return interiorType;
    }
    public void setTowingCapacity(String towingCapacity){
        this.towingCapacity = towingCapacity;
    }
    public String getTowingCapacity(){
        return towingCapacity;
    }
    public String toString(){
        return super.toString() + "Interior Type: " + interiorType + "\nTowing Capacity: " + towingCapacity;
    }

}
