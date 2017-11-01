package CollegeProject;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class goblin extends character {

	public goblin() {
		hitPoints = 30;
		magicPoints = 10;
		
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
  		 System.out.println("Enemy Defeated!!");
  		 //System.exit(0); 
  		 
  	 }
  	 
   }

}
