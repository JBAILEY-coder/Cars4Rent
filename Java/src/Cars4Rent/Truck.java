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
