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

public class RegisterActivity extends AppCompatActivity {

    private Button btnLogin, btnRegis;
    private EditText username_regis, password_regis, confirm_password;
    private String username, password, confirm_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        setData();
    }

    public void initView(){
        btnLogin = findViewById(R.id.btn_goto_login);
        btnRegis= findViewById(R.id.btn_regis);
        username_regis = findViewById(R.id.username_regis);
        password_regis = findViewById(R.id.password_regis);
        confirm_password = findViewById(R.id.confirm_password);

    }

    public void setData(){
        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = username_regis.getText().toString();
                password = password_regis.getText().toString();
                confirm_pass  = confirm_password.getText().toString();

                // action
                if(!username.equals("") && !password.equals("") && !confirm_pass.equals("")){
                    if(password.equals(confirm_pass)){
                        Toast.makeText(RegisterActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        intent.putExtra("username", username);
                        intent.putExtra("password", password);
                        startActivity(intent);
                    }else {
                        Toast.makeText(RegisterActivity.this, "password dan confirm password berbeda!", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    if (username.equals("")){
                        Toast.makeText(RegisterActivity.this, "username belum di isi!", Toast.LENGTH_SHORT).show();
                    }else if(password.equals("")){
                        Toast.makeText(RegisterActivity.this, "password belum di isi!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(RegisterActivity.this, "confirm password belum di isi!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // action
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}