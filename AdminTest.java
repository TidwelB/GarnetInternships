import static org.junit.jupiter.api.Assertions.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.UUID;


public class AdminTest {

    private AccountList accountList = AccountList.getInstance();
    private ArrayList<Account> accounts = accountList.getAccounts();
    private Resume bobResume = new Resume();
    Student student1 = new Student("Bob Bob", "bbob", "12345", "bbob@email.sc.edu", bobResume, new Rating(), "2022", new ArrayList<Internship>(), UUID.randomUUID());
    private InternshipList internshipList = InternshipList.getInstance();
	private ArrayList<Internship> internships = internshipList.getInternships();
    Internship internship = new Internship("Software Engineer", "description", new ArrayList<String>(), "recYear", 10.0, new ArrayList<Student>(), 0, UUID.randomUUID());
@Test
public void testRemoveRating(){
    accounts.add(student1);
    assertEquals (Admin.removeRating("Bob Bob"), null);

}

@Test
public void testdeleteInternship() {
    internships.add(new Internship("Web Developer", "description", new ArrayList<String>(), "recYear", 10.0, new ArrayList<Student>(), 0, UUID.randomUUID()));  
    Admin.deleteInternship("Web Developer");
    assertFalse(InternshipList.getInstance().getInternshipsByPosition("Web Devleoper").contains(internship));
}

@Test
public void testdeleteAccount() {
    accounts.add(student1);
    Admin.deleteAccount("Bob Bob");
    assertEquals(AccountList.getInstance().getAccountByName("Bob Bob"), null);

}
}

