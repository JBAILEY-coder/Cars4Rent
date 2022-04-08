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
    private InteriorType interiorType;
    private String towingCapacity;

    public Truck(String licensePlateNumber, String brand, String model, String year, String color, String engineSize, String fuelType, String transmissionType, String mileage, String seatingCapacity, String rentalStatus, int ratePerDay, InteriorType interiorType, String towingCapacity) {
        super(licensePlateNumber, brand, model, year, color, engineSize, fuelType, transmissionType, mileage, seatingCapacity, rentalStatus, ratePerDay);
        this.interiorType = interiorType;
        this.towingCapacity = towingCapacity;
    }
    public void setInteriorType(InteriorType interiorType){
        this.interiorType = interiorType;
    }
    public InteriorType getInteriorType(){
        return interiorType;
    }
    public void setTowingCapacity(String towingCapacity){
        this.towingCapacity = towingCapacity;
    }
    public String getTowingCapacity(){
        return towingCapacity;
    }
    public String toString(){
        String out;
        out = String.format(" %-13s      %-15s",interiorType,towingCapacity);
        return super.toString() + out;
    }

}
