package cn.mmvtc.shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Map;


public class PersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_information);
        ImageView back=(ImageView) findViewById(R.id.go_back);

        ImageView setting=(ImageView) findViewById(R.id.touxiang);
        RelativeLayout myAddress = findViewById(R.id.address_layout);
        RelativeLayout myHistoryOrder = findViewById(R.id.history_layout);
        TextView myCollection = findViewById(R.id.my_collection);
        TextView loginOut = findViewById(R.id.exit);

        TextView tv_nicheng = findViewById(R.id.nicheng);
        TextView tv_note = findViewById(R.id.note);



        Map<String,String> userInfo = SPSaveInfo.getProfileInfo(this);
        if (userInfo != null){
            tv_nicheng.setText("昵称:"+userInfo.get("nicheng"));
            tv_note.setText("个性签名:"+userInfo.get("qianming"));

        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PersonActivity.this,MainActivity.class);
                startActivityForResult(intent,1);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PersonActivity.this,EditProfile.class);
                startActivityForResult(intent,1);
            }
        });

        myAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PersonActivity.this, ShowAddressActivity.class);
                startActivityForResult(intent,1);
            }
        });

        myHistoryOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PersonActivity.this,HistoryOrderActivity.class);
                startActivityForResult(intent,1);
            }
        });

        myCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PersonActivity.this,CollectionActivity.class);
                startActivityForResult(intent,1);
            }
        });

        loginOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }




}
