package cn.mmvtc.shop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import cn.mmvtc.shop.adapter.ShoppingAdapter;
import cn.mmvtc.shop.bean.ShoppingBean;
import cn.mmvtc.shop.database.SQLiteHelper;

public class HistoryOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historyorder);

        ImageView back = findViewById(R.id.go_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryOrderActivity.this,PersonActivity.class);
                startActivity(intent);
            }
        });
    }

}
