package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
            
                Dto categorias = conexion.consultaCategorias().get(pos);

            }
        });
    }
}