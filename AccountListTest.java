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
    
    @BeforeEach
	public void setup() {
        accounts.add(student1);
        resumes.add(bobResume);
        DataWriter.saveAccounts();
		DataWriter.saveInternships();
		DataWriter.saveResumes();
		DataWriter.saveApplications();
    }

    @AfterEach
	public void tearDown() {
        accountList.getInstance().getAccounts().clear();
		resumeList.getInstance().getResumes().clear();
		DataWriter.saveAccounts();
		DataWriter.saveInternships();
		DataWriter.saveResumes();
		DataWriter.saveApplications();
    }


    @Test
    public void testGetInstance() {
        assertTrue(AccountList.getInstance() != null);
    }

    @Test
    public void testGetInstanceNull() {
        accountList = null;
        assertFalse(AccountList.getInstance() == null);
    }

    @Test
    public void testGetAccounts() {
        assertTrue(accountList.getAccounts() != null);
    }

    @Test
    public void testGetAccountsContainsStudent() {
        assertTrue(AccountList.getInstance().getAccounts().contains(student1));
    }

    @Test
    public void testGetAccountsNull() {
        assertFalse(accountList.getAccounts() == null);
    }

    @Test
    public void testGetAccount() {
        assertEquals(AccountList.getInstance().getAccount("bbob"), student1);
    }

    @Test
    public void testGetAccountNotInList() {
        assertEquals(AccountList.getInstance().getAccount("No username"), null);
    }

    @Test
    public void testGetAccountNull() {
        assertEquals(AccountList.getInstance().getAccount(null), null);
    }

    @Test
    public void testGetAccountEmpty() {
        assertEquals(AccountList.getInstance().getAccount(""), null);
    }

    @Test
    public void testGetAccountByName() {
        assertEquals(AccountList.getInstance().getAccountByName("Bob Bob"), student1);
    }

    @Test
    public void testGetAccountByNameNotInList() {
        assertEquals(AccountList.getInstance().getAccountByName("No name"), null);
    }

    @Test
    public void testGetAccountByNameNull() {
        assertEquals(AccountList.getInstance().getAccountByName(null), null);
    }

    @Test
    public void testGetAccountByNameEmpty() {
        assertEquals(AccountList.getInstance().getAccountByName(""), null);
    }

    @Test
    public void testGetAccountByID() {
        assertEquals(AccountList.getInstance().getAccountById(uu), student1);
    }

    @Test
    public void testGetAccountByIDNotInList() {
        assertEquals(AccountList.getInstance().getAccountById(UUID.randomUUID()), null);
    }

    @Test
    public void testGetAccountByIdNull() {
        assertEquals(AccountList.getInstance().getAccountById(null), null);
    }

    @Test
    public void testRemoveUser() {
        AccountList.getInstance().removeUser("Bob Bob");
        assertEquals(AccountList.getInstance().getAccountByName("Bob Bob"), null);
    }

    @Test
    public void testRemoveUserNotInList() {
        int sizeBefore = AccountList.getInstance().getAccounts().size();
        AccountList.getInstance().removeUser("User not there");
        assertEquals(sizeBefore, AccountList.getInstance().getAccounts().size());
    }

}