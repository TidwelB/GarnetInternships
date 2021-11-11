// Import packages
import static org.junit.jupiter.api.Assertions.*;
import java.util.UUID;
import java.beans.Transient;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Luke Howe
 */
public class InternshipTest {
    
    @BeforeClass
    public void setup() {
	
    }

    @Test
    public void testAddToApplicantsNormal() {
        Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        Student testStudent = new Student("Test Account", "tester", "12345", "email@email.com", new Resume(), new Rating(), "2025", new ArrayList<Internship>(), UUID.randomUUID());
        testInternship.addToApplicants(testStudent);
        assertTrue(testInternship.getApplicants().contains(testStudent));
    }

    @Test
    public void testAddToApplicantsNull() {
        Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        Student testStudent = new Student(null, null, null, null, null, null, null, null, null);
        testInternship.addToApplicants(testStudent);
        assertTrue(testInternship.getApplicants().contains(testStudent));
    }

    @Test
    public void testAddToApplicantsNumber() {
        Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        Student testStudent = new Student("Test Account", "tester", "12345", "email@email.com", new Resume(), new Rating(), "2025", new ArrayList<Internship>(), UUID.randomUUID());
        testInternship.addToApplicants(testStudent);
        assertEquals(testInternship.getNumOfApps(), 1);
    }

    @Test
    public void testGetCompany() {
        Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        Company testCompany = new Company("Test Company", "company", "12345", new Rating(), new ArrayList<Internship>(), UUID.randomUUID());
        testCompany.addJob(testInternship);
        assertEquals(testInternship.getCompany(),testCompany);
    }

    @Test
    public void testGetCompanyNull() {
        Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        Company testCompany = new Company(null, null, null, null, null, null);
        testCompany.addJob(testInternship);
        assertEquals(testInternship.getCompany(),testCompany);
    }

}