package com.example.appinventary_free_shop;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Principal extends AppCompatActivity{
    private FloatingActionMenu menu;
    private FloatingActionButton item1, item2,item3;
    private TextView tv;
    modal_Toast_Custom mo = new modal_Toast_Custom();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        // Establecemos la referencia al TextView para poder utilizarlo en el
        // código.
        tv = (TextView) findViewById(R.id.tv);

        // Sacamos el intent con el que se ha iniciado la Activity.
        Intent i = getIntent();

        // Del intent sacamos el Bundle en el que hemos introducido los datos en
        // la primera Activity.
        Bundle b = i.getExtras();

        // Comprobamos que el Bundle contenga datos, para evitar posibles
        // errores. Si no lo comprobamos y el Intent no tiene incorporado un
        // bundle, al intentar utilizar el bundle después nos saltará una
        // excepción por intentar un objeto que no existe
        // (NullPointerException).
        if (b != null) {
            String datos = b.getString("datos");

            // Establecemos el texto del TextView a partir de la cadena de texto
            // que hemos sacado del Bundle.
            tv.setText(datos);

            // Se puede hacer la asignación directamente:
            tv.setText(getIntent().getExtras().getString("datos"));
        }






    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            new android.app.AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_seguro)
                    .setTitle("Warning")
                    .setMessage("Realmente desea ir al inicio? \n tendras que iniciar sesion nuevamente!")
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


    public void item1(View view) {
        mo.dialogAbout(Principal.this);
    }

    public void item2(View view) {
      mo.dialogConfirmCustom2(Principal.this);
    }

    public void item3(View view) {
        cerrarAplicacion();
    }

    public void aggpro(View view) {
        Intent intent = new Intent(getApplicationContext(), tb_producto.class);
        startActivity(intent);
    }
    public void verpro(View view) {
            Intent intent = new Intent(getApplicationContext(),listview_productos.class);
            startActivity(intent);
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
        if (id == R.id.CrearC) {
            Intent intent = new Intent(getApplicationContext(),tb_categoria.class);
            startActivity(intent);
            return true;
        }else if (id==R.id.VerC){
            Intent intent = new Intent(getApplicationContext(),listview_categorias.class);
            startActivity(intent);
            return true;
        }else if (id==R.id.rv){
            Intent intent = new Intent(getApplicationContext(),recyclerview.class);
            startActivity(intent);
            return true;
        }else if (id==R.id.rv2){
            Intent intent = new Intent(getApplicationContext(),recyclerview2.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}