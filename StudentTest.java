
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
public class StudentTest {

    @Test
    public void testApply() {
        Internship internship = new Internship("position", "description", new ArrayList<String>(), "recYear", 10.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(), new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.apply(internship);
        assertTrue(student.getListOfAppJobs().contains(internship));
    }

    @Test
    public void testApplyNullInternship() {
        Internship internship = null;
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        boolean thrown = false;
                try {
            student.apply(internship);
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testApplyEmptyInternship() {
        Internship internship = new Internship("", "", new ArrayList<String>(), "", 10.0, new ArrayList<Student>(), 0, UUID.randomUUID());
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.apply(internship);
        assertTrue(student.getListOfAppJobs().contains(internship));
    }

    @Test
    public void testApplyThreeInternships() {
        Internship internship1 = new Internship("position1", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID());
        Internship internship2 = new Internship("position2", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID());
        Internship internship3 = new Internship("position3", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID());
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.apply(internship1);
        student.apply(internship2);
        student.apply(internship3);
        assertEquals(student.getListOfAppJobs().size(), 3);
    }

    @Test
    public void testApplyAlreadyApplied() {
        Internship internship = new Internship("position", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID());
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.apply(internship);
        int sizeBefore = student.getListOfAppJobs().size();
        //apply again
        student.apply(internship);
        assertEquals(sizeBefore, student.getListOfAppJobs().size());
    }

    @Test
    public void testGiveRating() {
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.giveRating(5.0, "description");
        assertTrue(student.getRating().getDescription().contains("description"));
    }

    @Test
    public void testGiveTwoRatingsAverage() {
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.giveRating(5.0, "description");
        student.giveRating(3.0, "description2");
        assertEquals(student.getRating().getNumValue(), 4.0);
    }

    @Test
    public void testGiveNullRating() {
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.giveRating(0.0, null);
        assertFalse(student.getRating().getDescription().contains(null));
    }

    @Test
    public void testGiveEmptyRating() {
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.giveRating(5.0, "");
        assertFalse(student.getRating().getDescription().contains(""));
    }

    @Test
    public void testAddSkill() {
        String testSkill = "JavaScript";
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.addSkill(testSkill);
        assertTrue(student.getResume().getSkills().contains(testSkill));
    }

    @Test
    public void testAddSkillNull() {
        String testSkill = null;
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.addSkill(testSkill);
        assertTrue(student.getResume().getSkills().contains(testSkill));
    }

    @Test
    public void testAddAward() {
        String testAward = "Testing Award";
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.addAward(testAward);
        assertTrue(student.getResume().getAwards().contains(testAward));
    }

    @Test
    public void testAddAwardNull() {
        String testAward = null;
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.addAward(testAward);
        assertFalse(student.getResume().getAwards().contains(testAward));
    }

    @Test
    public void testAddEducation() {
        Education testEducation = new Education("Test School", "Test Date", "Test City", "Test Degree");
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.addEducation(testEducation);
        assertTrue(student.getResume().getPriorEd().contains(testEducation));
    }

    @Test
    public void testAddEducationNull() {
        Education testEducation = null;
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.addEducation(testEducation);
        assertFalse(student.getResume().getPriorEd().contains(testEducation));
    }

    @Test
    public void testAddRelatedExperience() {
        Experience testExperience = new Experience("Test Org", "Test City", "Tester", "Test Day", "End Test Day",
                new ArrayList<String>());
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.addRelatedExperience(testExperience);
        assertTrue(student.getResume().getRelatedExp().contains(testExperience));
    }

    @Test
    public void testAddRelatedExperienceNull() {
        Experience testExperience = null;
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.addRelatedExperience(testExperience);
        assertFalse(student.getResume().getRelatedExp().contains(testExperience));
    }

    @Test
    public void testAddCommunityExperience() {
        Experience testExperience = new Experience("Test Org", "Test City", "Tester", "Test Day", "End Test Day",
                new ArrayList<String>());
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.addCommunityExperience(testExperience);
        assertTrue(student.getResume().getCommExp().contains(testExperience));
    }

    @Test
    public void testAddCommunityExperienceNull() {
        Experience testExperience = null;
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.addCommunityExperience(testExperience);
        assertFalse(student.getResume().getCommExp().contains(testExperience));
    }

    @Test
    public void testRemoveRating() {
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(),
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        student.giveRating(5.0, "description");
        student.removeRating();
        assertTrue(student.getRating().getDescription().contains("No ratings"));
    }

}
