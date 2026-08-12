import java.util.*;
import javax.swing.*;
import java.awt.*;

class AddContact extends JFrame{
	AddContact(){
		setTitle("Add Contact");
		setSize(600,600);
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
		
	}
}
