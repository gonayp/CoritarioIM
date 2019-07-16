package inis.coritario;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gonay.pico on 08/09/2015.
 * **/
 public class DatosSQLiteHelper extends SQLiteOpenHelper {

 // All Static variables
 // Database Version
 private static final int DATABASE_VERSION = 1;

 // Database Name
 private static final String DATABASE_NAME = "DBcoros";

 // Contacts table name
 private static final String TABLE_Name = "Coros";

 // Coros Table Columns names
 private static final String KEY_ID = "codigo";
 private static final String KEY_NAME = "nombre";
 private static final String KEY_DESRIPTION = "descripcion";
 private static final String KEY_SRC = "src";
 private static int NumCoros=111;


    // Temas table name
    private static final String TABLE1_Name = "temas";
    private static final String KEY_ID1 = "codigo";
    private static final String KEY_VALUE = "valor";


    // Acordes/Notas table name
    private static final String TABLE2_Name = "acordes";
    private static final String KEY_ID2 = "codigo";
    private static final String KEY_ACORDE = "acorde";

 public DatosSQLiteHelper(Context context) {
 super(context, DATABASE_NAME, null, DATABASE_VERSION);
 }


 // Creating Tables
 @Override
 public void onCreate(SQLiteDatabase db) {

     /*TABLE DE COROS*/
 String CREATE_ENTRADAS_TABLE = "CREATE TABLE " + TABLE_Name + "("
 + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
 + KEY_DESRIPTION + " TEXT," + KEY_SRC + " TEXT )";


 db.execSQL(CREATE_ENTRADAS_TABLE);

     /*TABLA DE TEMA*/
     String CREATE_THEME_TABLE = "CREATE TABLE " + TABLE1_Name + "("
             + KEY_ID1 + " INTEGER PRIMARY KEY,"
             + KEY_VALUE + " INTEGER )";

     db.execSQL(CREATE_THEME_TABLE);

     db.execSQL("INSERT INTO " + TABLE1_Name + " ("+KEY_VALUE+" ) " +
             "VALUES (3)");
/*TABLA DE ACORDES*/
     String CREATE_NOTES_TABLE = "CREATE TABLE " + TABLE2_Name + "("
             + KEY_ID2 + " INTEGER PRIMARY KEY,"
             + KEY_ACORDE + " INTEGER )";

     db.execSQL(CREATE_NOTES_TABLE);

     db.execSQL("INSERT INTO " + TABLE2_Name + " ("+KEY_ACORDE+" ) " +
             "VALUES (1)");


 CargarCoros(db);

 }

    private void CargarCoros(SQLiteDatabase db) {
        List<String> coros = new ArrayList<String>();
        CargarVariables(coros);
        for (int i=0; i< NumCoros; i++) {
            db.execSQL("INSERT INTO " + TABLE_Name + " ( "+KEY_NAME+" ) " +
                    "VALUES ('" + coros.get(i) + "')");
        }

    }



    // Upgrading database
 @Override
 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 // Drop older table if existed
 db.execSQL("DROP TABLE IF EXISTS " + TABLE_Name);
     db.execSQL("DROP TABLE IF EXISTS " + TABLE1_Name);

 // Create tables again
 onCreate(db);
 }

    private void CargarVariables(List<String> c) {

        c.add("Abre mis ojos, Señor");
        c.add("Agnus dei");
        c.add("Alabaré ");
        c.add("Al encuentro de Jesús");
        c.add("Alma misionera");
        c.add("Alto, escúchame");
        c.add("Alzaré mis ojos");
        c.add("Amor, amor");
        c.add( "Arco Iris");
        c.add("Atardece ");
        c.add("Avancemos ");
        c.add("Blanqueados ");
        c.add( "Brilla Jesús");
        c.add("Brillar por ti");
        c.add("Buscad primero");
        c.add( "Cada día de mañana");
        c.add("Cantad a Dios");
        c.add("Cantaré de tu amor");
        c.add( "Canto de alegría");
        c.add( "Cerca de Jesús");
        c.add("Como el ciervo");
        c.add( "Como no cantar");
        c.add("Cristo Joven");
        c.add("Cuán grande eres Dios");
        c.add("Cuando Cristo vino a mi corazón");
        c.add("Cuando el pueblo de Dios ora");
        c.add( "Cuando miro los claros cielos");
        c.add( "Da una sonrisa");
        c.add( "Dad gloria al Señor");
        c.add( "Dad gracias");
        c.add("Dame un nuevo corazón");
        c.add("Descansar");
        c.add("Después del río");
        c.add("Digno eres");
        c.add("Dios alzamos hoy tu nombre");
        c.add("Dios bueno es");
        c.add("Dios del cielo");
        c.add("Dios está aquí");
        c.add("Dios es nuestro amparo y fortaleza");
        c.add("Dios, que tu luz");
        c.add("El corazón de la adoración");
        c.add("El mejor lugar del mundo");
        c.add("Enciende una luz");
        c.add("Eres mi respirar");
        c.add("Eres mi todo");
        c.add("Eres tú");
        c.add("Es exaltado");
        c.add("És o meu refúgio");
        c.add("Espíritu Santo");
        c.add("Este es mi deseo");
        c.add("Estoy en paz");
        c.add("Fiel en toda prueba");
        c.add("Fija tus ojos");
        c.add("Grande es Jehová");
        c.add("Hablar con Dios");
        c.add("He decidido seguir a Cristo");
        c.add("Hosanna");
        c.add("Hoy aquí");
        c.add("Jesús mi guía es");
        c.add("Jesús te ama");
        c.add("La alegría");
        c.add("La naturaleza");
        c.add("La mañana gloriosa");
        c.add("La sangre de Cristo Jesús");
        c.add("Lado a lado");
        c.add("Majestuoso Dios");
        c.add("Maravilloso Dios");
        c.add("Mensajero");
        c.add("Mi Cristo me salva");
        c.add("Mi Dios, supremo rey");
        c.add("Mi Todo");
        c.add("Mirad cuál amor");
        c.add("Necesario");
        c.add("No me importa de dónde tú vengas");
        c.add("No me olvidé de ti");
        c.add("Nunca estéis desanimado");
        c.add("Oba oba");
        c.add("Oh, amor de Dios");
        c.add("Padre de amor");
        //c.add("Padre, tu palabra es mi luz");
        c.add("Padre, yo te adoro");
        c.add("Paso a paso");
        c.add("Paz en la tormenta");
        c.add("Permanece en mi");
        c.add("Pescador");
        c.add("Por encima de todo");
        c.add("Por tu gracia y amor");
        c.add("Príncipe de paz");
        c.add("Promesa");
        //c.add("Qué alegría encontrarás");
        c.add("Queremos ver a Cristo regresar");
        c.add("Quiero cantar una linda canción");
        c.add("Rendid a Yahvé");
        c.add("Renuévame");
        c.add("Salmos 1");
        c.add("Santo es el Señor");
        c.add("Santo Espíritu");
        c.add("Sentado estaba en mi barca");
        c.add("Señor, aviva tu obra en mí");
        c.add("Si comenzamos a orar");
        c.add("Todopoderoso");
        c.add("Tu amor por mí");
        //c.add("Tomados de la mano");
        c.add("Tú eres Dios");
        c.add("Tu poder");
        c.add("Tuyo soy");
        c.add("Vamos adorar al Señor");
        c.add("Vaso de honra");
        c.add("Ven a la cruz");
        c.add("Ven, es tiempo de adorarle");
        c.add("Vengo a adorarte");
        c.add("Voy caminando");
        c.add("Yo tengo esperanza");
        c.add("Yo voy");


    }
}