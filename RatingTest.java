// Import packages
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
public class RatingTest {
    
    @Test
    public void testAddRating() {
        
        Student testStudent = new Student("Test Account", "tester", "12345", "email@email.com", new Resume(), new Rating(), "2025", new ArrayList<Internship>(), UUID.randomUUID());
        testStudent.getRating().addRating(5.0, "test");
        assertTrue(testStudent.getRating().getDescription().contains("test"));
    }
    @Test
    public void testAdd0Rating() {
        Student testStudent = new Student("Test Account", "tester", "12345", "email@email.com", new Resume(), new Rating(), "2025", new ArrayList<Internship>(), UUID.randomUUID());
        testStudent.getRating().addRating(0.0, "test");
        assertTrue(testStudent.getRating().getDescription().contains("test"));
    }

    @Test
    public void testAddNullRating() {
        Student testStudent = new Student("Test Account", "tester", "12345", "email@email.com", new Resume(), new Rating(), "2025", new ArrayList<Internship>(), UUID.randomUUID());
        testStudent.getRating().addRating(5.0, null);
        assertFalse(testStudent.getRating().getDescription().contains(null));
    }

    @Test
    public void testAddNegativeRating() {
        Student testStudent = new Student("Test Account", "tester", "12345", "email@email.com", new Resume(), new Rating(), "2025", new ArrayList<Internship>(), UUID.randomUUID());
        testStudent.getRating().addRating(-5.0, "test");
        assertFalse(testStudent.getRating().getDescription().contains("test"));
    }

    @Test
    public void testRemoveRating() {
        Student testStudent = new Student("Test Account", "tester", "12345", "email@email.com", new Resume(), new Rating(), "2025", new ArrayList<Internship>(), UUID.randomUUID());
        AccountList.getInstance().getAccounts().add(testStudent);
        testStudent.giveRating(5.0, "Test rating");
        testStudent.getRating().removeRating("Test Account");
        assertEquals(testStudent.getRating().getDescription().get(0), "No ratings");
    }


}
