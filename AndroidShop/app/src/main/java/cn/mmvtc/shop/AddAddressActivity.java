package cn.mmvtc.shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddAddressActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_address);
        ImageView back=(ImageView) findViewById(R.id.go_back);
        Button addAddress = findViewById(R.id.btn_save);
        final EditText etshuohuoren = findViewById(R.id.et_shouhuoren);
        final EditText ettel = findViewById(R.id.et_tel);
        final EditText etplace = findViewById(R.id.et_place);
        final EditText etbeizhu = findViewById(R.id.et_beizhu);

        addAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //        当单机登录按钮时，获取QQ账号和密码
                String name = etshuohuoren.getText().toString().trim();
                String tel = ettel.getText().toString().trim();
                String place = etplace.getText().toString().trim();
                String note = etbeizhu.getText().toString().trim();
//        检查信息输入是否正确
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(AddAddressActivity.this,"请输入收货人",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(tel)){
                    Toast.makeText(AddAddressActivity.this,"请输入联系方式",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(place)){
                    Toast.makeText(AddAddressActivity.this,"请输入地址",Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(AddAddressActivity.this,"信息填写成功",Toast.LENGTH_SHORT).show();
//        保存用户信息
                boolean isSaveSuccess = SPSaveInfo.saveAddressInfo(AddAddressActivity.this,name,tel,place,note);
                if (isSaveSuccess){
                    Toast.makeText(AddAddressActivity.this,"保存成功",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(AddAddressActivity.this,"保存失败",Toast.LENGTH_SHORT).show();
                }
            }


//
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddAddressActivity.this,ShowAddressActivity.class);

                startActivityForResult(intent,1);
            }
        });

    }

}
