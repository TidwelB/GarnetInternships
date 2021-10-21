/**
 * @author We Lit Design Company
 */
public class CompanyUI {

    private static final String QUESTION = "What would you like to do?\n";

    public CompanyUI() {
        
    }
    
    public static String CompanyMenu() {
        String companyMenu = "";
        companyMenu+= "\nWelcome 'Company'!";
        companyMenu += "--------Menu--------";
        companyMenu+= "1. Edit Profile \n2. Post Internship \n3. Give a Rating\n";
        companyMenu += QUESTION;
        return companyMenu;
    }

    public static String CompanyProfile() {
        String companyProfile = "";
        companyProfile = "\n--------Profile--------";
        companyProfile = "1. Edit Bio \n2. Edit Profile Picture \n3. Edit Interests\n";
        companyProfile = QUESTION;
        return companyProfile;
    }
    
    public static String CompanyRating() {
        String companyRating = "";
        companyRating += "\n--------Rating--------";
        companyRating += "Enter the following:\n1. Student/Company Name \n2. Rating Description \n3. Rating 1-10\n";
        //NEED TO IMPLEMENT FUNCTIONALITY TO CHECK IF ALL REQUIREMENTS HAVE BEEN FILLED
        companyRating += "Submitting Rating!\n";
        return companyRating;
    }

    public static String PostInternship() {
        String postInternship = "";
        postInternship += "\n--------Post Internship--------";
        postInternship += "Enter the following:\n1. Position Title \n2. Required Skills \n3. Pay Rate \n4. Job Description\n";
        //NEED TO IMPLEMENT FUNCTIONALITY TO CHECK IF ALL REQUIREMENTS HAVE BEEN FILLED
        postInternship += "Posting Internship!\n";
        return postInternship;
    }
}
