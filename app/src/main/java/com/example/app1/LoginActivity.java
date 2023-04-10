package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_username,et_password;
    private Button btn_login,btn_login_cancel;
    private TextView not_hava_account;
    private ImageView backHome;
    private MyDBhelper myDBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        btn_login.setOnClickListener(this);
        btn_login_cancel.setOnClickListener(this);
        not_hava_account.setOnClickListener(this);
        backHome.setOnClickListener(this);
    }
    private void init(){
        et_username=findViewById(R.id.et_username_login);
        et_password=findViewById(R.id.et_password_login);
        Intent intent=getIntent();
        if(intent!=null){
            et_username.setText(intent.getStringExtra("username"));
            et_password.setText(intent.getStringExtra("password"));
        }
        btn_login=findViewById(R.id.btn_login);
        btn_login_cancel=findViewById(R.id.btn_cancel_login);
        not_hava_account=findViewById(R.id.not_have_account);
        backHome=findViewById(R.id.backHome_login);
    }

    private void login(){
        String username=et_username.getText().toString();
        String password=et_password.getText().toString();
        myDBhelper=new MyDBhelper(LoginActivity.this,"user.db",null,1);
        //从数据库中找用户信息
        UserInfo user=myDBhelper.query(username);
        if(user==null){
            Toast.makeText(LoginActivity.this, "该用户不存在！", Toast.LENGTH_LONG).show();
        }else{
            if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
                Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(LoginActivity.this, "用户名或密码错误！", Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_cancel_login:
                finish();
                break;
            case R.id.not_have_account:
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.backHome_login:
                finish();
                break;
        }
    }
}