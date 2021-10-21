import java.util.ArrayList;

/**
 * @author We Lit Design Company
 */
public class AccountList {
    
    //Create instance variables
    private static AccountList accountList;
    private ArrayList<Account> accounts;

    private AccountList() {
        
    }

    public static AccountList getInstance() {
        return null;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Account getAccount(String username) {
        return null;
    }
}
