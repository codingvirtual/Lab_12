import java.util.*;
import javax.swing.*;

import java.awt.*;
import javax.swing.border.*;
import java.awt.Color;
import java.awt.event.*;

/**

Create a GUI for this particular project. You can use the lab 4 solution that you’ve submitted.
Your GUI is completely up to you and should display all information that you find useful. It 
should be intuitive and informative.
Create a program that keeps track of specific information for Students. The information stored 
should be the following:
First Name, Last Name, Major, GPA, UIN, NetID, Age, Gender,
For this simple program we will only need to store 10 students in an ArrayList. Your students 
should be stored in an object called Student.
You should be able to add, sort (by any column you chose) and remove Students in the ArrayList.

**/



public class Lab_12 extends JFrame implements ActionListener {
	private JTextField txtMajor;
	private JTextField txtGpa;
	private JTextField txtUIN;
	private JTextField txtNetID;
	private JTextField txtAge;
	private JTextField txtGender;
	private Student_List roster = new Student_List();
	private DefaultListModel displayList = new DefaultListModel();
	private JList rosterList = new JList(displayList);
	private JLabel lblIndex;


	public static void main(String[] args) {
		new Lab_12();
	}

	public Lab_12() {
		this.setSize(800, 600);
		setTitle("Student Roster List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new TitledBorder(null, "Students", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel rosterPanel = new JPanel();
		mainPanel.add(rosterPanel, BorderLayout.CENTER);
		rosterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		

		rosterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rosterPanel.add(rosterList);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new GridLayout(0, 8, 0, 0));
		
		JButton nameField = new JButton("Name");
		nameField.addActionListener(this);
		
		lblIndex = new JLabel("Index");
		lblIndex.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(lblIndex);
		nameField.setContentAreaFilled(false);
		nameField.setDefaultCapable(false);
		nameField.setToolTipText("Click to sort by name");
		nameField.setBackground(new Color(255, 255, 255));
		nameField.setBorder(new LineBorder(new Color(0, 0, 0)));
		headerPanel.add(nameField);
		
		txtMajor = new JTextField();
		txtMajor.setHorizontalAlignment(SwingConstants.CENTER);
		txtMajor.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtMajor.setText("Major");
		headerPanel.add(txtMajor);
		txtMajor.setColumns(10);
		
		txtGpa = new JTextField();
		txtGpa.setHorizontalAlignment(SwingConstants.CENTER);
		txtGpa.setText("GPA");
		headerPanel.add(txtGpa);
		txtGpa.setColumns(10);
		
		txtUIN = new JTextField();
		txtUIN.setHorizontalAlignment(SwingConstants.CENTER);
		txtUIN.setText("UIN");
		headerPanel.add(txtUIN);
		txtUIN.setColumns(10);
		
		txtNetID = new JTextField();
		txtNetID.setHorizontalAlignment(SwingConstants.CENTER);
		txtNetID.setText("NetID");
		headerPanel.add(txtNetID);
		txtNetID.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setHorizontalAlignment(SwingConstants.CENTER);
		txtAge.setText("Age");
		headerPanel.add(txtAge);
		txtAge.setColumns(10);
		
		txtGender = new JTextField();
		txtGender.setText("Gender");
		txtGender.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(txtGender);
		txtGender.setColumns(10);
		
		JButton addStudent = new JButton("+");
		addStudent.addActionListener(this);
		
		getContentPane().add(addStudent, BorderLayout.WEST);
		
		JButton removeStudent = new JButton("-");
		removeStudent.addActionListener(this);
		getContentPane().add(removeStudent, BorderLayout.EAST);
		this.setVisible(true);
		
		updateList();
	}


private void updateList() {
	displayList.clear();
	for (Student s : roster) {
		String[] parsedList = s.toString().split("[|]");
		displayList.addElement(String.format("%-30s%5s, %5s%-25s%-25s%-25s%-25s%-25s%-25s", parsedList[0], parsedList[2], parsedList[1], parsedList[3], parsedList[4], parsedList[5], parsedList[6], parsedList[7], parsedList[8]));
	}
}

	private static void sortRoster(Student_List roster) {
		Collections.sort(roster, new Comparator<Student>(){
							public int compare(Student s1, Student s2) {
								return s1.getLast().compareToIgnoreCase(s2.getLast());
							}
						});
	}
		 
	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "+":		new Student_Entry_Dialog(roster);
							break;
			case "-":		roster.removeStudent(Integer.parseInt(rosterList.getSelectedValue().toString().substring(0, 29).trim()));
							break;
			case "Name":	sortRoster(roster);
							break;
		}
		
		updateList();
	}
}

