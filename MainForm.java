import javax.swing.*;
import java.awt.*;

class MainForm{
	public static void main(String[] args){
		JFrame f1 = new JFrame("Main");
		ImageIcon imageIcon = new ImageIcon("assets/img.png");
		JLabel imageLabel = new JLabel(imageIcon);
		f1.add("Center",imageLabel);
		f1.setVisible(true);
	}
	
}
