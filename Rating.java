import java.util.ArrayList;

/**
 * @author We Lit Design Company
 */
public class Rating {

    //Create instance variables
    private double numValue;
    private ArrayList<String> description;

    public Rating() {
        this.numValue = -1.0;
        this.description = new ArrayList<String>();
    }

    public Rating(double numValue, ArrayList<String> description) {
        this.numValue = numValue;
        this.description = description;
    }

    public void addRating(double numValue, String description) {
        this.description.add(description);
        this.numValue = (this.numValue + numValue)/this.description.size();
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
