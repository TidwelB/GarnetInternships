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

    public Experience(String organization, String location, String position, String startDate, String endDate, ArrayList<String> accomplishments) {
        this.accomplishments = accomplishments;
        this.organization = organization;
        this.location = location;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
    }

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