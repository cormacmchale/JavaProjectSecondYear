package CollegeProject;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JFrameHandling extends character {
	static JFrame wizardAliveFrame;
	static JFrame goblinAliveFrame;
	static JLabel goblinInfo;
	static JLabel wizardInfo;
	static JLabel goblinAliveImage;
	static JLabel goblinDeathImage;
	static JLabel wizardAliveImage;
	static JLabel wizardDeathImage;
	
	
    public static void createWindowGoblin(goblin Enemy) {
    	   

        //Create and set up the window. 
        goblinAliveFrame = new JFrame("Wild Goblin");       
        goblinAliveFrame.setLayout(new FlowLayout());
        goblinAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

         //JLabel textLabel = new JLabel("You Have Selected The Wizard!!", SwingConstants.CENTER);
         goblinInfo = new JLabel(Enemy.display(), SwingConstants.CENTER); 
         goblinInfo.setPreferredSize(new Dimension(300, 100)); 
        
        //frame.add(new JLabel(new ImageIcon("Path/To/Your/Image.png")));
        
       
         goblinAliveImage = (new JLabel (new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/goblin.jpg"))); 
         goblinAliveFrame.add(goblinAliveImage);
        //frame.add(textLabel, BorderLayout.CENTER);
         goblinAliveFrame.add(goblinInfo);
        //Display the window. 
         goblinAliveFrame.setLocation(1000,250); 
         goblinAliveFrame.pack();
         goblinAliveFrame.setVisible(true);
         goblinAliveFrame.setAlwaysOnTop (true);
        
     }
    
    public static void dealDamage(goblin enemy, int damage) 
    {
    	  enemy.takeDamage(damage);
    	  if(enemy.hitPoints <=0)
    	  {
    		 System.out.println("Enemy defeated");
    	  }
    	  else
    	  {
    		    goblinAliveFrame.remove(goblinInfo);
    		    //JFrame newGoblinFrame = new JFrame();
    		    //goblinAliveFrame = newGoblinFrame;
    	        //Create and set up the window. 
    	        //JFrame frame = new JFrame("Wild Goblin");
    		  	goblinAliveFrame.setLayout(new FlowLayout());
    		  	goblinAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    		  	//goblinAliveFrame.getContentPane().setLayout(null);
    		  	
    		
    	         //JLabel textLabel = new JLabel("You Have Selected The Wizard!!", SwingConstants.CENTER);
    		    goblinInfo = new JLabel(enemy.display(), SwingConstants.CENTER); 
    	        goblinInfo.setPreferredSize(new Dimension(300, 100)); 
 
    	        
    	        //frame.add(new JLabel(new ImageIcon("Path/To/Your/Image.png")));
    	        
    	        //goblinAliveFrame.add(new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/goblin.jpg"))); 
    	        //frame.add(textLabel, BorderLayout.CENTER);
    	        goblinAliveFrame.add(goblinInfo);
    	      
    	        //Display the window. 
    	         goblinAliveFrame.setLocation(1000,250); 
    	         goblinAliveFrame.pack();
    	         goblinAliveFrame.setVisible(true);
    	         goblinAliveFrame.setAlwaysOnTop (true);
    	  }
       }   
    
    public static void createWindowWizard(wizard Player) {
  	   

        //Create and set up the window. 
    	wizardAliveFrame = new JFrame("Your Hero");
    	wizardAliveFrame.setLayout(new FlowLayout());
    	wizardAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

         //JLabel textLabel = new JLabel("You Have Selected The Wizard!!", SwingConstants.CENTER);
    	wizardInfo = new JLabel(Player.display(), SwingConstants.CENTER); 
    	wizardInfo.setPreferredSize(new Dimension(300, 100)); 
        
        //frame.add(new JLabel(new ImageIcon("Path/To/Your/Image.png")));
        
         wizardAliveImage = (new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/wizardSprite.png"))); 
        //frame.add(textLabel, BorderLayout.CENTER);
        
         wizardAliveFrame.add(wizardAliveImage);
         wizardAliveFrame.add(wizardInfo);
        //Display the window. 
         wizardAliveFrame.setLocation(250,250); 
         wizardAliveFrame.pack();
         wizardAliveFrame.setVisible(true);
         wizardAliveFrame.setAlwaysOnTop(true);
     } 
    
    public static void playerDied(wizard Player) {
    	  
        //Create and set up the window. 
        //JFrame frame = new JFrame("Your Hero");
    	wizardAliveFrame.remove(wizardInfo);
    	wizardAliveFrame.remove(wizardAliveImage);
    	wizardAliveFrame.setLayout(new FlowLayout());
    	wizardAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

         //JLabel textLabel = new JLabel("You Have Selected The Wizard!!", SwingConstants.CENTER);
    	wizardInfo = new JLabel("Hero Has Fallen!!", SwingConstants.CENTER); 
    	wizardInfo.setPreferredSize(new Dimension(300, 100)); 
        
        //frame.add(new JLabel(new ImageIcon("Path/To/Your/Image.png")));
        
         wizardDeathImage = (new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/death.gif"))); 
        //frame.add(textLabel, BorderLayout.CENTER);
         wizardAliveFrame.add(wizardInfo);
         wizardAliveFrame.add(wizardDeathImage);
        //Display the window. 
         wizardAliveFrame.setLocation(250,250); 
         wizardAliveFrame.pack();
         wizardAliveFrame.setVisible(true); 
         wizardAliveFrame.setAlwaysOnTop (true);
  	  
     } 
    
    public static void takeDamage(wizard Player, int hitPoints) 
    {
    	  Player.takeDamage(hitPoints);
    	  if(Player.hitPoints <=0)
    	  {
    		  System.out.println("Hero Has Fallen!!");
    	  }
    	  else
    	  {
          //Create and set up the window. 
          //JFrame frame = new JFrame("Your Hero");
    		  wizardAliveFrame.remove(wizardAliveImage);
    		  wizardAliveFrame.remove(wizardInfo);
    		  wizardAliveFrame.setLayout(new FlowLayout());
    		  wizardAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

           //JLabel textLabel = new JLabel("You Have Selected The Wizard!!", SwingConstants.CENTER);
    		  wizardInfo = new JLabel(Player.display(), SwingConstants.CENTER); 
    		  wizardInfo.setPreferredSize(new Dimension(300, 100)); 
          
          //frame.add(new JLabel(new ImageIcon("Path/To/Your/Image.png")));
          
           wizardAliveImage = (new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/wizardSprite.png"))); 
          //frame.add(textLabel, BorderLayout.CENTER);
           wizardAliveFrame.add(wizardAliveImage);
           wizardAliveFrame.add(wizardInfo);
          //Display the window. 
           wizardAliveFrame.setLocation(250,250); 
           wizardAliveFrame.pack();
           wizardAliveFrame.setVisible(true); 
           wizardAliveFrame.setAlwaysOnTop(true);
        	
    	  }
       } 
    

    
    public static void enemyDefeated(goblin Enemy) {
    	goblinAliveFrame.remove(goblinInfo);
    	goblinAliveFrame.remove(goblinAliveImage);
        //Create and set up the window. 
        //JFrame frame = new JFrame("Enemy Defeated");
        goblinAliveFrame.setLayout(new FlowLayout());
        goblinAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

         //JLabel textLabel = new JLabel("You Have Selected The Wizard!!", SwingConstants.CENTER);
         goblinInfo = new JLabel("Goblin Slain!!", SwingConstants.CENTER); 
         goblinInfo.setPreferredSize(new Dimension(300, 100)); 
        
        //frame.add(new JLabel(new ImageIcon("Path/To/Your/Image.png")));
        
         goblinAliveFrame.add(new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/death.gif"))); 
        //frame.add(textLabel, BorderLayout.CENTER);
         goblinAliveFrame.add(goblinInfo);

        //Display the window. 
         goblinAliveFrame.setLocation(1000,250); 
         goblinAliveFrame.pack();
         goblinAliveFrame.setVisible(true);
         goblinAliveFrame.setAlwaysOnTop (true);
       // goblinAliveFrame.setVisible(false);
        
        
  	  
     } 
    

    


}
