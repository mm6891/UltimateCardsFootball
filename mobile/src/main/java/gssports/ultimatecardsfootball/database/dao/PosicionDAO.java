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
    public final static String DBUFC_POSICION_POS00="POS00"; // casilla 00
	public final static String DBUFC_POSICION_POS01="POS01"; // casilla 01
	public final static String DBUFC_POSICION_POS02="POS02"; // casilla 02
	public final static String DBUFC_POSICION_POS03="POS03"; // casilla 03
	public final static String DBUFC_POSICION_POS04="POS04"; // casilla 04
	public final static String DBUFC_POSICION_POS05="POS05"; // casilla 05
	public final static String DBUFC_POSICION_POS06="POS06"; // casilla 06
	public final static String DBUFC_POSICION_POS07="POS07"; // casilla 07
	public final static String DBUFC_POSICION_POS08="POS08"; // casilla 08
	public final static String DBUFC_POSICION_POS09="POS09"; // casilla 09
	public final static String DBUFC_POSICION_POS10="POS10"; // casilla 10
	public final static String DBUFC_POSICION_POS11="POS11"; // casilla 11
	public final static String DBUFC_POSICION_POS12="POS12"; // casilla 12
	public final static String DBUFC_POSICION_POS13="POS13"; // casilla 13
	public final static String DBUFC_POSICION_POS14="POS14"; // casilla 14
	public final static String DBUFC_POSICION_POS15="POS15"; // casilla 15
	public final static String DBUFC_POSICION_POS16="POS16"; // casilla 16
	public final static String DBUFC_POSICION_POS17="POS17"; // casilla 17
	public final static String DBUFC_POSICION_POS18="POS18"; // casilla 18
	public final static String DBUFC_POSICION_POS19="POS19"; // casilla 19
	public final static String DBUFC_POSICION_POS20="POS20"; // casilla 20
	public final static String DBUFC_POSICION_POS21="POS21"; // casilla 21
	public final static String DBUFC_POSICION_POS22="POS22"; // casilla 22
	public final static String DBUFC_POSICION_POS23="POS23"; // casilla 23
	public final static String DBUFC_POSICION_POS24="POS24"; // casilla 24
	public final static String DBUFC_POSICION_POS25="POS25"; // casilla 25
	public final static String DBUFC_POSICION_POS26="POS26"; // casilla 26
	public final static String DBUFC_POSICION_POS27="POS27"; // casilla 27
	public final static String DBUFC_POSICION_POS28="POS28"; // casilla 28
	public final static String DBUFC_POSICION_POS29="POS29"; // casilla 29
	public final static String DBUFC_POSICION_POS30="POS30"; // casilla 30
	public final static String DBUFC_POSICION_POS31="POS31"; // casilla 31
	public final static String DBUFC_POSICION_POS32="POS32"; // casilla 32
	public final static String DBUFC_POSICION_POS33="POS33"; // casilla 33
	public final static String DBUFC_POSICION_POS34="POS34"; // casilla 34
	public final static String DBUFC_POSICION_POS35="POS35"; // casilla 35
	public final static String DBUFC_POSICION_POS36="POS36"; // casilla 36
	public final static String DBUFC_POSICION_POS37="POS37"; // casilla 37
	public final static String DBUFC_POSICION_POS38="POS38"; // casilla 38
	public final static String DBUFC_POSICION_POS39="POS39"; // casilla 39
	public final static String DBUFC_POSICION_POS40="POS40"; // casilla 40
	public final static String DBUFC_POSICION_POS41="POS41"; // casilla 41
	public final static String DBUFC_POSICION_POS42="POS42"; // casilla 42
	public final static String DBUFC_POSICION_POS43="POS43"; // casilla 43
	public final static String DBUFC_POSICION_POS44="POS44"; // casilla 44
	public final static String DBUFC_POSICION_POS45="POS45"; // casilla 45
	
    /**
     *
	 */
    public PosicionDAO(){        
    }       

    public Posicion selectPosicionPorCardID(int cardID, SQLiteDatabase database) {
        Posicion ret;
        String[] cols = new String[] {DBUFC_POSICION_ID,DBUFC_POSICION_POS00, DBUFC_POSICION_POS01, DBUFC_POSICION_POS02,DBUFC_POSICION_POS03,DBUFC_POSICION_POS04,DBUFC_POSICION_POS05,
										DBUFC_POSICION_POS06,DBUFC_POSICION_POS07,DBUFC_POSICION_POS08,DBUFC_POSICION_POS09,DBUFC_POSICION_POS10,DBUFC_POSICION_POS11,DBUFC_POSICION_POS12,
										DBUFC_POSICION_POS13,DBUFC_POSICION_POS14,DBUFC_POSICION_POS15,DBUFC_POSICION_POS16,DBUFC_POSICION_POS17,DBUFC_POSICION_POS18,DBUFC_POSICION_POS19,
										DBUFC_POSICION_POS20,DBUFC_POSICION_POS21,DBUFC_POSICION_POS22,DBUFC_POSICION_POS23,DBUFC_POSICION_POS24,DBUFC_POSICION_POS25,DBUFC_POSICION_POS26,
										DBUFC_POSICION_POS27,DBUFC_POSICION_POS28,DBUFC_POSICION_POS29,DBUFC_POSICION_POS30,DBUFC_POSICION_POS31,DBUFC_POSICION_POS32,DBUFC_POSICION_POS33,
										DBUFC_POSICION_POS34,DBUFC_POSICION_POS35,DBUFC_POSICION_POS36,DBUFC_POSICION_POS37,DBUFC_POSICION_POS38,DBUFC_POSICION_POS39,DBUFC_POSICION_POS40,
										DBUFC_POSICION_POS41,DBUFC_POSICION_POS42,DBUFC_POSICION_POS43,DBUFC_POSICION_POS44,DBUFC_POSICION_POS45};
        String[] args = new String[]{String.valueOf(cardID)};
        Cursor mCursor = database.query(true, POSICION_TABLE,cols,DBUFC_POSICION_ID + "=?"
                , args, null, null, null, null);
        ret = new Posicion();        
        mCursor.moveToFirst();
        while (mCursor.isAfterLast() == false) {            
            ret.set_id(mCursor.getInt(0));
			ret.setPOS00(mCursor.getInt(1));
			ret.setPOS01(mCursor.getInt(2));
			ret.setPOS02(mCursor.getInt(3));
			ret.setPOS03(mCursor.getInt(4));
			ret.setPOS04(mCursor.getInt(5));
			ret.setPOS05(mCursor.getInt(6));
			ret.setPOS06(mCursor.getInt(7));
			ret.setPOS07(mCursor.getInt(8));
			ret.setPOS08(mCursor.getInt(9));
			ret.setPOS09(mCursor.getInt(10));
			ret.setPOS10(mCursor.getInt(11));
			ret.setPOS11(mCursor.getInt(12));
			ret.setPOS12(mCursor.getInt(13));
			ret.setPOS13(mCursor.getInt(14));
			ret.setPOS14(mCursor.getInt(15));
			ret.setPOS15(mCursor.getInt(16));
			ret.setPOS16(mCursor.getInt(17));
			ret.setPOS17(mCursor.getInt(18));
			ret.setPOS18(mCursor.getInt(19));
			ret.setPOS19(mCursor.getInt(20));
			ret.setPOS20(mCursor.getInt(21));
			ret.setPOS21(mCursor.getInt(22));
			ret.setPOS22(mCursor.getInt(23));
			ret.setPOS23(mCursor.getInt(24));
			ret.setPOS24(mCursor.getInt(25));
			ret.setPOS25(mCursor.getInt(26));
			ret.setPOS26(mCursor.getInt(27));
			ret.setPOS27(mCursor.getInt(28));
			ret.setPOS28(mCursor.getInt(29));
			ret.setPOS29(mCursor.getInt(30));
			ret.setPOS30(mCursor.getInt(31));
			ret.setPOS31(mCursor.getInt(32));
			ret.setPOS32(mCursor.getInt(33));
			ret.setPOS33(mCursor.getInt(34));
			ret.setPOS34(mCursor.getInt(35));
			ret.setPOS35(mCursor.getInt(36));
			ret.setPOS36(mCursor.getInt(37));
			ret.setPOS37(mCursor.getInt(38));
			ret.setPOS38(mCursor.getInt(39));
			ret.setPOS39(mCursor.getInt(40));
			ret.setPOS40(mCursor.getInt(41));
			ret.setPOS41(mCursor.getInt(42));
			ret.setPOS42(mCursor.getInt(43));
			ret.setPOS43(mCursor.getInt(44));
			ret.setPOS44(mCursor.getInt(45));
			ret.setPOS45(mCursor.getInt(46));
            
            mCursor.moveToNext();
        }
        return ret; // iterate to get each value.
    }       

}
