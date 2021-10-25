import java.util.ArrayList;

/**
 * @author We Lit Design Company
 */
public class AccountList {
    
    //Create instance variables
    private static AccountList accountList;
    private ArrayList<Account> accounts;

    private AccountList(ArrayList<Account> accounts) {
        this.accounts = accounts;
        accountList = this;
    }

    public static AccountList getInstance() {
        if (accountList == null) {
            ArrayList<Account> accounts = DataLoader.getAccounts();
            DataLoader.setAccountApplications(accounts);
            return new AccountList(accounts);
        }
        return accountList;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Account getAccount(String username) {
        return null;
    }
}
