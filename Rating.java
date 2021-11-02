import java.util.ArrayList;

/**
 * @author We Lit Design Company
 */
public class Rating {

    //Create instance variables
    private double numValue;
    private ArrayList<String> description;

    /**
     * Defailt setters for rating
     */
    public Rating() {
        this.numValue = -1.0;
        this.description = new ArrayList<String>();
        this.description.add("No ratings");
    }

    /**
     * 
     * @param numValue setter for numValue double for rating
     * @param description setter for Rating description in arrayList
     */
    public Rating(double numValue, ArrayList<String> description) {
        this.numValue = numValue;
        this.description = description;
    }

    /**
     * Checks to see if rating exists, if not then one is created
     * @param numValue double numerical representation for a rating
     * @param description string description of entity for a rating
     */
    public void addRating(double numValue, String description) {
        if (this.numValue == -1.0) {
            this.description = new ArrayList<String>();
        }
        this.description.add(description);
        this.numValue = (this.numValue*(this.description.size()-1) + numValue)/this.description.size();
    }

    /**
     * 
     * @return getter for numerical value of Rating
     */
    public double getNumValue() {
        return numValue;
    }

    /**
     * 
     * @return getter for written description list
     */
    public ArrayList<String> getDescription() {
        return description;
    }

    /**
     * To String to print the entities rating number and rating description
     */
    public String toString() {
        return "Number Value: "+numValue+"\nDescription: "+description;
    }

    /**
     * Checks that user accessing removal is an admin
     * @param name name of the account which has rating that is being requested for removal
     */
    public static void removeRating(String name) {
        Account account = AccountList.getInstance().getAccountByName(name);
        if(account.getType() == 0) {
            ((Student)account).removeRating();
        } else if(account.getType() == 2) {
            ((Company)account).removeRating();
        }
    }
    
}
