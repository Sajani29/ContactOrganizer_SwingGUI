
import java.util.*;
import javax.swing.*;
import java.awt.*;

class UpdateContact extends JFrame {

    private JPanel pnlUpdatebutton;
    private JButton btnCancel;
    private JButton btnUpdateName;
    private JButton btnUpdatePhoneno;
    private JButton btnUpdateComName;
    private JButton btnUpdateSalary;

    private int index;

    public UpdateContact(ContactManager manager) {

        setTitle("Update Contact");
        setSize(1200, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // <==========================1. TITLE========================>

        JLabel lblTopic = new JLabel("Update Contact");

        lblTopic.setHorizontalAlignment(SwingConstants.CENTER);
        lblTopic.setFont(new Font("", Font.ITALIC, 20));
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
                "Choose Options which want to update -> "
        );

        // ---------------------------------------------------------
        // CANCEL BUTTON
        // ---------------------------------------------------------

        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("", Font.BOLD, 10));
        btnCancel.setBackground(Color.red);

        btnCancel.addActionListener(e -> {
            dispose();
        });

        // ---------------------------------------------------------
        // UPDATE NAME BUTTON
        // ---------------------------------------------------------

        btnUpdateName = new JButton("Name");
        btnUpdateName.setFont(new Font("", Font.BOLD, 10));
        btnUpdateName.setBackground(Color.green);

        btnUpdateName.addActionListener(e -> {

            if (index == -1) {
                JOptionPane.showMessageDialog(
                        UpdateContact.this,
                        "Please search for a contact first."
                );
                return;
            }

            String newName = JOptionPane.showInputDialog(
                    UpdateContact.this,
                    "Enter new name:"
            );

            if (newName != null) {

                newName = newName.trim();

                if (newName.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            UpdateContact.this,
                            "Name cannot be empty."
                    );

                } else {

                    manager.contactArray[index].setContactName(newName);

                    JOptionPane.showMessageDialog(
                            UpdateContact.this,
                            "Name is updated successfully."
                    );
                }
            }
        });

        // ---------------------------------------------------------
        // UPDATE PHONE NUMBER BUTTON
        // ---------------------------------------------------------

        btnUpdatePhoneno = new JButton("Phone Number");
        btnUpdatePhoneno.setFont(new Font("", Font.BOLD, 10));
        btnUpdatePhoneno.setBackground(Color.green);

        btnUpdatePhoneno.addActionListener(e -> {

            if (index == -1) {
                JOptionPane.showMessageDialog(
                        UpdateContact.this,
                        "Please search for a contact first."
                );
                return;
            }

            String newPhone = JOptionPane.showInputDialog(
                    UpdateContact.this,
                    "Enter new phone number:"
            );

            if (newPhone != null) {

                newPhone = newPhone.trim();

                if (newPhone.matches("0\\d{9}")) {

                    manager.contactArray[index]
                            .setContactPhoneNumber(newPhone);

                    JOptionPane.showMessageDialog(
                            UpdateContact.this,
                            "Phone Number is updated successfully."
                    );

                } else {

                    JOptionPane.showMessageDialog(
                            UpdateContact.this,
                            "Phone number must start with 0 and contain 10 digits."
                    );
                }
            }
        });

        // ---------------------------------------------------------
        // UPDATE COMPANY NAME BUTTON
        // ---------------------------------------------------------

        btnUpdateComName = new JButton("Company Name");
        btnUpdateComName.setFont(new Font("", Font.BOLD, 10));
        btnUpdateComName.setBackground(Color.green);

        btnUpdateComName.addActionListener(e -> {

            if (index == -1) {
                JOptionPane.showMessageDialog(
                        UpdateContact.this,
                        "Please search for a contact first."
                );
                return;
            }

            String newCompanyName = JOptionPane.showInputDialog(
                    UpdateContact.this,
                    "Enter new company name:"
            );

            if (newCompanyName != null) {

                newCompanyName = newCompanyName.trim();

                if (newCompanyName.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            UpdateContact.this,
                            "Company name cannot be empty."
                    );

                } else {

                    manager.contactArray[index]
                            .setCompanyName(newCompanyName);

                    JOptionPane.showMessageDialog(
                            UpdateContact.this,
                            "Company Name is updated successfully."
                    );
                }
            }
        });

        // ---------------------------------------------------------
        // UPDATE SALARY BUTTON
        // ---------------------------------------------------------

        btnUpdateSalary = new JButton("Salary");
        btnUpdateSalary.setFont(new Font("", Font.BOLD, 10));
        btnUpdateSalary.setBackground(Color.green);

        // Salary input panel

        JPanel pnlgetSalary = new JPanel(
                new GridLayout(1, 2)
        );

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

        // Update button

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBackground(Color.green);
        btnUpdate.setFont(new Font("", Font.BOLD, 10));

        // Initially hide salary components

        pnlgetSalary.setVisible(false);
        btnUpdate.setVisible(false);

        // Salary button action

       btnUpdateSalary.addActionListener(e -> {

    if (index == -1) {
        JOptionPane.showMessageDialog(
            UpdateContact.this,
            "Please search for a contact first."
        );
        return;
    }

    String salaryText = JOptionPane.showInputDialog(
        UpdateContact.this,
        "Enter new salary:"
    );

    if (salaryText == null) {
        return; // User clicked Cancel
    }

    try {

        double salary = Double.parseDouble(salaryText.trim());

        if (salary <= 0) {

            JOptionPane.showMessageDialog(
                UpdateContact.this,
                "Salary must be a positive value."
            );

        } else {

            manager.contactArray[index].setSalaryAmount(salary);

            JOptionPane.showMessageDialog(
                UpdateContact.this,
                "Salary is updated successfully."
            );
        }

    } catch (NumberFormatException ex) {

        JOptionPane.showMessageDialog(
            UpdateContact.this,
            "Please enter a valid salary."
        );
    }
});
        // Add components to update panel

        pnlUpdatebutton.add(lblChoice);
        pnlUpdatebutton.add(btnCancel);
        pnlUpdatebutton.add(btnUpdateName);
        pnlUpdatebutton.add(btnUpdatePhoneno);
        pnlUpdatebutton.add(btnUpdateComName);
        pnlUpdatebutton.add(btnUpdateSalary);
        pnlUpdatebutton.add(pnlgetSalary);
        pnlUpdatebutton.add(btnUpdate);

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

            String input = txtInput.getText().trim();

            if (input.isEmpty()) {

                JOptionPane.showMessageDialog(
                        UpdateContact.this,
                        "Please enter name or phone number."
                );

                return;
            }

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

                                manager.contactArray[index]
                                        .getContactName(),

                                manager.contactArray[index]
                                        .getContactPhoneNumber(),

                                manager.contactArray[index]
                                        .getCompanyName(),

                                String.valueOf(
                                        manager.contactArray[index]
                                                .getSalaryAmount()
                                ),

                                manager.contactArray[index]
                                        .getDoB()
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

                // Show update panel

                pnlUpdatebutton.setVisible(true);

                pnlUpdatebutton.revalidate();
                pnlUpdatebutton.repaint();
            }
        });

        // <==========================8. SEARCH/BACK PANEL========================>

        JPanel pnlButton = new JPanel();

        pnlButton.add(btnBack);
        pnlButton.add(btnSearch);

        // <==========================9. BOTTOM PANEL========================>

        JPanel pnlBottom = new JPanel();

        pnlBottom.setLayout(
                new BoxLayout(pnlBottom, BoxLayout.Y_AXIS)
        );

        pnlBottom.add(pnlUpdatebutton);
        pnlBottom.add(pnlButton);

        add(pnlBottom, BorderLayout.SOUTH);

        // <==========================10. SHOW FRAME========================>

        setVisible(true);
    }
}
