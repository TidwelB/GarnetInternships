/**
 * @author We Lit Design Company
 */

public class Education {
    
    // Create instance variables
    private String school;
    private String graduationDate;
    private String location;
    private String degree;

    // Create constructor
    public Education(String school, String graduationDate, String location, String degree) {
        this.school = school;
        this.graduationDate = graduationDate;
        this.location = location;
        this.degree = degree;
    }

    public String toString() {
        String education = "----Education----";
        education += "\nSchool: "+school;
        education += "\nGraduation Date: "+graduationDate;
        education += "\nLocation: "+location;
        education += "\nDegree: "+degree;
        return education;
    }
}
