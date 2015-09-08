package gssports.ultimatecardsfootball.database.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by manuel.molero on 28/08/2015.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DBUFCARDS";

    private static final int DATABASE_VERSION = 1;
    public static String DB_PATH = "";

    // Database creation sql statement
    private static final String CREATE_TABLE_SG_CARDS =
            "create table SG_CARDS( _id integer primary key," +
                    "nombre text not null," +
                    "datos text not null," +
                    "numero text not null," +
                    "fecha TIMESTAMP NOT NULL DEFAULT current_timestamp," +
                    "_idRegistro integer," +
                    "_idCuenta integer not null," +
                    "grupogasto text not null," +
                    "  FOREIGN KEY(grupogasto) REFERENCES Grupo_Gastos(_id)," +
                    "  FOREIGN KEY(_idCuenta) REFERENCES Cuentas(_id)" +
                    ");";


    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE_SG_CARDS);
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
