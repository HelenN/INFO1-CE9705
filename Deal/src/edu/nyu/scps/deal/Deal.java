package edu.nyu.scps.deal;

public class Deal 
{
	int asset, wins;	
	static int microFlation = 1000, mezzoFlation = 5000, macroFlation = 100000;
	
	public Deal() 
	{
		asset = 500000;
		wins = 0;
	}
	
	//determine if the deal is valid
	public boolean validDeal (int yourFlation)
	{
		int temp = -1;
		
		switch (yourFlation)
		{
			case 0:
				temp = microFlation;
				break;
			case 1:
				temp = mezzoFlation;
				break;
			case 2:
				temp = macroFlation;
				break;
		}
		
		if (asset >= temp)
			return true;
		else 
			return false;
	}
	
	//decrease player's assets by flation used
	public void balance (int yourFlation)
	{		
		switch (yourFlation)
		{
			case 0:
				asset -= microFlation;
				break;
			case 1:
				asset -= mezzoFlation;
				break;
			case 2:
				asset -= macroFlation;
				break;
		};
	}
	
	//determine results of deal
	public boolean openDeal (int yourFlation, int theirFlation, Deal theirs)
	{	
		//calculate win, loss, or draw and update win count
		if (yourFlation == theirFlation)		
			System.out.println("Draw\n");
		else if (yourFlation < theirFlation)
		{
			System.out.println("You lose\n");
			++theirs.wins;
		}
		else 
		{
			System.out.println("You win\n");
			++wins;
		}
		
		//bankrupt = lose deal
		//win 3 matches first = win deal
		//both win 3 matches on the same turn = drawn deal
		//your opponent goes bankrupt = win deal
		//your opponent wins 3 matches first = lose deal
		if (asset == 0)
		{
			System.out.println("You are bankrupt.");
			return true;
		}
		else if (wins == 3 && theirs.wins < 3)
		{
			asset += theirs.asset; //you gain your opponent's assets for winning the deal
			System.out.println("You have gain: " + asset);
			return true;
		}
		else if (wins == 3 && theirs.wins == 3)
		{
			System.out.println("Deal is a draw\n");
			return true;
		}
		else if (theirs.wins == 3)
		{
			System.out.println("You lose.\nRemaining assets: " + asset);
			return true;
		}
		else
			return false; //keep the deal going
	}

}
