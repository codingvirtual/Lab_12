import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Student_Entry_Dialog extends JDialog implements ActionListener {
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtMajor;
	private JTextField txtGPA;
	private JTextField txtUIN;
	private JTextField txtNetID;
	private JTextField txtAge;
	private JTextField txtGender;
	private Student_List roster;
	
	public Student_Entry_Dialog(Student_List roster) {
		this.roster = roster;
		setTitle("New Student Entry");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		JPanel mainPanel = new JPanel();
		getContentPane().add(mainPanel, BorderLayout.NORTH);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel entryPanel = new JPanel();
		mainPanel.add(entryPanel, BorderLayout.CENTER);
		entryPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("First Name");
		entryPanel.add(lblNewLabel);
		
		txtFirstName = new JTextField();
		entryPanel.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		entryPanel.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		entryPanel.add(txtLastName);
		
		JLabel lblMajor = new JLabel("Major");
		entryPanel.add(lblMajor);
		
		txtMajor = new JTextField();
		txtMajor.setColumns(10);
		entryPanel.add(txtMajor);
		
		JLabel lblGpa = new JLabel("GPA");
		entryPanel.add(lblGpa);
		
		txtGPA = new JTextField();
		txtGPA.setColumns(10);
		entryPanel.add(txtGPA);
		
		JLabel lblUin = new JLabel("UIN");
		entryPanel.add(lblUin);
		
		txtUIN = new JTextField();
		txtUIN.setColumns(10);
		entryPanel.add(txtUIN);
		
		JLabel lblNetId = new JLabel("Net ID");
		entryPanel.add(lblNetId);
		
		txtNetID = new JTextField();
		txtNetID.setColumns(10);
		entryPanel.add(txtNetID);
		
		JLabel lblAge = new JLabel("Age");
		entryPanel.add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		entryPanel.add(txtAge);
		
		JLabel lblNewLabel_1 = new JLabel("Gender");
		entryPanel.add(lblNewLabel_1);
		
		txtGender = new JTextField();
		txtGender.setColumns(10);
		entryPanel.add(txtGender);
		
		JPanel buttonPanel = new JPanel();
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(this);
		buttonPanel.add(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		buttonPanel.add(cancelButton);
		this.setSize(400,300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Cancel":		this.dispose();
							break;
		case "OK":			roster.add(createStudent());
							this.dispose();
							break;
		}
	}

	private Student createStudent() {
		return new Student(txtLastName.getText(),txtFirstName.getText(), txtMajor.getText(), Double.parseDouble(txtGPA.getText()), Integer.parseInt(txtUIN.getText()), txtNetID.getText(), Integer.parseInt(txtAge.getText()), txtGender.getText());
	}
}
