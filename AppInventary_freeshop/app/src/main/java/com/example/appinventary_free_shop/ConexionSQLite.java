package com.example.appinventary_free_shop;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ConexionSQLite extends SQLiteOpenHelper {

    public ConexionSQLite(Context context) {
        super(context, "bd_inventario", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_producto(id_producto interger(9) not null primary key, nom_producto text(50) not null,des_producto text(90) not null,stock decimal(3,2) not null,precio decimal(3,2),unidad_de_medida text(20) not null, estado_producto interger(1),categoria interger(5)not null,fecha_entrada datetime not null)");

        db.execSQL("create table tb_categoria(id_categoria interger(5)not null primary key,nom_categoria text(50)not null,estado_categoria interger(1)not null)");

        db.execSQL("create table tb_usuario(id_usuario interger(11)not null primary key,nombre text(60)not null,apellido text(30)not null,correo text(45)not null,usuario text(30)not null,clave text(150)not null,tipo interger(1)not null,estado interger(1)not null,pregunta text(60),respuesta text(35)not null,fecha_registro timestamp)");


        db.execSQL("insert into tb_categoria values('1','Cat1','2')");


    }




    public SQLiteDatabase bd() {
        SQLiteDatabase bd = this.getWritableDatabase();
        return bd;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists tb_producto");
        db.execSQL("drop table if exists tb_categoria");
        db.execSQL("drop table if exists tb_usuario ");
        //En caso que hubiese más tablas hay que repetir las veces que sea necesario.
        //La línea: db.execSQL(“drop…”);
        onCreate(db);

    }


    public boolean InsertTradicional(Dto datos) {

        boolean estad = true;
        int resultado;
        //SQLiteDatabase bd = this.getWritableDatabase();
        try {





            int id_usuario = datos.getId_usuario();
            String nombre = datos.getNombre();
            String apellido = datos.getApellido();
            String correo = datos.getCorreo();
            String usuario = datos.getUsuario();
            String clave = datos.getClave();
            int tipo = datos.getTipo();
            int estado = datos.getEstado();
            String pregunta = datos.getPregunta();
            String respuesta = datos.getRespuesta();



            //Cursor fila = this.getWritableDatabase().rawQuery("select codigo from articulos
            Cursor fila = bd().rawQuery("select nombre from tb_usuario where nombre='" + nombre + "'", null);
            if (fila.moveToFirst() == true) {
                estad = false;
            } else {
                String SQL = "INSERT INTO tb_usuario\n" +
                        "(id_usuario,)\n" +
                        "VALUES \n" +
                        "('" + String.valueOf(id_usuario) + "', '" + nombre + "', '" + apellido + "', '" + correo+ "', '" + usuario + "', '" + clave + "','" + String.valueOf(tipo) + "','" + String.valueOf(estado) + "','" + pregunta + "','" +respuesta + "');";
                bd().execSQL(SQL);
                bd().close();
 /*
 this.getWritableDatabase().execSQL(SQL);
 this.getWritableDatabase().close();
 */
                estad = true;
            }
        } catch (Exception e) {
            estad = false;
            Log.e("error.", e.toString());
        }
        return estad;
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    //getting the current time for joining date
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String fecha1 = sdf.format(cal.getTime());
}