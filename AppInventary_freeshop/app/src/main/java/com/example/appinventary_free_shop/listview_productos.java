package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class listview_productos extends AppCompatActivity {
    ListView listViewProductos;
    ArrayAdapter adaptador1;
    SearchView searchVieww;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter adapter;

    String[]version={"Aestro","Blender","CupCake","Donut","Eclair","Froyo","GingerBread","HomeyComb","IceCream Sandwich","Jelly Bean","Kitkat","Lolipop","Marshmallow","Nought","Oreo"};

    ConexionSQLite conexion = new ConexionSQLite(this);
    Dto datos = new Dto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_productos);

        listViewProductos = (ListView)findViewById(R.id.ca);
        searchVieww = (SearchView)findViewById(R.id.search_productos);

        adaptador1 = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,conexion.consultaListaProductos1());
        listViewProductos.setAdapter(adaptador1);

        searchVieww.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                String text = s;
                adaptador1.getFilter().filter(text);
                return false;
            }
        });

        listViewProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long l) {
                String informacion ="ID: "+conexion.consultaProductos().get(pos).getId_producto()+"\n";
                informacion+="Nombre: "+conexion.consultaProductos().get(pos).getNom_producto()+"\n";
                informacion+="Descripción producto: "+conexion.consultaProductos().get(pos).getDes_producto()+"\n";
                informacion+="Stock: "+conexion.consultaProductos().get(pos).getStock()+"\n";
                informacion+="Precio: "+conexion.consultaProductos().get(pos).getPrecio()+"\n";
                informacion+="Unidad de medida: "+conexion.consultaProductos().get(pos).getUnidad_de_medida()+"\n";
                informacion+="Estado: "+conexion.consultaProductos().get(pos).getEstado_producto()+"\n";
                informacion+="Categoria: "+conexion.consultaProductos().get(pos).getCategoria();

                Dto articulos = conexion.consultaCategorias().get(pos);
                Intent intent = new Intent(listview_productos.this, detalles_productos.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("articulo", articulos);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            new android.app.AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_seguro)
                    .setTitle("Warning")
                    .setMessage("Realmente desea salir? " )
                    .setNegativeButton(android.R.string.cancel,null)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}