import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MainForm extends JFrame{
		JLabel imageLabel;
		JPanel leftPanel;
		JPanel rightPanel;
		MainForm(){
			setSize(1000,600);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new GridLayout(1,2));
			
			ImageIcon image = new ImageIcon("assets/images.png");
			imageLabel = new JLabel(image);
			leftPanel = new JPanel();
			leftPanel.setBackground(Color.RED);
			leftPanel.add(imageLabel);
			add(leftPanel);
			
			rightPanel = new JPanel();
			rightPanel.add(new JButton("ADD Contacts"));
			rightPanel.add(new JButton("UPDATE Contacts"));
			rightPanel.add(new JButton("DELETE Contacts"));
			rightPanel.add(new JButton("SEARCH Contacts"));
			rightPanel.add(new JButton("LIST Contacts"));
			rightPanel.add(new JButton("Exit"));
			add(rightPanel);
		}
	public static void main(String[] args){
		new MainForm().setVisible(true);
		
	}
	
}
