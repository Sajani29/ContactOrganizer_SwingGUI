import java.util.*;
import javax.swing.*;
import java.awt.*;

class UpdateContact extends JFrame{
		private JPanel pnlUpdatebutton;
		private JButton btnCancel;
		private JButton btnUpdateName;
		private JButton btnUpdatePhoneno;
		private JButton btnUpdateComName;
		private JButton btnUpdateSalary;
		private int index;
		public UpdateContact(ContactManager manager){
		setTitle("Update Contact");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // <==========================1. TITLE========================>

        JLabel lblTopic = new JLabel("Update Contact");

        lblTopic.setHorizontalAlignment(SwingConstants.CENTER);
        lblTopic.setFont(new Font("", 2, 20));
        lblTopic.setOpaque(true);
        lblTopic.setBackground(Color.yellow);
        lblTopic.setForeground(Color.black);


        // <==========================2. INPUT========================>

        JPanel pnlInput = new JPanel(new GridLayout(1, 2));

        JLabel lblName = new JLabel("Enter your name or Phone no: ");
        lblName.setFont(new Font("", Font.BOLD, 15));

        JPanel pnlNameLabel = new JPanel(
            new FlowLayout(FlowLayout.LEFT, 20, 0)
        );

        pnlNameLabel.add(lblName);

        JTextField txtInput = new JTextField(15);

        JPanel pnlInputName = new JPanel(
            new FlowLayout(FlowLayout.LEFT)
        );

        pnlInputName.add(txtInput);

        pnlInput.add(pnlNameLabel);
        pnlInput.add(pnlInputName);


        // <==========================3. TOP PANEL========================>

        JPanel pnlTop = new JPanel(new BorderLayout());

        pnlTop.add(lblTopic, BorderLayout.NORTH);
        pnlTop.add(pnlInput, BorderLayout.CENTER);

        add(pnlTop, BorderLayout.NORTH);


        // <==========================4. TABLE PANEL========================>

        JPanel pnlTable = new JPanel(new BorderLayout());

        add(pnlTable, BorderLayout.CENTER);


        // <==========================5. UPDATE BUTTON PANEL========================>

        pnlUpdatebutton = new JPanel(
            new FlowLayout(FlowLayout.CENTER, 20, 10)
        );

        JLabel lblChoice = new JLabel(
            "Choose Options which want to update ->  "
        );
        
        //Cancel button
        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("", Font.BOLD, 10));
        btnCancel.setBackground(Color.red);
        btnCancel.addActionListener(e -> {
			dispose();
		});

		//Update name button
        btnUpdateName = new JButton("Name");
        btnUpdateName.setFont(new Font("", Font.BOLD, 10));
        btnUpdateName.setBackground(Color.green);
		btnUpdateName.addActionListener(e -> {
		//manager.reduceArrays(index);

		JOptionPane.showMessageDialog(
			UpdateContact.this,
			"Name is updated successfully."
		);
		});
		
		//Update Phone no button
        btnUpdatePhoneno = new JButton("Phone Number");
        btnUpdatePhoneno.setFont(new Font("", Font.BOLD, 10));
        btnUpdatePhoneno.setBackground(Color.green);
		btnUpdatePhoneno.addActionListener(e -> {
		//manager.reduceArrays(index);

		JOptionPane.showMessageDialog(
			UpdateContact.this,
			"Phone Number is updated successfully."
		);
		});
		
		//Update com name 
		btnUpdateComName = new JButton("Comapny Name");
        btnUpdateComName.setFont(new Font("", Font.BOLD, 10));
        btnUpdateComName.setBackground(Color.green);
		btnUpdateComName.addActionListener(e -> {
		//manager.reduceArrays(index);

		JOptionPane.showMessageDialog(
			UpdateContact.this,
			"Company Name is updated successfully."
		);
		});

		//UPDATE salary
		btnUpdateSalary = new JButton("Salary");
        btnUpdateSalary.setFont(new Font("", Font.BOLD, 10));
        btnUpdateSalary.setBackground(Color.green);
		btnUpdateSalary.addActionListener(e -> {

		JPanel pnlgetSalary = new JPanel(new GridLayout(1, 2));

        JLabel lblSalary = new JLabel("Enter new salary: ");
        lblSalary.setFont(new Font("", Font.BOLD, 15));

        JPanel pnlSalaryLabel = new JPanel(
            new FlowLayout(FlowLayout.LEFT, 20, 0)
        );

        pnlSalaryLabel.add(lblSalary);

        JTextField txtInputforSalary = new JTextField(15);

        JPanel pnlInputSalary = new JPanel(
            new FlowLayout(FlowLayout.LEFT)
        );

        pnlInputSalary.add(txtInputforSalary);

        pnlgetSalary.add(pnlSalaryLabel);
        pnlgetSalary.add(pnlInputSalary);
        
        //btnUpdateSalary.add(pnlgetSalary);
		btnUpdateSalary.setVisible(false);
		
		//JPanel pnlInput = new JPanel();
		//manager.updateSalary(index);
		//manager.reduceArrays(index);

		JOptionPane.showMessageDialog(
			UpdateContact.this,
			"Salary is updated successfully."
		);

		});

        pnlUpdatebutton.add(lblChoice);
        pnlUpdatebutton.add(btnCancel);
        pnlUpdatebutton.add(btnUpdateName);
        pnlUpdatebutton.add(btnUpdatePhoneno);
        pnlUpdatebutton.add(btnUpdateComName);
        pnlUpdatebutton.add(btnUpdateSalary);

        // Initially hide update panel
        pnlUpdatebutton.setVisible(false);
        
         // <==========================6. BACK BUTTON========================>

        JButton btnBack = new JButton("Back");
        btnBack.setBackground(Color.red);

        btnBack.addActionListener(e -> {
            dispose();
            MainForm.main(null);
        });


        // <==========================7. SEARCH BUTTON========================>

        JButton btnSearch = new JButton("Search");
        btnSearch.setBackground(Color.GREEN);


        btnSearch.addActionListener(e -> {

            String input = txtInput.getText();

             index = manager.searchNameorPhoneNo(input);

            if (index == -1) {

                JOptionPane.showMessageDialog(
                    UpdateContact.this,
                    "No Contact found for " + input
                );

            } else {

                String[] columnNames = {
                    "Contact ID",
                    "Name",
                    "Phone Number",
                    "Company Name",
                    "Salary",
                    "B'Day"
                };

                String[][] data = {
                    {
                        manager.contactArray[index].getContactId(),
                        manager.contactArray[index].getContactName(),
                        manager.contactArray[index].getContactPhoneNumber(),
                        manager.contactArray[index].getCompanyName(),
                        String.valueOf(
                            manager.contactArray[index].getSalaryAmount()
                        ),
                        manager.contactArray[index].getDoB()
                    }
                };

                JTable table = new JTable(data, columnNames);

                JScrollPane scrollPane = new JScrollPane(table);

                pnlTable.removeAll();

                pnlTable.add(
                    scrollPane,
                    BorderLayout.CENTER
                );

                pnlTable.revalidate();
                pnlTable.repaint();

                // Show Delete/Cancel panel
                pnlUpdatebutton.setVisible(true);
            }
        });


        // <==========================8. SEARCH/BACK PANEL========================>

        JPanel pnlButton = new JPanel();

        pnlButton.add(btnBack);
        pnlButton.add(btnSearch);


        // <==========================9. BOTTOM PANEL========================>

        JPanel pnlBottom = new JPanel();
        pnlBottom.setLayout(new BoxLayout(pnlBottom, BoxLayout.Y_AXIS));

        pnlBottom.add(pnlUpdatebutton);
        pnlBottom.add(pnlButton);

        add(pnlBottom, BorderLayout.SOUTH);


        // <==========================10. SHOW FRAME========================>

        setVisible(true);
	}
}
