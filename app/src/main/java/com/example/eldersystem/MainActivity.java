package com.example.eldersystem;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.eldersystem.sms.SMSListShowActivity;
import com.example.eldersystem.weather.weather_main;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQ_CODE_CONTACT = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }


        Button buttontop=(Button)findViewById(R.id.button_top);
        Button button1=(Button)findViewById(R.id.button1);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Button button4=(Button)findViewById(R.id.button4);
        Button button5=(Button)findViewById(R.id.button5);
        Button button6=(Button)findViewById(R.id.button6);
        buttontop.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case  R.id.button_top:
                break;
            case  R.id.button1:
                Intent intent1=new Intent(this, weather_main.class);
                startActivity(intent1);
                break;

            case  R.id.button2:
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.
                        permission.READ_SMS)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.READ_SMS,Manifest.permission.RECEIVE_SMS,Manifest.permission.SEND_SMS},1);
                }
                else{
                    Intent intent2=new Intent(this, SMSListShowActivity.class);
                    startActivity(intent2);
                }
                break;

            case  R.id.button3:
                break;
            case  R.id.button4:
                break;
            case  R.id.button5:
                break;
            case  R.id.button6:
                break;

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults) {
        //判断用户是否，同意 获取短信授权
        if (requestCode == REQ_CODE_CONTACT && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //获取到读取短信权限
            Intent intent=new Intent(MainActivity.this,SMSListShowActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "未获取到短信权限", Toast.LENGTH_SHORT).show();
        }
    }

}

