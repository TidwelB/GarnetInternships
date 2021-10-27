import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

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
        listOfAppJobs.add(internship);
        internship.addToApplicants(this);
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
        boolean quitEdit = false;
        while(!quitEdit)
            resume.toString();
            Scanner keyboard = new Scanner(System.in);
            System.out.println("What section would you like to edit?\nEnter 1 for Prior Education, 2 for Awards, 3 for Related Experience, 4 for Community Experience, or 5 for Skills.");
                try {
                    int userOption = keyboard.nextInt();
                    if(userOption != 1 || userOption != 2 || userOption != 3 || userOption != 4 || userOption != 5) {
                        System.out.println("Wrong input.");
                    }
                    else if(userOption == 1) {
                        System.out.println("Editing Prior Education.");
                        System.out.println("Would you like to remove, add, or edit an entry?\nEnter 1 for remove, 2 for add, or 3 for edit.");
                        int userSubOption = keyboard.nextInt();
                        if(userSubOption != 1 || userSubOption != 2 || userSubOption != 3) {
                            System.out.println("Wrong input.");
                        }
                        else if(userSubOption == 1) {
                            System.out.println("Which entry would you like to remove?");
                            resume.getPriorEd().toString();
                        }
                        else if(userSubOption == 2) {
                            System.out.println("Which entry would you like to add?");
                        }
                        else if(userSubOption == 3) {
                            System.out.println("Which entry would you like to edit?");
                        }
                    }
                    else if(userOption == 2) {
                        System.out.println("Editing Awards.");
                    }
                    else if(userOption == 3) {
                        System.out.println("Editing Related Experience.");
                    }
                    else if(userOption == 4) {
                        System.out.println("Editing Community Experience.");
                    }
                    else if(userOption == 5) {
                        System.out.println("Editing Skills.");
                    }
                }
                catch(InputMismatchException e) {

                }

            }



        



    
}
