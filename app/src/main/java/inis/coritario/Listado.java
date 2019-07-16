package inis.coritario;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;


public class Listado extends Activity implements View.OnTouchListener {


    private DatosSQLiteHelper usdbh;
    private LinearLayout Cuerpo;
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
    private ImageButton btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        usdbh = new DatosSQLiteHelper(this);
        Cuerpo = (LinearLayout) findViewById(R.id.cuerpo);

        InicializarMenu();
        ActualizarListado();


        //Implementamos el evento “click” del botón
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                btnFind.setImageResource(R.drawable.botonbuscar1);
                //Creamos el Intent
                intent = new Intent(Listado.this, MainActivity.class);
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
                intent = new Intent(Listado.this, Listado.class);

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
                intent = new Intent(Listado.this, Configuracion.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        btnAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                btnAcerca.setImageResource(R.drawable.botonacerca1);
                //Creamos el Intent
                intent = new Intent(Listado.this, Acercade.class);

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

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransformarPantalla();
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
                if ((view.getId() == R.id.Body) && extendida) {
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
            btnMenu.setVisibility(View.GONE);
        }
        else{
            lp.weight = 0;
            extendida = false;
            scroll.setVisibility(View.VISIBLE);
            btnMenu.setVisibility(View.VISIBLE);
        }
        ventanaPrincipal.setLayoutParams(lp);

    }


    private void InicializarMenu() {
        btnExtend = (ImageButton) findViewById(R.id.btnExtend);
        btnExtend.setOnTouchListener(this);
        ventanaPrincipal = (LinearLayout) findViewById(R.id.ventanaPrincipal);
        btnFind = (ImageButton) findViewById(R.id.btnBuscar);
        btnList = (ImageButton) findViewById(R.id.btnList);
        lCuerpo = (LinearLayout) findViewById(R.id.Body);
        lCuerpo.setOnTouchListener(this);
        scroll = (ScrollView) findViewById(R.id.scrollView);
        btnSetings = (ImageButton) findViewById(R.id.btnStings);
        btnAcerca = (ImageButton) findViewById(R.id.btnAcerca);
        btnIM = (ImageButton) findViewById(R.id.btnIM);
        btnMenu = (ImageButton) findViewById(R.id.btnMenu);
    }


/**************************************************************************************************************/


    private void ActualizarListado() {

        //usdbh = new DatosSQLiteHelper(this);
        SQLiteDatabase db = usdbh.getWritableDatabase();
        //Si hemos abierto correctamente la base de datos
        if(db != null) {
            String rango = "SELECT * FROM Coros  ";
            Cursor c = db.rawQuery(rango, null);
            CrearBotonCoro(c);

        }

    }


    private void CrearBotonCoro(Cursor c) {
        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            BotonExtra();
            //Recorremos el cursor hasta que no haya más registros
            do {

                Coro e = new Coro(c.getString(1));
                e.setID(c.getInt(0));

                final Button btn = new Button(this);
                btn.setId(e.getID());
                btn.setText(e.getID()+". "+e.getNombre());
                CaracteristicasBoton(btn);
                Cuerpo.addView(btn);

                //Implementamos el evento “click” del botón
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent;
                        //Creamos el Intent
                        intent = new Intent(Listado.this, ShowCoro.class);
                        Bundle b = new Bundle();
                        b.putInt("CORO", btn.getId());
                        SQLiteDatabase db = usdbh.getWritableDatabase();
                        //Si hemos abierto correctamente la base de datos
                        if (db != null) {
                            String rango = "SELECT * FROM temas  WHERE codigo = 1";
                            Cursor c = db.rawQuery(rango, null);
                            if (c.moveToFirst()) {
                                b.putInt("THEME",c.getInt(1));
                            }
                            rango = "SELECT * FROM acordes  WHERE codigo = 1";
                            c = db.rawQuery(rango, null);
                            if (c.moveToFirst()) {
                                    b.putInt("ACORDES",c.getInt(1));
                            }
                        }
                        else{
                            b.putInt("THEME",3);
                            b.putInt("ACORDES",0);
                        }
                        //Añadimos la información al intent
                        intent.putExtras(b);
                        //Iniciamos la nueva actividad
                        startActivity(intent);
                    }
                });

            } while (c.moveToNext());
        }
    }


    private void CaracteristicasBoton(Button btn) {

        btn.setMinimumHeight(75);
        btn.setMinimumWidth(50);
        btn.setGravity(View.TEXT_ALIGNMENT_CENTER);
        btn.setPadding(15, 15, 15, 15);
        btn.setTextSize(22);
        btn.setTextColor(Color.parseColor("#FFFFFFFF"));
        btn.setBackgroundColor(Color.TRANSPARENT);
        btn.setGravity(Gravity.LEFT);
        //botonesCoros.add(btn);

    }

    private void BotonExtra() {

        final Button btn = new Button(this);
        CaracteristicasBoton(btn);
        Cuerpo.addView(btn);

    }



}
