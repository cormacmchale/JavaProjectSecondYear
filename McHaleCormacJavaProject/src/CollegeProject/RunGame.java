package CollegeProject;

import java.io.*;
import java.util.*;


public class RunGame extends JFrameHandling {
       static char continuePlaying;
	   public static void main(String[] args) {
		   	boolean correctChoice = true;
			char choice;
		    final Scanner console = new Scanner (System.in);
			
		    do
			{
		    System.out.println("PLease Choose a charcter: W/Wizard, K/Knight or R/rogue?");
		    choice= console.next().charAt(0);
		    if (choice == 'W' || choice =='K' || choice == 'R')
		    {
		    	correctChoice = false;
		    }
		    else
		    {
		    System.out.println("Invalid choice!");
		    }
			}
			while(correctChoice);
				
			//choice= console.next().charAt(0);
			
			
					if(choice == 'W' || choice == 'w')
					{
				       System.out.println("You've chosen the wizard!");
					   wizard playerCharacter = new wizard();
					   createWindowWizard(playerCharacter);
					   System.out.println("A Goblin Appears");
					   goblin enemyCharacter = new goblin();
					   createWindowGoblin(enemyCharacter);					   
					   fight(playerCharacter, enemyCharacter);
					   
					   
								if(enemyCharacter.hitPoints<=0)
								{
								System.out.println("Goblin Defeated! Continue to Level Two? Y/N");
								continuePlaying = console.next().charAt(0);	
								}
								if(playerCharacter.hitPoints<=0)
								{
								wizardAliveFrame.setVisible(false);	
								goblinAliveFrame.setVisible(false);
								System.out.println("You've been Defeated, Game Over");
						        }
								if(continuePlaying == 'Y' || continuePlaying == 'y')
								{
								goblinAliveFrame.setVisible(false);
								}								
								
						 }

					}

	      
	   
	
	  	  	  	   	   	   
	   public static void fight(wizard playerCharacter, goblin enemyCharacter)
	   {
		    final Scanner console = new Scanner (System.in);
		    int damageTaken;
		    int damageDealt;
		    int goblinRNG;
		    char attackChoice;
		    boolean fighting = true;
		    
		    
		   while(fighting)
		   {						   
						       

			   
		       System.out.println("Choose A/ttack or S/pell: ");
		       attackChoice = console.next().charAt(0);
		       if (attackChoice == 'A' || attackChoice == 'a')
		       {
		    	  System.out.println("You attacked the Goblin with a physical attack!");
		    	  damageDealt = (int)(Math.random()*30);
		    	  dealDamage(enemyCharacter, damageDealt);
		    	  System.out.println("You attacked dealing "+damageDealt+ " damage");
    			   goblinRNG = (int)(Math.random()*3);
	   			   if(goblinRNG == 1 && fighting == true)
	   			   {			   
	   			   damageTaken = (int)(Math.random()*10);		       
	   		       takeDamage(playerCharacter, damageTaken);
	   		       System.out.println("Goblin attacked dealing "+damageTaken+" damage");
	   			   }
	   			   else
	   			   {
	   				   System.out.println("Goblin Missed!");
	   			   }	   			   
                    if(enemyCharacter.hitPoints<=0)
                    {
                    	enemyDefeated(enemyCharacter);
                        fighting = false;
                    }
                    if(playerCharacter.hitPoints<=0)
                    {
                    	playerDied(playerCharacter);
                        fighting = false;
                    }

                  
		       }		       
			   						 					       
		    }
		  					   
	 	 		   
		   
	   }
	} 


