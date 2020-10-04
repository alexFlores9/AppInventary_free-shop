package com.example.appinventary_free_shop;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ConexionSQLite extends SQLiteOpenHelper {
boolean estadoDelete = true;
ArrayList<String>listaCategorias;
ArrayList<Dto>categoriasList;
ArrayList<String>listaProductos;
ArrayList<Dto>productosList;

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
            Cursor fila = bd().rawQuery("select id_usuario from tb_usuario where id_usuario='" + id_usuario + "'", null);
            if (fila.moveToFirst() == true) {
                estad = false;
            } else {
                String SQL = "INSERT INTO tb_usuario\n" +
                        "(id_usuario,nombre,apellido,correo,usuario,clave,tipo,estado,pregunta,respuesta,fecha_registro)\n" +
                        "VALUES \n" +
                        "('"+String.valueOf(id_usuario)+"','"+nombre +"','"+apellido+"','"+correo+"','"+usuario+"','"+clave+"','"+String.valueOf(tipo)+"','"+String.valueOf(estado)+"','"+pregunta+"','"+respuesta+"','"+getDateTime()+"');";
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

    //Espacio designado para registros de la tabla Categorias
    public boolean InertCategoria(Dto datos){
        boolean estado = true;
        int resultado;

        try{
            int id_categoria = datos.getId_categoria();
            String nombre_categoria = datos.getNom_categoria();
            int estado_categoria = datos.getEstado_categoria();

            Cursor fila = bd().rawQuery("select id_categoria from tb_categoria where id_categoria='"+id_categoria+"'",null);

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

   public ArrayList<String>consultaCategorias1(){
        boolean estado = false;
        SQLiteDatabase bd = this.getReadableDatabase();
        Dto categorias = null;
        categoriasList = new ArrayList<Dto>();
        try{
            Cursor fila = bd.rawQuery("select * from tb_categoria", null);
            while (fila.moveToNext()){
                categorias = new Dto();
                categorias.setId_categoria(fila.getInt(0));
                categorias.setNom_categoria(fila.getString(1));
                categorias.setEstado_categoria(fila.getInt(2));

                categoriasList.add(categorias);
            }
            listaCategorias = new ArrayList<>();

            for (int i = 0; i <= categoriasList.size(); i++){
                listaCategorias.add(categoriasList.get(i).getId_categoria()+"-"+ categoriasList.get(i).getEstado_categoria());
            }
        }catch (Exception e){

        }

        return listaCategorias;
   }
   //consulta para Listview de Categorias

    public  ArrayList<String> obtenerListaCategorias(){
        listaCategorias= new ArrayList<String>();
        listaCategorias.add("Seleccione");

        for(int i= 0;i<categoriasList.size();i++){
            listaCategorias.add(categoriasList.get(i).getId_categoria()+"-" +
                    ""+categoriasList.get(i).getEstado());
        }
        return listaCategorias;
    }

    public ArrayList<Dto> consultaCategorias(){
        boolean estado = false;

        SQLiteDatabase bd = this.getReadableDatabase();

        Dto categorias = null;
        categoriasList = new ArrayList<Dto>();

        try{
            Cursor fila = bd.rawQuery("select * from tb_categoria",null);
            while (fila.moveToNext()){
                categorias= new Dto();
                categorias.setId_categoria(fila.getInt(0));
                categorias.setNom_categoria(fila.getString(1));
                categorias.setEstado_categoria(fila.getInt(2));

                categoriasList.add(categorias);

                Log.i("id_categoria",String.valueOf(categorias.getId_categoria()));
                Log.i("nom_categoria",categorias.getNom_categoria().toString());
                Log.i("estado_categoria",String.valueOf(categorias.getEstado_categoria()));

            }
            obtenerListaCategorias();

        }catch (Exception e){

        }
        return categoriasList;
    }
    public Cursor Consultar(String usu, String pass) throws SQLException {
        Cursor mcursor =null;
        mcursor=this.getReadableDatabase().query("tb_usuario",new String[]{"id_usuario","nombre","apellido","correo","usuario","clave","tipo","estado","pregunta","respuesta"},"usuario like'"+usu+"'"+"and clave like'"+pass+"'",null,null,null,null);
        return mcursor;
    }
    //Fin de espacio asignado para registro de tabla categorias

    //Inicio de espacio asignado para tabla producto
    public boolean insertProducto(Dto datos){
        boolean estado = true;
        int resultado;

        try{
            int id_producto = datos.getId_producto();
            String nom_producto = datos.getNom_producto();
            String des_producto = datos.getDes_producto();
            double stock = datos.getStock();
            double precio = datos.getPrecio();
            String unidad_de_medida = datos.getUnidad_de_medida();
            int estado_producto = datos.getEstado_producto();
            int categoria = datos.getCategoria();

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fecha2 = sdf.format(cal.getTime());
            Cursor fila = bd().rawQuery("select id_producto from tb_producto where id_prodcuto"+datos.getId_producto()+"",null);
            if (fila.moveToFirst()==true){
                estado = false;
            }else{
                String SQL = "INSERT INTO tb_producto \n"+
                        "(id_producto,nom_producto,des_producto,stock,precio,unidad_de_medida,estado_producto,categoria)\n"+
                        "VALUES\n"+
                        "(?,?,?);";

                bd().execSQL(SQL,new String[]{String.valueOf(id_producto),nom_producto,des_producto,String.valueOf(stock),String.valueOf(precio),
                        unidad_de_medida,String.valueOf(estado_producto),String.valueOf(categoria)});
            }
        }catch (Exception e){
            estado = false;
            Log.e("error.",e.toString());
        }
        return estado;
    }
    //consulta listView para productos
    public ArrayList<String>consultaListaProductos1(){
        boolean estado = false;
        SQLiteDatabase bd = this.getReadableDatabase();

        Dto productos = null;
        productosList = new ArrayList<>();
        try {
            Cursor fila = bd.rawQuery("select * from tb_producto",null);
            while (fila.moveToNext()){
                productos = new Dto();
                productos.setId_producto(fila.getInt(0));
                productos.setNom_producto(fila.getString(1));
                productos.setDes_producto(fila.getString(2));
                productos.setStock(fila.getDouble(3));
                productos.setPrecio(fila.getDouble(4));
                productos.setUnidad_de_medida(fila.getString(5));
                productos.setEstado_producto(fila.getInt(6));
                productos.setCategoria(fila.getInt(7));

                productosList.add(productos);

            }
            listaProductos = new ArrayList<>();

            for (int i = 0; i <= productosList.size();i++){
                listaProductos.add(productosList.get(i).getId_producto()+"-"+productosList.get(i).getDes_producto());
            }
        }catch (Exception e){

        }
        return listaProductos;
    }

    //consulta para obtener producto
    public ArrayList<String>obtenerListaProductos(){
        listaProductos = new ArrayList<String>();
        listaProductos.add("Selecione: ");

        for (int i = 0; i<productosList.size();i++){
            listaProductos.add(productosList.get(i).getId_producto()+"-"+""+productosList.get(i).getDes_producto());
        }
        return listaProductos;
    }

    public ArrayList<Dto>consultaListaProductos(){
        boolean estado = false;

        SQLiteDatabase bd = this.getReadableDatabase();
        Dto productos = null;
        productosList = new ArrayList<Dto>();
        try {
            Cursor fila = bd.rawQuery("select * from tb_producto",null);
            while (fila.moveToNext()){
                productos= new Dto();
                productos.setId_producto(fila.getInt(0));
                productos.setNom_producto(fila.getString(1));
                productos.setDes_producto(fila.getString(2));
                productos.setStock(fila.getDouble(3));
                productos.setPrecio(fila.getDouble(4));
                productos.setUnidad_de_medida(fila.getString(5));
                productos.setEstado_producto(fila.getInt(6));
                productos.setCategoria(fila.getInt(7));

                productosList.add(productos);
                Log.i("id_producto",String.valueOf(productos.getId_producto()));
                Log.i("nom_producto",productos.getNom_producto());
                Log.i("des_producto",productos.getDes_producto());
                Log.i("stock",String.valueOf(productos.getStock()));
                Log.i("precio",String.valueOf(productos.getPrecio()));
                Log.i("unidad_de_medida",productos.getUnidad_de_medida());
                Log.i("estado_producto", String.valueOf(productos.getEstado_producto()));
                Log.i("categoria",String.valueOf(productos.getCategoria()));

            }
        }catch (Exception e){

        }
        return productosList;
    }
    //fin de espacio asignado para tabla productos
}