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

public class EditProfile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        ImageView back=(ImageView) findViewById(R.id.go_back);
        Button saveEdit= findViewById(R.id.edit_save);

        saveEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editNicheng = findViewById(R.id.et_nicheng);
                EditText editNote = findViewById(R.id.et_note);

                //        当单机登录按钮时，获取昵称和备注
                String nicheng = editNicheng.getText().toString().trim();
                String qianming = editNote.getText().toString().trim();

//        检查信息输入是否正确
                if(TextUtils.isEmpty(nicheng)){
                    Toast.makeText(EditProfile.this,"请输入昵称",Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(EditProfile.this,"资料编辑成功",Toast.LENGTH_SHORT).show();
//        保存用户信息
                boolean isSaveSuccess = (boolean) SPSaveInfo.saveProfileInfo(EditProfile.this,nicheng,qianming);
                if (isSaveSuccess){
                    Toast.makeText(EditProfile.this,"保存成功",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(EditProfile.this,"保存失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(EditProfile.this,PersonActivity.class);
                startActivity(intent);

            }



        });

    }

}
