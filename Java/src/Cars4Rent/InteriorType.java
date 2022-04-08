package Cars4Rent;

public class InteriorType {
    //attributes
    protected String interiorType;
    public InteriorType(String interiorType){
        this.interiorType = interiorType;
    } //primary constructor (accepting the attributes)
    public void setInteriorType(String interiorType){
        this.interiorType = interiorType;
    }
    public String getInteriorType(){
        return interiorType;
    }
    public String toString() {
        return interiorType;
    } //format everything to a string

}

