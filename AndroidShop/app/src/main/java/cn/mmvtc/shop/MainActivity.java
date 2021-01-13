package cn.mmvtc.shop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import cn.mmvtc.shop.database.CollectionHelper;
import cn.mmvtc.shop.database.SQLiteHelper;


public class MainActivity extends Activity {
    EditText textBox;//用于检索的搜索框
    TextView text;//记录文本
    private ListView mListView;
    SQLiteHelper mSQLiteHelper;
    CollectionHelper collectionHelper;
    String id;
    TextView Shopping_name, content;
    //商品名称与价格数据集合
    private String[] titles = {
            "Science科学刊物", "百年孤独", "NIKE运动鞋", "Adidas运动鞋", "格子衬衣",
            "时尚鸭舌帽", "MAC化妆包", "连线耳机"
    };
    private String[] prices = {
            "40", "50", "288", "388", "666", "120", "150", "68"
    };
    //图片数据集合
    private int[] icons = {R.drawable.science, R.drawable.alone, R.drawable.nike, R.drawable.adidas,
            R.drawable.shirt, R.drawable.cap, R.drawable.mac, R.drawable.headset};
    private android.view.LayoutInflater LayoutInflater;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBox = (EditText) findViewById(R.id.textBox);//初始化搜素框
        text = (TextView) findViewById(R.id.text);//初始化文本
        ImageView car = (ImageView) findViewById(R.id.car);
        ImageView my = (ImageView) findViewById(R.id.my);
        mListView = (ListView) findViewById(R.id.lv);//初始化ListView控件
        //MybaseAdapter mAdapter =new MybaseAdapter();//
        final MybaseAdapter mAdapter = new MybaseAdapter(titles, prices, icons);//
        mSQLiteHelper = new SQLiteHelper(this);
        collectionHelper = new CollectionHelper(this);
        mListView.setAdapter(mAdapter);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShoppinglistActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PersonActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        //新增了查询框改变相应函数
        textBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mAdapter.getFilter().filter(s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                mAdapter.getFilter().filter(s);
            }
        });
        initData();
    }

    protected void initData() {
//        mSQLiteHelper=new SQLiteHelper(this);
//        Shopping_name.setText("购物车");
    }

    class MybaseAdapter extends BaseAdapter {

        private MyFilter mFilter;//初始化查找函数
        //必须存放两个String[]类型数据，一个保存原始数据，一个用来展示过滤后的数据
        private String[] item;
        private String[] prices;
        private int[] icons;
        private String[] displayItem;
        private String[] displayprices;
        private int[] displayicons;

        //得到Item的View视图
        class ViewHolder {
            TextView title, price;
            ImageView iv;
            Button addshop;
            TextView addcollection;


        }

        //初始化函数
        public MybaseAdapter(String[] item, String[] item2, int[] item3) {
            super();
            this.item = item;
            displayItem = item;
            this.prices = item2;
            this.displayprices = item2;
            this.icons = item3;
            this.displayicons = item3;
        }

        //因为要展示的是过滤后的数据，所以是displayItem的一些属性
        @Override
        public int getCount() {
            return displayItem.length;
        }

        @Override
        public String getItem(int position) {
            return displayItem[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = View.inflate(MainActivity.this, R.layout.goods_item, null);
                holder = new ViewHolder();
                holder.title = convertView.findViewById(R.id.title);
                holder.price = convertView.findViewById(R.id.price);
                holder.iv = convertView.findViewById(R.id.iv);
                holder.addcollection = convertView.findViewById(R.id.addCollection);
                holder.addshop = convertView.findViewById(R.id.addshop);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.addshop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean n = mSQLiteHelper.insertData(titles[position], prices[position], icons[position]);
                    if (n) {
                        Toast.makeText(MainActivity.this, "加入购物车成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "加入购物车失败", Toast.LENGTH_SHORT).show();
                    }


                }
            });
            holder.addcollection.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean n = collectionHelper.insertData(titles[position], prices[position], icons[position]);
                    if (n) {
                        Toast.makeText(MainActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "收藏失败", Toast.LENGTH_SHORT).show();
                    }

                }
            });
            holder.title.setText(displayItem[position]);
            holder.price.setText(displayprices[position]);
            holder.iv.setBackgroundResource(displayicons[position]);
            return convertView;
        }

        //返回过滤器
        public MyFilter getFilter() {
            if (mFilter == null) {
                mFilter = new MyFilter();
            }
            return mFilter;
        }

        //新增内部类MyFilter
        class MyFilter extends Filter {
            @Override
            protected FilterResults performFiltering(CharSequence prefix) {
                FilterResults results = new FilterResults();

                if (prefix == null || prefix.length() == 0) {
                    results.values = item;

                    results.count = item.length;
                } else {
                    String prefixString = prefix.toString();

                    final ArrayList<String> newValues = new ArrayList<String>();

                    for (int i = 0; i < item.length; i++) {
                        final String value = item[i];


                        //value.equals(prefixString)
                        if (value.indexOf(prefixString) >= 0) {//我这里的规则就是筛选出和prefix模糊匹配的元素
                            newValues.add(value);

                        }
                    }

                    results.values = (String[]) newValues.toArray(new String[newValues.size()]);
                    results.count = newValues.size();
                }

                return results;
            }

            //完成接口方法
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                String[] test = (String[]) results.values;
                String[] new1 = new String[results.count];
                String[] new2 = new String[results.count];
                int[] new3 = new int[results.count];
                for (int i = 0; i < test.length; i++) {

                    for (int j = 0; j < item.length; j++) {
                        if (test[i].equals(item[j])) {
                            new1[i] = item[j];
                            new2[i] = prices[j];
                            new3[i] = icons[j];
                        }
                    }

                }
                displayItem = new1;
                displayprices = new2;
                displayicons = new3;

                if (results.count > 0) {
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        }


    }
}
