package com.example.zheyutong;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Activity_Part1 extends Activity {
	
	private CornerListView lv1;
	private String[] mData={"渔船检验申报","图纸审查申报","产品检验申报"};
	private  List<HashMap<String,String>> data;
	private SimpleAdapter adapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.part_1);
		initData();
		lv1=(CornerListView)findViewById(R.id.part1_lv);
		adapter=new SimpleAdapter(Activity_Part1.this, data, R.layout.part_item, new String[] {"name"}, new int[] {R.id.part1_name});
		lv1.setAdapter(adapter);
		
	}


	private List<HashMap<String,String>> initData() {
		data=new ArrayList<HashMap<String,String>>();
		for(int i=0;i<mData.length;i++){
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("name", mData[i]);
		data.add(map);
		}
		return data;
	}
}
