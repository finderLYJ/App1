package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_username,et_password,et_password_again;
    private Button btn_register,btn_register_cancel;
    private TextView have_account;
    private ImageView backHome;
    MyDBhelper myDBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        btn_register.setOnClickListener(this);
        btn_register_cancel.setOnClickListener(this);
        have_account.setOnClickListener(this);
        backHome.setOnClickListener(this);
    }
    private void init(){
        et_username=findViewById(R.id.et_username_register);
        et_password=findViewById(R.id.et_password_register);
        et_password_again=findViewById(R.id.et_password_again);
        btn_register=findViewById(R.id.btn_register);
        btn_register_cancel=findViewById(R.id.btn_cancel_register);
        have_account=findViewById(R.id.have_account);
        backHome=findViewById(R.id.backHome_register);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_register:
                String username=et_username.getText().toString();
                String password=et_password.getText().toString();
                String password_again=et_password_again.getText().toString();
                if(username.equals("") || password.equals("")||password_again.equals("")){
                    Toast.makeText(RegisterActivity.this,"用户名或密码不能为空！",Toast.LENGTH_LONG).show();
                }else if(!password.equals(password_again)){
                    Toast.makeText(RegisterActivity.this, "两次密码不一致！", Toast.LENGTH_LONG).show();
                }else if(password.equals(password_again)){
                    myDBhelper=new MyDBhelper(RegisterActivity.this,"user.db",null,1);
                    if(myDBhelper.insertUser(username,password)){
                        Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_LONG).show();
                        Intent toLogin=new Intent(RegisterActivity.this,LoginActivity.class);
                        toLogin.putExtra("username",username);
                        toLogin.putExtra("password",password);
                        startActivity(toLogin);
                        finish();
                    }
                }
                break;
            case R.id.btn_cancel_register:
                et_username.setText("");
                et_password.setText("");
                et_password_again.setText("");
                break;
            case R.id.have_account:
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.backHome_register:
                finish();
                break;
        }
    }
}