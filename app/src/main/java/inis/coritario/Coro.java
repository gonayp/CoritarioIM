package inis.coritario;

import java.io.InputStream;
import java.util.Calendar;

/**
 * Created by gonay.pico on 07/09/2015.
 */
public class Coro {

    private String nombre;
    private String descripcion;
    private String srcpic;
    private int id;
    private InputStream fraw;


    public Coro (){
        nombre = "";
        descripcion  = "";
        srcpic  = "";
        id = -1;
        fraw = null;
    }

    public Coro ( String name ){
        nombre = name;
        id = -1;
        fraw = null;
    }

    public Coro ( String name, String description, String src ){
        nombre = name;
        descripcion  = description;
        srcpic  = src;
        id = -1;
        fraw = null;
    }

    public int getID(){

        return id;
    }

    public String getNombre(){

        return nombre;
    }

    public String getDescripcion(){

        return descripcion;
    }


    public String getPicture(){

        return srcpic;
    }

    public InputStream getRaw(){

        return fraw;
    }

    /*SET*/

    public void setID(int t){

        id = t;

    }

    public void setNombre(String t){

        nombre = t;

    }

    public void setDescripcion(String t){

        descripcion = t;

    }


    public void setPicture(String c){

        srcpic = c;

    }

    public void setRaw(InputStream c){

        fraw = c;

    }


}
