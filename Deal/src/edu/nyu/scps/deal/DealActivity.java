package edu.nyu.scps.deal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DealActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //start the deal!      
        final Button start = (Button)findViewById(R.id.begin);              
        start.setOnClickListener(new View.OnClickListener ()
        {         	
        	public void onClick(View v)
        	{
        		Toast.makeText(DealActivity.this, "Open deal", Toast.LENGTH_SHORT).show();
        		start.setVisibility(View.GONE);
        	}
        });   
        
        //create the players
        Deal yours = new Deal();
        Deal theirs = new Deal();        
        boolean gameOver = false;
        
        //create the deal choices, attach listeners, run the deals   
        while (gameOver == false)
        {
        	setContentView(R.layout.menu);
        	RadioGroup choices = (RadioGroup)findViewById(R.id.menu);        
        	choices.addView(choices);
        
        	final View.OnClickListener radioListener = new View.OnClickListener() 
        	{
        		public void onClick(View v) 
        		{
        			RadioButton radioButton = (RadioButton)v;
        		}
        	};
		
        	final RadioButton choice0 = (RadioButton)findViewById(R.id.choice0);
        	choice0.setOnClickListener(radioListener);
		
        	final RadioButton choice1 = (RadioButton)findViewById(R.id.choice1);
        	choice1.setOnClickListener(radioListener);
		
        	final RadioButton choice2 = (RadioButton)findViewById(R.id.choice2);
        	choice2.setOnClickListener(radioListener);

        	switch (choices.getCheckedRadioButtonId())
        	{
				case 0:
					if (yours.validDeal(0))
					{
						yours.balance(0);
						gameOver = yours.openDeal(0, 1, theirs);
					}
					else 
						System.out.println("Choose again.\n");
						break;			
				case 1:
					if (yours.validDeal(1))
					{
						yours.balance(1);
						gameOver = yours.openDeal(1, 1, theirs);
					}
					else 
						System.out.println("Choose again.\n");
					break;
				case 2:
					if (yours.validDeal(2))
					{
						yours.balance(2);
						gameOver = yours.openDeal(2, 1, theirs);
					}
					else 
						System.out.println("Choose again.\n");
					break;
        	};//the opponent is pretty boring, sorry
        }             
    }
}