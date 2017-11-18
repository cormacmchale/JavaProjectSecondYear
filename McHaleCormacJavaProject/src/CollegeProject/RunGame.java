package CollegeProject;

import java.io.*;
import java.util.*;


public class RunGame extends JFrameHandling 
{
	 //static variable to use to ask if player woukd like to continue
     static char continuePlaying;
     
	 public static void main(String[] args) 
	 {
		 boolean correctChoice = true;
		 char choice;
		 //add to allow to ask user for input
		 final Scanner console = new Scanner (System.in);			
		 do
		 {
		 System.out.println("PLease Choose a charcter: W/Wizard or K/Knight?");
		 choice= console.next().charAt(0);
		 if (choice == 'W' || choice =='K' || choice == 'R')
		 {
			 correctChoice = false;//boolean
		 }
		 else
		 {
		     System.out.println("Invalid choice!");
		 }//end of if statement for error handling
		 }//end of DO statement
		 while(correctChoice);//end of do while loop to start game	
		 
		 if(choice == 'W' || choice == 'w')
		 {
			 System.out.println("You've chosen the wizard!");
			 Wizard playerCharacter = new Wizard();//creates object
			 createWindowWizard(playerCharacter);//spawns character choice
			 System.out.println("A Goblin Appears");
			 Goblin enemyCharacter = new Goblin();//creates enemy object
			 createWindowGoblin(enemyCharacter);//spawns enemy					   
			 fight(playerCharacter, enemyCharacter);//function to run battle
					   
			 	if(enemyCharacter.hitPoints<=0)//make sure code run correctly on exiting the function
				{
			 		System.out.println("Goblin Defeated! Continue to Next Enemy? Y/N");
					continuePlaying = console.next().charAt(0);	//variable to keep game running
				}
				if(playerCharacter.hitPoints<=0)//keep check on players hit points
				{
					wizardAliveFrame.setVisible(false);	
					goblinAliveFrame.setVisible(false);
					System.out.println("You've been Defeated, Game Over");//end game
				}
				if(continuePlaying == 'Y' || continuePlaying == 'y')
				{
					goblinAliveFrame.setVisible(false);//enemy defeated
				}
				
				
			}// end of if statement for Wizard Battles

	  }// end of main where game is being run	   
		  	  	  	   	   	   
	  public static void fight(Wizard playerCharacter, Goblin enemyCharacter)
	  {
		  //variable needed plus scanner for inputs
		  final Scanner console = new Scanner (System.in);
		  int damageTaken;
		  int damageDealt;
		  //using rng for goblin actions
		  int goblinRNG;
		  char attackChoice;
		  boolean fighting = true;
		  //begin the fight here using boolean to keep fight active
		  while(fighting)
		  {						   						       			   
			  System.out.println("Choose A/ttack or S/pell: ");
		      attackChoice = console.next().charAt(0); //choice of attack or spell
		      if (attackChoice == 'A' || attackChoice == 'a')
		      {
		    	  System.out.println("You attacked the Goblin with a physical attack!");
		    	  damageDealt = (int)(Math.random()*30);//random damage for attack
		    	  dealDamage(enemyCharacter, damageDealt);//function to deal damage
		    	  System.out.println("You attacked dealing "+damageDealt+ " damage");
    			  goblinRNG = (int)(Math.random()*3);//rng for deciding if goblin will attack or miss
	   			  if(goblinRNG == 1 && fighting == true)
	   			  {			   
	   				  damageTaken = (int)(Math.random()*10);		       
	   				  takeDamage(playerCharacter, damageTaken);//similar to player attack and damage
	   				  System.out.println("Goblin attacked dealing "+damageTaken+" damage");
	   			  }
	   			  else
	   			  {
	   				  System.out.println("Goblin Missed!");
	   			  }
	   			  //again check to make sure both character are alive
                  if(enemyCharacter.hitPoints<=0)
                  {
                	  enemyDefeated(enemyCharacter);
                      fighting = false;//end loop and exit function
                  }
                  if(playerCharacter.hitPoints<=0)
                  {
                	  playerDied(playerCharacter);
                      fighting = false;//end loop and exit function
                  }
                  
		       }		       
			   						 					       
		 }//end of while loop battle		  					   		   
	  }//end of fight function
	  
}//end of public class RunGame 


