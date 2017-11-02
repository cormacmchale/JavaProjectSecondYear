package CollegeProject;

import java.io.*;
import java.util.*;


public class RunGame extends JFrameHandling {

	   public static void main(String[] args) {

			char choice;
		    final Scanner console = new Scanner (System.in);
			System.out.println("PLease Choose a charcter: W/Wizard, K/Knight or R/rogue?");
			choice = console.next().charAt(0);
			
			
					if(choice == 'W' || choice == 'w')
					{
				       System.out.println("You've chosen the wizard!");
					}
									
					
					   wizard playerCharacter = new wizard();
					   createWindowWizard(playerCharacter);
					   
					   System.out.println("A Goblin Appears");
					   goblin enemyCharacter = new goblin();
					   createWindowGoblin(enemyCharacter);
					   
					   fight(playerCharacter, enemyCharacter);
					   
					   System.out.println("Is it finished");
					   System.out.println("more git hub jazz");
 
	      
	   }
	
	   
	   
	   
	   
	   
	   
	   public static void fight(wizard playerCharacter, goblin enemyCharacter)
	   {
		    final Scanner console = new Scanner (System.in);
		    int damageTaken;
		    int damageDealt;
		    char attackChoice;
		    boolean fighting = true;
		    
		    
		   while(playerCharacter.hitPoints >=0 && fighting)
		   {						   
						       
			   System.out.println("Enter damage taken: ");
		       damageTaken = console.nextInt();
		       takeDamage(playerCharacter, damageTaken);
		       System.out.println("Choose A/ttack or S/pell: ");
		       attackChoice = console.next().charAt(0);
		       if (attackChoice == 'A' || attackChoice == 'a')
		       {
		    	  System.out.println("You attacked the Goblin with a physical attack!");
		    	  damageDealt = (int)(Math.random()*20);
		    	  dealDamage(enemyCharacter, damageDealt);
                    if(enemyCharacter.hitPoints<=0)
                    {
                    	enemyDefeated(enemyCharacter);
                        fighting = false;
                    }
                  
		       }		       
			   						 					       
		    }
		  					   
	 	   //playerDied(playerCharacter); 		   
		   
	   }
	} 


