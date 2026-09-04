import java.util.*;
import javax.swing.*;
import java.awt.*;

class DeleteContact extends JFrame{
	
	public DeleteContact(ContactManager manage){
		setTitle("Delete Contact");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel lblTopic = new JLabel("Delete Contact");

        lblTopic.setHorizontalAlignment(SwingConstants.CENTER);
        lblTopic.setFont(new Font("", 2, 20));
        lblTopic.setOpaque(true);
        lblTopic.setBackground(Color.yellow);
        lblTopic.setForeground(Color.black);

        add(lblTopic, BorderLayout.NORTH);
	}
}
