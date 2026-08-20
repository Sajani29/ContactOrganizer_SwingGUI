import java.util.*;
import javax.swing.*;
import java.awt.*;

class AddContact extends JFrame{
	private JPanel pnlDetails;
	private JPanel pnlText;
	AddContact(ContactManager manager){
		setTitle("Add Contact");
		setSize(600,6500);
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
		
		JLabel lblTopic = new JLabel("Add Contact to the list");
		lblTopic.setHorizontalAlignment(0);
		add("North",lblTopic);
		lblTopic.setFont(new Font("",2,20));
		lblTopic.setOpaque(true);
		lblTopic.setBackground(Color.ORANGE);
		lblTopic.setForeground(Color.BLACK);
		lblTopic.setPreferredSize(new Dimension(100, 50));
		
		JLabel lblContactID = new JLabel("Contact ID: " +manager.generateId(manager.id));
		lblContactID.setFont(new Font("",1,14));
		JLabel contactID = new JLabel(manager.generateId(manager.id));
		contactID.setFont(new Font("",1,14));
		JPanel pnlId = new JPanel(new FlowLayout(1));
		pnlId.add(lblContactID);
		pnlId.add(contactID);
		//pnlId.setLayout(new FlowLayout(0));
		add(pnlId);
		/*
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("",1,10));
		
		JLabel lblNumber = new JLabel("Phone Number : ");
		lblNumber.setFont(new Font("",1,10));
		
		JLabel lblCompanyName = new JLabel("Company Name :");
		lblCompanyName.setFont(new Font("",1,10));
		
		JLabel lblSalary = new JLabel("Salary :");
		lblSalary.setFont(new Font("",1,10));
		
		JLabel lblBOD = new JLabel("B'Day(YYYY-MM-DD):");
		lblBOD.setFont(new Font("",1,10));

		pnlDetails  = new JPanel(new GridLayout(6,1));
		pnlDetails.add(lblContactID);
		pnlDetails.add(lblName);
		pnlDetails.add(lblNumber);
		pnlDetails.add(lblCompanyName);
		pnlDetails.add(lblSalary);
		pnlDetails.add(lblBOD);
		
		pnlDetails.setBorder(
				BorderFactory.createEmptyBorder(20, 5, 10, 30)
			);

			//rightPanel.add(pnlButton);

		add("West",pnlDetails);
		*/
		pnlText = new JPanel(new GridLayout(6,1));
		pnlText.add(pnlId);
		
		
		JTextField txtName = new JTextField(15);
		JPanel pnlName = new JPanel();
		pnlName.add(txtName);
		
		JTextField txtPhoneNo = new JTextField(10);
		JPanel pnlNo = new JPanel();
		pnlNo.add(txtPhoneNo);
		
		JTextField txtComName = new JTextField(10);
		JPanel pnlComName = new JPanel();
		pnlComName.add(txtComName);
		
		JTextField txtSalary = new JTextField(5);
		JPanel pnlsalary = new JPanel();
		pnlsalary.add(txtSalary);
		
		JTextField txtDOB = new JTextField(9);
		JPanel pnlDOB = new JPanel();
		pnlDOB.add(txtDOB);
		
		pnlText.add(pnlName);
		pnlText.add(pnlNo);
		pnlText.add(pnlComName);
		pnlText.add(pnlsalary);
		pnlText.add(pnlDOB);
		
		add("East",pnlText);
	}
	
	
}
