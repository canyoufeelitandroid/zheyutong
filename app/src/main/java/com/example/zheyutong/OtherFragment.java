package com.example.zheyutong;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OtherFragment extends android.support.v4.app.Fragment  implements OnClickListener{
	private Button finishBtn;
	private CornerListView other_lv;
	private SimpleAdapter adapter;
	private String[] mData={"修改密码","我的待办","版本信息"};
	private List<HashMap<String, String>> list;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.other_fragment, container, false);
		finishBtn=(Button)view.findViewById(R.id.finishBtn);
		other_lv=(CornerListView)view.findViewById(R.id.other_lv);
		init();
		adapter=new SimpleAdapter(getActivity(), list, R.layout.part_item, new String[] {"name"}, new int[] {R.id.part1_name});
		other_lv.setAdapter(adapter);
		finishBtn.setOnClickListener(this);
		
		return view;
	}

	private void init() {
		list=new ArrayList<HashMap<String,String>>();
		for(int i=0;i<mData.length;i++){
			HashMap<String,String> map=new HashMap<String,String>();
			map.put("name", mData[i]);
			list.add(map);
		}
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.finishBtn:
			Intent l_intent=new Intent(getActivity(),LogonActivity.class);
			getActivity().startActivity(l_intent);
			//getActivity().finish();
			break;
		default:
			break;
		}
		
	}
}
