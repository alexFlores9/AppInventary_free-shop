package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
EditText et1,et2;
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

    }

public void ingre(View v) {


}
}