import java.util.*;
import javax.swing.*;
import java.awt.*;

class SearchContact extends JFrame{
	
	public SearchContact(ContactManager manager){
		
		setTitle("Search Contact");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
      
        // <==========================1. TITLE========================>

        JLabel lblTopic = new JLabel("Search Contact");

        lblTopic.setHorizontalAlignment(SwingConstants.CENTER);
        lblTopic.setFont(new Font("", 2, 20));
        lblTopic.setOpaque(true);
        lblTopic.setBackground(Color.yellow);
        lblTopic.setForeground(Color.black);


        // <==========================2. INPUT========================>

        JPanel pnlInput = new JPanel(new GridLayout(1,2));
        
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


        // <==========================5. BUTTONS========================>

        JButton btnBack = new JButton("Back");
        btnBack.setBackground(Color.red);
		btnBack.addActionListener(e -> {
			MainForm.main(null);
		});
			

        JButton btnSearch = new JButton("Search");
        btnSearch.setBackground(Color.GREEN);


        btnSearch.addActionListener(e -> {
			
			String input = txtInput.getText();
			
			int index = manager.searchNameorPhoneNo(input);

			if (index == -1) {
				
				JOptionPane.showMessageDialog(
					SearchContact.this,
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
			}
		});


        // <==========================6. BUTTON PANEL========================>

        JPanel pnlButton = new JPanel();

        pnlButton.add(btnBack);
        pnlButton.add(btnSearch);

        add(pnlButton, BorderLayout.SOUTH);


        // <==========================7. SHOW FRAME========================>

        setVisible(true);
        
	}
}
