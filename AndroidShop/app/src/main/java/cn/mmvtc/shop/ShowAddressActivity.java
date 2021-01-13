package cn.mmvtc.shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;

public class ShowAddressActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ImageView back=(ImageView) findViewById(R.id.go_back);
        ImageView addAddress=(ImageView) findViewById(R.id.addAddress);
        TextView tv_shuohuoren = findViewById(R.id.gt_name);
        TextView tv_tel = findViewById(R.id.gt_tel);
        TextView tv_place = findViewById(R.id.gt_place);
        TextView tv_beizhu = findViewById(R.id.gt_note);


        Map<String,String> addressInfo = SPSaveInfo.getAddressInfo(this);
        if (addressInfo != null){
            tv_shuohuoren.setText("收货人:"+addressInfo.get("name"));
            tv_tel.setText("联系方式:"+addressInfo.get("tel"));
            tv_place.setText("地址:"+addressInfo.get("place"));
            tv_beizhu.setText("备注:"+addressInfo.get("note"));
        }


//        Intent intent = getIntent();
//        String shuohuoren = intent.getStringExtra("shuohuoren");
//        String tel = intent.getStringExtra("tel");
//        String place = intent.getStringExtra("place");
//        String beizhu = intent.getStringExtra("beizhu");
//        tv_shuohuoren.setText("收货人:"+shuohuoren);
//        tv_tel.setText("联系方式:"+tel);
//        tv_place.setText("地址:"+place);
//        tv_beizhu.setText("备注:"+beizhu);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShowAddressActivity.this,PersonActivity.class);
                startActivityForResult(intent,1);
            }
        });
        addAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShowAddressActivity.this,AddAddressActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

}
