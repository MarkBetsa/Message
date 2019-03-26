package com.example.message;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;import java.util.Date;import java.util.HashMap;
import java.util.HashSet;import java.util.List;import java.util.Map;
public class MainActivity extends AppCompatActivity {

    private TextView bg;
    private final String mFileColor = "Color.txt";
    //listview
  private ListView note;
  //数据
 private List<Map<String,Object>> data=new ArrayList<>();
 //适配器
private SimpleAdapter sa;
//内容访问者
 private ContentResolver resolver;
    private Button mBtnTextView;
    private Button mPeople;
    private Button setting;
    private Activity activity;
    String[][] msg = new String[1000][4];

    int ps = 0;
    @Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);

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

     for(int i = 0;i<1000;i++)
     {
         msg[i]=new String[4];
        for(int j=0;j<4;j++)
        {
            msg[i][j]=new String("");
        }
     }

     mBtnTextView = (Button)findViewById(R.id.add);
     mBtnTextView.setOnClickListener(new View.OnClickListener(){
                                         @Override
                                         public void onClick(View v){
                                             //跳转到TextView演示界面
                                             Intent intent = new Intent(MainActivity.this,AddActivity.class);
                                             startActivity(intent);
                                         }
                                     }
     );

     mPeople = (Button)findViewById(R.id.people);
     mPeople.setOnClickListener(new View.OnClickListener(){
                                         @Override
                                         public void onClick(View v){
                                             //跳转到TextView演示界面
                                             Intent intent = new Intent(MainActivity.this,PeopleActivity.class);
                                             startActivity(intent);
                                         }
                                     }
     );

        setting = (Button)findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener(){
                                       @Override
                                       public void onClick(View v){
                                           //跳转到TextView演示界面
                                           Intent intent = new Intent(MainActivity.this,SettingActivity.class);
                                           startActivity(intent);
                                       }
                                   }
        );

     //ListView
      note = (ListView) findViewById(R.id.note);
      //内容访问者
          resolver = getContentResolver();
          //数据来源
         getNote();
         //适配器
         sa = new SimpleAdapter(this,data,android.R.layout.simple_list_item_2,new String[]{"names","number"},new int[]{android.R.id.text1,android.R.id.text2});
         //绑定适配器
        note.setAdapter(sa);

     note.setOnItemClickListener(new AdapterView.OnItemClickListener(){
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             //我们需要的内容，跳转页面或显示详细信息
             //position = position;
             String a = msg[position][0];
             String b = msg[position][1];
             String c = msg[position][2];
             String d = msg[position][3];
             Intent intent = new Intent(MainActivity.this,DetailActivity.class);
             Bundle bundle=new Bundle();
             bundle.putString("addre",a);
             bundle.putString("date",b);
             bundle.putString("type",c);
             bundle.putString("body",d);
             intent.putExtras(bundle);
             startActivity(intent);

         }
     });



                                 }
 //数据来源
 public void getNote() {
     Uri uri = Uri.parse("content://sms/");
     Cursor cursor = resolver.query(uri, null, null, null, null);
     //这是时间格式
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
          while (cursor.moveToNext()){
              Map<String,Object> map=new HashMap<>();
              //手机号(谁给我发送的)
                   String phoneNumberColumn =cursor.getString(cursor.getColumnIndex("address"));
                   //内容
                   String smsbodyColumn = cursor.getString(cursor.getColumnIndex("body"));
                   //发送时间
                 String dateColumn = cursor.getString(cursor.getColumnIndex("date"));
                 //判断是发送还是接收
                 String typeColumn = cursor.getString(cursor.getColumnIndex("type"));
                 Date d = new Date(Long.parseLong(dateColumn));
                 dateColumn = dateFormat.format(d);

                 msg[ps][0] = phoneNumberColumn;
                 msg[ps][1] = dateColumn;
                 msg[ps][2] = typeColumn;
                 msg[ps][3] = smsbodyColumn;
                 ps++;
                 //判断是否是接收，发送
                  switch (typeColumn){
                      case "1":
                          typeColumn="↓";
                          break;
                          case "2":
                              typeColumn="↑";
                              break;
                  }
                  //将数据添加到map集合
                     map.put("names","Num: "+phoneNumberColumn+" "+typeColumn);
                  map.put("number","Content: "+smsbodyColumn);
                  //将map集合添加到list集合中
                   data.add(map);
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
