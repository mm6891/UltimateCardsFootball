package gssports.ultimatecardsfootball.activity.option;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.GridLayout;
import android.widget.Toast;
import gssports.ultimatecardsfootball.R;
import gssports.ultimatecardsfootball.database.dao.CardDAO;
import gssports.ultimatecardsfootball.activity.util.Constantes;

/**
 * Created by manuel.molero on 08/09/2015.
 */
public class SelectPlayersActivity extends Activity {
		
	public static final String TAG = "SelectPlayersActivity";			
		
    //botonera terreno de juego
    private ImageButton btn00;
    private GridLayout gvStadiumSide;
	//boton portero
	private Button imgBtn20;
		
	//botones defensas
	private Button imgBtn00;
	private Button imgBtn10;
	private Button imgBtn20;
	private Button imgBtn30;
	private Button imgBtn40;
	
	//botones medios
	private Button imgBtn01;
	private Button imgBtn11;
	private Button imgBtn21;
	private Button imgBtn31;
	private Button imgBtn41;
	
	//botones delanteros
	private Button imgBtn02;
	private Button imgBtn12;
	private Button imgBtn22;
	private Button imgBtn32;
	private Button imgBtn42;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team);		
		
		imgBtn20 = (Button) findViewById(R.id.imgBtn20);
		
		//load goalkeepers
		//cargamos el combo de porteros
        Spinner portero = (Spinner) findViewById(R.id.spPortero);

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

        List<String> list = new ArrayList<String>();
        CardDAO cardDAO = new CardDAO(getApplicationContext());
        String[] defensas = cardDAO.selectCardsByRol(Constantes.DEFENSA);
        list = Arrays.asList(defensas);

        ArrayAdapter<String> dataAdapterD = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapterD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        defensa.setAdapter(dataAdapterD);
		
		defensa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				imgBtn00;
				imgBtn10;
				imgBtn20;
				imgBtn30;
				imgBtn40;
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
		
}
