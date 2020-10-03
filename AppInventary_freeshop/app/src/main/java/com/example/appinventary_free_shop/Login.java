package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
EditText et1,et2;
Button btn1;
private Cursor fila;
    boolean inputE0=false;
    boolean inputE1=false;

    ConexionSQLite conexion = new ConexionSQLite(this);
    Dto datos = new Dto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);


        btn1=findViewById(R.id.btn_val);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1= findViewById(R.id.tv_usu);
                et2=findViewById(R.id.tv_pass);

                try {
                Cursor cursor=conexion.Consultar(et1.getText().toString(),et2.getText().toString());

         if (cursor.getCount()>0){
             Intent intent = new Intent(getApplicationContext(),tb_usuario.class);
             startActivity(intent);
         }else{
             Toast.makeText(Login.this, "error no  creado", Toast.LENGTH_SHORT).show();
         }
         et1.setText("");
                    et2.setText("");
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        });

    }


}