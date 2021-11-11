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
public class RatingTest {
    
    @Test
    public void testAddRating() {
        
        Student testStudent = new Student("Test Account", "tester", "12345", "email@email.com", new Resume(), new Rating(), "2025", new ArrayList<Internship>(), UUID.randomUUID());
        ArrayList<String> testArr = new ArrayList<String>();
        testArr.add("Test rating");
        Rating testRating = new Rating(5.0, testArr);
        testStudent.getRating().addRating(5.0, "Test rating");
        assertEquals(testStudent.getRating(), testRating);
    }

    @Test
    public void testRemoveRating() {
        Student testStudent = new Student("Test Account", "tester", "12345", "email@email.com", new Resume(), new Rating(), "2025", new ArrayList<Internship>(), UUID.randomUUID());
        Rating testRating = new Rating(5.0, new ArrayList<String>());
        testStudent.getRating().addRating(5.0, "Test rating");
        
    }


}
