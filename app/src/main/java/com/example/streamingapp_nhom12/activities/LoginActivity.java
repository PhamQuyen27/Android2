package com.example.streamingapp_nhom12.activities;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.streamingapp_nhom12.R;

import java.security.AccessControlContext;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin, btnFogotpass;
    EditText txtUsername, txtPassword;





    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initControll();

    }


    protected void initControll(){
        btnFogotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }



    protected void initView(){
        btnFogotpass = findViewById(R.id.btnForgotpass);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
    }
}

    
