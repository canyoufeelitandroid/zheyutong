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
		//��ȡ���ݹ�����URL��ַ
		Intent i=getIntent();
		URL=i.getStringExtra("URL");
		//������JS�Ŀɽ�����
		WebSettings settings = bpWeb.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setJavaScriptCanOpenWindowsAutomatically(true);
		
		//ʹҳ������Ӧ��Ļ
		settings.setUseWideViewPort(true);  
		settings.setLoadWithOverviewMode(true); 
		//������ҳ֧������
		settings.setBuiltInZoomControls(true);
		settings.setSupportZoom(true);
		
		//����֧��H5��ҳ����
		settings.setDomStorageEnabled(true);  
		bpWeb.loadUrl(URL);	
	}
}
