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
        //InternshipList.getInstance();
        
    }

    @Test
    public void testGetInstanceNull() {
        
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
        assertEquals(InternshipList.getInstance().getInternshipsByPosition(testInternship.getPosition()), testInternship);
    }

    @Test
    public void testGetInternshipsByPayrate() {
        Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        InternshipList.getInstance().getInternships().add(testInternship);
        assertEquals(InternshipList.getInstance().getInternshipsByPayrate(8.0), testInternship);
    }

    @Test
    public void testGetInternshipsBySkills() {
        Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        InternshipList.getInstance().getInternships().add(testInternship);
        assertEquals(InternshipList.getInstance().getInternshipsBySkills("Javascript"), testInternship.getReqSkills().contains("Javascript"));
    }
    
    @Test
    public void testRemoveInternship() {
        Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        InternshipList.getInstance().getInternships().add(testInternship);
        InternshipList.removeInternship("Test Position");
        assertTrue(InternshipList.getInstance().getInternships().contains(testInternship));
    }
}
