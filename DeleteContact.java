import java.util.*;
import javax.swing.*;
import java.awt.*;

class DeleteContact extends JFrame {

    private JButton btnDelete;
    private JButton btnCancel;
    private JPanel pnlDeletebutton;
	private int index;
    public DeleteContact(ContactManager manager) {

        setTitle("Delete Contact");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // <==========================1. TITLE========================>

        JLabel lblTopic = new JLabel("Delete Contact");

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


        // <==========================5. DELETE BUTTON PANEL========================>

        pnlDeletebutton = new JPanel(
            new FlowLayout(FlowLayout.CENTER, 20, 10)
        );

        JLabel lblChoice = new JLabel(
            "Do you want delete this contact?"
        );

        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("", Font.BOLD, 10));
        btnCancel.setBackground(Color.yellow);
        btnCancel.addActionListener(e -> {
			dispose();
		});

        btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("", Font.BOLD, 10));
        btnDelete.setBackground(Color.red);
		btnDelete.addActionListener(e -> {
		manager.reduceArrays(index);

		JOptionPane.showMessageDialog(
			DeleteContact.this,
			"Contact deleted successfully."
		);

		dispose();
		MainForm.main(null);
		});

        pnlDeletebutton.add(lblChoice);
        pnlDeletebutton.add(btnCancel);
        pnlDeletebutton.add(btnDelete);

        // Initially hide delete panel
        pnlDeletebutton.setVisible(false);


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
                    DeleteContact.this,
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
                pnlDeletebutton.setVisible(true);
            }
        });


        // <==========================8. SEARCH/BACK PANEL========================>

        JPanel pnlButton = new JPanel();

        pnlButton.add(btnBack);
        pnlButton.add(btnSearch);


        // <==========================9. BOTTOM PANEL========================>

        JPanel pnlBottom = new JPanel();
        pnlBottom.setLayout(new BoxLayout(pnlBottom, BoxLayout.Y_AXIS));

        pnlBottom.add(pnlDeletebutton);
        pnlBottom.add(pnlButton);

        add(pnlBottom, BorderLayout.SOUTH);


        // <==========================10. SHOW FRAME========================>

        setVisible(true);
    }
}
