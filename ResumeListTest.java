import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author We Lit Design Company
 */
public class ResumeListTest {
    @Test
    public void testGetInstance() {
        ResumeList resumeList = ResumeList.getInstance();
        assertTrue(resumeList != null);
    }

    @Test
    public void testGetInstanceNull() {
        ResumeList resumeList = ResumeList.getInstance();
        resumeList = null;
        assertTrue(ResumeList.getInstance() != null);
    }

    @Test
    public void testGetResumes() {
        assertTrue(ResumeList.getInstance().getResumes() != null);
    }

    @Test
    public void testGetResumesNull() {
        assertFalse(ResumeList.getInstance().getResumes() == null);
    }

    @Test
    public void testGetResume() {
        Resume testResume = new Resume(new ArrayList<Education>(), new ArrayList<String>(), new ArrayList<Experience>(),
                new ArrayList<Experience>(), new ArrayList<String>(), UUID.randomUUID());
        Student student = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", testResume,
                new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
        AccountList.getInstance().getAccounts().add(student);
        ResumeList.getInstance().getResumes().add(testResume);
        assertEquals(ResumeList.getInstance().getResume("talloyd"), testResume);
    }

    @Test
    public void testGetResumeNotAStudent() {
        Resume testResume = new Resume(new ArrayList<Education>(), new ArrayList<String>(), new ArrayList<Experience>(),
                new ArrayList<Experience>(), new ArrayList<String>(), UUID.randomUUID());
        Professor professor = new Professor("name", "professor", "password", "email", "credentials", UUID.randomUUID());
        ResumeList.getInstance().getResumes().add(testResume);
        AccountList.getInstance().getAccounts().add(professor);
        assertEquals(ResumeList.getInstance().getResume("professor"), null);
    }

    @Test
    public void testGetResumeNotInList() {
        assertEquals(ResumeList.getInstance().getResume("not in list"), null);
    }

    @Test
    public void testGetResumeById() {
        Resume testResume = new Resume(new ArrayList<Education>(), new ArrayList<String>(), new ArrayList<Experience>(), new ArrayList<Experience>(), new ArrayList<String>(), UUID.randomUUID());
        ResumeList.getInstance().getResumes().add(testResume);
        assertEquals(ResumeList.getInstance().getResumeById(testResume.getId()), testResume);
    }

    @Test
    public void testGetResumeByIdNotInList() {
        assertEquals(ResumeList.getInstance().getResumeById(UUID.randomUUID()), null);
    }
}
