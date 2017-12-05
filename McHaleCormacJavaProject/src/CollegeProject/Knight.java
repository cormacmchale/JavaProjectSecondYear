package CollegeProject;

//PlayerCharacter Option.. Easier Difficulty
public class Knight extends Character 
{

	public int defence;
	
	public Knight() //constructor for knight
	{
		hitPoints = 150;
		//magicPoints = 5; knight has no magic points
		defence = 8;		
	}
	
    //smaller methods for basic action
    public void takeDamage(int damage)
    {
  	hitPoints -= damage;
    }
    
    //overwrite display method for knight
	/*public String display()
	{
		String s = "";
		s+= super.toString();
		s+= " "+ defence+"\n";
		return s;
	}*/ //wont display properly in rungame
}
