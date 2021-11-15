import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
    private AccountList accountList = AccountList.getInstance();
    private ArrayList<Account> accounts = accountList.getAccounts();
    private InternshipList internshipList = InternshipList.getInstance();
    private ArrayList<Internship> internships = internshipList.getInternships();
    private ResumeList resumeList = ResumeList.getInstance();
    private ArrayList<Resume> resumes = resumeList.getResumes();

    @BeforeEach
    public void setup() {
        internships.clear();
        accounts.clear();
        resumes.clear();
        DataWriter.saveAccounts();
        DataWriter.saveInternships();
        DataWriter.saveResumes();
        DataWriter.saveApplications();
    }

    @AfterEach
    public void tearDown() {
        internships.clear();
        accounts.clear();
        resumes.clear();
        DataWriter.saveAccounts();
        DataWriter.saveInternships();
        DataWriter.saveResumes();
        DataWriter.saveApplications();
    }

    @Test
    void testWritingZeroAccounts() {
        accounts = DataLoader.getAccounts();
        assertEquals(0, accounts.size());
    }

    @Test
    void testWritingOneAccount() {
        accounts.add(new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(), new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID()));
        DataWriter.saveAccounts();
        assertEquals("talloyd", DataLoader.getAccounts().get(0).getUsername());
    }

    @Test
    void testWritingOneAccountSize() {
        accounts.add(new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(), new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID()));
        DataWriter.saveAccounts();
        assertEquals(1, DataLoader.getAccounts().size());
    }

    @Test
    void testWritingFiveUsers() {
        accounts.add(new Student("Student One", "s1", "12345", "s1@email.sc.edu", new Resume(), new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID()));
        accounts.add(new Student("Student Two", "s2", "12345", "s2@email.sc.edu", new Resume(), new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID()));
        accounts.add(new Student("Student Three", "s3", "12345", "s3@email.sc.edu", new Resume(), new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID()));
        accounts.add(new Student("Student Four", "s4", "12345", "s4@email.sc.edu", new Resume(), new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID()));
        accounts.add(new Student("Student Five", "s5", "12345", "s5@email.sc.edu", new Resume(), new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID()));
        DataWriter.saveAccounts();
        assertEquals("s5", DataLoader.getAccounts().get(4).getUsername());
    }

    @Test
    void testWritingFiveUsersSize() {
        accounts.add(new Student("Student One", "s1", "12345", "s1@email.sc.edu", new Resume(), new Rating(), "2024",
                new ArrayList<Internship>(), UUID.randomUUID()));
        accounts.add(new Student("Student Two", "s2", "12345", "s2@email.sc.edu", new Resume(), new Rating(), "2024",
                new ArrayList<Internship>(), UUID.randomUUID()));
        accounts.add(new Student("Student Three", "s3", "12345", "s3@email.sc.edu", new Resume(), new Rating(), "2024",
                new ArrayList<Internship>(), UUID.randomUUID()));
        accounts.add(new Student("Student Four", "s4", "12345", "s4@email.sc.edu", new Resume(), new Rating(), "2024",
                new ArrayList<Internship>(), UUID.randomUUID()));
        accounts.add(new Student("Student Five", "s5", "12345", "s5@email.sc.edu", new Resume(), new Rating(), "2024",
                new ArrayList<Internship>(), UUID.randomUUID()));
        DataWriter.saveAccounts();
        assertEquals(5, DataLoader.getAccounts().size());
    }

    @Test
    void testWritingEmptyUser() {
        accounts.add(new Professor("", "", "", "", "", UUID.randomUUID()));
        DataWriter.saveAccounts();
        assertEquals("", DataLoader.getAccounts().get(0).getUsername());
    }

    @Test
    void testWritingNullUser() {
        accounts.add(new Professor(null, null, null, null, null, UUID.randomUUID()));
        DataWriter.saveAccounts();
        assertEquals(null, DataLoader.getAccounts().get(0).getUsername());
    }

    //Internships
    @Test
    void testWritingZeroInternships() {
        internships = DataLoader.getInternships();
        assertEquals(0, internships.size());
    }

    @Test
    void testWritingOneInternship() {
        internships.add(new Internship("position", "description", new ArrayList<String>(), "recYear", 10.0, new ArrayList<Student>(), 0, UUID.randomUUID()));
        DataWriter.saveInternships();
        assertEquals("position", DataLoader.getInternships().get(0).getPosition());
    }

    @Test
    void testWritingOneInternshipSize() {
        internships.add(new Internship("position", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        DataWriter.saveInternships();
        assertEquals(1, DataLoader.getInternships().size());
    }

    @Test
    void testWritingFiveInternships() {
        internships.add(new Internship("position1", "description", new ArrayList<String>(), "recYear", 10.0, new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position2", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position3", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position4", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position5", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        DataWriter.saveInternships();
        assertEquals("position5", DataLoader.getInternships().get(4).getPosition());
    }

    @Test
    void testWritingFiveInternshipsSize() {
        internships.add(new Internship("position1", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position2", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position3", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position4", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position5", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        DataWriter.saveInternships();
        assertEquals(5, DataLoader.getInternships().size());
    }

    @Test
    void testWritingEmptyInternship() {
        internships.add(new Internship("", "", new ArrayList<String>(), "", 0.0, new ArrayList<Student>(), 0, UUID.randomUUID()));
        DataWriter.saveInternships();
        assertEquals("", DataLoader.getInternships().get(0).getPosition());
    }

    @Test
    void testWritingNullInternship() {
        internships.add(new Internship(null, null, null, null, null, null, 0, null));
        boolean thrown = false;
        try {
            DataWriter.saveInternships();
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    //Resumes

    @Test
    void testWritingZeroResumes() {
        resumes = DataLoader.getResumes();
        assertEquals(0, resumes.size());
    }

    @Test
    void testWritingOneResume() {
        Resume testResume = new Resume();
        resumes.add(testResume);
        DataWriter.saveResumes();
        assertEquals(testResume.getId(), DataLoader.getResumes().get(0).getId());
    }

    @Test
    void testWritingOneResumeSize() {
        Resume testResume = new Resume();
        resumes.add(testResume);
        DataWriter.saveResumes();
        assertEquals(1, DataLoader.getResumes().size());
    }

    @Test
    void testWritingFiveResumes() {
        Resume testResume1 = new Resume();
        resumes.add(testResume1);
        Resume testResume2 = new Resume();
        resumes.add(testResume2);
        Resume testResume3 = new Resume();
        resumes.add(testResume3);
        Resume testResume4 = new Resume();
        resumes.add(testResume4);
        Resume testResume5 = new Resume();
        resumes.add(testResume5);
        DataWriter.saveResumes();
        assertEquals(testResume5.getId(), DataLoader.getResumes().get(4).getId());
    }

    @Test
    void testWritingFiveResumesSize() {
        Resume testResume1 = new Resume();
        resumes.add(testResume1);
        Resume testResume2 = new Resume();
        resumes.add(testResume2);
        Resume testResume3 = new Resume();
        resumes.add(testResume3);
        Resume testResume4 = new Resume();
        resumes.add(testResume4);
        Resume testResume5 = new Resume();
        resumes.add(testResume5);
        DataWriter.saveResumes();
        assertEquals(5, DataLoader.getResumes().size());
    }

    @Test
    void testWritingNullRessume() {
        resumes.add(new Resume(null, null, null, null, null, null));
        boolean thrown = false;
        try {
            DataWriter.saveResumes();
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    void testWritingZeroApplications() {
        accounts.add(new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(), new Rating(),
                "2024", new ArrayList<Internship>(), UUID.randomUUID()));
        DataWriter.saveAccounts();
        DataWriter.saveApplications();
        accounts = DataLoader.getAccounts();
        DataLoader.setAccountApplications(accounts);
        Student student = (Student)accounts.get(0);
        assertEquals(0, student.getListOfAppJobs().size());
    }

    @Test
    void testWritingOneApplication() {
        accounts.add(new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(), new Rating(),
                "2024", new ArrayList<Internship>(), UUID.randomUUID()));
        internships.add(new Internship("position1", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        Student testStudent = (Student)accounts.get(0);
        testStudent.apply(internships.get(0));
        DataWriter.saveAccounts();
        DataWriter.saveApplications();
        accounts = DataLoader.getAccounts();
        DataLoader.setAccountApplications(accounts);
        Student student = (Student) accounts.get(0);
        assertEquals(1, student.getListOfAppJobs().size());
    }

    @Test
    void testWritingFiveApplications() {
        accounts.add(new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(), new Rating(),
                "2024", new ArrayList<Internship>(), UUID.randomUUID()));
        internships.add(new Internship("position1", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position2", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position3", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position4", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position5", "description", new ArrayList<String>(), "recYear",
                10.0, new ArrayList<Student>(), 0, UUID.randomUUID()));
        Student testStudent = (Student) accounts.get(0);
        for (int i = 0; i < internships.size(); i++) {
            testStudent.apply(internships.get(i));
        }
        DataWriter.saveAccounts();
        DataWriter.saveApplications();
        accounts = DataLoader.getAccounts();
        DataLoader.setAccountApplications(accounts);
        Student student = (Student) accounts.get(0);
        assertEquals(internships.get(4).getPosition(), student.getListOfAppJobs().get(4).getPosition());
    }

    @Test
    void testWritingFiveApplicationsSize() {
        accounts.add(new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(), new Rating(),
                "2024", new ArrayList<Internship>(), UUID.randomUUID()));
        internships.add(new Internship("position1", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position2", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position3", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position4", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        internships.add(new Internship("position5", "description", new ArrayList<String>(), "recYear", 10.0,
                new ArrayList<Student>(), 0, UUID.randomUUID()));
        Student testStudent = (Student) accounts.get(0);
        for (int i = 0; i < internships.size(); i++) {
            testStudent.apply(internships.get(i));
        }
        DataWriter.saveAccounts();
        DataWriter.saveApplications();
        accounts = DataLoader.getAccounts();
        DataLoader.setAccountApplications(accounts);
        Student student = (Student) accounts.get(0);
        assertEquals(5, student.getListOfAppJobs().size());
    }
}