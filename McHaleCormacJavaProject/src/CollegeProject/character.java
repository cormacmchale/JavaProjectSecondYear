package CollegeProject;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

//main character class
public abstract class character {
	
	//variables that apply to every character... user and enemy
	public int hitPoints;
	public int magicPoints;


	
	
	//a display for character or enemy at anytime during program
	public String display()
	{
		String s = "";
		s+= "Hit Points: "+hitPoints+" Magic Points: " + magicPoints +"\n";
		return s;
	} 


}
