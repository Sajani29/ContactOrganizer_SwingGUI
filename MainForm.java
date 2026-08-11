import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MainForm extends JFrame{
		private JPanel leftPanel;
		private JLabel lblTitle;
		private JButton btnAddContact;
		private JButton btnUpdateContact;
		private JButton btnDeleteContact;
		private JButton btnSearchContact;
		private JButton btnListContact;
		private JButton btnExist;
		private JPanel pnlButton;
		 MainForm(String title){
			setTitle(title);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(650,500);
			//setLayout(new GridLayout(
			//IMAGE====
			ImageIcon image = new ImageIcon("assets/img.png");
			Image originalImage = image.getImage();
			int targetWidth = 350;
			int targetHeight = 350;
			Image scaledImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
			ImageIcon resizedIcon = new ImageIcon(scaledImage);
			JLabel label = new JLabel(resizedIcon);
			leftPanel = new JPanel();
			JLabel imageLabel = new JLabel(image);
			leftPanel.add(label);
			add("West",leftPanel);
			
			//TITLE=====
			lblTitle = new JLabel("iFRIEND Contact Organizer");
			lblTitle.setFont(new Font(" ",3,25));
			lblTitle.setHorizontalAlignment(0);
			add("North",lblTitle);
			
			// BUTTONS
			pnlButton = new JPanel();
			pnlButton.setLayout(new BoxLayout(pnlButton, BoxLayout.Y_AXIS));

			// ADD
			btnAddContact = new JButton("ADD Contacts");
			btnAddContact.setFont(new Font("", Font.BOLD, 15));
			btnAddContact.setBackground(Color.GREEN);
			btnAddContact.setAlignmentX(Component.CENTER_ALIGNMENT);
			pnlButton.add(btnAddContact);

			pnlButton.add(Box.createVerticalStrut(15));

			// UPDATE
			btnUpdateContact = new JButton("UPDATE Contacts");
			btnUpdateContact.setFont(new Font("", Font.BOLD, 15));
			btnUpdateContact.setBackground(Color.GREEN);
			btnUpdateContact.setAlignmentX(Component.CENTER_ALIGNMENT);
			pnlButton.add(btnUpdateContact);

			pnlButton.add(Box.createVerticalStrut(15));

			// DELETE
			btnDeleteContact = new JButton("DELETE Contacts");
			btnDeleteContact.setFont(new Font("", Font.BOLD, 15));
			btnDeleteContact.setBackground(Color.GREEN);
			btnDeleteContact.setAlignmentX(Component.CENTER_ALIGNMENT);
			pnlButton.add(btnDeleteContact);

			pnlButton.add(Box.createVerticalStrut(15));

			// SEARCH
			btnSearchContact = new JButton("SEARCH Contacts");
			btnSearchContact.setFont(new Font("", Font.BOLD, 15));
			btnSearchContact.setBackground(Color.GREEN);
			btnSearchContact.setAlignmentX(Component.CENTER_ALIGNMENT);
			pnlButton.add(btnSearchContact);

			pnlButton.add(Box.createVerticalStrut(15));

			// LIST
			btnListContact = new JButton("LIST Contacts");
			btnListContact.setFont(new Font("", Font.BOLD, 15));
			btnListContact.setBackground(Color.GREEN);
			btnListContact.setAlignmentX(Component.CENTER_ALIGNMENT);
			pnlButton.add(btnListContact);

			//add(pnlButton, BorderLayout.CENTER);
			JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

			rightPanel.setBorder(
				BorderFactory.createEmptyBorder(80, 5, 10, 50)
			);

			rightPanel.add(pnlButton);

			add(rightPanel, BorderLayout.CENTER);
			//rightPanel.setBackground(Color.PINK);

			btnExist = new JButton("Exist");
			btnExist.setFont(new Font("",1,15));
			btnExist.setBackground(Color.GREEN);
			JPanel pnlExist = new JPanel(new FlowLayout(2));
			pnlExist.add(btnExist);
			add("South",pnlExist);
			setVisible(true);
		}
		 
    
    
	public static void main(String[] args){
		new MainForm("iFriend Contact Organizer").setVisible(true);
		
	}
	
}
