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
        ArrayList<Internship> internships = new ArrayList<Internship>();

        try {
            FileReader reader = new FileReader(INTERNSHIP_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray internshipsJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < internshipsJSON.size(); i++) {
                JSONObject internshipJSON = (JSONObject) internshipsJSON.get(i);

                UUID id = UUID.fromString((String) internshipJSON.get(INTERNSHIP_ID));
                String position = (String)internshipJSON.get(INTERNSHIP_POSITION);

                ArrayList<String> requiredSkills = new ArrayList<String>();
                JSONArray requiredSkillsJSON = (JSONArray) internshipJSON.get(INTERNSHIP_REQUIRED_SKILLS);
                for (int j = 0; j < requiredSkillsJSON.size(); j++) {
                    requiredSkills.add((String) requiredSkillsJSON.get(j));
                }

                String recYear = (String)internshipJSON.get(INTERNSHIP_RECYEAR);
                Double payrate = Double.parseDouble((String)internshipJSON.get(INTERNSHIP_PAYRATE));
                ArrayList<Student> applicants = new ArrayList<Student>();
                int numOfApplicants = 0;
                String description = (String)internshipJSON.get(INTERNSHIP_DESCRIPTION);
                
                internships.add(new Internship(position, description, requiredSkills, recYear, payrate, applicants, numOfApplicants, id));

            }

            reader.close();
            return internships;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Account> getAccounts() {
        ArrayList<Account> accounts = new ArrayList<Account>();

        try {
            FileReader reader = new FileReader(ACCOUNT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray accountsJSON = (JSONArray) new JSONParser().parse(reader);

            //ArrayList<Resume> resumes = getResumes();

            for (int i = 0; i < accountsJSON.size(); i++) {
                JSONObject accountJSON = (JSONObject) accountsJSON.get(i);

                String name = (String) accountJSON.get(ACCOUNT_NAME);
                String username = (String) accountJSON.get(ACCOUNT_USER_NAME);
                String password = (String) accountJSON.get(ACCOUNT_PASSWORD);
                UUID id = UUID.fromString((String) accountJSON.get(ACCOUNT_ID));
                JSONArray privilegeSpecificJSON = (JSONArray) accountJSON.get(ACCOUNT_PRIVILEGE_SPECIFIC);
                
                if (((String)accountJSON.get(ACCOUNT_PRIVILEGE)).equals("Student")) {
                    accounts.add(makeStudent(name, username, password, id, privilegeSpecificJSON));
                } else if (((String)accountJSON.get(ACCOUNT_PRIVILEGE)).equals("Company")) {
                    accounts.add(makeCompany(name, username, password, id, privilegeSpecificJSON));
                } else if (((String)accountJSON.get(ACCOUNT_PRIVILEGE)).equals("Professor")) {
                    accounts.add(makeProfessor(name, username, password, id, privilegeSpecificJSON));
                } else if (((String)accountJSON.get(ACCOUNT_PRIVILEGE)).equals("Admin")) {
                    accounts.add(new Admin(name, username, password, id));
                }

            }

            return accounts;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Internship> setInternshipApplications(ArrayList<Internship> internships) {

        try {
            FileReader reader = new FileReader(APPLICATIONS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray applicationsJSON = (JSONArray) new JSONParser().parse(reader);
            for (int i = 0; i < applicationsJSON.size(); i++) {
                JSONObject applicationJSON = (JSONObject) applicationsJSON.get(i);
                UUID studentId = UUID.fromString((String)applicationJSON.get(APPLICATIONS_STUDENT_ID));
                Student student = (Student)AccountList.getInstance().getAccountById(studentId);
                JSONArray internshipIdsJSON = (JSONArray) applicationJSON.get(APPLICATIONS_INTERNSHIP_IDS);
                for (int j = 0; j < (internshipIdsJSON.size()); j++) {
                    UUID internshipId = UUID.fromString((String)internshipIdsJSON.get(j));
                    for (Internship internship : internships) {
                        if (internship.getId().equals(internshipId)) {
                            student.apply(internship);
                            break;
                        }
                    }
                }
            }
            reader.close();
            return internships;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Account> setAccountApplications(ArrayList<Account> accounts) {
        try {
            FileReader reader = new FileReader(APPLICATIONS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray applicationsJSON = (JSONArray) new JSONParser().parse(reader);
            for (int i = 0; i < applicationsJSON.size(); i++) {
                JSONObject applicationJSON = (JSONObject) applicationsJSON.get(i);
                UUID studentId = UUID.fromString((String) applicationJSON.get(APPLICATIONS_STUDENT_ID));
                Student student = null;
                for (int j = 0; j < accounts.size(); j++) {
                    if (accounts.get(j).getId().equals(studentId));
                    student = (Student)accounts.get(j);
                }
                JSONArray internshipIdsJSON = (JSONArray) applicationJSON.get(APPLICATIONS_INTERNSHIP_IDS);
                for (int j = 0; j < (internshipIdsJSON.size()); j++) {
                    UUID internshipId = UUID.fromString((String) internshipIdsJSON.get(j));
                    student.apply(InternshipList.getInstance().getInternshipById(internshipId));
                }
            }
            reader.close();
            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Account makeProfessor(String name, String username, String password, UUID id, JSONArray privilegeSpecificJSON) {
        String email = (String)privilegeSpecificJSON.get(0);
        String credentials = (String)privilegeSpecificJSON.get(1);
        return new Professor(name, username, password, email, credentials, id);
    }

    private static Account makeCompany(String name, String username, String password, UUID id, JSONArray privilegeSpecificJSON) {
        JSONArray ratingJSON = (JSONArray) privilegeSpecificJSON.get(0);
        JSONArray descriptionsJSON = (JSONArray) ratingJSON.get(1);
        ArrayList<String> descriptions = new ArrayList<String>();
        for (Object description : descriptionsJSON) {
            descriptions.add((String) description);
        }
        JSONArray availJobsJSON = (JSONArray)privilegeSpecificJSON.get(1);
        ArrayList<Internship> availJobs = new ArrayList<Internship>();
        for (Object availJobIdJSON : availJobsJSON) {
            UUID availJobId = UUID.fromString((String)availJobIdJSON);
            availJobs.add(InternshipList.getInstance().getInternshipById(availJobId));
        }
        Rating rating = new Rating((double) ratingJSON.get(0), descriptions);
        return new Company(name, username, password, rating, availJobs, id);
    }

    private static Account makeStudent(String name, String username, String password, UUID id, JSONArray privilegeSpecificJSON) {
        String email = (String)privilegeSpecificJSON.get(0);
        Resume resume = ResumeList.getInstance().getResumeById(UUID.fromString((String)privilegeSpecificJSON.get(1)));
        JSONArray ratingJSON = (JSONArray)privilegeSpecificJSON.get(2);
        JSONArray descriptionsJSON = (JSONArray) ratingJSON.get(1);
        ArrayList<String> descriptions = new ArrayList<String>();
        for (Object description : descriptionsJSON) {
            descriptions.add((String)description);
        }
        Rating rating = new Rating((double)ratingJSON.get(0), descriptions);
        String gradYear = (String)privilegeSpecificJSON.get(3);
        ArrayList<Internship> listOfAppJobs = new ArrayList<Internship>();
        return new Student(name, username, password, email, resume, rating, gradYear, listOfAppJobs, id);
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
                    JSONArray commExpJSON = (JSONArray)commExpsJSON.get(j);
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
