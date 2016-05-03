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
	
	private AlertDialog mAlertDialog;
	
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team);		
		
		imgBtn20 = (Button) findViewById(R.id.imgBtn20);
		
		//load goalkeepers
		//cargamos el combo de categorias
        Spinner portero = (Spinner) findViewById(R.id.spPortero);

        List<String> list = new ArrayList<String>();
        CardDAO cardDAO = new CardDAO(getApplicationContext());
        String[] porteros = cardDAO.selectCardsByRol(Constantes.PORTERO);
        list = Arrays.asList(porteros);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        portero.setAdapter(dataAdapter);
		
		portero.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				imgBtn20.setText(portero.getSelectedItemPosition());                
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
		
}
