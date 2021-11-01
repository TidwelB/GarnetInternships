import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author We Lit Design Company
 */


public class Student extends Account{

    //Create instance variables
    private String email;
    private Resume resume;
    private Rating rating;
    private String gradYear;
    private ArrayList<Internship> listOfAppJobs;

    public Student(String name, String username, String password, String email, Resume resume, Rating rating, String gradYear, ArrayList<Internship> listOfAppJobs, UUID id) {
        super(name, username, password, id);
        setEmail(email);
        this.resume = resume;
        this.rating = rating;
        setGradYear(gradYear);
        this.listOfAppJobs = listOfAppJobs;
    }

    /**
     * 
     * @return student email string is returned
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * sets student email string to a value
     * @param email student email string
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return student resume data is returned
     */
    public Resume getResume() {
        return this.resume;
    }

    /**
     * 
     * @return student rating data is returned
     */
    public Rating getRating() {
        return this.rating;
    }

    /**
     * 
     * @return student graduation Year String is returned
     */
    public String getGradYear() {
        return this.gradYear;
    }

    /**
     * Sets grad year to inputted value
     * @param gradYear student graduation year string
     */
    public void setGradYear(String gradYear) {
        this.gradYear = gradYear;
    }

    /**
     * Checks to see if the list of applications holds an internship. If the list of applications does not hold the internship then the internship will be added. The internship is also added to the applicant.
     * @param internship The listing of proposed job. This is checked against list of applied jobs. 
     */
    public void apply(Internship internship) {
        if (!this.listOfAppJobs.contains(internship)) {
            listOfAppJobs.add(internship);
            internship.addToApplicants(this);
        }   
    }
    
    /**
     * 
     * @return List of applied jobs is returned from internship list
     */
    public ArrayList<Internship> getListOfAppJobs() {
        return this.listOfAppJobs;
    }

    /**
     * Sets paramaters of Rating numValue and description to values
     * @param numValue integer value for rating of student performance
     * @param description string value describing student performance
     */
    public void giveRating(double numValue, String description) {
        this.rating.addRating(numValue, description);
    }

    /**
     * 
     * @param resume instance of a students resume for applications
     */
    public void setResume(Resume resume) {
        this.resume = resume;
    }

    /**
     * Numerical representation of the type of account. 0 is set for a student account. 
     */
    public int getType() {
        return 0;
    }

    /**
     * 
     * @param skill paramater within resume. Holds students abilities for work implementation
     * @return returns the student skills from within resume
     */
    public boolean addSkill(String skill) {
        return resume.addSkill(skill);
    }

    /**
     * 
     * @param education paramater within resume. Holds students formal education
     * @return returns the formal education held by the student
     */
    public boolean addEducation(Education education) {
        return resume.addEducation(education);
    }

    /**
     * 
     * @param experience paramater within resume. Holds students experience in the work field
     * @return returns students prior work experience
     */
    public boolean addExperience(Experience experience) {
        return resume.addExperience(experience);
    }


    public void editResume() {

    }

    /**
     * Prints student resume to a file. If the file has an exception error the user is informed that the file was not created properly.
     */
    public void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter("NewResume.txt");
            fileWriter.write(resume.toString());
            fileWriter.close();
            System.out.println("Sucessfully created Resume text file.");
        }
        catch(IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
        
    



        



    
}