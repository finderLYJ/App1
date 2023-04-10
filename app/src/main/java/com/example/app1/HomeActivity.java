package com.example.app1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1,btn2,btn3,btn4;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }
    public void init(){
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        toolbar=findViewById(R.id.home_toolbar);
        toolbar.setTitle("");
        //设置toolbar对象
       setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.personal:
                        Intent intent1=new Intent(HomeActivity.this,PersonalCenterActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.help:
                        Intent intent2=new Intent(HomeActivity.this,HelpActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.exit:
                        showDialog();
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.personal:
                Intent intent1=new Intent(HomeActivity.this,PersonalCenterActivity.class);
                startActivity(intent1);
                break;
            case R.id.help:
                Intent intent2=new Intent(HomeActivity.this,HelpActivity.class);
                startActivity(intent2);
                break;
            case R.id.exit:
                showDialog();
        }
        return true;
    }
    private void showDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("退出登录");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                logout();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //dialog.dismiss();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    private void logout(){
        Intent intent=new Intent(HomeActivity.this,MainActivity.class);
        startActivity(intent);
        //获取SharedPreferences对象
        SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        //获取Editor对象的引用
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //将获取过来的值放入文件
        editor.remove("login");
        // 提交数据
        editor.commit();
        finish();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                Intent intent1=new Intent(HomeActivity.this,FirstActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn2:
                Intent intent2=new Intent(HomeActivity.this,SecondActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn3:
                Intent intent3=new Intent(HomeActivity.this,ThirdActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn4:
                Intent intent4=new Intent(HomeActivity.this,FouthActivity.class);
                startActivity(intent4);
                break;
            case R.id.home_imageview:
                Intent intent5=new Intent(HomeActivity.this,PersonalCenterActivity.class);
                startActivity(intent5);
                break;
        }
    }
}