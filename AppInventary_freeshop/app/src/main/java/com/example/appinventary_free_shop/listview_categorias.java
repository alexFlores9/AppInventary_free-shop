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

import java.util.ArrayList;

public class listview_categorias extends AppCompatActivity {
    ListView listViewCategorias;
    ArrayAdapter adaptador;
    SearchView searchView;
    ListView listView;
    ArrayList<String>list;
    ArrayAdapter adapter;


    String[]version={"Aestro","Blender","CupCake","Donut","Eclair","Froyo","GingerBread","HomeyComb","IceCream Sandwich","Jelly Bean","Kitkat","Lolipop","Marshmallow","Nought","Oreo"};

    ConexionSQLite conexion = new ConexionSQLite(this);
    Dto datos = new Dto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_categorias);

        listViewCategorias = (ListView)findViewById(R.id.listView_categorias);
        searchView= (SearchView)findViewById(R.id.search_categoria);

        adaptador = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,conexion.consultaCategorias1());
        listViewCategorias.setAdapter(adaptador);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                String text = s;
                adaptador.getFilter().filter(text);
                return false;
            }
        });

        listViewCategorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long l) {
                String infromacion = "ID: "+conexion.consultaCategorias().get(pos).getId_categoria()+"\n";
                infromacion+="Nombre categoria:"+conexion.consultaCategorias().get(pos).getNom_categoria()+"\n";
                infromacion+="Estado: "+conexion.consultaCategorias().get(pos).getEstado_categoria();
            
                Dto articulos = conexion.consultaCategorias().get(pos);
                Intent intent = new Intent(listview_categorias.this, detalles_categorias.class);
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