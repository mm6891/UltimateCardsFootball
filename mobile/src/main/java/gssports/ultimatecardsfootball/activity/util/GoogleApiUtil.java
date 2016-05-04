package gssports.ultimatecardsfootball.activity.util;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.games.Games;



public class GoogleApiUtil {

	public static final String TAG = "GoogleApiUtil";
	
	// Client used to interact with Google APIs
    private static GoogleApiClient mGoogleApiClient;
	
	public static GoogleApiClient getApiClient(){
		if(mGoogleApiClient != null)
			return mGoogleApiClient;
		else{
			// Create the Google API Client with access to Plus and Games
			mGoogleApiClient = new GoogleApiClient.Builder(this)
					.addConnectionCallbacks(this)
					.addOnConnectionFailedListener(this)
					.addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN)
					.addApi(Games.API).addScope(Games.SCOPE_GAMES)
					.build();
			return mGoogleApiClient;
		}			
	}
	
}
