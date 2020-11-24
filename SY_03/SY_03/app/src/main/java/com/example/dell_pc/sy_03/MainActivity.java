package com.example.dell_pc.sy_03;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TextView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.content.Context;
import android.content.DialogInterface;;
import android.widget.Toast;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

   // 声明ListView
    ListView mylist;
    public static Toast toast;
    private String[] names=new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] headimage=new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,
            R.drawable.dog,R.drawable.cat,R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SY_03_01
        //定位ListView
        ListView mylist=(ListView)findViewById(R.id.mylist);
        mylist.setOnItemClickListener((parent, view, position, id) -> {
            //TextView name=(TextView)mylist.getChildAt(R.id.name);
            toast=Toast.makeText(MainActivity.this,names[position],Toast.LENGTH_SHORT);
            toast.show();
        });



        List<Map<String,Object>> listItems=new ArrayList<>();
        for (int i=0;i<names.length;i++)
        {
            Map<String,Object> listItem=new HashMap<>();
            listItem.put("Animalname",names[i]);
            listItem.put("Animalhead",headimage[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter =new SimpleAdapter(this,listItems,R.layout.simple_item,
                new String[]{"Animalname","Animalhead"},new int[]{R.id.name,R.id.head});
        ListView list=findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);




    }


}


