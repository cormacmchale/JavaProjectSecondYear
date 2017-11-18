package CollegeProject;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

//Player character option.. harder difficulty
public class Wizard extends Character implements CharacterMethodsItems
{	
     //constructor for this player character class
     public Wizard()
      {
         hitPoints = 100;
         magicPoints = 200;
      }
        
        
      //smaller methods for basic action
      public void takeDamage(int damage)
      {
    	hitPoints -= damage;
      }
      public void gameOver()
      {
    	if(hitPoints <= 0)
    	{
    	   System.out.println("Your Hero Has Fallen...GAME OVER");
    	   //System.exit(0);     		 
    	}   	 
      }
}//end wizard class
 
