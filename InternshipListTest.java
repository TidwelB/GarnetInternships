// Import packages
import static org.junit.jupiter.api.Assertions.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Luke Howe
 */
public class InternshipListTest {
    
    @Test
    public void testGetInstance() {
        assertTrue(InternshipList.getInstance() != null);
    }

    @Test
    public void testGetInstanceNull() {
        assertFalse(InternshipList.getInstance() == null);
    }

    @Test
    public void testGetInternshipById() {
        Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        InternshipList.getInstance().getInternships().add(testInternship);
        assertEquals(InternshipList.getInstance().getInternshipById(testInternship.getId()), testInternship);        
    }

    @Test
    public void testGetInternshipsByPosition() {
        Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        InternshipList.getInstance().getInternships().add(testInternship);
        assertTrue(InternshipList.getInstance().getInternshipsByPosition("Test Position").contains(testInternship));
    }

    @Test
    public void testGetInternshipsByPositionNull() {
        Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        InternshipList.getInstance().getInternships().add(testInternship);
        assertTrue(InternshipList.getInstance().getInternshipsByPosition("Test Position").contains(testInternship));
    }

    @Test
    public void testGetInternshipsByPayrate() {
        Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        InternshipList.getInstance().getInternships().add(testInternship);
        assertTrue(InternshipList.getInstance().getInternshipsByPayrate(8.0).contains(testInternship));
    }

    @Test
    public void testGetInternshipsByPayrateZero() {
        Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 0.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        InternshipList.getInstance().getInternships().add(testInternship);
        assertTrue(InternshipList.getInstance().getInternshipsByPayrate(0.0).contains(testInternship));
    }

    @Test
    public void testGetInternshipByPayrateNegative() {
        Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", -8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        InternshipList.getInstance().getInternships().add(testInternship);
        assertTrue(InternshipList.getInstance().getInternshipsByPayrate(-8.0).contains(testInternship));
    }

    @Test
    public void testGetInternshipsBySkills() {
        ArrayList<String> testSkills = new ArrayList<String>();
        testSkills.add("JavaScript");
        Internship testInternship = new Internship("Test Position", "Testing the program.", testSkills, "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        InternshipList internshipList = InternshipList.getInstance();
        internshipList.getInternships().add(testInternship);
        assertTrue(internshipList.getInternshipsBySkills("JavaScript").contains(testInternship));
    }

    @Test
    public void testGetInternshipsBySkillsNotInList() {
        assertEquals(InternshipList.getInstance().getInternshipsBySkills("No skill").size(), 0);
    }
    
    @Test
    public void testRemoveInternship() {
        Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        InternshipList.getInstance().getInternships().add(testInternship);
        InternshipList.removeInternship("Test Position");
        assertFalse(InternshipList.getInstance().getInternships().contains(testInternship));
    }
}
