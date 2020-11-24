# FJNU_test
SY_04 自定义 WebView 验证隐式 Intent 的使用
通过自定义WebView加载URL来验证隐式Intent的使用。

# 流程说明

在第一个工程中编写EditText获取URL并使用按钮发起Intent访问请求

```
<EditText    
android:layout_width="match_parent"    
android:layout_height="wrap_content"    
android:textSize="20sp"    android:hint="输入网址"    
android:layout_weight="1"    
android:id="@+id/editText"    />

<Button    
android:layout_width="wrap_content"    
android:layout_height="wrap_content"    
android:text="访问"    
android:id="@+id/button"
        />
```

运行效果

![QQ图片20201124171622.png](https://i.loli.net/2020/11/24/4icXzbSkjCdyqFe.png)

在第二个工程中自定义WebView来加载URL

在AndroidManifest设置隐式响应Intent的调用

```
<intent-filter>    
<action android:name="android.intent.action.VIEW" />    
<category android:name="android.intent.category.DEFAULT" />    
<category android:name="android.intent.category.BROWSABLE"/>    
<data android:scheme="http" />
</intent-filter>
```

将模拟器的默认浏览器改为webview

![QQ图片20201124171703.png](https://i.loli.net/2020/11/24/HoiIe3qGmKgJf7j.png)

发起访问请求在自定义的webview中打开

![QQ图片20201124171708.png](https://i.loli.net/2020/11/24/Tojw9DLU8AxqEBS.png)