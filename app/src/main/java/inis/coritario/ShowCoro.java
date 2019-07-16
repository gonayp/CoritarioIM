package inis.coritario;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class ShowCoro extends Activity implements View.OnTouchListener{

    private ViewStub Contenedor;
    private TextView tvTitulo;
    private DatosSQLiteHelper usdbh;
    private ImageButton footer;
    private int Coro;
    private int Foto;
    private int X,Y,Xi,Yi;//valores de posicion de pulsacion de la pantalla (inicial y final)
    //private static int NumCoros=70;
    private static int NUMCORO;
    private ImageButton btnRight;
    private ImageButton btnLeft;
    private ImageButton btnHome;
    private ImageView coroAcorde;
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

    public final static int THEME_IM = 3;
    public final static int THEME_WHITE  = 2;
    public final static int THEME_BLACK  = 1;

    int position;
    int acorde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        position = getIntent().getIntExtra("THEME",3 );
        acorde = getIntent().getIntExtra("ACORDES",0);
        if (acorde == 0) {
            switch (position) {
                case THEME_BLACK:
                    setTheme(R.style.BLACK);
                    break;
                case THEME_WHITE:
                    setTheme(R.style.WHITE);
                    break;
                case THEME_IM:
                    setTheme(R.style.IM);
                    break;
                default:
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coro);

        tvTitulo = (TextView) findViewById(R.id.titulo);
        footer = (ImageButton) findViewById(R.id.imageButton4);
        Contenedor = (ViewStub)findViewById(R.id.contenedor);
        btnRight = (ImageButton) findViewById(R.id.btnRight);
        btnLeft = (ImageButton) findViewById(R.id.btnLeft);
        btnHome = (ImageButton) findViewById(R.id.btnHome);
        coroAcorde = (ImageView) findViewById(R.id.imageContent);

        usdbh = new DatosSQLiteHelper(this);

        //valores de posicion de pulsacion de la pantalla (inicial y final)
        X= 0;Xi=0;
        Y=0;Yi=0;

        InicializarMenu();

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        boolean aux = true;
        SQLiteDatabase db = usdbh.getWritableDatabase();

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            String rango = "SELECT * FROM acordes  WHERE codigo = 1";
            Cursor c = db.rawQuery(rango, null);
            if (c.moveToFirst()) {
                if (c.getInt(1)== 0) aux=false;
            }

        }

        NUMCORO = bundle.getInt("CORO");
        if(!aux) Coro = Auxiliar.CargarCoros(NUMCORO,aux);
        else  Coro = Auxiliar.CargarCoroAcordes(NUMCORO);
        Foto = Auxiliar.CargarFotos(NUMCORO);



        if (bundle != null) {
            if (!aux) CargarCoroXML(NUMCORO);
            else CargarCoroIMG(NUMCORO);
            MostrarTitulo(NUMCORO);

        }




        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (NUMCORO < 111) CargarNuevCoro(NUMCORO+1);
            }
        });

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NUMCORO > 1) CargarNuevCoro(NUMCORO-1);
            }
        });

        //Implementamos el evento “click” del botón
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                //Creamos el Intent
                intent = new Intent(ShowCoro.this, MainActivity.class);

                Bundle b = new Bundle();
                b.putInt("Busqueda", 1);
                intent.putExtras(b);
                //try{ Thread.sleep(1000); }catch(InterruptedException e){ }
                //Iniciamos la nueva actividad
                startActivity(intent);
                //SystemClock.sleep(1000);

            }
        });

        //Implementamos el evento “click” del botón
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                btnFind.setImageResource(R.drawable.botonbuscar1);
                //Creamos el Intent
                intent = new Intent(ShowCoro.this, MainActivity.class);

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
                intent = new Intent(ShowCoro.this, Listado.class);

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
                intent = new Intent(ShowCoro.this, Configuracion.class);

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
                intent = new Intent(ShowCoro.this, Acercade.class);

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

    private void CargarCoroIMG(int numcoro) {

        coroAcorde.setImageResource(Coro);
        footer.setImageResource(Foto);

    }

    private void CargarNuevCoro(int numcoro) {
        Intent intent;
        //Creamos el Intent
        intent = new Intent(ShowCoro.this, ShowCoro.class);

        Bundle b = new Bundle();
        b.putInt("CORO",numcoro);
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


    //Al tocar la pantalla...
    public boolean onTouch(View view, MotionEvent event) {
        //Recogemos las coordenadas del dedo

        //Dependiendo de la accion recogida..
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            //Al tocar la pantalla
            case MotionEvent.ACTION_DOWN:

                Xi = (int) event.getRawX();
                Yi = (int) event.getRawY();

                break;
            case MotionEvent.ACTION_UP:
                //Al levantar el dedo simplemento mostramos un mensaje
                //Toast.makeText(this, "Soltamos", Toast.LENGTH_LONG).show();
                if ((view.getId() == R.id.scrollView) && extendida) {
                    TransformarPantalla();
                }
                else {
                    if ((view.getId() == R.id.scrollView) && !extendida) {

                        int diferenciaX = Math.abs(Xi - X);
                        int diferenciaY = Math.abs(Yi - Y);

                        if ((diferenciaX > diferenciaY) && (diferenciaX > 200)) {
                            if ((Xi > X) && (NUMCORO < 111)) CargarNuevCoro(NUMCORO + 1);
                            if ((Xi < X) && (NUMCORO > 1)) CargarNuevCoro(NUMCORO - 1);
                        }
                    }
                }

                if (view.getId() == R.id.btnExtend)TransformarPantalla();
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                //No hace falta utilizarlo
                break;
            case MotionEvent.ACTION_POINTER_UP:
                //No hace falta utilizarlo
                break;
            case MotionEvent.ACTION_MOVE:

                X = (int) event.getRawX();
                Y = (int) event.getRawY();

                break;
        }
        //Se podría decir que 'dibujamos'
        //la posición de la imagen en el marco.
        // marco.invalidate();
        return false;
    }

    private void TransformarPantalla() {

        LinearLayout.LayoutParams  lp = new LinearLayout.LayoutParams (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        if (!extendida) {
            lp.weight = 2;
            extendida = true;
            contenido.setVisibility(View.GONE);
            btnMenu.setVisibility(View.GONE);
        }
        else{
            lp.weight = 0;
            extendida = false;
            contenido.setVisibility(View.VISIBLE);
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
        lCuerpo = (LinearLayout) findViewById(R.id.Cuerpo);
        lCuerpo.setOnTouchListener(this);
        scroll = (ScrollView) findViewById(R.id.scrollView);
        scroll.setOnTouchListener(this);
        btnSetings = (ImageButton) findViewById(R.id.btnStings);
        btnAcerca = (ImageButton) findViewById(R.id.btnAcerca);
        btnIM = (ImageButton) findViewById(R.id.btnIM);
        btnMenu = (ImageButton) findViewById(R.id.btnMenu);
        contenido = (LinearLayout) findViewById(R.id.contenido);
    }

    /******************************************************************************************************/



    private void MostrarTitulo(int coro) {


        SQLiteDatabase db = usdbh.getWritableDatabase();
        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            String rango = "SELECT * FROM Coros  WHERE codigo = '" + coro + "'";
            Cursor c = db.rawQuery(rango, null);
            if (c.moveToFirst()) {
                tvTitulo.setText(c.getInt(0)+". "+c.getString(1));

            }

        }

    }

    private void CargarCoroXML(int coro) {


        Contenedor.setLayoutResource(Coro);
        Contenedor.inflate();
        footer.setImageResource(Foto);

    }








}
