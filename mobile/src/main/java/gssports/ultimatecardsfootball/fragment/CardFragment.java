package gssports.ultimatecardsfootball.fragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

import gssports.ultimatecardsfootball.R;
import gssports.ultimatecardsfootball.activity.util.Constantes;
import gssports.ultimatecardsfootball.database.dao.CardDAO;
import gssports.ultimatecardsfootball.database.model.Atributos;
import gssports.ultimatecardsfootball.database.model.Avanzados;
import gssports.ultimatecardsfootball.database.model.Card;

public class CardFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.card, container, false);

		GridLayout.LayoutParams param = new GridLayout.LayoutParams();
		param.columnSpec =  GridLayout.spec(Integer.valueOf(getArguments().getString("c")).intValue());
		param.rowSpec = GridLayout.spec(Integer.valueOf(getArguments().getString("r")).intValue());
		v.setLayoutParams (param);
			
        String idCard = getArguments().getString("idCard");
		
		if(!idCard.equals("0")){
			CardDAO cardDAO = new CardDAO(v.getContext());
			Card card = cardDAO.selectCardByID(Integer.valueOf(idCard).intValue());

			TextView tvName = (TextView) v.findViewById(R.id.tvName);
			TextView tvNumero = (TextView) v.findViewById(R.id.tvNumero);
			TextView tvDatos = (TextView) v.findViewById(R.id.tvDatos);
			TextView tvDemarcacion = (TextView) v.findViewById(R.id.tvDemarcacion);
			TextView tvAtributos = (TextView) v.findViewById(R.id.tvAtributos);
			
			tvName.setText(card.getNombre());
			tvDemarcacion.setText(card.getDemarcacion());

			tvAtributos.setText(loadAtributosCard(card.getAtributos()) + loadAvanzadosCard(card.getAvanzados()));
		}
		else{
			TextView tvName = (TextView) v.findViewById(R.id.tvName);
			TextView tvNumero = (TextView) v.findViewById(R.id.tvNumero);
			TextView tvDatos = (TextView) v.findViewById(R.id.tvDatos);
			TextView tvDemarcacion = (TextView) v.findViewById(R.id.tvDemarcacion);
			TextView tvAtributos = (TextView) v.findViewById(R.id.tvAtributos);
			
			tvName.setText("VACIO");
			tvDemarcacion.setText("VACIO");

			tvAtributos.setText("VACIO");
		}

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				
            }
        });

        return v;
    }
	
	public static CardFragment newInstance(String idCard) {

        CardFragment f = new CardFragment();
        Bundle b = new Bundle();
        b.putString("idCard", idCard);		

        f.setArguments(b);

        return f;
    }

    public static CardFragment newInstance(String idCard, String column, String row) {

        CardFragment f = new CardFragment();
        Bundle b = new Bundle();
        b.putString("idCard", idCard);
        b.putString("c", column);
        b.putString("r", row);

        f.setArguments(b);

        return f;
    }

    private String loadAtributosCard(Atributos atributos){
        StringBuilder strBuilderAtributos = new StringBuilder();

        Class clsAtributos = null;
        try {
            clsAtributos = Class.forName(Constantes.PACKAGE_CLASS_ATRIBUTOS);
            for (Field f : clsAtributos.getDeclaredFields()) {
                Object value = f.get(atributos);
                int valueInt = Integer.valueOf(String.valueOf(value)).intValue();
                if(valueInt > 0){
                    strBuilderAtributos.append("|").append(f.getName()).append(":").append(String.valueOf(valueInt));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return strBuilderAtributos.toString();
    }

    private String loadAvanzadosCard(Avanzados avanzados) {
        StringBuilder strBuilderAvanzados = new StringBuilder();

        Class clsAvanzados = null;
        try {
            clsAvanzados = Class.forName(Constantes.PACKAGE_CLASS_AVANZADOS);
            for (Field f : clsAvanzados.getDeclaredFields()) {
                Object value = f.get(avanzados);
                int valueInt = Integer.valueOf(String.valueOf(value)).intValue();
                if(valueInt > 0){
                    strBuilderAvanzados.append("|").append(f.getName()).append(":").append(String.valueOf(valueInt));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return strBuilderAvanzados.toString();
    }
}
