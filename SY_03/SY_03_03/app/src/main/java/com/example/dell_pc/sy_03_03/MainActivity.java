package com.example.dell_pc.sy_03_03;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private static final int FONT_10 = 0x111;
    private static final int FONT_16 = 0x114;
    private static final int FONT_20= 0x115;
    private static final int PLAIN_ITEM = 0x11b;
    private static final int FONT_RED = 0x116;
    private static final int FONT_DARK = 0x117;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.test);
    }
    @Override public boolean onCreateOptionsMenu(Menu menu)
    {
        SubMenu fontMenu = menu.addSubMenu("字体大小");
        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0, FONT_10, 0, "小");
        fontMenu.add(0, FONT_16, 0, "中");
        fontMenu.add(0, FONT_20, 0, "大");
        menu.add(0, PLAIN_ITEM, 0, "普通菜单项");
        SubMenu colorMenu = menu.addSubMenu("字体颜色");
        colorMenu.setHeaderTitle("选择文字颜色");
        colorMenu.add(0, FONT_RED, 0, "红色");
        colorMenu.add(0, FONT_DARK, 0, "黑色");
        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem mi)
    {
        // 判断单击的是哪个菜单项，并有针对性地做出响应
        switch (mi.getItemId())
        {
            case FONT_10: text.setTextSize(10 * 2);	break;
            case FONT_16: text.setTextSize(16 * 2); break;
            case FONT_20: text.setTextSize(20 * 2); break;
            case FONT_RED: text.setTextColor(getResources().getColor(R.color.colorRed)); break;
            case FONT_DARK: text.setTextColor(getResources().getColor(R.color.colorDark)); break;
            case PLAIN_ITEM:
                Toast.makeText(MainActivity.this,
                        "您单击了普通菜单项", Toast.LENGTH_SHORT)
                        .show();
                break;
        }
        return true;
    }
}
