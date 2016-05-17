package gssports.ultimatecardsfootball.activity.option;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import android.content.ClipData;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.Toast;

import java.util.ArrayList;

import gssports.ultimatecardsfootball.R;
import gssports.ultimatecardsfootball.activity.main.MainActivity;
import gssports.ultimatecardsfootball.database.dao.CardDAO;
import gssports.ultimatecardsfootball.activity.util.Constantes;
import gssports.ultimatecardsfootball.fragment.CardFragment;
import gssports.ultimatecardsfootball.database.model.Card;

/**
 * Created by manuel.molero on 08/09/2015.
 */
public class SelectPlayersActivity extends FragmentActivity {
		
	public static final String TAG = "SelectPlayersActivity";			
		
    //botonera terreno de juego   
    private GridLayout gvStadiumSide;
	
	//boton portero
	private Button imgBtn20;		
	//botones defensas
	private Button imgBtn01;
	private Button imgBtn11;
	private Button imgBtn21;
	private Button imgBtn31;
	private Button imgBtn41;
	
	//botones medios
	private Button imgBtn02;
	private Button imgBtn12;
	private Button imgBtn22;
	private Button imgBtn32;
	private Button imgBtn42;
	
	//botones delanteros
	private Button imgBtn03;
	private Button imgBtn13;
	private Button imgBtn23;
	private Button imgBtn33;
	private Button imgBtn43;
	
	private Button btnDone;
	Card[] porteros;
	Card[] defensas;
	Card[] medios;
	Card[] delanteros;
	CardDAO cardDAO;

	ArrayList<Card> seleccionadas;

	private int currentPage;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team);		
		
		imgBtn21 = (Button) findViewById(R.id.imgBtn20);
		imgBtn21.setTag(21);
		imgBtn21.setOnDragListener(new MyDragListener());
		imgBtn01 = (Button) findViewById(R.id.imgBtn00);
		imgBtn01.setTag(01);
		imgBtn01.setOnDragListener(new MyDragListener());
		imgBtn11 = (Button) findViewById(R.id.imgBtn10);
		imgBtn11.setTag(11);
		imgBtn11.setOnDragListener(new MyDragListener());
		imgBtn21 = (Button) findViewById(R.id.imgBtn21);
		imgBtn21.setTag(21);
		imgBtn21.setOnDragListener(new MyDragListener());
		imgBtn31 = (Button) findViewById(R.id.imgBtn30);
		imgBtn31.setTag(31);
		imgBtn31.setOnDragListener(new MyDragListener());
		imgBtn41 = (Button) findViewById(R.id.imgBtn40);
		imgBtn41.setTag(41);
		imgBtn41.setOnDragListener(new MyDragListener());
		imgBtn02 = (Button) findViewById(R.id.imgBtn01);
		imgBtn02.setTag(02);
		imgBtn02.setOnDragListener(new MyDragListener());
		imgBtn12 = (Button) findViewById(R.id.imgBtn11);
		imgBtn12.setTag(12);
		imgBtn12.setOnDragListener(new MyDragListener());
		imgBtn22 = (Button) findViewById(R.id.imgBtn22);
		imgBtn22.setTag(22);
		imgBtn22.setOnDragListener(new MyDragListener());
		imgBtn32 = (Button) findViewById(R.id.imgBtn31);
		imgBtn32.setTag(32);
		imgBtn32.setOnDragListener(new MyDragListener());
		imgBtn42 = (Button) findViewById(R.id.imgBtn41);
		imgBtn42.setTag(42);
		imgBtn42.setOnDragListener(new MyDragListener());
		imgBtn03 = (Button) findViewById(R.id.imgBtn02);
		imgBtn03.setTag(03);
		imgBtn03.setOnDragListener(new MyDragListener());
		imgBtn13 = (Button) findViewById(R.id.imgBtn12);
		imgBtn13.setTag(13);
		imgBtn13.setOnDragListener(new MyDragListener());
		imgBtn23 = (Button) findViewById(R.id.imgBtn23);
		imgBtn23.setTag(23);
		imgBtn23.setOnDragListener(new MyDragListener());
		imgBtn33 = (Button) findViewById(R.id.imgBtn32);
		imgBtn33.setTag(33);
		imgBtn33.setOnDragListener(new MyDragListener());
		imgBtn43 = (Button) findViewById(R.id.imgBtn42);
		imgBtn43.setTag(43);
		imgBtn43.setOnDragListener(new MyDragListener());
		
		btnDone = (Button) findViewById(R.id.btnDone);
				        
        cardDAO = new CardDAO(getApplicationContext());
        porteros = cardDAO.selectCardsByRol(Constantes.PORTERO);               		
        defensas = cardDAO.selectCardsByRol(Constantes.DEFENSA);
		medios = cardDAO.selectCardsByRol(Constantes.CENTROCAMPISTA);
		delanteros = cardDAO.selectCardsByRol(Constantes.DELANTERO);
		seleccionadas = new ArrayList<Card>();
		
		//viewpagers
		ViewPager pagerPOR = (ViewPager) findViewById(R.id.viewPagerPOR);
        pagerPOR.setAdapter(new MyPageAdapter(getSupportFragmentManager(), porteros));
		pagerPOR.setOnTouchListener(new MyTouchListener());
		pagerPOR.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			}
			@Override
			public void onPageSelected(int position) {
				currentPage = position;
			}
			@Override
			public void onPageScrollStateChanged(int state) {
			}
			public final int getCurrentPage() {
				return currentPage;
			}
		});
		ViewPager pagerDEF = (ViewPager) findViewById(R.id.viewPagerDEF);
        pagerDEF.setAdapter(new MyPageAdapter(getSupportFragmentManager(), defensas));
		pagerDEF.setOnTouchListener(new MyTouchListener());
		ViewPager pagerMED = (ViewPager) findViewById(R.id.viewPagerMED);
        pagerMED.setAdapter(new MyPageAdapter(getSupportFragmentManager(), medios));
		pagerMED.setOnTouchListener(new MyTouchListener());
		ViewPager pagerDEL = (ViewPager) findViewById(R.id.viewPagerDEL);
        pagerDEL.setAdapter(new MyPageAdapter(getSupportFragmentManager(), delanteros));
		pagerDEL.setOnTouchListener(new MyTouchListener());
    }		
	
	// actualiza cartas para el jugador x
    public void onDoneClicked(View view) {
		//validar que sean 11 cartas
		if(seleccionadas.size() != 11)
			Toast.makeText(this,"Debe seleccionar 11 futbolistas", Toast.LENGTH_SHORT).show();
		else{
			//minimo 3 def, 3 med, 1 del
			int por = 0;int def=0; int med=0; int del=0;
			for(Card tempCard : seleccionadas){
				String pos = tempCard.getDemarcacion();
				switch (pos){
					case Constantes.PORTERO:
						por++;
						break;
					case Constantes.DEFENSA:
						def++;
						break;
					case Constantes.CENTROCAMPISTA:
						med++;
						break;
					case Constantes.DELANTERO:
						del++;
						break;
					default:
						break;
				}
			}
			if(por != 1)
				Toast.makeText(this,"Alineación incorrecta: debes jugar con un portero", Toast.LENGTH_SHORT).show();
			else if(def < 3 || def > 5)
				Toast.makeText(this,"Alineación incorrecta: de 3 a 5 defensas", Toast.LENGTH_SHORT).show();
			else if(med < 3 || med > 5)
				Toast.makeText(this,"Alineación incorrecta: de 3 a 5 centrocampistas", Toast.LENGTH_SHORT).show();
			else if(del < 1 || del > 3)
				Toast.makeText(this,"Alineación incorrecta: de 1 a 3 delanteros", Toast.LENGTH_SHORT).show();
			//almacenar nick para cada carta
			else{
				//String nick =
				Card[] arraySeleccionadas = (Card[])seleccionadas.toArray();
				boolean done = cardDAO.updateCardsByPlayer(getIntent().getExtras().getString("nick"),arraySeleccionadas);
				if(done) {
					Intent in = new Intent(SelectPlayersActivity.this, MainActivity.class);
					startActivity(in);
					setResult(RESULT_OK);
					finish();
				}
				else{
					Toast.makeText(this,"No se ha actualizado la alineación, error no controlado", Toast.LENGTH_SHORT).show();
					Intent in = new Intent(SelectPlayersActivity.this, MainActivity.class);
					startActivity(in);
					setResult(RESULT_CANCELED);
					finish();
				}

			}
		}
    }
	
	  /**
    * Custom Page adapter
    */
    private class MyPageAdapter extends FragmentPagerAdapter
    {
		Card[] cards;

		public MyPageAdapter(FragmentManager fm, Card[] cards)
		{
			super(fm);
			this.cards = cards;
		}

        @Override
        public int getCount()
        {
            return cards.length;
        }
        @Override
        public CardFragment getItem(int position)
        {
			String name = cards[position].getNombre();
			return CardFragment.newInstance(name);					          
        }

		public Card getCard(int position)
		{
			return cards[position];
		}
     }
	 
	 private final class MyTouchListener implements OnTouchListener {
		public boolean onTouch(View view, MotionEvent motionEvent) {
		  if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
			ClipData data = ClipData.newPlainText("", "");
			DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
			view.startDrag(data, shadowBuilder, view, 0);
			view.setVisibility(View.INVISIBLE);
			return true;
		  } else {
			return false;
		  }
		}
	  }

	  class MyDragListener implements OnDragListener {
		//Drawable enterShape = getResources().getDrawable(R.drawable.shape_droptarget);
		//Drawable normalShape = getResources().getDrawable(R.drawable.shape);
		//Drawable cardShape = getResources().getDrawable(R.drawable.card);

		@Override
		public boolean onDrag(View v, DragEvent event) {
		  int action = event.getAction();
		  switch (event.getAction()) {
		  case DragEvent.ACTION_DRAG_STARTED:
			// do nothing
			break;
		  case DragEvent.ACTION_DRAG_ENTERED:
			//v.setBackgroundDrawable(enterShape);
			//v.setBackgroundDrawable(cardShape);
			break;
		  case DragEvent.ACTION_DRAG_EXITED:
			//v.setBackgroundDrawable(normalShape);
			break;
		  case DragEvent.ACTION_DROP:
			// Dropped, reassign View to ViewGroup
			//View view = (View) event.getLocalState();
			//ViewGroup owner = (ViewGroup) view.getParent();
			//owner.removeView(view);
			//LinearLayout container = (LinearLayout) v;
			//container.addView(view);
			//view.setVisibility(View.VISIBLE);
			  ViewPager view = (ViewPager) event.getLocalState();
			  MyPageAdapter 	myPageAdapter = (MyPageAdapter)view.getAdapter();
			  Button button = (Button) v;
			  CardFragment item = myPageAdapter.getItem(currentPage);
			  Card seleccionada = myPageAdapter.getCard(currentPage);
			  seleccionada.setPosicionActual((Integer)v.getTag());
			  seleccionadas.add(seleccionada);
			  button.setText(item.getArguments().getString("name"));
			break;
		  case DragEvent.ACTION_DRAG_ENDED:
			//v.setBackgroundDrawable(normalShape);
		  default:
			break;
		  }
		  return true;
		}
	  }
}
