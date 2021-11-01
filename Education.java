/**
 * @author We Lit Design Company
 */

public class Education {
    
    /**
     * Instance variables strings of school, graduationDate, location, degree
     */
    private String school;
    private String graduationDate;
    private String location;
    private String degree;

    /**
     * Create constructor
     * @param school school or univ where the student attended
     * @param graduationDate date in which the student graduated or will graduate
     * @param location where the school is located
     * @param degree type of education recieved
     */
    public Education(String school, String graduationDate, String location, String degree) {
        this.school = school;
        this.graduationDate = graduationDate;
        this.location = location;
        this.degree = degree;
    }

    /**
     * 
     * @return returns the school in which a student has attended
     */
    public String getSchool() {
        return this.school;
    }

    /**
     * 
     * @return returns the date of graducation from the institution
     */
    public String getGraduationDate() {
        return this.graduationDate;
    }

    /**
     * 
     * @return returns the location of the school
     */
    public String getLocation() {
        return this.location;
    }


    /**
     * 
     * @return returns the type of education recieved
     */
    public String getDegree() {
        return this.degree;
    }

    /**
     * Formats and prints information held within the education parameter (school ,grad date, location, and degree)
     */
    public String toString() {
        String education = "----Education----";
        education += "\nSchool: "+school;
        education += "\nGraduation Date: "+graduationDate;
        education += "\nLocation: "+location;
        education += "\nDegree: "+degree;
        return education;
    }
}
