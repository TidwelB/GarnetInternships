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
        assertFalse(GarnetInternships.getInstance() == null);
    }

    @Test
    public void testCreateAccountStudent() {
        int studentTestPriv = 0;
        GarnetInternships.getInstance().createAccount("name", "username", "password", studentTestPriv);
        assertEquals(GarnetInternships.getUser().getType(), studentTestPriv);
    }

    @Test
    public void testCreateAccountProfessor() {
        int professorTestPriv = 3;
        GarnetInternships.getInstance().createAccount("name", "username", "password", professorTestPriv);
        assertEquals(GarnetInternships.getUser().getType(), professorTestPriv);
    }

    public void testCreateAccountCompany() {
        int companyTestPriv = 2;
        GarnetInternships.getInstance().createAccount("name", "username", "password", companyTestPriv);
        assertEquals(GarnetInternships.getUser().getType(), companyTestPriv);
    }

    public void testCreateAccountAdmin() {
        int adminTestPriv = 1;
        GarnetInternships.getInstance().createAccount("name", "username", "password", adminTestPriv);
        assertEquals(GarnetInternships.getUser().getType(), adminTestPriv);
    }

    @Test
    public void testLoginStudent() {
        Student testStudent = new Student("Test Account", "tester", "12345", "email@email.com", new Resume(), new Rating(), "2025", new ArrayList<Internship>(), UUID.randomUUID());
        assertTrue(testStudent.getUsername().contains("tester"));
        assertTrue(testStudent.getPassword().contains("12345"));
    }

    @Test
    public void testLoginProfessor() {
        Professor testProfessor = new Professor("Test Account", "tester", "12345", "email@email.com", "credentials", UUID.randomUUID());
        assertTrue(testProfessor.getUsername().contains("tester"));
        assertTrue(testProfessor.getPassword().contains("12345"));
    }

    @Test
    public void testLoginCompany() {
        Company testCompany = new Company("Test Account", "tester", "12345", new Rating(), new ArrayList<Internship>(), UUID.randomUUID());
        assertTrue(testCompany.getUsername().contains("tester"));
        assertTrue(testCompany.getPassword().contains("12345"));
    }

    @Test
    public void testLoginAdmin() {
        Admin testAdmin = new Admin("Test Account", "tester", "12345", UUID.randomUUID());
        assertTrue(testAdmin.getUsername().contains("tester"));
        assertTrue(testAdmin.getPassword().contains("12345"));
    }

    @Test
    public void testPasswordCheck() {
        Student testAccount = new Student("Test Account", "tester", "12345", "email@email.com", new Resume(), new Rating(), "2025", new ArrayList<Internship>(), UUID.randomUUID());
        assertEquals(testAccount.getPassword(), "12345");
    }

    @Test
    public void testPasswordCheckWrong() {
        Student testAccount = new Student("Test Account", "tester", "12345", "email@email.com", new Resume(), new Rating(), "2025", new ArrayList<Internship>(), UUID.randomUUID());
        assertFalse(testAccount.getPassword() != "12345");
    }

    @Test
    public void testLogout() {
        assertTrue(GarnetInternships.getInstance().logout() == false);
    }

    @Test
    public void StayLoggedIn() {
        assertTrue(GarnetInternships.getInstance().logout() == false);
    }
}
