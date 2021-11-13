import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataLoaderTest {
	private AccountList accountList = AccountList.getInstance();
	private ArrayList<Account> accounts = accountList.getAccounts();
	private InternshipList internshipList = InternshipList.getInstance();
	private ArrayList<Internship> internships = internshipList.getInternships();
	private ResumeList resumeList = ResumeList.getInstance();
	private ArrayList<Resume> resumes = resumeList.getResumes();
	private Resume thomasResume = new Resume();
	private Resume bobResume = new Resume();
	Student student0 = new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", thomasResume, new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID());
	Student student1 = new Student("Bob Bob", "bbob", "12345", "bbob@email.sc.edu", bobResume, new Rating(), "2022", new ArrayList<Internship>(), UUID.randomUUID());

	@BeforeEach
	public void setup() {
		internships.clear();
		internships.add(new Internship("Software Engineer", "description", new ArrayList<String>(), "recYear", 10.0, new ArrayList<Student>(), 0, UUID.randomUUID()));
		internships.add(new Internship("Web Developer", "description", new ArrayList<String>(), "recYear", 10.0, new ArrayList<Student>(), 0, UUID.randomUUID()));
		accounts.clear();
		resumes.clear();
		accounts.add(student0);
		accounts.add(new Professor("Dr. Smith", "dsmith", "12345", "dsmith@sc.edu", "Doctorate in Computer Science", UUID.randomUUID()));
		accounts.add(student1);
		resumes.add(thomasResume);
		resumes.add(bobResume);
		student0.apply(internships.get(0));
		student0.apply(internships.get(1));
		student1.apply(internships.get(0));
		DataWriter.saveAccounts();
		DataWriter.saveInternships();
		DataWriter.saveResumes();
		DataWriter.saveApplications();
	}
	
	@AfterEach
	public void tearDown() {
		accountList.getInstance().getAccounts().clear();
		internshipList.getInstance().getInternships().clear();
		resumeList.getInstance().getResumes().clear();
		DataWriter.saveAccounts();
		DataWriter.saveInternships();
		DataWriter.saveResumes();
		DataWriter.saveApplications();
	}
	
	
	@Test
	void testGetAccountsSize() {
		accounts = DataLoader.getAccounts();
		assertEquals(3, accounts.size());
	}

	@Test
	void testGetAccountSizeZero() {
		accountList.getInstance().getAccounts().clear();
		DataWriter.saveAccounts();
		accounts = DataLoader.getAccounts();
		assertEquals(0, accounts.size());
	}
	
	@Test
	void testGetUserFirstUserName() {
		accounts = DataLoader.getAccounts();
		assertEquals("talloyd", accounts.get(0).getUsername());
	}

	@Test
	void testGetInternshipsSize() {
		internships = DataLoader.getInternships();
		assertEquals(2, internships.size());
	}

	@Test
	void testGetInternshipsSizeZero() {
		internshipList.getInstance().getInternships().clear();
		DataWriter.saveInternships();
		internships = DataLoader.getInternships();
		assertEquals(0, internships.size());
	}

	@Test
	void testGetInternshipsFirstPosition() {
		internships = DataLoader.getInternships();
		assertEquals("Software Engineer", internships.get(0).getPosition());
	}

	@Test
	void testGetResumesSize() {
		resumes = DataLoader.getResumes();
		assertEquals(2, resumes.size());
	}

	@Test
	void testGetResumesSizeZero() {
		resumeList.getInstance().getResumes().clear();
		DataWriter.saveResumes();
		resumes = DataLoader.getResumes();
		assertEquals(0, resumes.size());
	}

	@Test
	void testGetResumesFirstId() {
		resumes = DataLoader.getResumes();
		assertEquals(thomasResume.getId(), resumes.get(0).getId());
	}

	@Test
	void testSetInternshipApplicationsSize() {
		internships = DataLoader.getInternships();
		DataLoader.setInternshipApplications(internships);
		assertEquals(2, internships.get(0).getApplicants().size());
	}

	@Test
	void testSetInternshipApplicationsSizeZero() {
		internships.get(0).getApplicants().clear();
		student0.getListOfAppJobs().clear();
		student1.getListOfAppJobs().clear();
		DataWriter.saveApplications();
		DataLoader.setInternshipApplications(internships);
		assertEquals(0, internships.get(0).getApplicants().size());
	}

	@Test
	void testSetInternshipApplicationsContainsFirstStudent() {
		DataLoader.setInternshipApplications(internships);
		assertTrue(internships.get(0).getApplicants().contains(student0));
	}

	@Test
	void testSetAccountApplicationsSize() {
		accounts = DataLoader.getAccounts();
		DataLoader.setAccountApplications(accounts);
		Student tempStudent = (Student)accounts.get(0);
		assertEquals(2, tempStudent.getListOfAppJobs().size());
	}

	@Test
	void testSetAccountApplicationsSizeZero() {
		internships.get(0).getApplicants().clear();
		internships.get(1).getApplicants().clear();
		student0.getListOfAppJobs().clear();
		student1.getListOfAppJobs().clear();
		DataWriter.saveApplications();
		DataLoader.setAccountApplications(accounts);
		Student tempStudent = (Student) accounts.get(0);
		assertEquals(0, tempStudent.getListOfAppJobs().size());
	}

	@Test
	void testSetAccountApplicationsContainsFirstInternship() {
		accounts = DataLoader.getAccounts();
		DataLoader.setAccountApplications(accounts);
		Student tempStudent = (Student) accounts.get(0);
		assertTrue(tempStudent.getListOfAppJobs().contains(internships.get(0)));
	}
	
}