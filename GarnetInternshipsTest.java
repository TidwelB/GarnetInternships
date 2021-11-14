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
        assertEquals(GarnetInternships.getUser().getType() == 0, studentTestPriv);
    }

    @Test
    public void testCreateAccountProfessor() {
        int professorTestPriv = 3;
        assertEquals(GarnetInternships.getUser().getType() == 3, professorTestPriv);
    }

    public void testCreateAccountCompany() {
        int professorTestPriv = 2;
        assertEquals(GarnetInternships.getUser().getType() == 2, professorTestPriv);
    }

    public void testCreateAccountAdmin() {
        int professorTestPriv = 1;
        assertEquals(GarnetInternships.getUser().getType() == 1, professorTestPriv);
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
