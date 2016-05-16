package gssports.ultimatecardsfootball.activity.option;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

import gssports.ultimatecardsfootball.R;
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

	private int currentPage;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team);		
		
		imgBtn20 = (Button) findViewById(R.id.imgBtn20);
		imgBtn20.setOnDragListener(new MyDragListener());
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
