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

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ImageView back = findViewById(R.id.iv_registeractivity_back);
        final ImageView showCode = findViewById(R.id.iv_registeractivity_showCode);
        showCode.setImageBitmap(Code.getInstance().createBitmap());
        final String[] realCode = {Code.getInstance().getCode().toLowerCase()};

        Button registe = findViewById(R.id.bt_registeractivity_register);



       showCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showCode.setImageBitmap(Code.getInstance().createBitmap());
                realCode[0] = Code.getInstance().getCode();
//                et_username.setText(realCode[0]);



            }
        });

        registe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_username = findViewById(R.id.et_registeractivity_username);
                EditText et_password = findViewById(R.id.et_registeractivity_password1);
                EditText et_ensurepassword = findViewById(R.id.et_registeractivity_password2);
                EditText et_code = findViewById(R.id.et_registeractivity_phoneCodes);

                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                String ensurepassword = et_ensurepassword.getText().toString();
                String code = et_code.getText().toString();
                if(TextUtils.isEmpty(username)){
                    Toast.makeText(RegisterActivity.this,"请输入用户名!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this,"请输入密码!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!password.equals(ensurepassword)){
                    Toast.makeText(RegisterActivity.this,"两次输入的密码不符!",Toast.LENGTH_SHORT).show();
                    return;
                }
//                if(!realCode[0].equals(code)){
//                    Toast.makeText(RegisterActivity.this,"验证码有误!",Toast.LENGTH_SHORT).show();
//                    return;
//                }
//        保存用户信息
                boolean isSaveSuccess = (boolean) SPSaveInfo.saveUserInfo(RegisterActivity.this,username,password);
                if (isSaveSuccess){
                    try {
                        Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else {
                    Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });



    }

}
