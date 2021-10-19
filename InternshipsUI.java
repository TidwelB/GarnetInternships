import java.util.Scanner;
import java.util.UUID;
/**
 * @author We Lit Design Company
 */
public class InternshipsUI {
    private Scanner scanner;
    private GarnetInternships application;

    public void run() {
        displayMainMenu();
        
    }

    private void displayMainMenu() {
        System.out.println("Welcome to Garnet Internships!\n-----Log In-----\nNetwork Username:");
        
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        InternshipsUI driver = new InternshipsUI();
        driver.run();
    }
}

