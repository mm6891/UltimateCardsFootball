package gssports.ultimatecardsfootball.stadium;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import gssports.ultimatecardsfootball.R;

/**
 * Created by manuel.molero on 08/09/2015.
 */
public class StadiumActivity extends Activity {

    //botonera terreno de juego
    private Button btn00;

    private GridLayout gvStadium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stadium);

        //casilla 00
        btn00 = (Button) findViewById(R.id.imgBtn00);
        btn00.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

         /*   //tamanyo de gridlayout segun pantalla en pixeles
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            int height = size.y;
            //margen establecido en main.xml como dp
            int margen = 10;
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int px = Math.round(margen * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
            gv = (GridLayout) findViewById(R.id.glMenu);
            int anchoBoton = (width/2)  - (px*3);

            final float scale = getApplicationContext().getResources().getDisplayMetrics().density;

            for (int i = 0; i < gv.getChildCount(); i++)
            {
                //anchura
                Button row = (Button)gv.getChildAt(i);
                row.setWidth(anchoBoton);
            }*/

    }

    private void loadPlayers(){

    }

        /*@Override
        public void onBackPressed() {
            new AlertDialog.Builder(this)
                    .setTitle(getResources().getString(R.string.Salir))
                    .setMessage(getResources().getString(R.string.Abandonar))
                    .setNegativeButton(getResources().getString(R.string.NEGACION), null)
                    .setPositiveButton(getResources().getString(R.string.AFIRMACION), new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface arg0, int arg1) {
                            Intent intent = new Intent(MainActivity.this, Password.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.putExtra("EXIT", true);
                            startActivity(intent);
                        }
                    }).create().show();
        }*/
}
