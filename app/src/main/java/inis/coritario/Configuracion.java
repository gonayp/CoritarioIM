package inis.coritario;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;


public class Configuracion extends Activity implements View.OnTouchListener{


    private DatosSQLiteHelper usdbh;
    private RadioGroup radioGroup;
    private RadioButton rbBlack;
    private RadioButton rbWhite;
    private RadioButton rbIM;
    private ImageButton btnAcordes;
    private Boolean acordeActivado;
    private LinearLayout contenido;

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
        setContentView(R.layout.activity_configuracion);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rbBlack = (RadioButton) findViewById(R.id.rbBlack);
        rbWhite = (RadioButton) findViewById(R.id.rbWhite);
        rbIM = (RadioButton) findViewById(R.id.rbIM);
        btnAcordes = (ImageButton) findViewById(R.id.btnAcordes);
        contenido = (LinearLayout) findViewById( R.id.contenido);
        contenido.setOnTouchListener(this);

        usdbh = new DatosSQLiteHelper(this);

        InicializarMenu();

        CargarTema();
        CargarAcordes();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int tema = 1;

                if (rbBlack.isChecked())tema = 1;
                if (rbWhite.isChecked())tema = 2;
                if (rbIM.isChecked())tema = 3;

                SQLiteDatabase db = usdbh.getWritableDatabase();
                if (db != null) {
                    db.execSQL("UPDATE temas SET valor=" + tema +
                            " WHERE codigo= 1");
                    //Cerramos la base de datos

                    db.close();
                }
            }
        });


        btnAcordes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = usdbh.getWritableDatabase();
                if (db != null) {
                    if (acordeActivado) {
                        db.execSQL("UPDATE acordes SET acorde=" + 0 +
                                " WHERE codigo= 1");
                        acordeActivado=false;
                        btnAcordes.setImageResource(R.drawable.ic_acordes);
                    }
                    else{
                        db.execSQL("UPDATE acordes SET acorde=" + 1 +
                                " WHERE codigo= 1");
                        acordeActivado=true;
                        btnAcordes.setImageResource(R.drawable.ic_acordes1);
                    }

                    //Cerramos la base de datos
                    db.close();
                }
            }
        });

        //Implementamos el evento “click” del botón
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                btnFind.setImageResource(R.drawable.botonbuscar1);
                //Creamos el Intent
                intent = new Intent(Configuracion.this, MainActivity.class);
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
                intent = new Intent(Configuracion.this, Listado.class);

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
                intent = new Intent(Configuracion.this, Configuracion.class);

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
                intent = new Intent(Configuracion.this, Acercade.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransformarPantalla();
            }
        });

    }

    private void CargarAcordes() {

        SQLiteDatabase db = usdbh.getWritableDatabase();
        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            String rango = "SELECT * FROM acordes  WHERE codigo = 1";
            Cursor c = db.rawQuery(rango, null);
            if (c.moveToFirst()) {
                if (c.getInt(1) == 0){
                    acordeActivado=false;//rbBlack.setChecked(true);
                    btnAcordes.setImageResource(R.drawable.ic_acordes);
                }
                if (c.getInt(1) == 1){
                    acordeActivado=true;//rbWhite.setChecked(true);
                    btnAcordes.setImageResource(R.drawable.ic_acordes1);
                }

            }
        }

    }

    private void CargarTema() {


                SQLiteDatabase db = usdbh.getWritableDatabase();
                //Si hemos abierto correctamente la base de datos
                if (db != null) {
                    String rango = "SELECT * FROM temas  WHERE codigo = 1";
                    Cursor c = db.rawQuery(rango, null);
                    if (c.moveToFirst()) {
                        if (c.getInt(1) == 1)rbBlack.setChecked(true);
                        if (c.getInt(1) == 2)rbWhite.setChecked(true);
                        if (c.getInt(1) == 3)rbIM.setChecked(true);
                    }
                }

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
                if ((view.getId() == R.id.contenido) && extendida) {
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
            lCuerpo.setVisibility(View.INVISIBLE);
            btnMenu.setVisibility(View.GONE);

        }
        else{
            lp.weight = 0;
            extendida = false;
            lCuerpo.setVisibility(View.VISIBLE);
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

        scroll = (ScrollView) findViewById(R.id.scrollView);
        btnSetings = (ImageButton) findViewById(R.id.btnStings);
        btnAcerca = (ImageButton) findViewById(R.id.btnAcerca);
        btnIM = (ImageButton) findViewById(R.id.btnIM);
        btnMenu = (ImageButton) findViewById(R.id.btnMenu);
    }


}
