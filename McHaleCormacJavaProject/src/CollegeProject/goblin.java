package CollegeProject;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Goblin extends Character implements CharacterItems
{
	public Goblin() 
	{
		hitPoints = 60;
		magicPoints = 10;		
	}	
	
    //smaller methods for basic action
    public void takeDamage(int damage)
    {
	    hitPoints -= damage;
    }
   
    //wont need this as code takes different route when run
    public void gameOver()
    {
  	 if(hitPoints <= 0)
  	{
  		 //System.out.println("Enemy Defeated!!");
  		 //System.exit(0);   		 
  	}
  	 
    }//end of gameOver

}// end goblin class
