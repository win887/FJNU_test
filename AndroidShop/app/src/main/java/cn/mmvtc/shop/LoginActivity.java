package cn.mmvtc.shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    String input_name;
    String input_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final TextView regist = findViewById(R.id.tv_loginactivity_register);
        Button login = findViewById(R.id.bt_loginactivity_login);


        Map<String,String> userInfo = SPSaveInfo.getUserInfo(this);
        final String exit_password = userInfo.get("password");


        System.out.println(input_name);
        System.out.println(input_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_username = findViewById(R.id.et_loginactivity_username);
                EditText et_password = findViewById(R.id.et_loginactivity_password);

                input_name = et_username.getText().toString();
                input_password = et_password.getText().toString();

                if(TextUtils.isEmpty(input_name)){
                    System.out.println(input_name);
                    Toast.makeText(LoginActivity.this,"请输入用户名!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(input_password)){
                    System.out.println(input_password);
                    Toast.makeText(LoginActivity.this,"请输入密码!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (input_password.equals(exit_password)){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this,"用户名/密码错误!",Toast.LENGTH_SHORT).show();
                }

            }
        });


        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });


    }

}
