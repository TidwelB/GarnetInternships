
import static org.junit.jupiter.api.Assertions.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.UUID;

public class CompanyTest {
    
   Internship testInternship = new Internship("Test Position", "Testing the program.", new ArrayList<String>(), "2025", 8.0, new ArrayList<Student>(), 0, UUID.randomUUID());
    Company company = new Company("Test Company", "Test", "12345", new Rating (), new ArrayList<Internship> (), UUID.randomUUID());
    private Rating rating = new Rating();

@Test
public void testGetRating(){
assertFalse(company.getRating() == null);
}

@Test
public void testGetAvailJobs() {
assertFalse(company.getAvailJobs()  == null);
}

@Test
public void testAvailJobsNotPopulated() {
    assertFalse(company.getAvailJobs().contains(testInternship));
}

@Test
public void testGiveRating() {
    company.giveRating(5.0, "meh");
    assertTrue(company.getRating().getNumValue() == 5.0 && (company.getRating().getDescription().get(0).equals("meh")) );
}

@Test
public void testGiveIncorrectRating() {
    company.giveRating(-1.0, "");
    assertTrue(company.getRating().getDescription().contains("No ratings") && company.getRating().getNumValue()== (0.0));
}

@Test
public void testGiveEmptyRating() {
    company.giveRating(5.0, "");
    assertTrue(company.getRating().getDescription().contains("No ratings"));
}

@Test
public void testGiveIncorrectRatingNum() {
    company.giveRating( -1, "meh");
    assertTrue(company.getRating().getNumValue() == (0.0));
}

@Test
public void testAddJob() {
    company.addJob(testInternship);
    assertTrue(company.getAvailJobs().contains(testInternship));
}
@Test
public void testRemoveJob() {
    company.removeJob(testInternship);
    assertFalse(InternshipList.getInstance().getInternships().contains(testInternship));
}
@Test
public void testGetType() {
assertEquals(company.getType(), 2);
}

@Test
public void testGetListings() {
assertFalse(company.getListingsString() == null);
}

@Test
public void testTemoveRating() {
company.removeRating();
assertTrue(company.getRating().getNumValue() == -1);
}
}
