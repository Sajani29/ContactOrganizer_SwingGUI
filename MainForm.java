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
			setSize(600,600);
			//setLayout(new GridLayout(
			//IMAGE====
			ImageIcon image = new ImageIcon("assets/img.png");
			Image originalImage = image.getImage();
			int targetWidth = 300;
			int targetHeight = 300;
			Image scaledImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
			ImageIcon resizedIcon = new ImageIcon(scaledImage);
			JLabel label = new JLabel(resizedIcon);
			leftPanel = new JPanel();
			JLabel imageLabel = new JLabel(image);
			leftPanel.add(label);
			add("West",leftPanel);
			
			//TITLE=====
			lblTitle = new JLabel("iFRIEND Contact Organizer");
			lblTitle.setFont(new Font(" ",1,20));
			lblTitle.setHorizontalAlignment(JLabel.LEFT);
			add("North",lblTitle);
			
			//BUTTON========
			pnlButton = new JPanel();
			pnlButton.setLayout(new BoxLayout(pnlButton, BoxLayout.Y_AXIS));
			
			pnlButton.add(btnAddContact);
pnlButton.add(Box.createVerticalStrut(15));

pnlButton.add(btnUpdateContact);
pnlButton.add(Box.createVerticalStrut(15));

pnlButton.add(btnDeleteContact);
pnlButton.add(Box.createVerticalStrut(15));

pnlButton.add(btnSearchContact);
pnlButton.add(Box.createVerticalStrut(15));

pnlButton.add(btnListContact);
			//JPanel pnlAddContact = new JPanel();
			btnAddContact = new JButton("ADD Contacts");
			btnAddContact.setFont(new Font("",1,10));
			JPanel pnlAdd = new JPanel();
			pnlAdd.add(btnAddContact);
			pnlButton.add(pnlAdd);
			
			btnUpdateContact = new JButton("UPDATE Contacts");
			btnUpdateContact.setFont(new Font("",1,10));
			JPanel pnlUpdate = new JPanel();
			pnlUpdate.add(btnUpdateContact);
			pnlButton.add(pnlUpdate);
			
			btnDeleteContact = new JButton("DELETE Contacts");
			btnDeleteContact.setFont(new Font("",1,10));
			JPanel pnlDelete = new JPanel();
			pnlDelete.add(btnDeleteContact);
			pnlButton.add(pnlDelete);
			
			btnSearchContact = new JButton("SEARCH Contacts");
			btnSearchContact.setFont(new Font("",1,10));
			JPanel pnlSearch = new JPanel();
			pnlSearch.add(btnSearchContact);
			pnlButton.add(pnlSearch);
			
			btnListContact = new JButton("LIST Contacts");
			btnListContact.setFont(new Font("",1,10));
			JPanel pnlList = new JPanel();
			pnlList.add(btnListContact);
			pnlButton.add(pnlList);
			add(pnlButton);
			
			btnExist = new JButton("Exist");
			btnExist.setFont(new Font("",1,8));
			JPanel pnlExist = new JPanel(new FlowLayout(2));
			//btnExist.setHorizontalAlignment(JButton.RIGHT);
			pnlExist.add(btnExist);
			//pnlExist.setHorizontalAlignment(2);
			add("South",pnlExist);
			setVisible(true);
		}
		 
    
    
	public static void main(String[] args){
		new MainForm("iFriend Contact Organizer").setVisible(true);
		
	}
	
}
