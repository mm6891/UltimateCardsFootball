package gssports.ultimatecardsfootball.activity.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import gssports.ultimatecardsfootball.R;
import gssports.ultimatecardsfootball.activity.option.SelectPlayersActivity;



public class MainActivity extends Activity {      
  
    private TextView tvNick;
    private TextView tvStatus;
	
	private Button btnSelectTeam;  
    private ImageButton btnGooglePlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        
        btnSelectTeam = (Button) findViewById(R.id.btnSelectTeam);
        btnSelectTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectPlayersActivity.class);
                startActivity(intent);
                finish();
            }
        });
       
    }      
}
