import static org.junit.jupiter.api.Assertions.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.UUID;

class AccountListTest {
    private AccountList accountList = AccountList.getInstance();
    private ArrayList<Account> accounts = accountList.getAccounts();
    private ResumeList resumeList = ResumeList.getInstance();
	private ArrayList<Resume> resumes = resumeList.getResumes();
    UUID uu = UUID.randomUUID();
    private Resume bobResume = new Resume();
    Student student1 = new Student("Bob Bob", "bbob", "12345", "bbob@email.sc.edu", bobResume, new Rating(), "2022", new ArrayList<Internship>(), uu);
    

@Test
    public void testGetInstance() {
        assertTrue(AccountList.getInstance() != null);
    }

    @Test
    public void testGetAccounts() {
        assertTrue(accountList.getAccounts() != null);
    }

    @Test
    public void testGetAccountByName() {
        accounts.add(student1);
        resumes.add(bobResume);
        assertEquals(AccountList.getInstance().getAccountByName("Bob Bob"), student1);

    }

    @Test
    public void testGetAccountByID() {
        accounts.add(student1);
        resumes.add(bobResume);
        assertEquals(AccountList.getInstance().getAccountById(uu), student1);
    }

    @Test
    public void testRemoveUser() {
        accounts.add(student1);
        resumes.add(bobResume);
        assertEquals(AccountList.getInstance().getAccountByName("Bob Bob"), student1);
        AccountList.getInstance().removeUser("Bob Bob");
        assertEquals(AccountList.getInstance().getAccountByName("Bob Bob"), null);
    }

}