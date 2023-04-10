package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button go_login,go_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go_login=findViewById(R.id.go_login);
        go_register=findViewById(R.id.go_register);
        go_login.setOnClickListener(this);
        go_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.go_login:
                Intent intent1=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.go_register:
                Intent intent2=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent2);
                break;
        }
    }
}