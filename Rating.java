import java.util.ArrayList;

/**
 * @author We Lit Design Company
 */
public class Rating {

    //Create instance variables
    private double numValue;
    private ArrayList<String> description;

    public Rating(double numValue, ArrayList<String> description) {
        this.numValue = numValue;
        this.description = description;
    }

    public double getNumValue() {
        return numValue;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public String toString() {
        return "Number Value: "+numValue+"\nDescription: "+description;
    }
    
}
