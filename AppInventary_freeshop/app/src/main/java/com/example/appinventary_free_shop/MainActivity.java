package com.example.appinventary_free_shop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.KeyEvent;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FloatingActionMenu menu;
    private FloatingActionButton item1, item2,item3;
    modal_Toast_Custom mo = new modal_Toast_Custom();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            new android.app.AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_seguro)
                    .setTitle("Warning")
                    .setMessage("Realmente desea ir al inicio?")
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
    private void cerrarAplicacion() {
        new AlertDialog.Builder(this) .setIcon(R.drawable.ic_seguro)
                .setTitle("¿Realmente desea cerrar la aplicación?")
                .setCancelable(false) .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    // un listener queal pulsar, cierre la aplicacion


                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finishAffinity();
                        //Su funcion es algo similar a lo que se llama cuando sepresiona el botón "Forzar Detención" o "Administrar aplicaciones" , lo cuál mata la aplicación //finish(); Si solo quiere mandar la aplicación a segundo plano
                    }
                }).show(); }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        menu = findViewById(R.id.menu);
        item1 =findViewById(R.id.item1);
        item2 =findViewById(R.id.item2);
        item3 =findViewById(R.id.item3);

        menu.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
                if (opened){
                    Toast.makeText(MainActivity.this, "Menu abierto", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Menu cerrado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   finish();
                // Intent intent = new Intent(consulta_spinner.this, MainActivity.class);
                mo.dialogAbout(MainActivity.this);
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        item3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                cerrarAplicacion();

            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}