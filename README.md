Android中使用listView绘制表格实例：

一.效果图：

![这里写图片描述](http://img.blog.csdn.net/20151219102937100?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)


二，创建步骤：

1，创建布局：
activity_main中的布局：
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_margin="3dip"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >
    
     <View 
        android:layout_width="match_parent"
        android:layout_height="1dip"
        android:background="#A7A5A5"/>
    <!--调用外部控件的布局list_item布局。--!>
    <include 
        layout="@layout/list_item"
        android:id="@+id/table_title"/>
    
    <View 
        android:layout_width="match_parent"
        android:layout_height="1.5dip"
        android:background="#686867"/>

    <ListView
        android:id="@+id/list"
        android:divider="#B4B3B3"
        android:dividerHeight="1.0dip"
        android:scrollbars="none"
        android:background="@drawable/listview_bg"
        android:cacheColorHint="@android:color/transparent"
        android:fadingEdge="none"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content" >
    </ListView>

</LinearLayout>

2，创建list_item布局：
<?xml version="1.0" encoding="UTF-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal"
    android:layout_width="fill_parent"
    android:layout_height="wrap_content" >

    <TextView
        android:id="@+id/text_id"
        android:layout_width="0dip"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:gravity="center"
        android:paddingBottom="10dip"
        android:paddingTop="10dip"
        android:textColor="#000000"
        android:textSize="15sp"
        android:singleLine="true"
        android:text="序号" />
    
    <View 
        android:layout_width="1.5dip"
        android:layout_height="fill_parent"
        android:background="#B4B3B3"/>

    <TextView
        android:id="@+id/text_goods_name"
        android:layout_width="0dip"
        android:layout_height="wrap_content"
        android:layout_weight="3"
        android:paddingBottom="10dip"
        android:paddingTop="10dip"
        android:textColor="#000000"
        android:textSize="15sp"
        android:singleLine="true"
        android:gravity="center"
        android:text="商品名称" />
    
     <View 
        android:layout_width="1.5dip"
        android:layout_height="fill_parent"
        android:background="#B4B3B3"/>

     <TextView
        android:id="@+id/text_codeBar"
        android:layout_width="0dip"
        android:layout_height="wrap_content"
        android:layout_weight="2"
        android:paddingBottom="10dip"
        android:textColor="#000000"
        android:paddingTop="10dip"
        android:singleLine="true"
        android:textSize="15sp"
        android:gravity="center"
        android:text="条形码" />
     
     <View 
        android:layout_width="1.5dip"
        android:layout_height="fill_parent"
        android:background="#B4B3B3"/>

     <TextView
        android:id="@+id/text_num"
        android:layout_width="0dip"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:paddingBottom="10dip"
        android:paddingTop="10dip"
        android:textColor="#000000"
        android:singleLine="true"
        android:textSize="15sp"
        android:gravity="center"
        android:text="数量" />
     
     <View 
        android:layout_width="1.5dip"
        android:layout_height="fill_parent"
        android:background="#B4B3B3"/>

     <TextView
        android:id="@+id/text_curPrice"
        android:layout_width="0dip"
        android:layout_height="wrap_content"
        android:layout_weight="1.5"
        android:paddingBottom="10dip"
        android:textColor="#000000"
        android:textSize="15sp"
        android:singleLine="true"
        android:paddingTop="10dip"
        android:gravity="center"
        android:text="现价" />
     
     <View 
        android:layout_width="1.5dip"
        android:layout_height="fill_parent"
        android:background="#B4B3B3"/>

     <TextView
        android:id="@+id/text_money"
        android:layout_width="0dip"
        android:layout_height="wrap_content"
        android:layout_weight="1.5"
        android:paddingBottom="10dip"
        android:singleLine="true"
        android:textSize="15sp"
        android:textColor="#000000"
        android:paddingTop="10dip"
        android:gravity="center"
        android:text="金额" />

</LinearLayout>

3，适配器中内容：
TableAdapter:
package com.example.listviewtable;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class TableAdapter extends BaseAdapter {
	
	private List<Goods> list;
	private LayoutInflater inflater;
	
	public TableAdapter(Context context, List<Goods> list){
		this.list = list;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		int ret = 0;
		if(list!=null){
			ret = list.size();
		}
		return ret;
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Goods goods = (Goods) this.getItem(position);
		
		ViewHolder viewHolder;
		
		if(convertView == null){
			
			viewHolder = new ViewHolder();
			
			convertView = inflater.inflate(R.layout.list_item, null);
			viewHolder.goodId = (TextView) convertView.findViewById(R.id.text_id);
			viewHolder.goodName = (TextView) convertView.findViewById(R.id.text_goods_name);
			viewHolder.goodCodeBar = (TextView) convertView.findViewById(R.id.text_codeBar);
			viewHolder.goodNum = (TextView) convertView.findViewById(R.id.text_num);
			viewHolder.goodCurrPrice = (TextView) convertView.findViewById(R.id.text_curPrice);
			viewHolder.goodMoney = (TextView) convertView.findViewById(R.id.text_money);
			
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		viewHolder.goodId.setText(goods.getId());
		viewHolder.goodId.setTextSize(13);
		viewHolder.goodName.setText(goods.getGoodsName());
		viewHolder.goodName.setTextSize(13);
		viewHolder.goodCodeBar.setText(goods.getCodeBar());
		viewHolder.goodCodeBar.setTextSize(13);
		viewHolder.goodNum.setText(goods.getNum()+"");
		viewHolder.goodNum.setTextSize(13);
		viewHolder.goodCurrPrice.setText(goods.getCurPrice()+"");
		viewHolder.goodCurrPrice.setTextSize(13);
		viewHolder.goodMoney.setText(goods.getMoney()+"");
		viewHolder.goodMoney.setTextSize(13);
		
		return convertView;
	}
	
	public static class ViewHolder{
		public TextView goodId;
		public TextView goodName;
		public TextView goodCodeBar;
		public TextView goodNum;
		public TextView goodCurrPrice;
		public TextView goodMoney;
	}
	
}

4，Activity中内容：
package com.example.listviewtable;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;

public class ListTableActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//设置表格标题的背景颜色
		ViewGroup tableTitle = (ViewGroup) findViewById(R.id.table_title);
		tableTitle.setBackgroundColor(Color.rgb(177, 173, 172));
		
		List<Goods> list = new ArrayList<Goods>();
		list.add(new Goods("01", "伊利婴儿加盖奶粉110ml", "982323423232",34,23,23));
		list.add(new Goods("02", "鱼翅", "31312323223",34,23,23));
		list.add(new Goods("03", "农夫山泉", "12",34,23,23));
		list.add(new Goods("04", "飞天茅台0", "12333435445",34,23,23));
		list.add(new Goods("05", "农家小菜", "34523",34,23,23));
		list.add(new Goods("06", "飞天消费菜", "345456",34,23,23));
		list.add(new Goods("07", "旺仔小牛奶", "2344",34,23,23));
		list.add(new Goods("08", "旺旺", "23445",34,23,23));
		list.add(new Goods("09", "达利园超时牛奶", "3234345",34,23,23));
		
		ListView tableListView = (ListView) findViewById(R.id.list);
		
		TableAdapter adapter = new TableAdapter(this, list);
		
		tableListView.setAdapter(adapter);
	}

}

5，实体类：
商品信息内容：
package com.example.listviewtable;

public class Goods {
	private String id;
	private String goodsName;
	private String codeBar;
	private float num;
	private float curPrice;
	private float money;
	
	public Goods() {
		super();
	}

	public Goods(String id, String goodsName, String codeBar, float num,
			float curPrice, float money) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.codeBar = codeBar;
		this.num = num;
		this.curPrice = curPrice;
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getCodeBar() {
		return codeBar;
	}

	public void setCodeBar(String codeBar) {
		this.codeBar = codeBar;
	}

	public float getNum() {
		return num;
	}

	public void setNum(float num) {
		this.num = num;
	}

	public float getCurPrice() {
		return curPrice;
	}

	public void setCurPrice(float curPrice) {
		this.curPrice = curPrice;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}
			
}

DEMO地址：https://github.com/zqHero/ListViewTable
