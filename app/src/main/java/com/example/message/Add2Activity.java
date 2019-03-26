package com.example.message;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class Add2Activity extends AppCompatActivity {

    private TextView bg;
    private final String mFileColor = "Color.txt";
    private ImageView mBtnTextView;
    private Button mSent;
    private String number;
    private EditText nu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

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

        number =  getIntent().getStringExtra("num");

        nu = (EditText) findViewById(R.id.num);
        nu.setText(number);

        mBtnTextView = (ImageView)findViewById(R.id.back);
        mBtnTextView.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v){
                                                //跳转到TextView演示界面
                                                Intent intent = new Intent(Add2Activity.this,MainActivity.class);
                                                startActivity(intent);
                                            }
                                        }
        );

        mSent = (Button)findViewById(R.id.sent);
        mSent.setOnClickListener(new View.OnClickListener(){
                                     @Override
                                     public void onClick(View v){
                                         EditText num=(EditText)findViewById(R.id.num);
                                         String N=num.getText().toString();

                                         EditText content=(EditText)findViewById(R.id.content);
                                         String C=content.getText().toString();

                                         SmsManager sm = SmsManager.getDefault();
                                         ArrayList<String> sms = sm.divideMessage(C);

                                         for (String smslist :sms){
                                             sm.sendTextMessage(N,null,smslist,null,null);
                                         }
                                         Toast.makeText(getApplicationContext(),"Send success!",Toast.LENGTH_LONG).show();
                                         num.setText("");
                                         content.setText("Content");
                                     }
                                 }
        );



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
