package com.example.message;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleActivity extends AppCompatActivity {

    private TextView bg;
    private final String mFileColor = "Color.txt";
    private final String mFileName = "People.txt";
    private ListView note;
    //数据
    private List<Map<String,Object>> data=new ArrayList<>();
    //适配器
    private SimpleAdapter sa;
    //内容访问者
    private ContentResolver resolver;
    private Button add;
    private Button del;
    private EditText names;
    private Button mSent;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

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

        final String people = read();
        String P = people;
        if(people!=null) {
            if (people.substring(0, 4).equals("null"))
                P = people.substring(4, people.length());
            //ListView
            note = (ListView) findViewById(R.id.note);
            //内容访问者
            resolver = getContentResolver();
            //数据来源
            getNote(P);
            //适配器
            sa = new SimpleAdapter(this, data, android.R.layout.simple_list_item_2, new String[]{"names", "number"}, new int[]{android.R.id.text1, android.R.id.text2});
            //绑定适配器
            note.setAdapter(sa);

            note.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //我们需要的内容，跳转页面或显示详细信息
                    String name = read();
                    String n = "";
                    int k = 0;
                    if (name.substring(0, 4).equals("null"))
                        name = name.substring(4, name.length());
                    int index1 = -1;
                    int index2 = 0;
                    for (int i = 0; i <= position; i++) {
                        if (name != null) {
                            index2 = name.indexOf(";", index1 + 1);
                            if (index2 >= index1 + 1)
                                n = name.substring(index1 + 1, index2);
                            else k++;
                            index1 = name.indexOf("\\", index2 + 1);
                        }


                    }
                    if (k == 0) {
                        names = (EditText) findViewById(R.id.names);
                        names.setText(names.getText() + n + ";");
                    }

                }
            });


        }


            add = (Button) findViewById(R.id.add);
            add.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           //跳转到TextView演示界面
                                           Intent intent = new Intent(PeopleActivity.this, NewActivity.class);
                                           startActivity(intent);
                                       }
                                   }
            );

            del = (Button) findViewById(R.id.del);
            del.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           //跳转到TextView演示界面
                                           Intent intent = new Intent(PeopleActivity.this, DelActivity.class);
                                           startActivity(intent);
                                       }
                                   }
            );

            back = (ImageView) findViewById(R.id.back);
            back.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            //跳转到TextView演示界面
                                            Intent intent = new Intent(PeopleActivity.this, MainActivity.class);
                                            startActivity(intent);
                                        }
                                    }
            );





        mSent = (Button)findViewById(R.id.sent);
        mSent.setOnClickListener(new View.OnClickListener(){
                                     @Override
                                     public void onClick(View v){
                                         names = (EditText) findViewById(R.id.names);
                                         String N=names.getText().toString();
                                         int index1 = 6;
                                         int index2 = 7;
                                         String name = "";


                                         int i = 0;
                                         while (i==0){
                                             if(N!=null) {
                                                 index2 = N.indexOf(";", index1 + 1);
                                                 if(index2>=index1+1)
                                                     name = N.substring(index1 + 1, index2);
                                                 index1 = N.indexOf(";", index1 + 1);
                                             }

                                             if(index1 == 0||index1 == -1||index2 == 0||index2 == -1)
                                             {
                                                 i++;
                                             }
                                             else {
                                                 //发送短信

                                                 String num = read();
                                                 if(num.substring(0,4).equals("null"))
                                                     num = num.substring(4,num.length());

                                                 int i1 = -1;
                                                 int i2 = 0;
                                                 for(int j = 0; j == 0; ){
                                                     String na = "";
                                                     String nu = "";

                                                 if (num != null) {
                                                     i2 = num.indexOf(";", i1 + 1);
                                                     if (i2 >= i1 + 1)
                                                         na = num.substring(i1 + 1, i2);

                                                     i1 = num.indexOf("\\", i2 + 1);
                                                     if (i1 >= i2 + 1)
                                                         nu = num.substring(i2 + 1, i1);
                                                 }
                                                 if(name.equals(na))
                                                 {
                                                     EditText content=(EditText)findViewById(R.id.content);
                                                     String C=content.getText().toString();

                                                     int ind1 = 0;
                                                     int ind2 = 6;

                                                     for(int k = 0;k == 0;)
                                                     {
                                                         if(ind2>C.length())k++;
                                                         else {
                                                             String e = C.substring(ind1, ind2);
                                                             if (e.equals("\"name\"")) {
                                                                 String str1 = "";
                                                                 String str2 = "";
                                                                 if (ind1 != 0)
                                                                     str1 = C.substring(0, ind1);
                                                                 if (ind2 != C.length())
                                                                     str2 = C.substring(ind2, C.length());
                                                                 C = str1 + na + str2;
                                                                 k++;
                                                             }
                                                             ind1++;
                                                             ind2++;
                                                         }

                                                     }

                                                     SmsManager sm = SmsManager.getDefault();
                                                     ArrayList<String> sms = sm.divideMessage(C);

                                                     for (String smslist :sms){
                                                         sm.sendTextMessage(nu,null,smslist,null,null);
                                                     }
                                                     j++;
                                                 }
                                                 }



                                             }
                                         }
                                         EditText content=(EditText)findViewById(R.id.content);
                                         Toast.makeText(getApplicationContext(),"Send success!",Toast.LENGTH_LONG).show();
                                         names.setText("Names: ");
                                         content.setText("Content");
                                     }
                                 }
        );

    }



    //数据来源
    public void getNote(String People) {
        String name = "";
        String num = "";

        int index1 = -1;
        int index2 = 0;
        int i = 0;
        while (i==0){
            Map<String,Object> map=new HashMap<>();
            if(People!=null) {
                index2 = People.indexOf(";", index1 + 1);
                if(index2>=index1+1)
                name = People.substring(index1 + 1, index2);

                index1 = People.indexOf("\\", index2 + 1);
                if(index1>=index2+1)
                num = People.substring(index2 + 1, index1);
            }

            if(index1 == 0||index1 == -1||index2 == 0||index2 == -1)
            {
                //将数据添加到map集合
                map.put("names","Name: Blank");
                map.put("number","Num: Blank");
                //将map集合添加到list集合中
                data.add(map);
                i++;
            }
            else {
                //将数据添加到map集合
                map.put("names","Name: "+name );
                map.put("number", "Num: "+num);
                //将map集合添加到list集合中
                data.add(map);
            }
        }

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
