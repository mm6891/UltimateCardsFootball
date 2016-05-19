package gssports.ultimatecardsfootball.activity.stadium;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * Created by manuel.molero on 27/04/2016.
 */
public class StadiumTurn {

    public static final String TAG = "EBTurn";

    public String data = "";	
    public int turnCounter;
    //true : ataque, false: defensa
    public boolean turnoAtaque;
    //idcard,position
    //public HashMap<Integer,String> movimientos;

    public StadiumTurn() {
    }

    // This is the byte array we will write out to the TBMP API.
    public byte[] persist() {
        JSONObject retVal = new JSONObject();

        try {
            retVal.put("data", data);
            retVal.put("turnCounter", turnCounter);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String st = retVal.toString();

        Log.d(TAG, "==== PERSISTING\n" + st);

        return st.getBytes(Charset.forName("UTF-8"));
    }

    // Creates a new instance of StadiumTurn.
    static public StadiumTurn unpersist(byte[] byteArray) {

        if (byteArray == null) {
            Log.d(TAG, "Empty array---possible bug.");
            return new StadiumTurn();
        }

        String st = null;
        try {
            st = new String(byteArray, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            return null;
        }

        Log.d(TAG, "====UNPERSIST \n" + st);

        StadiumTurn retVal = new StadiumTurn();

        try {
            JSONObject obj = new JSONObject(st);

            if (obj.has("data")) {
                retVal.data = obj.getString("data");
            }
            if (obj.has("turnCounter")) {
                retVal.turnCounter = obj.getInt("turnCounter");
            }
           /* if (obj.has("movimientos")) {
                Object movimientosObj = obj.get("movimientos");

            }*/

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return retVal;
    }
}
