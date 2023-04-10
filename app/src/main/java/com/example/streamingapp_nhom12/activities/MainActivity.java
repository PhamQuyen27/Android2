package com.example.streamingapp_nhom12.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.streamingapp_nhom12.database.login.account;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import com.example.streamingapp_nhom12.R;
import com.example.streamingapp_nhom12.fragments.FavouritesFragment;
import com.example.streamingapp_nhom12.fragments.MovieFragment;
import com.example.streamingapp_nhom12.fragments.SearchFragment;
import com.example.streamingapp_nhom12.fragments.SeriesFragment;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnForgotpass;
    EditText txtUsername, txtPassword;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initControll();

    }


    protected void initControll(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = String.valueOf(txtUsername.getText());
                String password = String.valueOf(txtPassword.getText());

                if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Vui lòng nhập đầy đủ tài khoản và mật khẩu để đăng nhập!")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // do something
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                } else {
                    if(username.equals("users")&&password.equals("users")){
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Tài khoản hoặc mật khẩu không chính xác. Vui lòng kiểm tra lại!")
                                .setCancelable(false)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // do something
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }

                }
            }
        });

        btnForgotpass = findViewById(R.id.btnForgotpass);

        btnForgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo Intent để chuyển tới ForgotpassActivity
                    Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
                    startActivity(intent);
            }
        });
    }



    protected void initView(){
        btnForgotpass = findViewById(R.id.btnForgotpass);
        btnLogin = findViewById(R.id.btnLogin);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);


    }



//    BottomNavigationView bottomNavigationView;
//    Toolbar toolbar;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        bottomNavigationView = findViewById(R.id.bottom_nav);
//        toolbar = findViewById(R.id.toolbar_main);
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MovieFragment()).commit();
//        toolbar.setTitle("Movies");
//
//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.nav_movie:
//                        if (!getSupportFragmentManager().findFragmentById(R.id.fragment_container).getClass().getSimpleName().equals("MovieFragment")) {
//                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MovieFragment()).commit();
//                            toolbar.setTitle("Movies");
//                        }
//                        break;
//                    case R.id.nav_series:
//                        if (!getSupportFragmentManager().findFragmentById(R.id.fragment_container).getClass().getSimpleName().equals("SeriesFragment")) {
//                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SeriesFragment()).commit();
//                            toolbar.setTitle("Series");
//                        }
//                        break;
//                    case R.id.nav_search:
//                        if (!getSupportFragmentManager().findFragmentById(R.id.fragment_container).getClass().getSimpleName().equals("SearchFragment")) {
//                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SearchFragment()).commit();
//                            toolbar.setTitle("Search");
//                        }
//                        break;
//                    case R.id.nav_favourites:
//                        if (!getSupportFragmentManager().findFragmentById(R.id.fragment_container).getClass().getSimpleName().equals("FavouritesFragment")) {
//                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FavouritesFragment()).commit();
//                            toolbar.setTitle("Favourites");
//                        }
//                        break;
//                }
//                return true;
//            }
//        });
//    }
}