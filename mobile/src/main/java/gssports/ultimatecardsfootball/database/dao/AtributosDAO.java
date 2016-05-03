package gssports.ultimatecardsfootball.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import gssports.ultimatecardsfootball.database.util.MyDatabaseHelper;

/**
 * Created by manuel.molero on 03/02/2015.
 */
public class AtributosDAO {
    
    //tables´s name
    public final static String ATRIBUTOS_TABLE="DBUFC_ATRIBUTOS";

    //columns table DBUFC_CARD
    public final static String DBUFC_ATRIBUTOS_ID="_id"; // id value
    public final static String DBUFC_ATRIBUTOS_CO="CO"; // colocacion
	public final static String DBUFC_ATRIBUTOS_RF="RF"; // reflejos
	public final static String DBUFC_ATRIBUTOS_SA="SA"; // salida por alto
	public final static String DBUFC_ATRIBUTOS_SP="SP"; // salida a los pies
	public final static String DBUFC_ATRIBUTOS_PC="PC"; // pase corto
	public final static String DBUFC_ATRIBUTOS_PL="PL"; // pase largo
	public final static String DBUFC_ATRIBUTOS_RG="RG"; // regate
	public final static String DBUFC_ATRIBUTOS_A="A"; // anticipacion
	public final static String DBUFC_ATRIBUTOS_RB="RB"; // robo de balon
	
	public final static String DBUFC_ATRIBUTOS_RC="RC"; // remate/despeje de cabeza
	public final static String DBUFC_ATRIBUTOS_LF="LF"; // lanzamiento de falta
	public final static String DBUFC_ATRIBUTOS_RM="RM"; // remate
	public final static String DBUFC_ATRIBUTOS_DL="DL"; // disparo lejano

    /**
     *
     * @param context
     */
    public AtributosDAO(){        
    }       

    public Atributos selectAtributosPorCardID(int cardID, MyDatabaseHelper database) {
        Atributos ret;
        String[] cols = new String[] {DBUFC_ATRIBUTOS_ID,DBUFC_ATRIBUTOS_CO, DBUFC_ATRIBUTOS_RF, DBUFC_ATRIBUTOS_SA,DBUFC_ATRIBUTOS_SP,DBUFC_ATRIBUTOS_PC,
										DBUFC_ATRIBUTOS_PL,DBUFC_ATRIBUTOS_RG,DBUFC_ATRIBUTOS_A,DBUFC_ATRIBUTOS_RB,DBUFC_ATRIBUTOS_RC,DBUFC_ATRIBUTOS_LF,
										DBUFC_ATRIBUTOS_RM,DBUFC_ATRIBUTOS_DL};
        String[] args = new String[]{String.valueOf(cardID)};
        Cursor mCursor = database.query(true, ATRIBUTOS_TABLE,cols,DBUFC_ATRIBUTOS_ID + "=?"
                , args, null, null, null, null);
        ret = new Atributos();        
        mCursor.moveToFirst();
        while (mCursor.isAfterLast() == false) {            
            ret.set_id(mCursor.getInt(0));
			ret.setCO(mCursor.getInt(1));
			ret.setRF(mCursor.getInt(2));
			ret.setSA(mCursor.getInt(3));
			ret.setSP(mCursor.getInt(4));
			ret.setPC(mCursor.getInt(5));
			ret.setPL(mCursor.getInt(6));
			ret.setRG(mCursor.getInt(7));
			ret.setA(mCursor.getInt(8));
			ret.setRB(mCursor.getInt(9));
			ret.setRC(mCursor.getInt(10));
			ret.setLF(mCursor.getInt(11));
			ret.setRM(mCursor.getInt(12));
			ret.setDL(mCursor.getInt(13));
            
            mCursor.moveToNext();
        }
        return ret; // iterate to get each value.
    }       

}
