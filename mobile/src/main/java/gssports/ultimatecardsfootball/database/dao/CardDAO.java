package gssports.ultimatecardsfootball.database.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import gssports.ultimatecardsfootball.database.model.Atributos;
import gssports.ultimatecardsfootball.database.model.Avanzados;
import gssports.ultimatecardsfootball.database.model.Card;
import gssports.ultimatecardsfootball.database.model.Posicion;
import gssports.ultimatecardsfootball.database.util.MyDatabaseHelper;

/**
 * Created by manuel.molero on 03/02/2015.
 */
public class CardDAO {
    private MyDatabaseHelper dbHelper;

    private SQLiteDatabase database;

    //tables´s name
    public final static String CARD_TABLE="DBUFC_CARD";

    //columns table DBUFC_CARD
    public final static String DBUFC_CARD_ID="_id"; // id value
    public final static String DBUFC_CARD_NOMBRE="nombre";  // nombre del jugador/carta
    public final static String DBUFC_CARD_ATRIBUTOS="atributos";  // atributos de la tabla atributos
    public final static String DBUFC_CARD_AVANZADOS="avanzados";  // atributos avanzados de la tabla avanzados
    public final static String DBUFC_CARD_POSICION="posicion";  // posiciones del jugador/carta en el campo
    public final static String DBUFC_CARD_PLAYER="player"; // informado con nick de player si esta seleccionado en partida
	public final static String DBUFC_CARD_DEMARCACION="demarcacion"; // demarcacion, POR, DEF, MED, DEL
		

    /**
     *
     * @param context
     */
    public CardDAO(Context context){
        dbHelper = new MyDatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }   

    public Card[] selectCards() {
        Card[] ret;
        String[] cols = new String[] {DBUFC_CARD_ID,DBUFC_CARD_NOMBRE, DBUFC_CARD_ATRIBUTOS, DBUFC_CARD_AVANZADOS,DBUFC_CARD_POSICION,DBUFC_CARD_PLAYER,DBUFC_CARD_DEMARCACION};
        Cursor mCursor = database.query(true, CARD_TABLE,cols,null
                , null, null, null, null, null);
        ret = new Card[mCursor.getCount()];
        int i = 0;
        mCursor.moveToFirst();
        while (mCursor.isAfterLast() == false) {
            Card cardTemp = new Card();
            cardTemp.set_id(mCursor.getInt(0));
			cardTemp.setNombre(mCursor.getString(1));            
			
            int idAtributos = mCursor.getInt(2);
			AtributosDAO atributosDAO = new AtributosDAO();
			Atributos atributos = atributosDAO.selectAtributosPorCardID(idAtributos,database);
            cardTemp.setAtributos(atributos);
			
			int idAvanzados = mCursor.getInt(3);
			AvanzadosDAO avanzadosAO = new AvanzadosDAO();
			Avanzados avanzados = avanzadosAO.selectAvanzadosPorCardID(idAvanzados,database);
            cardTemp.setAvanzados(avanzados);
			
			int idPosicion = mCursor.getInt(4);
			PosicionDAO posicionDAO = new PosicionDAO();
			Posicion posicion = posicionDAO.selectPosicionPorCardID(idPosicion,database);
            cardTemp.setPosicion(posicion);
			
			cardTemp.setPlayer(mCursor.getString(5));            
			cardTemp.setDemarcacion(mCursor.getString(6)); 
			
            ret[i] = cardTemp;
            i++;
            mCursor.moveToNext();
        }
        return ret; // iterate to get each value.
    }

    public Card[] selectCardsByPlayer(String playerNick) {
        Card[] ret;
        String[] cols = new String[] {DBUFC_CARD_ID,DBUFC_CARD_NOMBRE, DBUFC_CARD_ATRIBUTOS, DBUFC_CARD_AVANZADOS,DBUFC_CARD_POSICION,DBUFC_CARD_PLAYER,DBUFC_CARD_DEMARCACION};
        String[] args = new String[]{playerNick};
        Cursor mCursor = database.query(true, CARD_TABLE,cols,DBUFC_CARD_PLAYER + "=?"
                , args, null, null, null, null);
        ret = new Card[mCursor.getCount()];
        int i = 0;
        mCursor.moveToFirst();
        while (mCursor.isAfterLast() == false) {
            Card cardTemp = new Card();
            cardTemp.set_id(mCursor.getInt(0));
			cardTemp.setNombre(mCursor.getString(1));            
			
            int idAtributos = mCursor.getInt(2);
			AtributosDAO atributosDAO = new AtributosDAO();
			Atributos atributos = atributosDAO.selectAtributosPorCardID(idAtributos,database);
            cardTemp.setAtributos(atributos);
			
			int idAvanzados = mCursor.getInt(3);
			AvanzadosDAO avanzadosAO = new AvanzadosDAO();
			Avanzados avanzados = avanzadosAO.selectAvanzadosPorCardID(idAvanzados,database);
            cardTemp.setAvanzados(avanzados);
			
			int idPosicion = mCursor.getInt(4);
			PosicionDAO posicionDAO = new PosicionDAO();
			Posicion posicion = posicionDAO.selectPosicionPorCardID(idPosicion,database);
            cardTemp.setPosicion(posicion);
			
			cardTemp.setPlayer(mCursor.getString(5));            
			cardTemp.setDemarcacion(mCursor.getString(6)); 
			
            ret[i] = cardTemp;
            i++;
            mCursor.moveToNext();
        }
        return ret; // iterate to get each value.
    }       
	
	public String[] selectCardsByRol(String rol) {
        String[] ret;
        String[] cols = new String[] {DBUFC_CARD_NOMBRE};
        String[] args = new String[]{rol};
        Cursor mCursor = database.query(true, CARD_TABLE,cols,DBUFC_CARD_DEMARCACION + "=?"
                , args, null, null, null, null);
        ret = new String[mCursor.getCount()];
        int i = 0;
        mCursor.moveToFirst();
        while (mCursor.isAfterLast() == false) {
            String cardTemp = new String();            
			cardTemp = mCursor.getString(0);
			
            ret[i] = cardTemp;
            i++;
            mCursor.moveToNext();
        }
        return ret; // iterate to get each value.
    }
	
	public Card selectCardByID(int idCard) {
        Card ret;
        String[] cols = new String[] {DBUFC_CARD_ID,DBUFC_CARD_NOMBRE, DBUFC_CARD_ATRIBUTOS, DBUFC_CARD_AVANZADOS,DBUFC_CARD_POSICION,DBUFC_CARD_PLAYER,DBUFC_CARD_DEMARCACION};
        String[] args = new String[]{String.valueOf(idCard)};
        Cursor mCursor = database.query(true, CARD_TABLE,cols,DBUFC_CARD_ID + "=?"
                , args, null, null, null, null);
        ret = new Card();
        int i = 0;
        mCursor.moveToFirst();
        while (mCursor.isAfterLast() == false) {
            Card cardTemp = new Card();
            cardTemp.set_id(mCursor.getInt(0));
			cardTemp.setNombre(mCursor.getString(1));            
			
            int idAtributos = mCursor.getInt(2);
			AtributosDAO atributosDAO = new AtributosDAO();
			Atributos atributos = atributosDAO.selectAtributosPorCardID(idAtributos,database);
            cardTemp.setAtributos(atributos);
			
			int idAvanzados = mCursor.getInt(3);
			AvanzadosDAO avanzadosAO = new AvanzadosDAO();
			Avanzados avanzados = avanzadosAO.selectAvanzadosPorCardID(idAvanzados,database);
            cardTemp.setAvanzados(avanzados);
			
			int idPosicion = mCursor.getInt(4);
			PosicionDAO posicionDAO = new PosicionDAO();
			Posicion posicion = posicionDAO.selectPosicionPorCardID(idPosicion,database);
            cardTemp.setPosicion(posicion);
			
			cardTemp.setPlayer(mCursor.getString(5));            
			cardTemp.setDemarcacion(mCursor.getString(6)); 
			
            ret = cardTemp;
            i++;
            mCursor.moveToNext();
        }
        return ret; // iterate to get each value.
    }    

}
