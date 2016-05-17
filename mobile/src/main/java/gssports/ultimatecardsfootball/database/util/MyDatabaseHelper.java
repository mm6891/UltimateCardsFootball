package gssports.ultimatecardsfootball.database.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by manuel.molero on 28/08/2015.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DBUFC";

    private static final int DATABASE_VERSION = 1;
    public static String DB_PATH = "";

    // Database creation sql statement
    private static final String CREATE_TABLE_DBUFC_CARD =
            "create table DBUFC_CARD( _id integer primary key," +                   
					"url_imagen text," +
                    "  FOREIGN KEY(atributos) REFERENCES DBUFC_ATRIBUTOS(_id)," +
                    "  FOREIGN KEY(avanzados) REFERENCES DBUFC_AVANZADOS(_id)," +					
					"  FOREIGN KEY(posicion) REFERENCES DBUFC_POSICION(_id)," +
					"  FOREIGN KEY(player) REFERENCES DBUFC_PLAYER(_id)," +
                    ");";
	private static final String CREATE_TABLE_DBUFC_ATRIBUTOS =
            "create table DBUFC_ATRIBUTOS( _id integer primary key," +                   
					"CO integer," +
                    "RF integer," +
					"SA integer," +
					"SP integer," +
					"PC integer," +
					"PL integer," +
					"RG integer," +
					"A integer," +
					"RB integer," +
					"RC integer," +
					"LF integer," +
					"RM integer," +
					"DL integer," +
                    ");";
	private static final String CREATE_TABLE_DBUFC_AVANZADOS =
            "create table DBUFC_AVANZADOS( _id integer primary key," +                   
					"V integer," +
                    "PA integer," +
					"F integer," +
					"D integer," +
                    ");";
		
	private static final String CREATE_TABLE_DBUFC_POSICION =
            "create table DBUFC_POSICION( _id integer primary key," +                   												
					"POS01 integer,POS02 integer, POS03 integer, POS04 integer, POS05 integer,POS06 integer," +					
					"POS11 integer, POS12 integer, POS13 integer, POS14 integer,POS15 integer,POS16 integer," +					
	"POS20 integer, POS21 integer, POS22 integer, POS23 integer,POS24 integer,POS25 integer,POS26 integer,POS27 integer," +					
					"POS31 integer, POS32 integer, POS33 integer, POS34 integer,POS35 integer,POS36 integer," +
					"POS41 integer, POS42 integer, POS43 integer, POS44 integer,POS45 integer,POS46 integer," +												
                    ");";
	private static final String CREATE_TABLE_DBUFC_FORMACION =
            "create table DBUFC_FORMACION( _id integer primary key," +    
					"formacion text not null," +
					"  FOREIGN KEY(formacionFK) REFERENCES DBUFC_POSICION(_id)," +									
                    ");";
	private static final String CREATE_TABLE_DBUFC_PLAYER =
            "create table DBUFC_PLAYER( _id integer primary key," +    
					"nickPlayer text not null," +													
                    ");";


    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {

        //database.execSQL(CREATE_TABLE_SG_CARDS);
    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion){
        Log.w(MyDatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS SG_CARDS");

        onCreate(database);
    }
}
