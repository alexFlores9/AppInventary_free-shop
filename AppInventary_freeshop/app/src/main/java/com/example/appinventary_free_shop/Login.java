package com.example.appinventary_free_shop;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
EditText et1,et2;
Button btn1,btn2;
private Cursor fila;
    boolean inputE0=false;
    boolean inputE1=false;

    ConexionSQLite conexion = new ConexionSQLite(this);
    Dto datos = new Dto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        et1= findViewById(R.id.tv_usu);
        et2=findViewById(R.id.tv_pass);
        btn2=findViewById(R.id.btn_prueba);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),tb_usuario.class);
                startActivity(intent);
            }
        });

        btn1=findViewById(R.id.btn_val);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1= findViewById(R.id.tv_usu);
                et2=findViewById(R.id.tv_pass);
                datos.setUsuario(et1.getText().toString());
                try {
                    Cursor cursor=conexion.Consultar(et1.getText().toString(),et2.getText().toString());

                    if (cursor.getCount()>0){
                        // Utilizamos un objeto de la clase Bundle para incluir un par
                        // "Clave/Valor", este objeto tendrá como clave "datos", y su valor
                        // será el texto que se introduzca en el EditText.
                        Bundle b = new Bundle();
                        b.putString("datos", et1.getText().toString());

                        // La clase Intent establece un link entre esta Activity y la nueva
                        // que queremos lanzar, para ello al instanciar el Intent
                        // introducimos como parámetros esta propia Activity, y la clase que
                        // representa a la nueva Activity.
                        Intent i = new Intent(Login.this,
                                Principal.class);

                        // En el Intent añadimos el Bundle, para que lleve la información a
                        // la siguiente Activity.
                        i.putExtras(b);

                        // Lanzamos la siguiente Activity.
                        startActivity(i);
                   //     Intent intent = new Intent(getApplicationContext(),Principal.class);
                     //   startActivity(intent);
                        Toast.makeText(Login.this, "Bienvenido \n" + et1.getText().toString(), Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Login.this, "error! usuario y/o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    }
                    et1.setText("");
                    et2.setText("");
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        });


    }

    private Object prue() {
        return et1.getText().toString();
        }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            new android.app.AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_seguro)
                    .setTitle("Warning")
                    .setMessage("Realmente desea salir?")
                    .setNegativeButton(android.R.string.cancel,null)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finishAffinity();
                        }
                    })
                    .show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}