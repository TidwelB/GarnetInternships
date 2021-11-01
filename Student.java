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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Resume getResume() {
        return this.resume;
    }

    public Rating getRating() {
        return this.rating;
    }

    public String getGradYear() {
        return this.gradYear;
    }

    public void setGradYear(String gradYear) {
        this.gradYear = gradYear;
    }

    public void apply(Internship internship) {
        if (!this.listOfAppJobs.contains(internship)) {
            listOfAppJobs.add(internship);
            internship.addToApplicants(this);
        }   
    }
    
    public ArrayList<Internship> getListOfAppJobs() {
        return this.listOfAppJobs;
    }

    public void giveRating(double numValue, String description) {
        this.rating.addRating(numValue, description);
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public int getType() {
        return 0;
    }

    public boolean addSkill(String skill) {
        return resume.addSkill(skill);
    }

    public boolean addEducation(Education education) {
        return resume.addEducation(education);
    }

    public boolean addExperience(Experience experience) {
        return resume.addExperience(experience);
    }

    public void editResume() {

    }

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