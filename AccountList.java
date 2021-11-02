// Import packages
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author We Lit Design Company
 */

 // This is the AccountList class.
public class AccountList {
    
    //Create instance variables
    private static AccountList accountList;
    private ArrayList<Account> accounts;

    /**
     * This is the constructor for the AccountList object.
     * @param accounts This value is the array list of the accounts being loaded.
     */
    private AccountList(ArrayList<Account> accounts) {
        this.accounts = accounts;
        accountList = this;
    }

    /**
     * This is the getter for the instance.
     * @return Returns the list of accounts.
     */
    public static AccountList getInstance() {
        if (accountList == null) {
            ArrayList<Account> accounts = DataLoader.getAccounts();
            return new AccountList(accounts);
        }
        return accountList;
    }

    /**
     * This is the getter for the accounts.
     * @return Returns the accounts in the list.
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * This is the getter for a specific account in the list
     * @param username This is the value that holds the username of the account being got
     * @return Returns null if the account is not found
     */
    public Account getAccount(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equalsIgnoreCase(username)) {
                return accounts.get(i);
            }
        }
        return null;
    }

    /**
     * This is the getter for the account by name
     * @param name This is the value that holds the name being got
     * @return Returns the matche found
     */
    public Account getAccountByName(String name) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getName().equalsIgnoreCase(name)) {
                return accounts.get(i);
            }
        }
        return null;
    }

    /**
     * This is the getter for the account by Id
     * @param id This value holds the Id that the account is getting got by
     * @return Returns null if nothing is found
     */
    public Account getAccountById(UUID id) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(id)) {
                return accounts.get(i);
            }
        }
        return null;
    }

    public static void removeUser(String name) {
        for(int i=0;i<getInstance().getAccounts().size();i++) {
            if(getInstance().getAccounts().get(i).getName().equalsIgnoreCase(name)) {
                getInstance().getAccounts().remove(i);
            }
        }
    }
}
