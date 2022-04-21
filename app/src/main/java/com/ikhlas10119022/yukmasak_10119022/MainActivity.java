package com.ikhlas10119022.yukmasak_10119022;
/*
    tanggal pengerjaan  : 22 April 2022
    nim                 : 10119022
    nama                : Muhammad Ikhlas Naufalsyah Ranau
    kelas               : IF-1
*/
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnLogout, btnGotoProfile;
    private TextView txtViewUsername, txtViewPassword;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setData();
    }

    public void initView(){
        btnLogout = findViewById(R.id.btn_logout);
        btnGotoProfile = findViewById(R.id.btn_lihatProfile);
        txtViewUsername = findViewById(R.id.username_text);

    }

    public void setData(){
        Intent intn = getIntent();
        username = intn.getStringExtra("username");

        txtViewUsername.setText(username);
        btnGotoProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // action
                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // action
                Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}