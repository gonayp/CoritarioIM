package inis.coritario;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends Activity implements View.OnTouchListener {


    private ImageButton btnBuscar;
    private LinearLayout Listado;
    private LinearLayout ListadoCompleto;
    private EditText etBuscador;
    private DatosSQLiteHelper usdbh;
    private List<Button> botonesCoros;
    private ImageButton btnIngresar;
    private ImageButton btnMainTitle;
    //MENU
    private LinearLayout lCuerpo;
    private boolean extendida = false;
    private ImageButton btnExtend;
    private LinearLayout ventanaPrincipal;
    private ImageButton btnFind;
    private ImageButton btnList;
    private ScrollView scroll;
    private ImageButton btnSetings;
    private ImageButton btnAcerca;
    private ImageButton btnIM;
    private ImageButton btnMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonesCoros = new ArrayList<Button>();
        usdbh = new DatosSQLiteHelper(this);
        Bundle bundle = this.getIntent().getExtras();
        if (bundle == null)Inicializar(0);
        else Inicializar(1);



        etBuscador.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                etBuscador.setInputType(InputType.TYPE_CLASS_TEXT);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                //final Toast toast = Toast.makeText(getBaseContext(), "caracteres: "+s,Toast.LENGTH_SHORT);
                //toast.show();

            }

            @Override
            public void afterTextChanged(Editable s) {


                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                Listado.removeAllViews();
                DespejarListado();
                if (s.length() != 0) {
                    SQLiteDatabase db = usdbh.getWritableDatabase();
                    //Si hemos abierto correctamente la base de datos
                    if (db != null) {
                        String rango = "SELECT * FROM Coros  WHERE nombre LIKE '%" + s + "%' OR codigo LIKE '"+s+"%'";
                        Cursor c = db.rawQuery(rango, null);

                        CrearBotonCoro(c, true, false);

                        //lp.weight = 2;
                        btnMainTitle.setVisibility(View.GONE);
                        lCuerpo.setLayoutParams(lp);

                    }
                }
                else{
                    lp.weight = 0;
                    lCuerpo.setLayoutParams(lp);
                }
            }


        });





    btnIngresar.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {



                                           Intent intent;
                                           intent = new Intent(MainActivity.this, MainActivity.class);
                                           Bundle b = new Bundle();
                                           b.putInt("Busqueda", 1);
                                           intent.putExtras(b);
                                           startActivity(intent);


                                       }
                                   });


        //Implementamos el evento “click” del botón
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                btnFind.setImageResource(R.drawable.botonbuscar1);
                //Creamos el Intent
                intent = new Intent(MainActivity.this, MainActivity.class);

                Bundle b = new Bundle();
                b.putInt("Busqueda", 1);
                intent.putExtras(b);
                //try{ Thread.sleep(1000); }catch(InterruptedException e){ }
                //Iniciamos la nueva actividad
                startActivity(intent);
                //SystemClock.sleep(1000);

            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                //Creamos el Intent
                intent = new Intent(MainActivity.this, MainActivity.class);

                Bundle b = new Bundle();
                b.putInt("Busqueda", 1);
                intent.putExtras(b);
                //Iniciamos la nueva actividad
                startActivity(intent);

            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                btnList.setImageResource(R.drawable.botonlistado1);
                //Creamos el Intent
                intent = new Intent(MainActivity.this, Listado.class);

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
                intent = new Intent(MainActivity.this, Configuracion.class);

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
                intent = new Intent(MainActivity.this, Acercade.class);

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

        btnIM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
                btnIM.setImageResource(R.drawable.botonim1);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://institutomisionero.com/"));
                startActivity(browserIntent);
            }
        });



    }

    private void TransformarPantalla() {

        LinearLayout.LayoutParams  lp = new LinearLayout.LayoutParams (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        if (!extendida) {
            lp.weight = 2;
            //btnExtend.setImageResource(R.drawable.flecha);
            //btnExtend.setBackgroundColor( Color.parseColor("#ffe9eaeb"));
            extendida = true;
            scroll.setVisibility(View.GONE);
            btnMenu.setVisibility(View.GONE);
            //ListadoCompleto.removeAllViews();

            //ActualizarListado();

        }
        else{
            lp.weight = 0;
            //btnExtend.setImageResource(R.drawable.flechab);
            extendida = false;
            scroll.setVisibility(View.VISIBLE);
            btnMenu.setVisibility(View.VISIBLE);
            DespejarListado();
            //btnExtend.setBackgroundColor( Color.parseColor("#b4b5b6"));
        }
        ventanaPrincipal.setLayoutParams(lp);

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
                if ((view.getId() == R.id.Cuerpo) && extendida) {
                    TransformarPantalla();
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

                break;
        }
        //Se podría decir que 'dibujamos'
        //la posición de la imagen en el marco.
       // marco.invalidate();
        return true;
    }


    private void ActualizarListado() {

        LinearLayout.LayoutParams  lp = new LinearLayout.LayoutParams (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.weight = 1;
        //progress.setLayoutParams(lp);
        ListadoCompleto.setLayoutParams(lp);



    }

    private void DespejarListado() {

        botonesCoros.clear();

    }


    private void CrearBotonCoro(Cursor c,boolean cuerpo, boolean listado) {
        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //BotonExtra(cuerpo,listado);
            //Recorremos el cursor hasta que no haya más registros
            do {

                Coro e = new Coro(c.getString(1));
                e.setID(c.getInt(0));

                final Button btn = new Button(this);
                btn.setId(e.getID());
                btn.setText(e.getID()+". "+e.getNombre());
                CaracteristicasBoton(btn);
                if (listado)ListadoCompleto.addView(btn);
                if (cuerpo) Listado.addView(btn);
                //Implementamos el evento “click” del botón
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent;
                        //Creamos el Intent
                        intent = new Intent(MainActivity.this, ShowCoro.class);

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
        btn.setPadding(10, 10, 10, 10);
        btn.setTextColor(Color.parseColor("#FFFFFFFF"));
        btn.setTextSize(24);
        btn.setBackgroundColor(Color.TRANSPARENT);
        btn.setGravity(Gravity.CENTER);
        botonesCoros.add(btn);

    }

    private void BotonExtra(boolean cuerpo, boolean listado) {

        final Button btn = new Button(this);
        CaracteristicasBoton(btn);
        if (listado)ListadoCompleto.addView(btn);
        if (cuerpo) Listado.addView(btn);

    }

    private void Inicializar(int buscar) {

        Listado = (LinearLayout) findViewById(R.id.Listado);
        //ListadoCompleto = (LinearLayout) findViewById(R.id.ListadoCompleto);
        etBuscador = (EditText) findViewById(R.id.buscador);
        btnIngresar = (ImageButton) findViewById(R.id.btnIngresar);
        btnBuscar = (ImageButton) findViewById(R.id.btnfind);
        btnMainTitle = (ImageButton) findViewById(R.id.MainTitle);
        if (buscar == 0) {
            etBuscador.setInputType(InputType.TYPE_NULL);
            btnBuscar.setVisibility(View.INVISIBLE);
            etBuscador.setVisibility(View.INVISIBLE);
            btnIngresar.setVisibility(View.VISIBLE);
            btnMainTitle.setVisibility(View.VISIBLE);
        }
        else{
            btnBuscar.setVisibility(View.VISIBLE);
            etBuscador.setVisibility(View.VISIBLE);
            btnIngresar.setVisibility(View.GONE);

            etBuscador.setInputType(InputType.TYPE_CLASS_TEXT);

        }
        lCuerpo = (LinearLayout) findViewById(R.id.Cuerpo);
        lCuerpo.setOnTouchListener(this);


        InicializarMenu();


    }

    private void InicializarMenu() {
        btnExtend = (ImageButton) findViewById(R.id.btnExtend);
        btnMenu = (ImageButton) findViewById(R.id.btnMenu);
        btnExtend.setOnTouchListener(this);
        ventanaPrincipal = (LinearLayout) findViewById(R.id.ventanaPrincipal);
        btnFind = (ImageButton) findViewById(R.id.btnBuscar);
        btnList = (ImageButton) findViewById(R.id.btnList);
        scroll = (ScrollView) findViewById(R.id.scrollView);
        btnSetings = (ImageButton) findViewById(R.id.btnStings);
        btnAcerca = (ImageButton) findViewById(R.id.btnAcerca);
        btnIM = (ImageButton) findViewById(R.id.btnIM);

    }


}

