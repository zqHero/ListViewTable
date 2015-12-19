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
