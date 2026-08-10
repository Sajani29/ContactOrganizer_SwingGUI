import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MainForm extends JFrame{
		JLabel imageLabel;
		JPanel leftPanel;
		JPanel rightPanel;
		MainForm(String title){
			setSize(1000,600);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new GridLayout(1,2));
			ImageIcon image = new ImageIcon("assets/images.png");
			leftPanel = new JPanel();
			leftPanel.setLayout(new GridLayout(2,1));
			JLabel textLabel = new JLabel("iFriend Contact Organizer");
			
			
			imageLabel = new JLabel(image);
			leftPanel.setBackground(Color.PINK);
			leftPanel.add(textLabel);
			leftPanel.add(imageLabel);
			add(leftPanel);
			
			rightPanel = new JPanel();
			rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
			rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			JButton redButton = createColoredButton("Red Action", Color.RED, Color.WHITE);
            JButton greenButton = createColoredButton("Green Action", Color.GREEN, Color.BLACK);
            JButton blueButton = createColoredButton("Blue Action", Color.BLUE, Color.WHITE);
			
			rightPanel.add(redButton);
            rightPanel.add(Box.createRigidArea(new Dimension(0, 15))); 
            rightPanel.add(greenButton);
            rightPanel.add(Box.createRigidArea(new Dimension(0, 15))); 
            rightPanel.add(blueButton);

            frame.add(rightPanel);
            frame.setLocationRelativeTo(null); // Center window on screen
            frame.setVisible(true);
		}
		
		private static JButton createColoredButton(String text, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        
        // Color configuration
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        
        // Fixes background visibility on Mac / Look and Feels
        button.setOpaque(true);
        button.setBorderPainted(false);
        
        // Layout and Alignment configuration
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Horizontally center within the box layout
        button.setMaximumSize(new Dimension(180, 50));    // Lock the maximum dimension bounds
        button.setPreferredSize(new Dimension(180, 50));   // Standard initial dimension hint
        
        return button;
    }
    
	public static void main(String[] args){
		new MainForm("iFriend Contact Organizer").setVisible(true);
		
	}
	
}
