package gssports.ultimatecardsfootball.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import gssports.ultimatecardsfootball.database.util.MyDatabaseHelper;

/**
 * Created by manuel.molero on 03/02/2015.
 */
public class AvanzadosDAO {
    
    //tables´s name
    public final static String AVANZADOS_TABLE="DBUFC_AVANZADOS";

    //columns table DBUFC_CARD
    public final static String DBUFC_AVANZADOS_ID="_id"; // id value
    public final static String DBUFC_AVANZADOS_V="V"; // colocacion
	public final static String DBUFC_AVANZADOS_PA="PA"; // reflejos
	public final static String DBUFC_AVANZADOS_F="F"; // salida por alto
	public final static String DBUFC_AVANZADOS_D="D"; // salida a los pies	

    /**
     *
     * @param context
     */
    public AvanzadosDAO(){        
    }       

    public Avanzados selectAvanzadosPorCardID(int cardID, MyDatabaseHelper database) {
        Avanzados ret;
        String[] cols = new String[] {DBUFC_AVANZADOS_ID,DBUFC_AVANZADOS_V, DBUFC_AVANZADOS_PA, DBUFC_AVANZADOS_F,DBUFC_AVANZADOS_D};
        String[] args = new String[]{String.valueOf(cardID)};
        Cursor mCursor = database.query(true, AVANZADOS_TABLE,cols,DBUFC_AVANZADOS_ID + "=?"
                , args, null, null, null, null);
        ret = new Atributos();        
        mCursor.moveToFirst();
        while (mCursor.isAfterLast() == false) {            
            ret.set_id(mCursor.getInt(0));
			ret.setV(mCursor.getInt(1));
			ret.setPA(mCursor.getInt(2));
			ret.setF(mCursor.getInt(3));
			ret.setD(mCursor.getInt(4));			
            
            mCursor.moveToNext();
        }
        return ret; // iterate to get each value.
    }       

}
