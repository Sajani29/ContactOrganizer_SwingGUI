import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
class AddContact extends JFrame {

    private JPanel pnlDetails;

    AddContact(ContactManager manager) {

        setTitle("Add Contact");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        // =====================================================
        // 1. TITLE
        // =====================================================

        JLabel lblTopic = new JLabel("Add Contact to the list");

        lblTopic.setHorizontalAlignment(SwingConstants.CENTER);
        lblTopic.setFont(new Font("", 2, 20));
        lblTopic.setOpaque(true);
        lblTopic.setBackground(Color.yellow);
        lblTopic.setForeground(Color.black);

        add(lblTopic, BorderLayout.NORTH);


        // =====================================================
        // 2. MAIN CENTER PANEL
        // =====================================================

        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));


        // =====================================================
        // 3. CONTACT ID
        // =====================================================

        JLabel lblContactId =
                new JLabel("Contact ID: " + manager.generateId(manager.id));
		lblContactId.setForeground(Color.blue);
        lblContactId.setFont(new Font("", Font.BOLD, 14));
        lblContactId.setAlignmentX(Component.CENTER_ALIGNMENT);

        pnlMain.add(Box.createVerticalStrut(15));
        pnlMain.add(lblContactId);
        pnlMain.add(Box.createVerticalStrut(20));


        // =====================================================
        // 4. LABELS
        // =====================================================

        JLabel lblName = new JLabel("Name :");
        lblName.setFont(new Font("", Font.BOLD, 10));

        JLabel lblNumber = new JLabel("Phone Number :");
        lblNumber.setFont(new Font("", Font.BOLD, 10));

        JLabel lblCompanyName = new JLabel("Company Name :");
        lblCompanyName.setFont(new Font("", Font.BOLD, 10));

        JLabel lblSalary = new JLabel("Salary :");
        lblSalary.setFont(new Font("", Font.BOLD, 10));

        JLabel lblBOD = new JLabel("B'Day (YYYY-MM-DD):");
        lblBOD.setFont(new Font("", Font.BOLD, 10));


        // =====================================================
        // 5. TEXT FIELDS
        // =====================================================

        JTextField txtName = new JTextField(15);

        JTextField txtPhoneNo = new JTextField(10);
 
        JTextField txtComName = new JTextField(10);

        JTextField txtSalary = new JTextField(7);
  
        JTextField txtDOB = new JTextField(10);
        
		

        // =====================================================
        // 6. LABEL PANELS
        //    These move the labels slightly to the right
        // =====================================================

        JPanel pnlNameLabel =
                new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        pnlNameLabel.add(lblName);


        JPanel pnlNumberLabel =
                new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        pnlNumberLabel.add(lblNumber);


        JPanel pnlCompanyLabel =
                new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        pnlCompanyLabel.add(lblCompanyName);


        JPanel pnlSalaryLabel =
                new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        pnlSalaryLabel.add(lblSalary);


        JPanel pnlBODLabel =
                new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        pnlBODLabel.add(lblBOD);


        // =====================================================
        // 7. TEXT FIELD PANELS
        //    These keep the text fields small
        // =====================================================

        JPanel pnlName =
                new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnlName.add(txtName);


        JPanel pnlNo =
                new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnlNo.add(txtPhoneNo);


        JPanel pnlComName =
                new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnlComName.add(txtComName);


        JPanel pnlSalary =
                new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnlSalary.add(txtSalary);


        JPanel pnlDOB =
                new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnlDOB.add(txtDOB);


        // =====================================================
        // 8. DETAILS GRID
        // =====================================================

        pnlDetails = new JPanel(
                new GridLayout(5, 2, 10, 10)
        );


        // Row 1
        pnlDetails.add(pnlNameLabel);
        pnlDetails.add(pnlName);


        // Row 2
        pnlDetails.add(pnlNumberLabel);
        pnlDetails.add(pnlNo);


        // Row 3
        pnlDetails.add(pnlCompanyLabel);
        pnlDetails.add(pnlComName);


        // Row 4
        pnlDetails.add(pnlSalaryLabel);
        pnlDetails.add(pnlSalary);


        // Row 5
        pnlDetails.add(pnlBODLabel);
        pnlDetails.add(pnlDOB);


        // =====================================================
        // 9. FORM WRAPPER
        //    Keeps the grid from stretching across the frame
        // =====================================================

        JPanel pnlFormWrapper =
                new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        pnlFormWrapper.add(pnlDetails);

        pnlMain.add(pnlFormWrapper);


        // Add main panel to CENTER
        add(pnlMain, BorderLayout.CENTER);


        // =====================================================
        // 10. BUTTON PANEL
        // =====================================================

        JPanel pnlButtons =
                new JPanel(new FlowLayout(
                        FlowLayout.CENTER, 20, 10
                ));

        JButton btnAddContact = new JButton("Add Contact");
        JButton btnCancel = new JButton("Cancel");

        pnlButtons.add(btnAddContact);
        pnlButtons.add(btnCancel);
        btnAddContact.setBackground(Color.GREEN);
        btnCancel.setBackground(Color.red );
        add(pnlButtons, BorderLayout.SOUTH);

		//Add contact button event==========
        btnAddContact.addActionListener(e -> {
			String name = txtName.getText();
			String phone = txtPhoneNo.getText().trim();
			String companyName = txtComName.getText();
			double salary = Double.parseDouble(txtSalary.getText());
			String dOB = txtDOB.getText();
			
			if (!(manager.isValidPhonenumber(phone)))
			{
				JOptionPane.showMessageDialog(
							AddContact.this,
							"Invalid phone number.\n" +
							"Phone number must start with 0 and contain 10 digits."
					);

					return;
			}
			
			if (!(manager.isValidsalary(salary)))
			{				
				JOptionPane.showMessageDialog(
							AddContact.this,
							"Invalid value for salary.\n" +
							"Salary must be positive."
					);
					
					return;
			}
			
			if (!(manager.isValidBirthday(dOB)))
			{
				JOptionPane.showMessageDialog(
							AddContact.this,
							"Invalid value for Birth day.\n" +
							"Enter YYYY-MM-DD format."
					);
			}
			
			manager.addContact(name,phone,companyName,salary,dOB);
			JOptionPane.showMessageDialog(this, "Contact added successfully!");
			dispose();
			MainForm.main(null);
		});
		
        // cancel button event=============
        btnCancel.addActionListener(e -> {
            dispose();
        });


        // =====================================================
        // 12. SHOW FRAME
        // =====================================================

        setVisible(true);
    }
}
