package cn.mmvtc.shop.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.mmvtc.shop.MainActivity;
import cn.mmvtc.shop.R;
import cn.mmvtc.shop.ShoppinglistActivity;
import cn.mmvtc.shop.bean.ShoppingBean;


public class ShoppingAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<ShoppingBean> list;
    public ShoppingAdapter(Context context, List<ShoppingBean> list){
        this.layoutInflater=LayoutInflater.from(context);
        this.list=list;
    }
    @Override
    public  int getCount(){
        return list==null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }
    @Override
    public long getItemId(int position){
        return  position;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder  viewHolder;
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.shopping_item,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
//        viewHolder.buy.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                //System.out.println("aa");
//
//            }
//        });
        ShoppingBean ShoppingInfo = (ShoppingBean) getItem(position);
        viewHolder.tvShoppingTitle.setText(ShoppingInfo.getShoppingTitle());
        viewHolder.tvShoppingPrice.setText(ShoppingInfo.getShoppingPrice());
        viewHolder.ivImg.setBackgroundResource(ShoppingInfo.getImg());
        return convertView;
    }
    class ViewHolder{
        TextView tvShoppingTitle;
        TextView tvShoppingPrice;
        ImageView ivImg;
        //Button buy;
        public ViewHolder(View view){
            tvShoppingTitle=(TextView) view.findViewById(R.id.item_title);
            tvShoppingPrice=(TextView) view.findViewById(R.id.item_price);
            ivImg = view.findViewById(R.id.iv_img);
            //buy=(Button) view.findViewById(R.id.toBuy);
        }
    }
}
