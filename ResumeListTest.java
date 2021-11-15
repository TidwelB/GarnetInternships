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
        assertTrue(ResumeList.getInstance() != null);
    }

    @Test
    public void testGetInstanceNull() {
        assertFalse(ResumeList.getInstance() == null);
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
    public void testGetResumeById() {
        Resume testResume = new Resume(new ArrayList<Education>(), new ArrayList<String>(), new ArrayList<Experience>(), new ArrayList<Experience>(), new ArrayList<String>(), UUID.randomUUID());
        ResumeList.getInstance().getResumes().add(testResume);
        assertEquals(ResumeList.getInstance().getResumeById(testResume.getId()), testResume);
    }
}
