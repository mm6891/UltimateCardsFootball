package gssports.ultimatecardsfootball.activity.card;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.GridLayout;
import android.widget.Toast;
import gssports.ultimatecardsfootball.R;


/**
 * Created by manuel.molero on 08/09/2015.
 */
public class CardActivity extends Activity {
		
	public static final String TAG = "CardActivity";	
		       
 
	TextView tvName;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card);		
		
		tvName = (TextView) findViewById(R.id.tvName);
		
            
    }
		
}
