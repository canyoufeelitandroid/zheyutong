package com.example.zheyutong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class BusinessProcess_Activity extends Activity {

	private WebView bpWeb;
	private String URL;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.business_process);
		bpWeb=(WebView)findViewById(R.id.bp_web);
		//获取传递过来的URL地址
		Intent i=getIntent();
		URL=i.getStringExtra("URL");
		//设置与JS的可交互性
		WebSettings settings = bpWeb.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setJavaScriptCanOpenWindowsAutomatically(true);
		
		//使页面自适应屏幕
		settings.setUseWideViewPort(true);  
		settings.setLoadWithOverviewMode(true); 
		//设置网页支持缩放
		settings.setBuiltInZoomControls(true);
		settings.setSupportZoom(true);
		
		//设置支持H5网页功能
		settings.setDomStorageEnabled(true);  
		bpWeb.loadUrl(URL);	
	}
}
