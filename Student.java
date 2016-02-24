/**
 * @author Songze Chen
 */
public class Student {
    /**
     * andrewId.
     */
    private String andrewId;
    /**
     * firstName.
     */
    private String firstName;
    /**
     * lastName.
     */
    private String lastName;
    /**
     * phoneNumber.
     */
    private String phoneNumber;
    /**
     *
     * @param andrewId andrewID
     */
    public Student(String andrewId) {
        this.andrewId = andrewId;
    }
    /**
     *
     * @return andrewId
     */
    public String getAndrewId() {
        return andrewId;
    }
    /**
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     *
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     *
     * @param s firstName
     */
    public void setFirstName(String s) {
        if (firstName == null) {
            firstName = s;
        }
    }
    /**
     *
     * @param s lastName
     */
    public void setLastName(String s) {
        if (lastName == null) {
            lastName = s;
        }
    }
    /**
     *
     * @param s phoneNumber
     */
    public void setPhoneNumber(String s) {
        if (phoneNumber == null) {
            phoneNumber = s;
        }
    }
    /**
     * @return representation of Student
     */
    public String toString() {
        return firstName + " " + lastName + " (Andrew ID: " + andrewId + ", Phone Number: " + phoneNumber + ")";
    }
}
