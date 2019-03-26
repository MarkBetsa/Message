package com.example.message;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DetailActivity extends AppCompatActivity {

    private String addre = "";
    private String date = "";
    private String type = "";
    private String body = "";
    String str = "";

    private TextView bg;
    private final String mFileColor = "Color.txt";
    private final String mFileName = "People.txt";

    private TextView num;
    private TextView da;
    private TextView bo;
    private ImageView back;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

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

        addre = getIntent().getStringExtra("addre");
        date = getIntent().getStringExtra("date");
        type = getIntent().getStringExtra("type");
        body = getIntent().getStringExtra("body");

        if(addre.substring(0,3).equals("+86"))
            addre = addre.substring(3,addre.length());

        switch (type){
            case "1":
                type="↓";
                break;
            case "2":
                type="↑";
                break;
        }


        str = read();
        int k = 0;
        num = (TextView) findViewById(R.id.addre);
        if(str!=null) {
            if (str.substring(0, 4).equals("null"))
                str = str.substring(4, str.length());
            int index1 = 0;
            int index2 = 11;
            for (int i = 0; i == 0; ) {
                if (str.length() < 10) break;
                String temp = str.substring(index1, index2);
                if (addre.equals(temp)) {
                    for (int j = 0; j == 0; ) {
                        if (str.substring(index1, index1 + 1).equals("\\") || index1 == 0) {
                            index2 = str.indexOf(";", index1 + 1);
                            if (index2 == -1) {
                                j++;
                            } else {
                                if (index1 == 0)
                                    num.setText(addre + " " + "(" + str.substring(index1, index2) + ")");
                                else
                                    num.setText(addre + " " + "(" + str.substring(index1 + 1, index2) + ")");
                                k++;
                                j++;
                            }
                        }
                        index1--;
                        if (index1 < 0) {
                            j++;
                        }
                    }
                    i++;
                }
                index1++;
                index2++;
                if (index2 == 0 || index2 == -1 || index2 > str.length()) {
                    i++;
                }
            }
        }
        if(k == 0) num.setText(addre);

        da = (TextView) findViewById(R.id.date);
        bo = (TextView) findViewById(R.id.body);

        da.setText(date+type);
        bo.setText(body);

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View v){
                                        //跳转到TextView演示界面
                                        Intent intent = new Intent(DetailActivity.this,MainActivity.class);
                                        startActivity(intent);
                                    }
                                }
        );

        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View v){
                                        //跳转到TextView演示界面
                                        Intent intent = new Intent(DetailActivity.this,Add2Activity.class);
                                        Bundle bundle=new Bundle();
                                        bundle.putString("num",addre);
                                        intent.putExtras(bundle);
                                        startActivity(intent);
                                    }
                                }
        );

    }



    private void save(String content){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(mFileName,MODE_PRIVATE);
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

    private String read(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput(mFileName);
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
