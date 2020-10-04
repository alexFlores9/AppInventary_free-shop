package com.example.appinventary_free_shop;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class modal_Toast_Custom extends AppCompatActivity {


    Dialog myDialog;
    androidx.appcompat.app.AlertDialog.Builder dialogo;
    AlertDialog.Builder dialogo1;


    public void dialogAbout(final Context context) {
        //dialogo1 = new AlertDialog.Builder(context);
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.acercade);
        myDialog.setCancelable(false);

        ImageView BtnCerrarAutor = myDialog.findViewById(R.id.BtnCerrarAutor);

        BtnCerrarAutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }




    public void dialogConfirmCustom2(final Context context) {
        //dialogo1 = new AlertDialog.Builder(context);

        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.cerrars);
        myDialog.setCancelable(false);

        ImageView ivClose = (ImageView)myDialog.findViewById(R.id.ivClose);
        Button btnAccept = (Button)myDialog.findViewById(R.id.btnAccept);
        Button btnCancel = myDialog.findViewById(R.id.btnCancel);

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Clic en Aceptar.", Toast.LENGTH_SHORT).show();
                finish();
                Intent intent = new Intent(context, Login.class);
                context.startActivity(intent);
                //startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Clic en Cancelar", Toast.LENGTH_SHORT).show();
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }





}
