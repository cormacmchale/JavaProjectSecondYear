package CollegeProject;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

//main character class
public abstract class Character {
	
	//variables that apply to every character... user and enemy
	public int hitPoints;
	public int magicPoints;
	//items for use
	public static int magicPotion = 2;
	public static int healthPotion = 2;
	//a display for character or enemy at anytime during program
	public String display()
	{
		String s = "";
		s+= "Hit Points: "+hitPoints+" Magic Points: " + magicPoints +"\n";
		return s;
	} 


}
