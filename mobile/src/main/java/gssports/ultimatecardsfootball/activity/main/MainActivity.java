package gssports.ultimatecardsfootball.activity.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import gssports.ultimatecardsfootball.R;
import gssports.ultimatecardsfootball.activity.option.SelectPlayersActivity;
import gssports.ultimatecardsfootball.activity.util.*;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

import com.google.android.gms.plus.Plus;



public class MainActivity extends Activity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        OnInvitationReceivedListener{    

	public static final String TAG = "MainActivity";
	
	    // Are we currently resolving a connection failure?
    private boolean mResolvingConnectionFailure = false;

	/**
     * A flag indicating that a PendingIntent is in progress and prevents us
     * from starting further intents.
     */
    private boolean mIntentInProgress;
    // Has the user clicked the sign-in button?
    private boolean mSignInClicked = false;

    // Automatically start the sign-in flow when the Activity starts
    private boolean mAutoStartSignInFlow = true;
	
	private ConnectionResult mConnectionResult;
	
	// For our intents
    private static final int RC_SIGN_IN = 9001;
    final static int RC_SELECT_PLAYERS = 10000;
    final static int RC_LOOK_AT_MATCHES = 10001;
  
    private TextView tvNick;
    private TextView tvStatus;
	
	private Button btnSelectTeam;  
    private com.google.android.gms.common.SignInButton btnSignIn;
	private Button btnSignOut;  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);    	
			
		btnSignIn = (com.google.android.gms.common.SignInButton) findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               signInWithGplus();
            }
        });	

		btnSignOut = (Button) findViewById(R.id.btn_sign_out);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               signOutFromGplus();
            }
        });	
			
        btnSelectTeam = (Button) findViewById(R.id.btnSelectTeam);
        btnSelectTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectPlayersActivity.class);
                startActivity(intent);
                finish();
            }
        });		       
    }      
	
	protected void onStart() {
        super.onStart();
        GoogleApiUtil.getApiClient().connect();
    }
 
    protected void onStop() {
        super.onStop();
        if (GoogleApiUtil.getApiClient().isConnected()) {
            GoogleApiUtil.getApiClient().disconnect();
        }
    }
 
    /**
     * Method to resolve any signin errors
     * */
    private void resolveSignInError() {
        if (mConnectionResult.hasResolution()) {
            try {
                mIntentInProgress = true;
                mConnectionResult.startResolutionForResult(this, RC_SIGN_IN);
            } catch (SendIntentException e) {
                mIntentInProgress = false;
                GoogleApiUtil.getApiClient().connect();
            }
        }
    }
 
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        if (!result.hasResolution()) {
            GooglePlayServicesUtil.getErrorDialog(result.getErrorCode(), this,
                    0).show();
            return;
        }
 
        if (!mIntentInProgress) {
            // Store the ConnectionResult for later usage
            mConnectionResult = result;
 
            if (mSignInClicked) {
                // The user has already clicked 'sign-in' so we attempt to
                // resolve all
                // errors until the user is signed in, or they cancel.
                resolveSignInError();
            }
        }
 
    }
 
    @Override
    protected void onActivityResult(int requestCode, int responseCode,
            Intent intent) {
        if (requestCode == RC_SIGN_IN) {
            if (responseCode != RESULT_OK) {
                mSignInClicked = false;
            }
 
            mIntentInProgress = false;
 
            if (!GoogleApiUtil.getApiClient().isConnecting()) {
                GoogleApiUtil.getApiClient().connect();
            }
        }
    }
 
    @Override
    public void onConnected(Bundle arg0) {
        mSignInClicked = false;
        Toast.makeText(this, "User is connected!", Toast.LENGTH_LONG).show();       
 
        // Update the UI after signin
        updateUI(true);
 
    }
 
    /**
     * Updating the UI, showing/hiding buttons and profile layout
     * */
    private void updateUI(boolean isSignedIn) {
        if (isSignedIn) {
            btnSignIn.setVisibility(View.GONE);
            btnSignOut.setVisibility(View.VISIBLE);
            //btnRevokeAccess.setVisibility(View.VISIBLE);
            //llProfileLayout.setVisibility(View.VISIBLE);
        } else {
            btnSignIn.setVisibility(View.VISIBLE);
            btnSignOut.setVisibility(View.GONE);
            //btnRevokeAccess.setVisibility(View.GONE);
            //llProfileLayout.setVisibility(View.GONE);
        }
    }   
 
    @Override
    public void onConnectionSuspended(int arg0) {
        GoogleApiUtil.getApiClient().connect();
        updateUI(false);
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }    
 
    /**
     * Sign-in into google
     * */
    private void signInWithGplus() {
        if (!GoogleApiUtil.getApiClient().isConnecting()) {
            mSignInClicked = true;
            resolveSignInError();
        }
    }
 
    /**
     * Sign-out from google
     * */
    private void signOutFromGplus() {
        if (GoogleApiUtil.getApiClient().isConnected()) {
            Plus.AccountApi.clearDefaultAccount(GoogleApiUtil.getApiClient());
            GoogleApiUtil.getApiClient().disconnect();
            GoogleApiUtil.getApiClient().connect();
            updateUI(false);
        }
    }
 
    /**
     * Revoking access from google
     * */
    private void revokeGplusAccess() {
        if (GoogleApiUtil.getApiClient().isConnected()) {
            Plus.AccountApi.clearDefaultAccount(GoogleApiUtil.getApiClient());
            Plus.AccountApi.revokeAccessAndDisconnect(GoogleApiUtil.getApiClient())
                    .setResultCallback(new ResultCallback<Status>() {
                        @Override
                        public void onResult(Status arg0) {
                            Log.e(TAG, "User access revoked!");
                            GoogleApiUtil.getApiClient().connect();
                            updateUI(false);
                        }
 
                    });
        }
    }
}
