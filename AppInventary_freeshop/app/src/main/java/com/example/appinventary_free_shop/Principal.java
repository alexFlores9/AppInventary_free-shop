package com.example.appinventary_free_shop;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Principal extends AppCompatActivity{
    private FloatingActionMenu menu;
    private FloatingActionButton item1, item2,item3;
    modal_Toast_Custom mo = new modal_Toast_Custom();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);









    }
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


    public void item1(View view) {
        mo.dialogAbout(Principal.this);
    }

    public void item2(View view) {
      mo.dialogConfirmCustom2(Principal.this);
    }

    public void item3(View view) {
        cerrarAplicacion();
    }
}