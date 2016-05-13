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
import gssports.ultimatecardsfootball.fragment.CardFragment;

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
	Card[] porteros;
	Card[] defensas;
	Card[] medios;
	Card[] delanteros;
 
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
				        
        CardDAO cardDAO = new CardDAO(getApplicationContext());
        porteros = cardDAO.selectCardsByRol(Constantes.PORTERO);               		
        defensas = cardDAO.selectCardsByRol(Constantes.DEFENSA);
		medios = cardDAO.selectCardsByRol(Constantes.CENTROCAMPISTA);
		delanteros = cardDAO.selectCardsByRol(Constantes.DELANTERO);
		
		//viewpagers
		ViewPager pagerPOR = (ViewPager) findViewById(R.id.viewPagerPOR);
        pagerPOR.setAdapter(new MyPageAdapter(getSupportFragmentManager(), porteros));		
		ViewPager pagerDEF = (ViewPager) findViewById(R.id.viewPagerDEF);
        pagerDEF.setAdapter(new MyPageAdapter(getSupportFragmentManager(), defensas));
		ViewPager pagerMED = (ViewPager) findViewById(R.id.viewPagerMED);
        pagerMED.setAdapter(new MyPageAdapter(getSupportFragmentManager(), medios));
		ViewPager pagerDEL = (ViewPager) findViewById(R.id.viewPagerDEL);
        pagerDEL.setAdapter(new MyPageAdapter(getSupportFragmentManager(), delanteros));
    }		
	
	// actualiza cartas para el jugador x
    public void onDoneClicked(View view) {        
		//recuperar cartas seleccionadas
		
		//validar que sean 11 cartas, minimo 3 def, 3 med, 1 del
		
		//almacenar nick para cada carta
		
    }
	
	  /**
    * Custom Page adapter
    */
    private class MyPageAdapter extends FragmentPagerAdapter
    {
		Card[] cards;
        public MyPageAdapter(FragmentManager fm, Card[] cards)
        {
			this.cards = cards;
            super(fm);
        }
        @Override
        public int getCount()
        {
            return cards.length();
        }
        @Override
        public CardFragment getItem(int position)
        {
			String name = cards[position];
			return CardFragment.newInstance(name);					          
        }
     }
}
