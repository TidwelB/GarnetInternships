//Import packages
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
public class ResumeTest {
    
    @Test
    public void testAddSkill() {
        String testSkill = "JavaScript";
        Resume testResume = new Resume(new ArrayList<Education>(), new ArrayList<String>(), new ArrayList<Experience>(), new ArrayList<Experience>(), new ArrayList<String>(), UUID.randomUUID());
        testResume.addSkill(testSkill);
        assertTrue(testResume.getSkills().contains(testSkill));
    }

    @Test
    public void testAddAward() {
        String testAward = "Testing Award";
        ArrayList<String> awards = new ArrayList<String>();
        awards.add(testAward);
        Resume testResume = new Resume(new ArrayList<Education>(), awards, new ArrayList<Experience>(), new ArrayList<Experience>(), new ArrayList<String>(), UUID.randomUUID());
        testResume.addAward(testAward);
        assertTrue(testResume.getAwards().contains(testAward));
    }

    @Test
    public void testAddEducation() {
        Education testEducation = new Education("Test School", "Test Date", "Test City", "Test Degree");
        Resume testResume = new Resume(new ArrayList<Education>(), new ArrayList<String>(), new ArrayList<Experience>(), new ArrayList<Experience>(), new ArrayList<String>(), UUID.randomUUID());
        testResume.addEducation(testEducation);
        assertTrue(testResume.getPriorEd().contains(testEducation));
    }

    @Test
    public void testAddRelatedExperience() {
        Experience testExperience = new Experience("Test Org", "Test City", "Tester", "Test Day", "End Test Day", new ArrayList<String>());
        Resume testResume = new Resume(new ArrayList<Education>(), new ArrayList<String>(), new ArrayList<Experience>(), new ArrayList<Experience>(), new ArrayList<String>(), UUID.randomUUID());
        testResume.addRelatedExperience(testExperience);
        assertTrue(testResume.getRelatedExp().contains(testExperience));
    }

    @Test
    public void testAddCommunityExperience() {
        Experience testExperience = new Experience("Test Org", "Test City", "Tester", "Test Day", "End Test Day", new ArrayList<String>());
        Resume testResume = new Resume(new ArrayList<Education>(), new ArrayList<String>(), new ArrayList<Experience>(), new ArrayList<Experience>(), new ArrayList<String>(), UUID.randomUUID());
        testResume.addCommunityExperience(testExperience);
        assertTrue(testResume.getCommExp().contains(testExperience));
    }

}
