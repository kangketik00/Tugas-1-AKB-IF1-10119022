package com.ikhlas10119022.yukmasak_10119022;
/*
    tanggal pengerjaan  : 22 April 2022
    nim                 : 10119022
    nama                : Muhammad Ikhlas Naufalsyah Ranau
    kelas               : IF-1
*/
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin, btnRegis;
    private EditText username_login, password_login;
    private TextView login_alert;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setData();
    }

    public void initView(){
        btnLogin = findViewById(R.id.btn_login);
        btnRegis = findViewById(R.id.btn_goto_regis);
        username_login = findViewById(R.id.username_login);
        password_login = findViewById(R.id.password_login);
        login_alert = findViewById(R.id.login_alert);

    }

    public void setData(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = username_login.getText().toString();
                password = password_login.getText().toString();
                // action
                if(username.equals("admin") && password.equals("admin")){
                    Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    login_alert.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                    login_alert.setVisibility(View.VISIBLE);
                }
            }
        });

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // action
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}