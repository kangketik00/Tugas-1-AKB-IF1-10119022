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
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {
    private Button btnGotoHome;
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();
        setData();
    }

    public void initView(){
        btnGotoHome = findViewById(R.id.btn_goto_beranda);
    }

    public void setData(){
        Intent intn = getIntent();
        username = intn.getStringExtra("username");
        btnGotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // action
                Intent intent = new Intent(ProfileActivity.this,MainActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
}