import java.util.*;
import javax.swing.*;
import java.awt.*;

class AddContact extends JFrame{
	private JPanel pnlDetails;
	private JPanel pnlText;
	AddContact(ContactManager manager){
		setTitle("Add Contact");
		setSize(400,400);
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
		
		JLabel lblContactID = new JLabel("Contact ID: ");
		lblContactID.setFont(new Font("",1,10));
		JPanel pnlContactID = new JPanel();
		pnlContactID.add(lblContactID);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("",1,10));
		JPanel pnlName = new JPanel();
		pnlName.add(lblName);
		
		JLabel lblNumber = new JLabel("Phone Number : ");
		lblNumber.setFont(new Font("",1,10));
		JPanel pnlNumber = new JPanel();
		pnlNumber.add(lblNumber);
		
		JLabel lblCompanyName = new JLabel("Company Name :");
		lblCompanyName.setFont(new Font("",1,10));
		JPanel pnlCompanyName = new JPanel();
		pnlCompanyName.add(lblCompanyName);
		
		JLabel lblSalary = new JLabel("Salary :");
		lblSalary.setFont(new Font("",1,10));
		JPanel pnlSalary = new JPanel();
		pnlSalary.add(lblSalary);
		
		
		JLabel lblBOD = new JLabel("B'Day(YYYY-MM-DD):");
		lblBOD.setFont(new Font("",1,10));
		JPanel pnlBOD = new JPanel();
		pnlBOD.add(lblBOD);
		
		pnlDetails  = new JPanel(new GridLayout(6,1));
		pnlDetails.add(pnlContactID);
		pnlDetails.add(pnlName);
		pnlDetails.add(pnlNumber);
		pnlDetails.add(pnlCompanyName);
		pnlDetails.add(pnlSalary);
		pnlDetails.add(pnlBOD);
		
		pnlDetails.setBorder(
				BorderFactory.createEmptyBorder(20, 5, 10, 30)
			);

			//rightPanel.add(pnlButton);

		add("West",pnlDetails);

		
		
	}
	
	
}
