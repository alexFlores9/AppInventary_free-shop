package com.example.appinventary_free_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.appinventary_free_shop.ui.login.LoginActivity;

public class slash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(slash.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}