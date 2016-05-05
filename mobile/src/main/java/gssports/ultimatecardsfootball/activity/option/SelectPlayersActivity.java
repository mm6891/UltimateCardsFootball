package gssports.ultimatecardsfootball.activity.option;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gssports.ultimatecardsfootball.R;
import gssports.ultimatecardsfootball.database.dao.CardDAO;
import gssports.ultimatecardsfootball.activity.util.Constantes;

/**
 * Created by manuel.molero on 08/09/2015.
 */
public class SelectPlayersActivity extends Activity {
		
	public static final String TAG = "SelectPlayersActivity";			
		
    //botonera terreno de juego   
    private GridLayout gvStadiumSide;
	
	//boton portero
	private Button imgBtn20;		
	//botones defensas
	private Button imgBtn00;
	private Button imgBtn10;
	private Button imgBtn21;
	private Button imgBtn30;
	private Button imgBtn40;
	
	//botones medios
	private Button imgBtn01;
	private Button imgBtn11;
	private Button imgBtn22;
	private Button imgBtn31;
	private Button imgBtn41;
	
	//botones delanteros
	private Button imgBtn02;
	private Button imgBtn12;
	private Button imgBtn23;
	private Button imgBtn32;
	private Button imgBtn42;
	
	private Button btnDone;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team);		
		
		imgBtn20 = (Button) findViewById(R.id.imgBtn20);
		imgBtn00 = (Button) findViewById(R.id.imgBtn00);
		imgBtn10 = (Button) findViewById(R.id.imgBtn10);
		imgBtn21 = (Button) findViewById(R.id.imgBtn21);
		imgBtn30 = (Button) findViewById(R.id.imgBtn30);
		imgBtn40 = (Button) findViewById(R.id.imgBtn40);
		imgBtn01 = (Button) findViewById(R.id.imgBtn01);
		imgBtn11 = (Button) findViewById(R.id.imgBtn11);
		imgBtn22 = (Button) findViewById(R.id.imgBtn22);
		imgBtn31 = (Button) findViewById(R.id.imgBtn31);
		imgBtn41 = (Button) findViewById(R.id.imgBtn41);
		imgBtn02 = (Button) findViewById(R.id.imgBtn02);
		imgBtn12 = (Button) findViewById(R.id.imgBtn12);
		imgBtn23 = (Button) findViewById(R.id.imgBtn23);
		imgBtn32 = (Button) findViewById(R.id.imgBtn32);
		imgBtn42 = (Button) findViewById(R.id.imgBtn42);
		
		btnDone = (Button) findViewById(R.id.btnDone);
		
		//load goalkeepers
		//cargamos el combo de porteros
        final Spinner portero = (Spinner) findViewById(R.id.spPortero);

        List<String> list = new ArrayList<String>();
        CardDAO cardDAO = new CardDAO(getApplicationContext());
        String[] porteros = cardDAO.selectCardsByRol(Constantes.PORTERO);
        list = Arrays.asList(porteros);

        ArrayAdapter<String> dataAdapterP = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        portero.setAdapter(dataAdapterP);
		
		portero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				imgBtn20.setText(portero.getSelectedItemPosition());                
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
		
		//load deffenders
		//cargamos el combo de defensas
        Spinner defensa = (Spinner) findViewById(R.id.spDefensa);

        List<String> listDef = new ArrayList<String>();

        String[] defensas = cardDAO.selectCardsByRol(Constantes.DEFENSA);
		listDef = Arrays.asList(defensas);

        ArrayAdapter<String> dataAdapterDef = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listDef);
		dataAdapterDef.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        defensa.setAdapter(dataAdapterDef);
		
		defensa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
	
	private void updateTeamByNick(){
		
	}
		
}
