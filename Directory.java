import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
/**
 *
 * @author Songze Chen
 *
 */
import java.util.HashMap;
/**
 *
 * @author Songze Chen
 *
 */
public class Directory {
    /**
     * Key is andrewId, Value is Object Student.
     */
    private Map<String, Student> studentMap = new HashMap<String, Student>();
    /**
     * Key is andrewId, Value is firstName.
     */
    private Map<String, String> firstNameMap = new HashMap<String, String>();
    /**
     * Key is andrewId, Value is lastName.
     */
    private Map<String, String> lastNameMap = new HashMap<String, String>();
    /**
     * Directory.
     */
    public Directory() {
    }
    /**
     *
     * @param s Student
     */
    public void addStudent(Student s) {
        if (s == null) {
            throw new IllegalArgumentException();
        } else if (!studentMap.containsKey(s.getAndrewId())) {
            Student ss = new Student(s.getAndrewId());
            ss.setFirstName(s.getFirstName());
            ss.setLastName(s.getLastName());
            ss.setPhoneNumber(s.getPhoneNumber());
            studentMap.put(ss.getAndrewId(), ss);
            firstNameMap.put(ss.getAndrewId(), ss.getFirstName());
            lastNameMap.put(ss.getAndrewId(), ss.getLastName());
        } else {
            throw new IllegalArgumentException();
        }
    }
    /**
     *
     * @param andrewId andrewID
     */
    public void deleteStudent(String andrewId) {
        if (andrewId == null) {
            throw new IllegalArgumentException();
        } else if (studentMap.containsKey(andrewId)) {
            studentMap.remove(andrewId);
            firstNameMap.remove(andrewId);
            lastNameMap.remove(andrewId);
        } else {
            throw new IllegalArgumentException();
        }
    }
    /**
     *
     * @param andrewId andrewID
     * @return Student
     */
    public Student searchByAndrewId(String andrewId) {
        if (andrewId == null) {
            throw new IllegalArgumentException();
        } else if (studentMap.containsKey(andrewId)) {
            return studentMap.get(andrewId);
        }
        return null;
    }
    /**
     *
     * @param firstName
     *          firstName
     * @return Student
     */
    public List<Student> searchByFirstName(String firstName) {
        List<Student> firstNameList = new ArrayList<Student>();
        if (firstName == null) {
            throw new IllegalArgumentException();
        } else if (firstNameMap.containsValue(firstName)) {
            for (Entry<String, String> entry1 : firstNameMap.entrySet()) {
                if (entry1.getValue().equals(firstName)) {
                    firstNameList.add(studentMap.get(entry1.getKey()));
                }
            }
        }
        return firstNameList;
    }
    /**
     *
     * @param lastName
     *          lastName
     * @return Student
     */
    public List<Student> searchByLastName(String lastName) {
        List<Student> lastNameList = new ArrayList<Student>();
        if (lastName == null) {
            throw new IllegalArgumentException();
        } else if (lastNameMap.containsValue(lastName)) {
            for (Entry<String, String> entry2 : lastNameMap.entrySet()) {
                if (entry2.getValue().equals(lastName)) {
                    lastNameList.add(studentMap.get(entry2.getKey()));
                }
            }
        }
        return lastNameList;
    }
    /**
     *
     * @return how many Students in the map
     */
    public int size() {
        return studentMap.size();
    }
}
