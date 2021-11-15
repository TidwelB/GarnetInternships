import static org.junit.jupiter.api.Assertions.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author We Lit Design Company (Ben Tidwell)
 */

public class AdminTest {

    private AccountList accountList = AccountList.getInstance();
    private ArrayList<Account> accounts = accountList.getAccounts();
    private Resume bobResume = new Resume();
    Student student1 = new Student("Bob Bob", "bbob", "12345", "bbob@email.sc.edu", bobResume, new Rating(), "2022", new ArrayList<Internship>(), UUID.randomUUID());
    private InternshipList internshipList = InternshipList.getInstance();
	private ArrayList<Internship> internships = internshipList.getInternships();
    Internship internship = new Internship("Software Engineer", "description", new ArrayList<String>(), "recYear", 10.0, new ArrayList<Student>(), 0, UUID.randomUUID());
    Admin admin = new Admin("Test Admin", "TAdmin", "12345", UUID.randomUUID());
@Test
public void testRemoveRatingDescription(){
    accounts.add(student1);
    Admin.removeRating("Bob Bob");
    assertTrue(student1.getRating().getDescription().contains("No ratings"));
}

@Test
public void testRemoveRatingNum(){
    accounts.add(student1);
    Admin.removeRating("Bob Bob");
    assertTrue(student1.getRating().getNumValue() == -1.0);
}

@Test
public void testdeleteInternship() {
    internshipList.getInternships().clear();
    Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
    InternshipList.getInstance().getInternships().add(testInternship);
    assertTrue(InternshipList.getInstance().getInternships().contains(testInternship));
    Admin.deleteInternship("Test Position");
    assertFalse(InternshipList.getInstance().getInternships().contains(testInternship));
}

@Test
public void testdeleteDifferentInternship() {
    Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
    InternshipList.getInstance().getInternships().add(testInternship);
    Admin.deleteInternship("Not an Internship");
    assertTrue(InternshipList.getInstance().getInternships().contains(testInternship));
}

@Test
public void testdeleteAccount() {
    accounts.clear();
    accounts.add(student1);
    Admin.deleteAccount("Bob Bob");
    assertEquals(AccountList.getInstance().getAccountByName("Bob Bob"), null);

}

@Test
public void testdeleteDifferentAccount() {
    accounts.add(student1);
    Admin.deleteAccount("I don't Exist");
    assertTrue(AccountList.getInstance().getAccounts().contains(student1));

}

@Test
public void testDeleteNonAccount() {
    Admin.deleteAccount("I don't Exist");
    assertEquals(AccountList.getInstance().getAccountByName("I don't Exist"), null);
}

@Test
public void testGetType() {
    assertEquals(admin.getType(), 1);
}
}

