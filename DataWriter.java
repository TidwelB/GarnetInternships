/**
 * @author We Lit Design Company
 */

 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.ArrayList;
 import org.json.simple.JSONArray;
 import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
    public void saveAccounts() {
        AccountList accountList = AccountList.getInstance();
        ArrayList<Account> accounts = accountList.getAccounts();
        JSONArray AccountJSON = new JSONArray();

    for(int i=0; i< AccountJSON.size(); i++) {
        AccountJSON.add(getAccountJSON(accounts.get(i)));
    }

    try (FileWriter file = new FileWriter(ACCOUNT_FILE_NAME)){

        file.write(AccountJSON.toJSONString());
        file.flush();
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void saveResumes() {
        
    }

    public void saveInternships() {
        
    }
}
