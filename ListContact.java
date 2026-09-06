import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

class ListContact extends JFrame {

    private ContactManager manager;
    private JTable table;

    public ListContact(ContactManager manager) {

        this.manager = manager;

        setTitle("Sort Contact");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // =========================================================
        // TITLE
        // =========================================================

        JLabel lblTopic = new JLabel("Sort Contact");

        lblTopic.setHorizontalAlignment(SwingConstants.CENTER);
        lblTopic.setFont(new Font("", Font.BOLD, 20));
        lblTopic.setOpaque(true);
        lblTopic.setBackground(Color.YELLOW);
        lblTopic.setForeground(Color.BLACK);

        add("North", lblTopic);


        // =========================================================
        // BUTTON - SORT BY NAME
        // =========================================================

        JButton btnSortbyName = new JButton("Sort by name");

        btnSortbyName.setFont(new Font("", Font.BOLD, 15));
        btnSortbyName.setBackground(Color.GREEN);
        btnSortbyName.setAlignmentX(Component.CENTER_ALIGNMENT);


        // =========================================================
        // BUTTON - SORT BY SALARY
        // =========================================================

        JButton btnSortbySalary = new JButton("Sort by salary");

        btnSortbySalary.setFont(new Font("", Font.BOLD, 15));
        btnSortbySalary.setBackground(Color.GREEN);
        btnSortbySalary.setAlignmentX(Component.CENTER_ALIGNMENT);


        // =========================================================
        // BUTTON - SORT BY BIRTHDAY
        // =========================================================

        JButton btnSortbyBOD = new JButton("Sort by birthday");

        btnSortbyBOD.setFont(new Font("", Font.BOLD, 15));
        btnSortbyBOD.setBackground(Color.GREEN);
        btnSortbyBOD.setAlignmentX(Component.CENTER_ALIGNMENT);


        // =========================================================
        // BUTTON PANEL
        // =========================================================

        JPanel pnlButton = new JPanel();

        pnlButton.setLayout(
                new BoxLayout(pnlButton, BoxLayout.Y_AXIS)
        );

        pnlButton.add(Box.createVerticalGlue());

        pnlButton.add(btnSortbyName);

        pnlButton.add(Box.createVerticalStrut(10));

        pnlButton.add(btnSortbySalary);

        pnlButton.add(Box.createVerticalStrut(10));

        pnlButton.add(btnSortbyBOD);

        pnlButton.add(Box.createVerticalGlue());


        // =========================================================
        // TABLE
        // =========================================================

        table = new JTable();

        JScrollPane scrollPane = new JScrollPane(table);


        // Main center panel
        JPanel pnlCenter = new JPanel(new BorderLayout());

        pnlCenter.add(pnlButton, BorderLayout.WEST);
        pnlCenter.add(scrollPane, BorderLayout.CENTER);

        add("Center", pnlCenter);


        // =========================================================
        // SORT BY NAME BUTTON
        // =========================================================

        btnSortbyName.addActionListener(e -> {

            sortByName();

            displayContacts();

        });


        // =========================================================
        // SORT BY SALARY BUTTON
        // =========================================================

        btnSortbySalary.addActionListener(e -> {

            sortBySalary();

            displayContacts();

        });


        // =========================================================
        // SORT BY BIRTHDAY BUTTON
        // =========================================================

        btnSortbyBOD.addActionListener(e -> {

            sortByBirthday();

            displayContacts();

        });


        // =========================================================
        // SHOW FRAME
        // =========================================================

        setVisible(true);
    }


    // =============================================================
    // SORT BY NAME
    // =============================================================

    private void sortByName() {

        for (int i = 0; i < manager.contactArray.length - 1; i++) {

            for (int j = i + 1;
                 j < manager.contactArray.length;
                 j++) {

                if (manager.contactArray[i] != null &&
                    manager.contactArray[j] != null) {

                    if (manager.contactArray[i]
                            .getContactName()
                            .compareToIgnoreCase(
                            manager.contactArray[j]
                            .getContactName()) > 0) {

                        Contacts temp =
                                manager.contactArray[i];

                        manager.contactArray[i] =
                                manager.contactArray[j];

                        manager.contactArray[j] =
                                temp;
                    }
                }
            }
        }
    }


    // =============================================================
    // SORT BY SALARY
    // =============================================================

    private void sortBySalary() {

        for (int i = 0; i < manager.contactArray.length - 1; i++) {

            for (int j = i + 1;
                 j < manager.contactArray.length;
                 j++) {

                if (manager.contactArray[i] != null &&
                    manager.contactArray[j] != null) {

                    if (manager.contactArray[i]
                            .getSalaryAmount()
                            >
                        manager.contactArray[j]
                            .getSalaryAmount()) {

                        Contacts temp =
                                manager.contactArray[i];

                        manager.contactArray[i] =
                                manager.contactArray[j];

                        manager.contactArray[j] =
                                temp;
                    }
                }
            }
        }
    }


    // =============================================================
    // SORT BY BIRTHDAY
    // =============================================================

    private void sortByBirthday() {

        for (int i = 0; i < manager.contactArray.length - 1; i++) {

            for (int j = i + 1;
                 j < manager.contactArray.length;
                 j++) {

                if (manager.contactArray[i] != null &&
                    manager.contactArray[j] != null) {

                    if (manager.contactArray[i]
                            .getDoB()
                            .compareTo(
                            manager.contactArray[j]
                            .getDoB()) > 0) {

                        Contacts temp =
                                manager.contactArray[i];

                        manager.contactArray[i] =
                                manager.contactArray[j];

                        manager.contactArray[j] =
                                temp;
                    }
                }
            }
        }
    }


    // =============================================================
    // DISPLAY CONTACTS IN TABLE
    // =============================================================

    private void displayContacts() {

        String[] columnNames = {
                "Contact ID",
                "Name",
                "Phone Number",
                "Company",
                "Salary",
                "Birthday"
        };

        DefaultTableModel model =
                new DefaultTableModel(columnNames, 0);


        // Get contacts directly from object array

        for (int i = 0;
             i < manager.contactArray.length;
             i++) {

            if (manager.contactArray[i] != null) {

                Contacts contact =
                        manager.contactArray[i];

                Object[] row = {

                        contact.getContactId(),

                        contact.getContactName(),

                        contact.getContactPhoneNumber(),

                        contact.getCompanyName(),

                        contact.getSalaryAmount(),

                        contact.getDoB()
                };

                model.addRow(row);
            }
        }


        table.setModel(model);

        table.setRowHeight(30);

        table.getTableHeader().setFont(
                new Font("", Font.BOLD, 13)
        );

        table.setFont(
                new Font("", Font.PLAIN, 13)
        );
    }
}
