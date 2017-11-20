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
			 //create next enemy for battle
			 //check you have left battle.. spawn wizard again
				spawnStartWizard(playerCharacter);
			}// end of if statement for Wizard Battles

	  }// end of main where game is being run
	 
      //fight now finished- hopefully	  	  	   	   	   
	  public static void fight(Wizard playerCharacter, Goblin enemyCharacter)
	  {
		  //variable needed plus scanner for inputs
		  final Scanner console = new Scanner (System.in);
		  int damageTaken;
		  int damageDealt;
		  //using rng for goblin actions
		  int goblinRNG;
		  char attackChoice;
		  char actionChoice;
		  boolean fighting = true;
		  //begin the fight here using boolean to keep fight active
		  while(fighting)
		  {
			  
	            System.out.println("Choose A/ttack or I/tem: ");
	            actionChoice = console.next().charAt(0); //choice of attack or item		    	  
  			    goblinRNG = (int)(Math.random()*3);//rng for deciding if goblin will attack or miss
	   			  if(goblinRNG == 1 && fighting == true)
	   			  {		
	   				 
	   				  damageTaken = (int)(Math.random()*10);		       
	   				  takeDamage(playerCharacter, damageTaken);//similar to player attack and damage
	   				  System.out.println("Goblin attacked dealing "+damageTaken+" damage");
	   				  goblinAttacks(enemyCharacter);
	   				  takeDamage(playerCharacter, 0);

	   			  }
	   			  else
	   			  {
	   				  System.out.println("Goblin Missed!");
	   			  }

	            if(actionChoice == 'A' || actionChoice == 'a')
	              {
	              
				  System.out.println("Choose P/hysical attack or S/pell: ");
			      attackChoice = console.next().charAt(0); //choice of attack or spell
			      if (attackChoice == 'P' || attackChoice == 'p')
			      {
			    	  System.out.println("You attacked the Goblin with a physical attack!");
			    	  damageDealt = (int)(Math.random()*1);//random damage for attack
			    	  dealDamage(enemyCharacter, damageDealt);//function to deal damage
			    	  System.out.println("You attacked dealing "+damageDealt+ " damage");

		   			  
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
			       }//end of if for attack
			       //begin choice for spell
			       else if (attackChoice == 'S' || attackChoice == 's')
	    		   {

			    	   if(playerCharacter.magicPoints > 0)
			    	   {
				    	   System.out.println("You Launch a Fireball at the goblin!");
				    	   damageDealt = (int)(Math.random()*1000);//random damage for attack
				    	   dealDamage(enemyCharacter, damageDealt);//function to deal damage
				    	   useSpell(playerCharacter, 50);
				    	   System.out.println("Fire spell deals "+damageDealt+ " damage");

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
			    	   else
			    	   {
			    		   System.out.println("Magic Depleted, spell is un-effective!!");
			    		   goblinRNG = (int)(Math.random()*3);//rng for deciding if goblin will attack or mis
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
	    		   }//end of else if for attack
			      
               }
	           else if(actionChoice =='I' || actionChoice == 'i')
	           {
	        	   System.out.println("finish item actions in code");
	           }//end of if for action
		 }//end of while loop battle		  					   		   
	  }//end of fight function
	  
}//end of public class RunGame 


