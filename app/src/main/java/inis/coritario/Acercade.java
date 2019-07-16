package inis.coritario;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;


public class Acercade extends Activity implements View.OnTouchListener{

    //MENU
    private boolean extendida = false;
    private ImageButton btnExtend;
    private LinearLayout ventanaPrincipal;
    private ImageButton btnFind;
    private ImageButton btnList;
    private LinearLayout lCuerpo;
    private ScrollView scroll;
    private ImageButton btnSetings;
    private ImageButton btnAcerca;
    private ImageButton btnIM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);
        InicializarMenu();



        //Implementamos el evento “click” del botón
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                btnFind.setImageResource(R.drawable.botonbuscar1);
                //Creamos el Intent
                intent = new Intent(Acercade.this, MainActivity.class);
                Bundle b = new Bundle();
                b.putInt("Busqueda", 1);
                intent.putExtras(b);

                //try{ Thread.sleep(1000); }catch(InterruptedException e){ }
                //Iniciamos la nueva actividad
                startActivity(intent);
                //SystemClock.sleep(1000);

            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                btnList.setImageResource(R.drawable.botonlistado1);
                //Creamos el Intent
                intent = new Intent(Acercade.this, Listado.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        btnSetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                btnSetings.setImageResource(R.drawable.botonconfig1);
                //Creamos el Intent
                intent = new Intent(Acercade.this, Configuracion.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        btnIM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                btnIM.setImageResource(R.drawable.botonim1);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://institutomisionero.com/"));
                startActivity(browserIntent);
            }
        });

        btnAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                btnAcerca.setImageResource(R.drawable.botonacerca1);
                //Creamos el Intent
                intent = new Intent(Acercade.this, Acercade.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

    }



    //Al tocar la pantalla...
    public boolean onTouch(View view, MotionEvent event) {
        //Recogemos las coordenadas del dedo
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        //Dependiendo de la accion recogida..
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            //Al tocar la pantalla
            case MotionEvent.ACTION_DOWN:



                break;
            case MotionEvent.ACTION_UP:
                //Al levantar el dedo simplemento mostramos un mensaje
                //Toast.makeText(this, "Soltamos", Toast.LENGTH_LONG).show();
                if ((view.getId() == R.id.ventanaPrincipal) && extendida) {
                    TransformarPantalla();
                }
                if (view.getId() == R.id.btnExtend){
                    TransformarPantalla();
                }

                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                //No hace falta utilizarlo
                break;
            case MotionEvent.ACTION_POINTER_UP:
                //No hace falta utilizarlo
                break;
            case MotionEvent.ACTION_MOVE:

                break;
        }
        //Se podría decir que 'dibujamos'
        //la posición de la imagen en el marco.
        // marco.invalidate();
        return true;
    }



    private void TransformarPantalla() {

        LinearLayout.LayoutParams  lp = new LinearLayout.LayoutParams (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        if (!extendida) {
            lp.weight = 2;
            extendida = true;
            scroll.setVisibility(View.GONE);
            lCuerpo.setVisibility(View.GONE);
        }
        else{
            lp.weight = 0;
            extendida = false;
            scroll.setVisibility(View.VISIBLE);
            lCuerpo.setVisibility(View.VISIBLE);
        }
        ventanaPrincipal.setLayoutParams(lp);

    }


    private void InicializarMenu() {
        btnExtend = (ImageButton) findViewById(R.id.btnExtend);
        btnExtend.setOnTouchListener(this);
        ventanaPrincipal = (LinearLayout) findViewById(R.id.ventanaPrincipal);
        ventanaPrincipal.setOnTouchListener(this);
        btnFind = (ImageButton) findViewById(R.id.btnBuscar);
        btnList = (ImageButton) findViewById(R.id.btnList);
        lCuerpo = (LinearLayout) findViewById(R.id.Body);
        lCuerpo.setOnTouchListener(this);
        scroll = (ScrollView) findViewById(R.id.scrollView);
        btnSetings = (ImageButton) findViewById(R.id.btnStings);
        btnAcerca = (ImageButton) findViewById(R.id.btnAcerca);
        btnIM = (ImageButton) findViewById(R.id.btnIM);
    }


}
