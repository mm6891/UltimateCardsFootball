package gssports.ultimatecardsfootball.activity.card;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.GridLayout;
import android.widget.Toast;
import gssports.ultimatecardsfootball.R;


/**
 * Created by manuel.molero on 08/09/2015.
 */
public class CardActivity extends Activity {
		
	public static final String TAG = "CardActivity";	
		       
 
	TextView tvName;
	TextView tvDemarcacion;
	TextView tvAtributos;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card);		
		
		String idPlayer = getArguments().getString("idCard");
		CardDAO cardDAO = new CardDAO(getApplicationContext());
        Card card = cardDAO.selectCardByID(Integer.valueOf(idPlayer).intValue);
				
		tvName = (TextView) findViewById(R.id.tvName);
		tvDemarcacion = (TextView) findViewById(R.id.tvDemarcacion);
		tvAtributos = (TextView) findViewById(R.id.tvAtributos);
		
		tvName.setText(card.getNombre());
		tvDemarcacion.setText(card.getDemarcacion());
		tvAtributos.setText(loadAtributosCard(card.getAtributos()) + loadAvanzadosCard(card.getAvanzados()));        
    }

	private String loadAtributosCard(Atributos atributos) {	
		StringBuilder strBuilderAtributos = new StringBuilder();		
		
		Class clsAtributos = Class.forName(Constantes.PACKAGE_CLASS_ATRIBUTOS);		
		for (Field f : clsAtributos.getDeclaredFields()) {			
			Object value = f.get(atributos);
			int valueInt = Integer.valueOf(value).intValue();
			if(valueInt > 0){
				strBuilderAtributos.append("|").append(f.getName()).append(":").append(String.valueOf(valueInt));
			}
		}	
		return strBuilderAtributos.toString();
	}
	
	private String loadAvanzadosCard(Avanzados avanzados) {
		StringBuilder strBuilderAvanzados = new StringBuilder();		
		
		Class clsAvanzados = Class.forName(Constantes.PACKAGE_CLASS_AVANZADOS);		
		for (Field f : clsAvanzados.getDeclaredFields()) {			
			Object value = f.get(avanzados);
			int valueInt = Integer.valueOf(value).intValue();
			if(valueInt > 0){
				strBuilderAvanzados.append("|").append(f.getName()).append(":").append(String.valueOf(valueInt));
			}
		}	
		return strBuilderAvanzados.toString();
	}
}
