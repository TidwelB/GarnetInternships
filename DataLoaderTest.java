import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataLoaderTest {
	private AccountList accountList = AccountList.getInstance();
	private ArrayList<Account> accounts = accountList.getAccounts();
	
	@BeforeEach
	public void setup() {
		accounts.clear();
		accounts.add(new Student("Thomas Lloyd", "talloyd", "12345", "talloyd@email.sc.edu", new Resume(), new Rating(), "2024", new ArrayList<Internship>(), UUID.randomUUID()));
		accounts.add(new Professor("Dr. Smith", "dsmith", "12345", "dsmith@sc.edu", "Doctorate in Computer Science", UUID.randomUUID()));
		DataWriter.saveAccounts();
	}
	
	@AfterEach
	public void tearDown() {
		accountList.getInstance().getAccounts().clear();
		DataWriter.saveAccounts();
	}
	
	
	@Test
	void testGetAccountsSize() {
		accounts = DataLoader.getAccounts();
		assertEquals(2, accounts.size());
	}

	@Test
	void testGetAccountSizeZero() {
		accountList.getInstance().getAccounts().clear();
		DataWriter.saveAccounts();
		assertEquals(0, accounts.size());
	}
	
	@Test
	void testGetUserFirstUserName() {
		accounts= DataLoader.getAccounts();
		assertEquals("talloyd", accounts.get(0).getUsername());
	}
}