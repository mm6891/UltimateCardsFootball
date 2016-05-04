/*
package gssports.ultimatecardsfootball.dialog.card;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

import gssports.ultimatecardsfootball.R;
import gssports.ultimatecardsfootball.activity.util.Constantes;
import gssports.ultimatecardsfootball.database.dao.CardDAO;
import gssports.ultimatecardsfootball.database.model.Atributos;
import gssports.ultimatecardsfootball.database.model.Avanzados;
import gssports.ultimatecardsfootball.database.model.Card;


*/
/**
 * Created by manuel.molero on 08/09/2015.
 *//*

public class CardDialog extends DialogFragment {
		
	public static final String TAG = "CardDialog";	
		       
 
	TextView tvName;
	TextView tvDemarcacion;
	TextView tvAtributos;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
							 
		final View view = inflater.inflate(R.layout.card, container, false);      
		
		String idPlayer = getArguments().getString("idCard");
		CardDAO cardDAO = new CardDAO(view.getContext());
        Card card = cardDAO.selectCardByID(Integer.valueOf(idPlayer).intValue());
				
		tvName = (TextView) view.findViewById(R.id.tvName);
		tvDemarcacion = (TextView) view.findViewById(R.id.tvDemarcacion);
		tvAtributos = (TextView) view.findViewById(R.id.tvAtributos);
		
		tvName.setText(card.getNombre());
		tvDemarcacion.setText(card.getDemarcacion());
		tvAtributos.setText(loadAtributosCard(card.getAtributos()) + loadAvanzadosCard(card.getAvanzados()));        
    }
	
	 */
/** The system calls this only when creating the layout in a dialog. *//*

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        return dialog;
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
*/
