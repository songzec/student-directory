/**
 *
 * @author Songze Chen
 *
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
/**
 * create a swing GUI of a database.
 */
public class DirectoryDriver implements ActionListener, KeyListener {
    /**
     * Initialize JButtons.
     */
    private JButton addButton, deleteButton, searchByAndrewIDButton,
        searchByFirstNameButton, searchByLastNameButton;
    /**
     * Initialize JTextArea.
     */
    private JTextArea resultArea;
    /**
     * Initialize JTextFields.
     */
    private JTextField addFirstNameArea, addLastNameArea, addAndrewIDArea,
        addPhoneNumberArea, deleteAndrewIDArea, searchKeyArea;
    /**
     * database named Directory.
     */
    private static Directory newDirectory = new Directory();
    /**
     * Constructor.
     */
    public DirectoryDriver() {
        JFrame frame = new JFrame("Student Directory");
        frame.setSize(1000, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        JPanel addPanel = new JPanel();
        JPanel deletePanel = new JPanel();
        JPanel searchPanel = new JPanel();
        JPanel resultPanel = new JPanel();
        Font labelFont = new Font(Font.DIALOG, Font.CENTER_BASELINE, 15);
        Border areaBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3);
        addPanel.setBackground(Color.white);
        Border addPanelBorder = BorderFactory.createTitledBorder("Add a new student");
        addPanel.setBorder(addPanelBorder);
        /**
         * Create addFirstNameLabel.
         */
        JLabel addFirstNameLabel = new JLabel("First Name: ");
        addFirstNameLabel.setFont(labelFont);
        addPanel.add(addFirstNameLabel);
        addFirstNameArea = new JTextField(10);
        addFirstNameArea.setBorder(areaBorder);
        addPanel.add(addFirstNameArea);
        /**
         * Create addLastNameLabel.
         */
        JLabel addLastNameLabel = new JLabel("Last Name: ");
        addLastNameLabel.setFont(labelFont);
        addPanel.add(addLastNameLabel);
        addLastNameArea = new JTextField(10);
        addLastNameArea.setBorder(areaBorder);
        addPanel.add(addLastNameArea);
        /**
         * Create addAndrewIDLabel.
         */
        JLabel addAndrewIDLabel = new JLabel("Andrew ID: ");
        addAndrewIDLabel.setFont(labelFont);
        addPanel.add(addAndrewIDLabel);
        addAndrewIDArea = new JTextField(10);
        addAndrewIDArea.setBorder(areaBorder);
        addPanel.add(addAndrewIDArea);
        /**
         * Create addPhoneNumberLabel.
         */
        JLabel addPhoneNumberLabel = new JLabel("Phone Number: ");
        addPhoneNumberLabel.setFont(labelFont);
        addPanel.add(addPhoneNumberLabel);
        addPhoneNumberArea = new JTextField(10);
        addPhoneNumberArea.setBorder(areaBorder);
        addPanel.add(addPhoneNumberArea);
        /**
         * Create addButton.
         */
        addButton = new JButton("Add");
        addButton.setSize(20, 10);
        addButton.addActionListener(this);
        addPanel.add(addButton);
        JLabel addSpaceLabel = new JLabel("           ");
        addPanel.add(addSpaceLabel);
        /**
         * Set deletePenel's features.
         */
        deletePanel.setBackground(Color.white);
        Border deletePanelBorder = BorderFactory.createTitledBorder("Delete a new student");
        deletePanel.setBorder(deletePanelBorder);
        /**
         * Create deleteAndrewIDLabel.
         */
        JLabel deleteAndrewIDLabel = new JLabel("Andrew ID: ");
        deleteAndrewIDLabel.setFont(labelFont);
        deletePanel.add(deleteAndrewIDLabel);
        deleteAndrewIDArea = new JTextField(15);
        deleteAndrewIDArea.setBorder(areaBorder);
        deletePanel.add(deleteAndrewIDArea);
        /**
         * Create deleteButton.
         */
        deleteButton = new JButton("Delete");
        deleteButton.setSize(20, 10);
        deleteButton.addActionListener(this);
        deletePanel.add(deleteButton);
        JLabel deleteSpaceLabel = new JLabel("                                "
                + "                                                           "
                + "                                                           "
                + "                                                         ");
        deletePanel.add(deleteSpaceLabel);
        /**
         * Set searchPanel's features.
         */
        searchPanel.setBackground(Color.white);
        Border searchPanelBorder = BorderFactory.createTitledBorder("Search student(s)");
        searchPanel.setBorder(searchPanelBorder);
        /**
         * Create searchAndrewIDLabel.
         */
        JLabel searchAndrewIDLabel = new JLabel("Search Key: ");
        searchAndrewIDLabel.setFont(labelFont);
        searchPanel.add(searchAndrewIDLabel);
        /**
         * Create Search Key Area.
         */
        searchKeyArea = new JTextField(15);
        searchKeyArea.setBorder(areaBorder);
        searchKeyArea.addKeyListener(this);
        searchPanel.add(searchKeyArea);
        /**
         * Create searchButton.
         */
        searchByAndrewIDButton = new JButton("By Andrew ID");
        searchByAndrewIDButton.setSize(20, 10);
        searchByAndrewIDButton.addActionListener(this);
        searchPanel.add(searchByAndrewIDButton);
        searchByFirstNameButton = new JButton("By First Name");
        searchByFirstNameButton.setSize(20, 10);
        searchByFirstNameButton.addActionListener(this);
        searchPanel.add(searchByFirstNameButton);
        searchByLastNameButton = new JButton("By Last Name");
        searchByLastNameButton.setSize(20, 10);
        searchByLastNameButton.addActionListener(this);
        searchPanel.add(searchByLastNameButton);
        JLabel searchSpaceLabel = new JLabel("                                "
                + "                                                           "
                + "                      ");
        searchPanel.add(searchSpaceLabel);
        /**
         * Set resultPanel's features.
         */
        resultPanel.setBackground(Color.white);
        Border resultPanelBorder = BorderFactory.createTitledBorder("Results");
        resultPanel.setBorder(resultPanelBorder);
        /**
         * Create result Key Area.
         */
        resultArea = new JTextArea(20, 87);
        resultArea.setEditable(false);
        resultArea.setBorder(areaBorder);
        JScrollPane scroller = new JScrollPane(resultArea);
        resultPanel.add(scroller);
        /**
         * add all panels to frame.
         */
        pane.add(addPanel);
        pane.add(deletePanel);
        pane.add(searchPanel);
        pane.add(resultPanel);
        frame.setContentPane(pane);
        frame.setVisible(true);
        searchKeyArea.requestFocusInWindow();
    }
    /**
     * Detect action events.
     * @param e
     * event
     */
    public void actionPerformed(ActionEvent e) {
        /**
         * add a new student.
         */
        if (e.getSource() == addButton) {
            if (addAndrewIDArea.getText().length() != 0 && addFirstNameArea.getText().length() != 0
                    && addLastNameArea.getText().length() != 0) {
                if (newDirectory.searchByAndrewId(addAndrewIDArea.getText()) == null) {
                    Student newStudent = new Student(addAndrewIDArea.getText());
                    newStudent.setFirstName(addFirstNameArea.getText());
                    newStudent.setLastName(addLastNameArea.getText());
                    newStudent.setPhoneNumber(addPhoneNumberArea.getText());
                    newDirectory.addStudent(newStudent);
                    resultArea.setText(newStudent.toString() + " is added.\n");
                    return;
                }
                resultArea.append("Database already contains an entry for this Andrew ID\n");
                return;
            }
            if (addAndrewIDArea.getText().length() == 0) {
                resultArea.append("Andrew ID missing\n");
                return;
            }
            if (addFirstNameArea.getText().length() == 0) {
                resultArea.append("First Name missing\n");
                return;
            }
            if (addLastNameArea.getText().length() == 0) {
                resultArea.append("Last Name missing\n");
                return;
            }
        }
        /**
         * delete a student if he/she exists.
         */
        if (e.getSource() == deleteButton) {
            if (deleteAndrewIDArea.getText().length() == 0) {
                resultArea.append("Andrew ID missing\n");
                return;
            }
            try {
                Student s = newDirectory.searchByAndrewId(deleteAndrewIDArea.getText());
                newDirectory.deleteStudent(deleteAndrewIDArea.getText());
                resultArea.setText(s + " was deleted.\n");
            } catch (Exception exception) {
                resultArea.append("There is no student with Andrew ID " + deleteAndrewIDArea.getText() + "\n");
            }
            if (deleteAndrewIDArea.getText().length() == 0) {
                resultArea.append("Andrew ID missing\n");
            }
            return;
        }
        /**
         * search by Andrew ID.
         */
        if (e.getSource() == searchByAndrewIDButton) {
            if (searchKeyArea.getText().length() == 0) {
                resultArea.append("Andrew ID missing\n");
                return;
            }
            try {
                Student s = newDirectory.searchByAndrewId(searchKeyArea.getText());
                resultArea.setText(s.toString() + "\n");
            } catch (Exception exception) {
                resultArea.append("There is no student with Andrew ID " + searchKeyArea.getText() + "\n");
            }
            return;
        }
        /**
         * search by first name, if more than one show a list.
         */
        if (e.getSource() == searchByFirstNameButton) {
            if (searchKeyArea.getText().length() == 0) {
                resultArea.append("First Name missing\n");
                return;
            }
            List<Student> firstNameList = newDirectory.searchByFirstName(searchKeyArea.getText());
            if (!firstNameList.isEmpty()) {
                resultArea.setText("");
            }
            for (Student s : firstNameList) {
                resultArea.append(s.toString() + "\n");
            }
            if (firstNameList.isEmpty()) {
                resultArea.append("There is no student with first name " + searchKeyArea.getText() + "\n");
            }
            return;
        }
        /**
         * search by last name, if more than one show a list.
         */
        if (e.getSource() == searchByLastNameButton) {
            if (searchKeyArea.getText().length() == 0) {
                resultArea.append("Last Name missing\n");
                return;
            }
            List<Student> lastNameList = newDirectory.searchByLastName(searchKeyArea.getText());
            if (!lastNameList.isEmpty()) {
                resultArea.setText("");
            }
            for (Student s : lastNameList) {
                resultArea.append(s.toString() + "\n");
            }
            if (lastNameList.isEmpty()) {
                resultArea.append("There is no student with last name " + searchKeyArea.getText() + "\n");
            }
            return;
        }
    }
    /**
     * Read and add Students in CSV File.
     * @param csvFile
     * csvFile
     * @throws IOException
     * IOException.
     */
    public static void csvReader(BufferedReader csvFile) throws IOException {
        boolean eof = false;
        int j = 0;
        String line = csvFile.readLine();
        if (line == null) {
            eof = true;
        }
        while (!eof) {
            line = csvFile.readLine();
            if (line == null) {
                eof = true;
            } else {
                String valueToString = new String();
                String tempFirstName = new String();
                String tempLastName = new String();
                String tempAndrewID = new String();
                String tempPhoneNumber = new String();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '"') {
                        StringBuffer value = new StringBuffer();
                        value.append("");
                        int iplus = i + 1;
                        while (line.charAt(iplus) != '"') {
                            value.append(line.charAt(iplus));
                            i++;
                            iplus++;
                        }
                        i += 2;
                        valueToString = value.toString();
                        j++;
                    }
                    if (j == 1) {
                        tempFirstName = valueToString;
                    } else if (j == 2) {
                        tempLastName = valueToString;
                    } else if (j == 3) {
                        tempAndrewID = valueToString;
                    } else if (j == 4) {
                        tempPhoneNumber = valueToString;
                        j = 0;
                    }
                }
                Student newStudent = new Student(tempAndrewID);
                newStudent.setFirstName(tempFirstName);
                newStudent.setLastName(tempLastName);
                newStudent.setPhoneNumber(tempPhoneNumber);
                newDirectory.addStudent(newStudent);
            }
        }
    }
    /**
     *
     * @param args
     * input argument
     * @throws IOException
     * IO Exception
     */
    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            FileReader fr = new FileReader(args[0]);
            BufferedReader bf = new BufferedReader(fr);
            csvReader(bf);
        }
        new DirectoryDriver();
    }
    /**
     * @param e
     * if press enter in searchArea, then search by Andrew ID.
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (searchKeyArea.getText().length() == 0) {
                resultArea.append("Andrew ID missing\n");
                return;
            }
            try {
                Student s = newDirectory.searchByAndrewId(searchKeyArea.getText());
                resultArea.setText(s.toString() + "\n");
            } catch (Exception exception) {
                resultArea.append("There is no student with Andrew ID " + searchKeyArea.getText() + "\n");
            }
            return;
        }
    }
    /**
     * @param e
     * not putting anything in this method.
     */
    public void keyReleased(KeyEvent e) {
        // not putting anything in this method.
    }
    /**
     * @param e
     * not putting anything in this method.
     */
    public void keyTyped(KeyEvent e) {
        // not putting anything in this method.
    }
}
