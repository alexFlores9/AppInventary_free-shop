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

        db.execSQL("create table tb_usuario(id_usuario interger(11)not null primary key,nombre text(60)not null,apellido text(30)not null,correo text(45)not null,usuario text(30)not null,clave text(150)not null,tipo interger(1)not null,estado text(1)not null,pregunta text(60),respuesta text(35)not null,fecha_registro timestamp)");


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

    public boolean InserTradicionaltb_producto(Dto datos) {

        boolean estado = true;
        int resultado;
        //SQLiteDatabase bd = this.getWritableDatabase();
        try {
            int id_producto = datos.getId_producto();
            String nom_producto = datos.getNom_producto();
            String des_producto = datos.getDes_producto();
            double stock = datos.getStock();
            double precio = datos.getPrecio();
            String unidade_de_medida = datos.getUnidad_de_medida();
            double estado_producto = datos.getEstado_producto();
            int categoria = datos.getCategoria();
            //Cursor fila = this.getWritableDatabase().rawQuery("select codigo from articulos
            Cursor fila = bd().rawQuery("select id_producto from tb_producto where id_producto='" + id_producto + "'", null);
            if (fila.moveToFirst() == true) {
                estado = false;
            } else {
                String SQL = "INSERT INTO tb_producto \n" +
                        "(codigo,descripcion,precio)\n" +
                        "VALUES \n" +
                        "('" + String.valueOf(id_producto) + "', '" + nom_producto + "', '" + des_producto + "','" + String.valueOf(stock) + "','" + String.valueOf(precio) + "','" + unidade_de_medida + "','" + String.valueOf(precio) + "','" + String.valueOf(categoria) + "','" + getDateTime() + "');";
                bd().execSQL(SQL);
                bd().close();
 /*
 this.getWritableDatabase().execSQL(SQL);
 this.getWritableDatabase().close();
 */
                estado = true;
            }
        } catch (Exception e) {
            estado = false;
            Log.e("error.", e.toString());
        }
        return estado;
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

    //Espacio designado para registros de la tabla Categorias
    public boolean InertCategoria(Dto datos){
        boolean estado = true;
        int resultado;

        try{
            int id_categoria = datos.getId_categoria();
            String nombre_categoria = datos.getNom_categoria();
            int estado_categoria = datos.getEstado_categoria();

            Cursor fila = bd().rawQuery("select id_categoria from categoria where id_categoria='"+id_categoria+"'",null);

            if (fila.moveToFirst()==true){
                estado =false;
            }else{
                String SQL = "INSERT INTO tb_categoria\n"+
                        "(id_categoria,nom_categoria,estado_categoria)\n"+
                        "VALUES\n"+
                        "('"+String.valueOf(id_categoria)+"','"+nombre_categoria+"','"+
                        String.valueOf(estado_categoria)+"');";
                bd().execSQL(SQL);
                bd().close();

                estado = true;
            }
        }catch (Exception e){
            estado = false;
            Log.e("Error.",e.toString());
        }
        return estado;
    }
    //Fin de espacio asignado para registro de tabla categorias
}