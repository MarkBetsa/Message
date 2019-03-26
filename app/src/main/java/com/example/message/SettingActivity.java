package com.example.message;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SettingActivity extends AppCompatActivity {

    private final String mFileColor = "Color.txt";
    private TextView bg;
    private Button color1;
    private Button color2;
    private Button color3;
    private Button color4;
    private Button color5;
    private Button color6;
    private Button color7;
    private Button color8;
    private ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        String color = "";
        color = readcolor();
        if(color == null)
        {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(android.graphics.Color.rgb(40,163,163));
        }
        if(color!=null)
        {
            bg = (TextView)findViewById(R.id.textView);
            switch (color){
                case "1":
                    bg.setBackgroundColor(android.graphics.Color.rgb(150,50,50));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(android.graphics.Color.rgb(150,50,50));
                    }
                    break;
                case "2":
                    bg.setBackgroundColor(android.graphics.Color.rgb(40,163,163));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(android.graphics.Color.rgb(40,163,163));
                    }
                    break;
                case "3":
                    bg.setBackgroundColor(android.graphics.Color.rgb(43,177,127));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(android.graphics.Color.rgb(43,177,127));
                    }
                    break;
                case "4":
                    bg.setBackgroundColor(android.graphics.Color.rgb(255,150,0));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(android.graphics.Color.rgb(255,150,0));
                    }
                    break;
                case "5":
                    bg.setBackgroundColor(android.graphics.Color.rgb(40,60,155));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(android.graphics.Color.rgb(40,60,155));
                    }
                    break;
                case "6":
                    bg.setBackgroundColor(android.graphics.Color.rgb(255,150,150));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(android.graphics.Color.rgb(255,150,150));
                    }
                    break;
                case "7":
                    bg.setBackgroundColor(android.graphics.Color.rgb(0,200,60));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(android.graphics.Color.rgb(0,200,60));
                    }
                    break;
                case "8":
                    bg.setBackgroundColor(android.graphics.Color.rgb(0,210,190));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(android.graphics.Color.rgb(0,210,190));
                    }
                    break;
                default:
                    break;
            }
        }


        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
                                      @Override
                                      public void onClick(View v){
                                          //跳转到TextView演示界面
                                          Intent intent = new Intent(SettingActivity.this,MainActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );

        color1 = (Button)findViewById(R.id.color1);
        color1.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       //跳转到TextView演示界面
                                       savecolor("1");
                                       Toast.makeText(getApplicationContext(),"Restart to take effect",Toast.LENGTH_LONG).show();
                                       Intent intent = new Intent(SettingActivity.this,SettingActivity.class);
                                       startActivity(intent);
                                   }
                               }
        );

        color2 = (Button)findViewById(R.id.color2);
        color2.setOnClickListener(new View.OnClickListener(){
                                      @Override
                                      public void onClick(View v){
                                          //跳转到TextView演示界面
                                          savecolor("2");
                                          Toast.makeText(getApplicationContext(),"Restart to take effect",Toast.LENGTH_LONG).show();
                                          Intent intent = new Intent(SettingActivity.this,SettingActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );

        color3 = (Button)findViewById(R.id.color3);
        color3.setOnClickListener(new View.OnClickListener(){
                                      @Override
                                      public void onClick(View v){
                                          //跳转到TextView演示界面
                                          savecolor("3");
                                          Toast.makeText(getApplicationContext(),"Restart to take effect",Toast.LENGTH_LONG).show();
                                          Intent intent = new Intent(SettingActivity.this,SettingActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );

        color4 = (Button)findViewById(R.id.color4);
        color4.setOnClickListener(new View.OnClickListener(){
                                      @Override
                                      public void onClick(View v){
                                          //跳转到TextView演示界面
                                          savecolor("4");
                                          Toast.makeText(getApplicationContext(),"Restart to take effect",Toast.LENGTH_LONG).show();
                                          Intent intent = new Intent(SettingActivity.this,SettingActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );

        color5 = (Button)findViewById(R.id.color5);
        color5.setOnClickListener(new View.OnClickListener(){
                                      @Override
                                      public void onClick(View v){
                                          //跳转到TextView演示界面
                                          savecolor("5");
                                          Toast.makeText(getApplicationContext(),"Restart to take effect",Toast.LENGTH_LONG).show();
                                          Intent intent = new Intent(SettingActivity.this,SettingActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );

        color6 = (Button)findViewById(R.id.color6);
        color6.setOnClickListener(new View.OnClickListener(){
                                      @Override
                                      public void onClick(View v){
                                          //跳转到TextView演示界面
                                          savecolor("6");
                                          Toast.makeText(getApplicationContext(),"Restart to take effect",Toast.LENGTH_LONG).show();
                                          Intent intent = new Intent(SettingActivity.this,SettingActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );

        color7 = (Button)findViewById(R.id.color7);
        color7.setOnClickListener(new View.OnClickListener(){
                                      @Override
                                      public void onClick(View v){
                                          //跳转到TextView演示界面
                                          savecolor("7");
                                          Toast.makeText(getApplicationContext(),"Restart to take effect",Toast.LENGTH_LONG).show();
                                          Intent intent = new Intent(SettingActivity.this,SettingActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );

        color8 = (Button)findViewById(R.id.color8);
        color8.setOnClickListener(new View.OnClickListener(){
                                      @Override
                                      public void onClick(View v){
                                          //跳转到TextView演示界面
                                          savecolor("8");
                                          Toast.makeText(getApplicationContext(),"Restart to take effect",Toast.LENGTH_LONG).show();
                                          Intent intent = new Intent(SettingActivity.this,SettingActivity.class);
                                          startActivity(intent);
                                      }
                                  }
        );






    }

    private void savecolor(String content){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(mFileColor,MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        }   catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fileOutputStream != null){
                try{
                    fileOutputStream.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private String readcolor(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput(mFileColor);
            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder("");
            int len = 0;
            while((len = fileInputStream.read(buff)) > 0){
                sb.append(new String(buff,0,len));
            }
            return sb.toString();
        }   catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
