import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Test;

/**
 * @author We Lit Design Company
 */
public class GarnetInternshipsTest {
    @Test
    public void testGetInstance() {
        assertTrue(GarnetInternships.getInstance() != null);
    }

    @Test
    public void testGetInstanceNull() {
        GarnetInternships garnetInternships = GarnetInternships.getInstance();
        garnetInternships = null;
        assertTrue(GarnetInternships.getInstance() != null);
    }

    @Test
    public void testLoginStudent() {
        Student testStudent = new Student("Test Account", "tester", "12345", "email@email.com", new Resume(), new Rating(), "2025", new ArrayList<Internship>(), UUID.randomUUID());
        AccountList.getInstance().getAccounts().add(testStudent);
        assertTrue(GarnetInternships.getInstance().login("tester", "12345"));
    }

    @Test
    public void testLoginProfessor() {
        Professor testProfessor = new Professor("Test Account", "tester", "12345", "email@email.com", "credentials", UUID.randomUUID());
        AccountList.getInstance().getAccounts().add(testProfessor);
        assertTrue(GarnetInternships.getInstance().login("tester", "12345"));
    }

    @Test
    public void testLoginCompany() {
        Company testCompany = new Company("Test Account", "tester", "12345", new Rating(), new ArrayList<Internship>(), UUID.randomUUID());
        AccountList.getInstance().getAccounts().add(testCompany);
        assertTrue(GarnetInternships.getInstance().login("tester", "12345"));
    }

    @Test
    public void testLoginAdmin() {
        Admin testAdmin = new Admin("Test Account", "tester", "12345", UUID.randomUUID());
        AccountList.getInstance().getAccounts().add(testAdmin);
        assertTrue(GarnetInternships.getInstance().login("tester", "12345"));
    }

    @Test
    public void testLoginUserDoesNotExist() {
        assertFalse(GarnetInternships.getInstance().login("not here", "password"));
    }

    @Test
    public void testPasswordCheck() {
        Student testAccount = new Student("Test Account", "tester", "12345", "email@email.com", new Resume(), new Rating(), "2025", new ArrayList<Internship>(), UUID.randomUUID());
        AccountList.getInstance().getAccounts().add(testAccount);
        assertTrue(GarnetInternships.getInstance().login("tester", "12345"));
    }

    @Test
    public void testPasswordCheckWrong() {
        Student testAccount = new Student("Test Account", "tester", "12345", "email@email.com", new Resume(), new Rating(), "2025", new ArrayList<Internship>(), UUID.randomUUID());
        assertFalse(GarnetInternships.getInstance().login("tester", "not the passord"));
    }

    @Test
    public void testLogout() {
        AccountList.getInstance().getAccounts().clear();
        Professor testProfessor = new Professor("Test Account", "tester", "12345", "email@email.com", "credentials",
                UUID.randomUUID());
        AccountList.getInstance().getAccounts().add(testProfessor);
        GarnetInternships.getInstance().login("tester", "12345");
        assertTrue(GarnetInternships.getInstance().logout());
    }

    @Test
    public void testLogoutNoOneLoggedIn() {
        GarnetInternships.getInstance().logout();
        assertTrue(GarnetInternships.getInstance().logout() == false);
    }

    @Test
    public void testStayLoggedIn() {
        assertTrue(GarnetInternships.getInstance().logout() == false);
    }
}
