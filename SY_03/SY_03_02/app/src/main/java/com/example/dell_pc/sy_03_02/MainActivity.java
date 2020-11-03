package com.example.dell_pc.sy_03_02;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void onDialogClick(View v){
        TableLayout loginForm=(TableLayout)getLayoutInflater().inflate(R.layout.login,null);
        new AlertDialog.Builder(MainActivity.this)
                //.setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("ANOROIO APP")
                .setView(loginForm)
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        finish();//Exit Activity
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                }).create().show();
    }


}


