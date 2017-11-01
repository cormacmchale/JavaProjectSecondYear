package CollegeProject;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JFrameHandling extends character {
	
	static JFrame goblinAliveFrame;
	static JLabel goblinInfo;
	
    public static void createWindowGoblin(goblin Enemy) {
    	   

        //Create and set up the window. 
        goblinAliveFrame = new JFrame("Wild Goblin");       
        goblinAliveFrame.setLayout(new FlowLayout());
        goblinAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

         //JLabel textLabel = new JLabel("You Have Selected The Wizard!!", SwingConstants.CENTER);
         goblinInfo = new JLabel(Enemy.display(), SwingConstants.CENTER); 
         goblinInfo.setPreferredSize(new Dimension(300, 100)); 
        
        //frame.add(new JLabel(new ImageIcon("Path/To/Your/Image.png")));
        
         goblinAliveFrame.add(new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/goblin.jpg"))); 
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
    		  System.out.println("Enemy Defeated!");
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
        JFrame frame = new JFrame("Your Hero");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

         //JLabel textLabel = new JLabel("You Have Selected The Wizard!!", SwingConstants.CENTER);
         JLabel textLabel2 = new JLabel(Player.display(), SwingConstants.CENTER); 
         textLabel2.setPreferredSize(new Dimension(300, 100)); 
        
        //frame.add(new JLabel(new ImageIcon("Path/To/Your/Image.png")));
        
        frame.add(new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/wizardSprite.png"))); 
        //frame.add(textLabel, BorderLayout.CENTER);
        frame.add(textLabel2);
        //Display the window. 
        frame.setLocation(250,250); 
        frame.pack();
        frame.setVisible(true);
        frame.setAlwaysOnTop (true);
     } 
    
    public static void playerDied(wizard Player) {
    	  
        //Create and set up the window. 
        JFrame frame = new JFrame("Your Hero");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

         //JLabel textLabel = new JLabel("You Have Selected The Wizard!!", SwingConstants.CENTER);
         JLabel textLabel2 = new JLabel("Hero Has Fallen!!", SwingConstants.CENTER); 
         textLabel2.setPreferredSize(new Dimension(300, 100)); 
        
        //frame.add(new JLabel(new ImageIcon("Path/To/Your/Image.png")));
        
        frame.add(new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/death.gif"))); 
        //frame.add(textLabel, BorderLayout.CENTER);
        frame.add(textLabel2);
        //Display the window. 
        frame.setLocation(250,250); 
        frame.pack();
        frame.setVisible(true); 
        frame.setAlwaysOnTop (true);
  	  
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
          JFrame frame = new JFrame("Your Hero");
          frame.setLayout(new FlowLayout());
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

           //JLabel textLabel = new JLabel("You Have Selected The Wizard!!", SwingConstants.CENTER);
           JLabel textLabel2 = new JLabel(Player.display(), SwingConstants.CENTER); 
           textLabel2.setPreferredSize(new Dimension(300, 100)); 
          
          //frame.add(new JLabel(new ImageIcon("Path/To/Your/Image.png")));
          
          frame.add(new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/wizardSprite.png"))); 
          //frame.add(textLabel, BorderLayout.CENTER);
          frame.add(textLabel2);
          //Display the window. 
          frame.setLocation(250,250); 
          frame.pack();
          frame.setVisible(true); 
          frame.setAlwaysOnTop(true);
        	
    	  }
       } 
    

    
    public static void enemyDefeated(goblin Enemy) {
  	  
        //Create and set up the window. 
        JFrame frame = new JFrame("Enemy Defeated");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

         //JLabel textLabel = new JLabel("You Have Selected The Wizard!!", SwingConstants.CENTER);
         JLabel textLabel2 = new JLabel("Goblin Slain!!", SwingConstants.CENTER); 
         textLabel2.setPreferredSize(new Dimension(300, 100)); 
        
        //frame.add(new JLabel(new ImageIcon("Path/To/Your/Image.png")));
        
        frame.add(new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/death.gif"))); 
        //frame.add(textLabel, BorderLayout.CENTER);
        frame.add(textLabel2);

        //Display the window. 
        frame.setLocation(1000,250); 
        frame.pack();
        frame.setVisible(true);
        frame.setAlwaysOnTop (true);
        goblinAliveFrame.setVisible(false);
        //w
        
  	  
     } 
    

    


}
