import java.util.ArrayList;
import java.util.UUID;

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
            return new AccountList(accounts);
        }
        return accountList;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Account getAccount(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equalsIgnoreCase(username)) {
                return accounts.get(i);
            }
        }
        return null;
    }

    public ArrayList<Account> getAccountByName(String name) {
        ArrayList<Account> matches = new ArrayList<Account>();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getName().equalsIgnoreCase(name)) {
                matches.add(accounts.get(i));
            }
        }
        return matches;
    }

    public Account getAccountById(UUID id) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(id)) {
                return accounts.get(i);
            }
        }
        return null;
    }
}
