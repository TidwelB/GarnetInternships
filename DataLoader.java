import java.util.ArrayList;
import java.io.FileReader;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * @author We Lit Design Company
 */
public class DataLoader extends DataConstants{
    
    public static ArrayList<Internship> getInternships() {
        
        return null;
    }

    public static ArrayList<Account> getAccounts() {
        ArrayList<Account> accounts = new ArrayList<Account>();

        try {
            FileReader reader = new FileReader(ACCOUNT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray accountsJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < accountsJSON.size(); i++) {
                JSONObject accountJSON = (JSONObject) accountsJSON.get(i);

                String name = (String) accountJSON.get(ACCOUNT_NAME);
                String username = (String) accountJSON.get(ACCOUNT_USER_NAME);
                String password = (String) accountJSON.get(ACCOUNT_PASSWORD);
                UUID id = UUID.fromString((String) accountJSON.get(ACCOUNT_ID));

                if (accountJSON.get(ACCOUNT_PRIVILEGE).equals("Student")) {
                    // accounts.add(new Student(name, username, password, id));
                }

            }

            return accounts;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Resume> getResumes() {
        ArrayList<Resume> resumes = new ArrayList<Resume>();

        try {
            FileReader reader = new FileReader(RESUME_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray resumesJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < resumesJSON.size(); i++) {
                JSONObject resumeJSON = (JSONObject) resumesJSON.get(i);

                //prior education
                ArrayList<Education> educations = new ArrayList<Education>();
                JSONArray edsJSON = (JSONArray) resumeJSON.get(RESUME_PRIOR_EDUCATION);
                for (int j = 0; j < edsJSON.size(); j++) {
                    JSONArray edJSON = (JSONArray) edsJSON.get(j);
                    educations.add(new Education((String)edJSON.get(0), (String)edJSON.get(1), 
                            (String)edJSON.get(2), (String)edJSON.get(3)));
                }

                //skills
                ArrayList<String> skills = new ArrayList<String>();
                JSONArray skillsJSON = (JSONArray) resumeJSON.get(RESUME_SKILLS);
                for (int j = 0; j < skillsJSON.size(); j++) {
                    skills.add((String)skillsJSON.get(j));
                }

                //awards
                ArrayList<String> awards = new ArrayList<String>();
                JSONArray awardsJSON = (JSONArray) resumeJSON.get(RESUME_AWARDS);
                for (int j = 0; j < awardsJSON.size(); j++) {
                    awards.add((String) awardsJSON.get(j));
                }

                //RELATED EXP
                ArrayList<Experience> relatedExps = new ArrayList<Experience>();
                JSONArray relExpsJSON = (JSONArray) resumeJSON.get(RESUME_RELATED_EXPERIENCE);
                for (int j = 0; j < relExpsJSON.size(); j++) {
                    JSONArray relExpJSON = (JSONArray) relExpsJSON.get(j);
                    JSONArray accomsJSON = (JSONArray) relExpJSON.get(5);
                    ArrayList<String> accoms = new ArrayList<String>();
                    for (Object accomJSON : accomsJSON)
                        accoms.add((String)accomJSON);
                    relatedExps.add(new Experience((String) relExpJSON.get(0), (String) relExpJSON.get(1), (String) relExpJSON.get(2),
                            (String) relExpJSON.get(3), (String) relExpJSON.get(4), accoms));
                }

                //Comm exp
                ArrayList<Experience> commExps = new ArrayList<Experience>();
                JSONArray commExpsJSON = (JSONArray) resumeJSON.get(RESUME_COMMUNITY_EXPERIENCE);
                for (int j = 0; j < commExpsJSON.size(); j++) {
                    JSONArray commExpJSON = (JSONArray) commExpsJSON.get(j);
                    JSONArray accomsJSON = (JSONArray) commExpJSON.get(5);
                    ArrayList<String> accoms = new ArrayList<String>();
                    for (Object accomJSON : accomsJSON)
                        accoms.add((String) accomJSON);
                    commExps.add(new Experience((String) commExpJSON.get(0), (String) commExpJSON.get(1),
                            (String) commExpJSON.get(2), (String) commExpJSON.get(3), (String) commExpJSON.get(4),
                            accoms));
                }

                UUID id = UUID.fromString((String)resumeJSON.get(ACCOUNT_ID));

                resumes.add(new Resume( educations, awards, relatedExps, commExps, skills, id));

            }

            reader.close();
            return resumes;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
