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
		 System.out.print("PLease Choose a charcter: W/Wizard or K/Knight? ");
		 choice= console.next().charAt(0);
		 if (choice == 'W' || choice =='K')
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
			 wizardFight(playerCharacter, enemyCharacter);//function to run battle
					   
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
					System.out.println("To be continued...");
				}
				else if(continuePlaying == 'N' || continuePlaying == 'n')
				{
					wizardAliveFrame.setVisible(false);	
					goblinAliveFrame.setVisible(false);
				}
			 //create next enemy for battle
			 //check you have left battle.. spawn wizard again
				spawnStartWizard(playerCharacter);
			}// end of if statement for Wizard Battles

			else if(choice == 'K' || choice == 'k')
			{
				System.out.println("You've chosen the Knight!");
				Knight playerCharacter = new Knight();//object created here
				createWindowKnight(playerCharacter);//spawn knight
				System.out.println("A Goblin Appears");
				Goblin enemyCharacter = new Goblin();//creates enemy object
				createWindowGoblin(enemyCharacter);//spawns enemy
				
				knightFight(playerCharacter, enemyCharacter);//function to run battle
				
				 	if(enemyCharacter.hitPoints<=0)//make sure code run correctly on exiting the function
					{
				 		System.out.println("Goblin Defeated! Continue to Next Enemy? Y/N");
						continuePlaying = console.next().charAt(0);	//variable to keep game running
					}
					if(playerCharacter.hitPoints<=0)//keep check on players hit points
					{
						knightAliveFrame.setVisible(false);	
						goblinAliveFrame.setVisible(false);
						System.out.println("You've been Defeated, Game Over");//end game
					}
					if(continuePlaying == 'Y' || continuePlaying == 'y')
					{
						goblinAliveFrame.setVisible(false);//enemy defeated
						System.out.println("To be continued...");
					}
					else if(continuePlaying == 'N' || continuePlaying == 'n')
					{
						knightAliveFrame.setVisible(false);	
						goblinAliveFrame.setVisible(false);
					}
			        //create next enemy for battle - to be worked on...
			        //check you have left battle.. spawn knight again
				    spawnStartKnight(playerCharacter);
				
			}// end of if else for Knight battles
		 
	  }// end of main where game is being run
	 
      //fight now finished	  	  	   	   	   
	  public static void wizardFight(Wizard playerCharacter, Goblin enemyCharacter)
	  {
		  //variable needed plus scanner for inputs
		  final Scanner console = new Scanner (System.in);
		  int damageTaken;
		  int damageDealt;
		  //using rng for goblin actions
		  int goblinRNG;
		  char attackChoice;
		  char actionChoice;
		  char potionChoice;
		  boolean fighting = true;
		  //begin the fight here using boolean to keep fight active
		  while(fighting)
		  {			  
	            System.out.print("Choose A/ttack or I/tem: ");
	            actionChoice = console.next().charAt(0); //choice of attack or item		    	  
  			    goblinRNG = (int)(Math.random()*3);//rng for deciding if goblin will attack or miss
	   			  if(goblinRNG == 2 && fighting == true || goblinRNG == 3 && fighting == true )
	   			  {		
	   				 
	   				  damageTaken = (int)(Math.random()*50);		       
	   				  takeDamage(playerCharacter, damageTaken);//similar to player attack and damage
	   				  System.out.println("Goblin attacked dealing "+damageTaken+" damage");
	   				  goblinAttacks(enemyCharacter);

	   			  }
	   			  else
	   			  {
	   				  System.out.println("Goblin Missed!");
	   				  spawnStartGoblin(enemyCharacter);
	   			  }//end of if for goblin attack

	              if(actionChoice == 'A' || actionChoice == 'a')
	              {
	            	System.out.print("Choose P/hysical attack or S/pell: ");
	            	attackChoice = console.next().charAt(0); //choice of attack or spell
			      if (attackChoice == 'P' || attackChoice == 'p')
			      {
			    	  //spawn wizard for attack animation
			          spawnStartWizard(playerCharacter);
			    	  System.out.println("You attacked the Goblin with a physical attack!");
			    	  damageDealt = (int)(Math.random()*10);//random damage for attack
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
				    	   damageDealt = (int)(Math.random()*40);//random damage for attack
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
			    	   }//end of if for magic points
			    	   else
			    	   {
			    		   System.out.println("Magic depleted, Spell un-effective!!");
			    		   spawnStartWizard(playerCharacter);
			    	   }
			    	 }//end of else if for attack choice
			      
	    		   }//end of else if for action choice
			                     
	           else if(actionChoice =='I' || actionChoice == 'i')
	           {
	        	   System.out.print("Enter H for Health Potion or M for Magic Potion: ");

	        	   potionChoice = console.next().charAt(0); //choice of Potion
	        	   if (potionChoice =='H' || potionChoice == 'h')
	        	   {
	        		   if(healthPotion <=0)
	        		   {
	        			   System.out.println("No more Health Potions!!");
	        		   }
	        		   else
	        		   {
	        			   playerCharacter.hitPoints+=playerCharacter.POTION_HEALING;//implementing an interface
		        		   spawnStartWizard(playerCharacter);//re set the animation of window for battle continuity
		        		   spawnStartGoblin(enemyCharacter);//re set the animation of window for battle continuity
		        		   System.out.println("You've healed for 50 HP!");
		        		   healthPotion--;
	        		   }//end of if statement to check if you can use health potion..
	        	   }
	        	   else if (potionChoice == 'M' || potionChoice == 'm')
	        	   {
	        		   if(magicPotion <=0)
	        		   {
	        			   System.out.println("No more Magic Potions!!");
	        		   }
	        		   else
	        		   {
	        			   playerCharacter.magicPoints+=playerCharacter.POTION_MAGIC;
		        		   spawnStartWizard(playerCharacter);//re set the animation of window for battle continuity
		        		   spawnStartGoblin(enemyCharacter);//re set the animation of window for battle continuity
		        		   System.out.println("You've regained 50 MP!");
		        		   magicPotion--;
	        		   }//end of if statement to check if you can use magic potion..
	        	   }	        	   			        	   
	           }//end of if for action
		 }//end of while loop battle		  					   		   
	  }//end of fight function
	
	  public static void knightFight(Knight playerCharacter, Goblin enemyCharacter)
	  {
		  //variable needed plus scanner for inputs
		  final Scanner console = new Scanner (System.in);
		  int damageTaken;
		  int damageDealt;
		  //using rng for goblin actions
		  int goblinRNG;
		  char attackChoice;
		  char actionChoice;
		  char potionChoice;
		  boolean fighting = true;
		  while(fighting)
		  {			  
	            System.out.print("Choose A/ttack or I/tem: ");
	            actionChoice = console.next().charAt(0); //choice of attack or item		    	  
  			    goblinRNG = (int)(Math.random()*3);//rng for deciding if goblin will attack or miss
	   			  if(goblinRNG == 2 && fighting == true || goblinRNG == 3 && fighting == true )
	   			  {		
	   				 
	   				  damageTaken = (int)(Math.random()*50);
	   				  if (damageTaken > 30)
	   				  {
		   				  takeDamageKnight(playerCharacter, (damageTaken-playerCharacter.defence));//knights defence lessens the damage
		   				  System.out.println("Goblin attacked dealing "+damageTaken+" damage, Knights armour of "+playerCharacter.defence+" blocked damage");
		   				  goblinAttacks(enemyCharacter);
	   				  }// this will make sure that threshold for defense dosent mess up the function
	   				  else
	   				  {
		   				  takeDamageKnight(playerCharacter,damageTaken);//knights defence lessens the damage
		   				  System.out.println("Goblin attacked dealing "+damageTaken+" damage");
		   				  goblinAttacks(enemyCharacter); 
	   				  }
	   			  }
	   			  else
	   			  {
	   				  System.out.println("Goblin Missed!");
	   				  spawnStartGoblin(enemyCharacter);
	   			  }//end of if for goblin attack
	   			  
	   			  if(actionChoice == 'A' || actionChoice == 'a')//knight attacks
	   			  {
		            	System.out.print("Choose P/hysical attack or D/efend: ");
		            	attackChoice = console.next().charAt(0); //choice of attack or defence
				      if (attackChoice == 'P' || attackChoice == 'p')
				      {
				    	  //spawn knight for attack animation
				          spawnStartKnightAttack(playerCharacter);
				    	  System.out.println("You attacked the Goblin with a physical attack!");
				    	  damageDealt = (int)(Math.random()*40);//random damage for attack
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
		                	  playerDiedKnight(playerCharacter);
		                      fighting = false;//end loop and exit function
		                  }
				       }//end of if for attack
				      else if(attackChoice == 'D' || attackChoice == 'd')
				      {
				    	  spawnStartKnightDefend(playerCharacter);
				    	  spawnStartGoblin(enemyCharacter);//animation for defense action
				    	  playerCharacter.defence+=5;//defense threshold increasing
				    	  System.out.println("You've Raised you're defence by 5!");				    	  
				    	  
				      }//end of if for attack choice				      				  
	   			  }//end of if statement for attack with knight
	   			  else if(actionChoice == 'I' || actionChoice == 'i')
	   			  {
		        	   System.out.print("Enter H for Health Potion or D for Defence Up: ");

		        	   potionChoice = console.next().charAt(0); //choice of Potion
		        	   if (potionChoice =='H' || potionChoice == 'h')
		        	   {
		        		   if(healthPotion <=0)
		        		   {
		        			   System.out.println("No more Health Potions!!");
		        		   }
		        		   else
		        		   {
		        			   playerCharacter.hitPoints+=playerCharacter.POTION_HEALING;//implementing an interface
			        		   spawnStartKnight(playerCharacter);//re set the animation of window for battle continuity
			        		   spawnStartGoblin(enemyCharacter);//re set the animation of window for battle continuity
			        		   System.out.println("You've healed for 50 HP!");
			        		   healthPotion--;
		        		   }//end of if statement to check if you can use health potion..
		        	   }
		        	   else if (potionChoice == 'D' || potionChoice == 'd')
		        	   {
		        		   if(magicPotion <=0)
		        		   {
		        			   System.out.println("No more Magic Potions!!");
		        		   }
		        		   else
		        		   {
		        			   playerCharacter.defence += playerCharacter.DEFENCE_BOOST;
			        		   spawnStartKnight(playerCharacter);//re set the animation of window for battle continuity
			        		   spawnStartGoblin(enemyCharacter);//re set the animation of window for battle continuity
			        		   System.out.println("You've gained 2 Defence!");
			        		   magicPotion--;
		        		   }//end of if statement to check if you can use magic potion..
		        	   }//end of if else to use Health Potion or Defense UP
	   			  }//end of else if for Item
		  }//end of while loop for knight battle		  		  
	  }//end of fight function for Knight	  
}//end of public class RunGame 


