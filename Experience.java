/**
 * @author We Lit Design Company
 */

 // Import packages
 import java.util.ArrayList;

public class Experience {
    
    // Create instance variables
    private String organization;
    private String location;
    private String position;
    private String startDate;
    private String endDate;
    private ArrayList<String> accomplishments;

    /**
     * Experience parameters
     * @param organization organization where experience was accuired
     * @param location location of the organization
     * @param position position held at the organization
     * @param startDate starting date at the organization
     * @param endDate end date at the organization
     * @param accomplishments accomplishments through the organization
     */
    public Experience(String organization, String location, String position, String startDate, String endDate, ArrayList<String> accomplishments) {
        this.accomplishments = accomplishments;
        this.organization = organization;
        this.location = location;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * 
     * @return returns the organization name
     */
    public String getOrganization() {
        return this.organization;
    }

    /**
     * 
     * @return returns the location of the organization
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * 
     * @return returns the position held
     */
    public String getPosition() {
        return this.position;
    }

    /**
     * 
     * @return returns starting date at org
     */
    public String getStartDate() {
        return this.startDate;
    }

    /**
     * 
     * @return returns end date at org
     */
    public String getEndDate() {
        return this.endDate;
    }

    /**
     * 
     * @return returns accomplishments through org
     */
    public ArrayList<String> getAccomplishments() {
        return this.accomplishments;
    }

    /**
     * To string, writes information for experience
     */
    public String toString() {
        String experience = "----Experience----";
        experience += "\nOrganization: "+organization;
        experience += "\nLocation: "+location;
        experience += "\nPosition: "+position;
        experience += "\nDate: "+startDate+" - "+endDate;
        experience += "\nAccomplishments: "+accomplishments;
        return experience;
    }
}