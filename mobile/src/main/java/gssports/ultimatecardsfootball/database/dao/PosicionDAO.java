package gssports.ultimatecardsfootball.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import gssports.ultimatecardsfootball.database.model.Posicion;
import gssports.ultimatecardsfootball.database.util.MyDatabaseHelper;

/**
 * Created by manuel.molero on 03/02/2015.
 */
public class PosicionDAO {
    
    //tables´s name
    public final static String POSICION_TABLE="DBUFC_POSICION";

    //columns table DBUFC_CARD
    public final static String DBUFC_POSICION_ID="_id"; // id value
	public final static String DBUFC_POSICION_POS01="POS01"; // casilla 01
	public final static String DBUFC_POSICION_POS02="POS02"; // casilla 02
	public final static String DBUFC_POSICION_POS03="POS03"; // casilla 03
	public final static String DBUFC_POSICION_POS04="POS04"; // casilla 04
	public final static String DBUFC_POSICION_POS05="POS05"; // casilla 05
	public final static String DBUFC_POSICION_POS06="POS06"; // casilla 06
	public final static String DBUFC_POSICION_POS11="POS11"; // casilla 11
	public final static String DBUFC_POSICION_POS12="POS12"; // casilla 12
	public final static String DBUFC_POSICION_POS13="POS13"; // casilla 13
	public final static String DBUFC_POSICION_POS14="POS14"; // casilla 14
	public final static String DBUFC_POSICION_POS15="POS15"; // casilla 15
	public final static String DBUFC_POSICION_POS16="POS16"; // casilla 16
	public final static String DBUFC_POSICION_POS20="POS20"; // casilla 20
	public final static String DBUFC_POSICION_POS21="POS21"; // casilla 21
	public final static String DBUFC_POSICION_POS22="POS22"; // casilla 22
	public final static String DBUFC_POSICION_POS23="POS23"; // casilla 23
	public final static String DBUFC_POSICION_POS24="POS24"; // casilla 24
	public final static String DBUFC_POSICION_POS25="POS25"; // casilla 25
	public final static String DBUFC_POSICION_POS26="POS26"; // casilla 26
	public final static String DBUFC_POSICION_POS27="POS27"; // casilla 27
	public final static String DBUFC_POSICION_POS31="POS31"; // casilla 31
	public final static String DBUFC_POSICION_POS32="POS32"; // casilla 32
	public final static String DBUFC_POSICION_POS33="POS33"; // casilla 33
	public final static String DBUFC_POSICION_POS34="POS34"; // casilla 34
	public final static String DBUFC_POSICION_POS35="POS35"; // casilla 35
	public final static String DBUFC_POSICION_POS36="POS36"; // casilla 36
	public final static String DBUFC_POSICION_POS41="POS41"; // casilla 41
	public final static String DBUFC_POSICION_POS42="POS42"; // casilla 42
	public final static String DBUFC_POSICION_POS43="POS43"; // casilla 43
	public final static String DBUFC_POSICION_POS44="POS44"; // casilla 44
	public final static String DBUFC_POSICION_POS45="POS45"; // casilla 45
	public final static String DBUFC_POSICION_POS46="POS46"; // casilla 46
	
    /**
     *
	 */
    public PosicionDAO(){        
    }       

    public Posicion selectPosicionPorCardID(int cardID, SQLiteDatabase database) {
        Posicion ret;
        String[] cols = new String[] {DBUFC_POSICION_ID,DBUFC_POSICION_POS01, DBUFC_POSICION_POS02,DBUFC_POSICION_POS03,DBUFC_POSICION_POS04,DBUFC_POSICION_POS05,DBUFC_POSICION_POS06,
				DBUFC_POSICION_POS11,DBUFC_POSICION_POS12,DBUFC_POSICION_POS13,DBUFC_POSICION_POS14,DBUFC_POSICION_POS15,DBUFC_POSICION_POS16,
										DBUFC_POSICION_POS20,DBUFC_POSICION_POS21,DBUFC_POSICION_POS22,DBUFC_POSICION_POS23,DBUFC_POSICION_POS24,DBUFC_POSICION_POS25,DBUFC_POSICION_POS26, DBUFC_POSICION_POS27,
										DBUFC_POSICION_POS31,DBUFC_POSICION_POS32,DBUFC_POSICION_POS33,DBUFC_POSICION_POS34,DBUFC_POSICION_POS35,DBUFC_POSICION_POS36,
										DBUFC_POSICION_POS41,DBUFC_POSICION_POS42,DBUFC_POSICION_POS43,DBUFC_POSICION_POS44,DBUFC_POSICION_POS45,DBUFC_POSICION_POS46};
        String[] args = new String[]{String.valueOf(cardID)};
        Cursor mCursor = database.query(true, POSICION_TABLE,cols,DBUFC_POSICION_ID + "=?"
                , args, null, null, null, null);
        ret = new Posicion();        
        mCursor.moveToFirst();
        while (mCursor.isAfterLast() == false) {            
            ret.set_id(mCursor.getInt(0));
			ret.setPOS01(mCursor.getInt(1));
			ret.setPOS02(mCursor.getInt(2));
			ret.setPOS03(mCursor.getInt(3));
			ret.setPOS04(mCursor.getInt(4));
			ret.setPOS05(mCursor.getInt(5));
			ret.setPOS06(mCursor.getInt(6));
			ret.setPOS11(mCursor.getInt(7));
			ret.setPOS12(mCursor.getInt(8));
			ret.setPOS13(mCursor.getInt(9));
			ret.setPOS14(mCursor.getInt(10));
			ret.setPOS15(mCursor.getInt(11));
			ret.setPOS16(mCursor.getInt(12));
			ret.setPOS20(mCursor.getInt(13));
			ret.setPOS21(mCursor.getInt(14));
			ret.setPOS22(mCursor.getInt(15));
			ret.setPOS23(mCursor.getInt(16));
			ret.setPOS24(mCursor.getInt(17));
			ret.setPOS25(mCursor.getInt(18));
			ret.setPOS26(mCursor.getInt(19));
			ret.setPOS27(mCursor.getInt(20));
			ret.setPOS31(mCursor.getInt(21));
			ret.setPOS32(mCursor.getInt(22));
			ret.setPOS33(mCursor.getInt(23));
			ret.setPOS34(mCursor.getInt(24));
			ret.setPOS35(mCursor.getInt(25));
			ret.setPOS36(mCursor.getInt(26));
			ret.setPOS41(mCursor.getInt(27));
			ret.setPOS42(mCursor.getInt(28));
			ret.setPOS43(mCursor.getInt(29));
			ret.setPOS44(mCursor.getInt(30));
			ret.setPOS45(mCursor.getInt(31));
			ret.setPOS46(mCursor.getInt(32));
            
            mCursor.moveToNext();
        }
        return ret; // iterate to get each value.
    }       

}
