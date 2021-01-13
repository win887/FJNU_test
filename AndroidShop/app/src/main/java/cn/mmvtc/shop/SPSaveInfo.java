package cn.mmvtc.shop;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class SPSaveInfo {

    //    ============================存储用户资料=====================================

    public static boolean saveUserInfo(Context context, String username, String password){
        SharedPreferences sp = context.getSharedPreferences("user",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username",username);
        editor.putString("password",password);

        editor.commit();
        return true;
    }
    public static Map<String,String> getUserInfo(Context context){
        SharedPreferences sp = context.getSharedPreferences("user",Context.MODE_PRIVATE);
        String username = sp.getString("username",null);
        String password = sp.getString("password",null);

        Map<String,String> userMap = new HashMap<String, String>();
        userMap.put("username",username);
        userMap.put("password",password);

        return userMap;
    }


    //    ============================存储地址信息=====================================

    //    保存收货人姓名、联系方式、地址、备注到address.xml文件中
    public static boolean saveAddressInfo(Context context, String name, String tel,String place,String note){
        SharedPreferences sp = context.getSharedPreferences("address",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name",name);
        editor.putString("tel",tel);
        editor.putString("place",place);
        editor.putString("note",note);
        editor.commit();
        return true;
    }
    //    从address.xml文件中获取存储的收货人姓名、联系方式、地址、备注
    public static Map<String,String> getAddressInfo(Context context){
        SharedPreferences sp = context.getSharedPreferences("address",Context.MODE_PRIVATE);
        String name = sp.getString("name",null);
        String tel = sp.getString("tel",null);
        String place = sp.getString("place",null);
        String note = sp.getString("note",null);
        Map<String,String> addressMap = new HashMap<String, String>();
        addressMap.put("name",name);
        addressMap.put("tel",tel);
        addressMap.put("place",place);
        addressMap.put("note",note);
        return addressMap;
    }


    //=======================================================
    public static boolean saveProfileInfo(Context context, String nicheng, String qianming){
        SharedPreferences sp = context.getSharedPreferences("profile",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("nicheng",nicheng);
        editor.putString("qianming",qianming);

        editor.commit();
        return true;
    }
    public static Map<String,String> getProfileInfo(Context context){
        SharedPreferences sp = context.getSharedPreferences("profile",Context.MODE_PRIVATE);
        String nicheng = sp.getString("nicheng",null);
        String qianming = sp.getString("qianming",null);

        Map<String,String> profileMap = new HashMap<String, String>();
        profileMap.put("nicheng",nicheng);
        profileMap.put("qianming",qianming);

        return profileMap;
    }


}
