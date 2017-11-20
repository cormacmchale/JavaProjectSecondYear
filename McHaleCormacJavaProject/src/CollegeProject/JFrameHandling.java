package CollegeProject;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JFrameHandling extends Character {
	//these variable allow changes to be made to j panel content without spawning new windows(bettter flow)
	static JFrame wizardAliveFrame;
	static JFrame goblinAliveFrame;
	static JLabel goblinInfo;
	static JLabel wizardInfo;
	static JLabel goblinAliveImage;
	static JLabel goblinDeathImage;
	static JLabel wizardAliveImage;
	static JLabel wizardDeathImage;
	   
     // these methods finished
     public static void createWindowWizard(Wizard Player) 
     {  
    	 if(wizardAliveFrame == null)
    	 {
	         //Create and set up the window. 
	    	 wizardAliveFrame = new JFrame("Your Hero");
	    	 wizardAliveFrame.setLayout(new FlowLayout());
	    	 wizardAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    	 wizardInfo = new JLabel(Player.display(), SwingConstants.CENTER); 
	    	 wizardInfo.setPreferredSize(new Dimension(300, 100));         
	         wizardAliveImage = (new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/wizardTest.png"))); 
	         wizardAliveFrame.add(wizardAliveImage);
	         wizardAliveFrame.add(wizardInfo);
	        //Display the window. 
	         wizardAliveFrame.setLocation(250,250); 
	         wizardAliveFrame.pack();
	         wizardAliveFrame.setVisible(true);
	         wizardAliveFrame.setAlwaysOnTop(true);
    	 }
    	 else
    	 {
    		 wizardAliveFrame.remove(wizardInfo);
    		 wizardAliveFrame.setLayout(new FlowLayout());
    		 wizardAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    		 wizardInfo = new JLabel(Player.display(), SwingConstants.CENTER); 
    		 wizardInfo.setPreferredSize(new Dimension(300, 100));          
             wizardAliveFrame.add(wizardInfo); 
             wizardAliveFrame.setLocation(250,250); 
             wizardAliveFrame.pack();
             wizardAliveFrame.setVisible(true); 
             wizardAliveFrame.setAlwaysOnTop(true); 
    	 }
     } 
     
     public static void spawnStartWizard(Wizard Player)
     {
    	 wizardAliveFrame.remove(wizardInfo);
    	 wizardAliveFrame.remove(wizardAliveImage);
         //Create and set up the window. 
    	 //wizardAliveFrame = new JFrame("Your Hero");
    	 wizardAliveFrame.setLayout(new FlowLayout());
    	 wizardAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    	 wizardInfo = new JLabel(Player.display(), SwingConstants.CENTER); 
    	 wizardInfo.setPreferredSize(new Dimension(300, 100));         
         wizardAliveImage = (new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/wizardTest.png"))); 
         wizardAliveFrame.add(wizardAliveImage);
         wizardAliveFrame.add(wizardInfo);
        //Display the window. 
         wizardAliveFrame.setLocation(250,250); 
         wizardAliveFrame.pack();
         wizardAliveFrame.setVisible(true);
         wizardAliveFrame.setAlwaysOnTop(true);
     }
     
     public static void playerDied(Wizard Player) 
     {
         wizardAliveFrame.remove(wizardInfo);
    	 wizardAliveFrame.remove(wizardAliveImage);
    	 wizardAliveFrame.setLayout(new FlowLayout());
    	 wizardAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    	 //updated window
    	 wizardInfo = new JLabel("Hero Has Fallen!!", SwingConstants.CENTER); 
    	 wizardInfo.setPreferredSize(new Dimension(300, 100));
    	 //new image for death/gameover
         wizardDeathImage = (new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/death.gif"))); 
         wizardAliveFrame.add(wizardInfo);
         wizardAliveFrame.add(wizardDeathImage);
         //Display the window. 
         wizardAliveFrame.setLocation(250,250); 
         wizardAliveFrame.pack();
         wizardAliveFrame.setVisible(true); 
         wizardAliveFrame.setAlwaysOnTop (true);  	  
     } 
    
     public static void takeDamage(Wizard Player, int hitPoints) 
     {
    	  //again use this to check hit points are being used properly
    	 Player.takeDamage(hitPoints);
    	 if(Player.hitPoints <=0)
    	 {
    		 System.out.println("Hero Has Fallen!!");
    	 }
    	 else
    	 {
    		 //Create and set up the window. 
    		 //same process as before
    		 wizardAliveFrame.remove(wizardAliveImage);
    		 wizardAliveFrame.remove(wizardInfo);
    		 wizardAliveFrame.setLayout(new FlowLayout());
    		 wizardAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    		 wizardInfo = new JLabel(Player.display(), SwingConstants.CENTER); 
    		 wizardInfo.setPreferredSize(new Dimension(300, 100));          
             wizardAliveImage = (new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/wizardTakeDamage.png"))); 
             wizardAliveFrame.add(wizardAliveImage);
             wizardAliveFrame.add(wizardInfo); 
             wizardAliveFrame.setLocation(250,250); 
             wizardAliveFrame.pack();
             wizardAliveFrame.setVisible(true); 
             wizardAliveFrame.setAlwaysOnTop(true);        	
    	  }
      } 
	
     public static void useSpell(Wizard Player, int magicPoints)
     {
   	  	 //again use this to check magic points are being used properly
    	
    	 if(Player.magicPoints <=0)
    	 {
    		 System.out.println("Magic Depleted");
    	 }
    	 else
    	 {
    		 Player.fireSpell(magicPoints);
    		 //Create and set up the window. 
    		 //same process as before
    		 wizardAliveFrame.remove(wizardAliveImage);
    		 wizardAliveFrame.remove(wizardInfo);
    		 wizardAliveFrame.setLayout(new FlowLayout());
    		 wizardAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    		 wizardInfo = new JLabel(Player.display(), SwingConstants.CENTER); 
    		 wizardInfo.setPreferredSize(new Dimension(300, 100));          
             wizardAliveImage = (new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/wizardAttack.png"))); 
             wizardAliveFrame.add(wizardAliveImage);
             wizardAliveFrame.add(wizardInfo); 
             wizardAliveFrame.setLocation(250,250); 
             wizardAliveFrame.pack();
             wizardAliveFrame.setVisible(true); 
             wizardAliveFrame.setAlwaysOnTop(true);        	
   	      }  	 
     }
     
     public static void createWindowGoblin(Goblin Enemy) 
     {
        //Create and set up the window. 
    	//use static variables..
    	if(goblinAliveFrame == null)
    	{
	        goblinAliveFrame = new JFrame("Wild Goblin");       
	        goblinAliveFrame.setLayout(new FlowLayout());
	        goblinAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        //add information
	        goblinInfo = new JLabel(Enemy.display(), SwingConstants.CENTER); 
	        goblinInfo.setPreferredSize(new Dimension(300, 100)); 
	        //change file path for project
	        goblinAliveImage = (new JLabel (new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/goblinSpawn.png"))); 
	        goblinAliveFrame.add(goblinAliveImage);
	        goblinAliveFrame.add(goblinInfo);
	        //Display the window. 
	        goblinAliveFrame.setLocation(1000,250); 
	        goblinAliveFrame.pack();
	        goblinAliveFrame.setVisible(true);
	        goblinAliveFrame.setAlwaysOnTop (true); 
    	}
    	else
    	{
    		goblinAliveFrame.remove(goblinInfo);
    		goblinAliveFrame.setLayout(new FlowLayout());
    		goblinAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    		goblinInfo = new JLabel(Enemy.display(), SwingConstants.CENTER); 
    	    goblinInfo.setPreferredSize(new Dimension(300, 100)); 
    	    //add new information back in
    	    goblinAliveFrame.add(goblinInfo);    	      
    	    //Display the window. 
    	    goblinAliveFrame.setLocation(1000,250); 
    	    goblinAliveFrame.pack();
    	    goblinAliveFrame.setVisible(true);
    	    goblinAliveFrame.setAlwaysOnTop (true);
    	}
     }       
          
     public static void enemyDefeated(Goblin Enemy) 
      {
    	  //again same logic as before
          goblinAliveFrame.remove(goblinInfo);
    	  goblinAliveFrame.remove(goblinAliveImage);
          goblinAliveFrame.setLayout(new FlowLayout());
          goblinAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
          goblinInfo = new JLabel("Goblin Slain!!", SwingConstants.CENTER); 
          goblinInfo.setPreferredSize(new Dimension(300, 100));         
          goblinAliveFrame.add(new JLabel(new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/goblinDefeated.png"))); 
          goblinAliveFrame.add(goblinInfo);
          goblinAliveFrame.setLocation(1000,250); 
          goblinAliveFrame.pack();
          goblinAliveFrame.setVisible(true);
          goblinAliveFrame.setAlwaysOnTop (true);	  
     } 
     
     public static void spawnStartGoblin(Goblin Enemy)     
     {   
    	  goblinAliveFrame.remove(goblinAliveImage);
    	  goblinAliveFrame.remove(goblinInfo);
	      goblinAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	      //change file path for project
	      goblinInfo = new JLabel(Enemy.display(), SwingConstants.CENTER); 
	      goblinInfo.setPreferredSize(new Dimension(300, 100));
	      goblinAliveImage = (new JLabel (new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/goblinSpawn.png"))); 
	      //Display the window. 
	      goblinAliveFrame.add(goblinAliveImage);
	      goblinAliveFrame.add(goblinInfo);
	      goblinAliveFrame.setLocation(1000,250); 
	      goblinAliveFrame.pack();
	      goblinAliveFrame.setVisible(true);
	      goblinAliveFrame.setAlwaysOnTop (true);
     }
     
     public static void dealDamage(Goblin enemy, int damage) 
     {
    	//use this to check that hit points are being read correctly and can be use to call death frame
    	enemy.takeDamage(damage);
    	if(enemy.hitPoints <=0)
    	{
    		System.out.println("Enemy defeated");
    	}
    	else
    	{
    		//remove information first so that information updates properly
    		goblinAliveFrame.remove(goblinInfo);
      	    goblinAliveFrame.remove(goblinAliveImage);
    		goblinAliveFrame.setLayout(new FlowLayout());
    		goblinAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    		goblinInfo = new JLabel(enemy.display(), SwingConstants.CENTER); 
    	    goblinInfo.setPreferredSize(new Dimension(300, 100)); 
    	    //add new information back in
            goblinAliveImage = (new JLabel (new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/goblinTakeDamage.png")));
            goblinAliveFrame.add(goblinAliveImage);
    	    goblinAliveFrame.add(goblinInfo);    	      
    	    //Display the window. 
    	    goblinAliveFrame.setLocation(1000,250); 
    	    goblinAliveFrame.pack();
    	    goblinAliveFrame.setVisible(true);
    	    goblinAliveFrame.setAlwaysOnTop (true);
    	}
     }       
     
     public static void goblinAttacks(Goblin enemy)
     {
 		goblinAliveFrame.remove(goblinInfo);
  	    goblinAliveFrame.remove(goblinAliveImage);
		goblinAliveFrame.setLayout(new FlowLayout());
		goblinAliveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		goblinInfo = new JLabel(enemy.display(), SwingConstants.CENTER); 
	    goblinInfo.setPreferredSize(new Dimension(300, 100)); 
	    //add new information back in
        goblinAliveImage = (new JLabel (new ImageIcon("C:/Users/Cormac/Desktop/Java Projects/McHaleCormacJavaProject/images/goblinAttack.png")));
        goblinAliveFrame.add(goblinAliveImage);
	    goblinAliveFrame.add(goblinInfo);    	      
	    //Display the window. 
	    goblinAliveFrame.setLocation(1000,250); 
	    goblinAliveFrame.pack();
	    goblinAliveFrame.setVisible(true);
	    goblinAliveFrame.setAlwaysOnTop (true); 
     }
     //these methods finished 
     
}//end of class JFrame handling
