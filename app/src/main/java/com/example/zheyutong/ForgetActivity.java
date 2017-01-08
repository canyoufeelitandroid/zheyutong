package com.example.zheyutong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by 64088 on 2017/1/4.
 */

public class ForgetActivity extends Activity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getName();
    private ImageView iv_showCode;
    private EditText et_phoneCode;
    private EditText et_phoneNum;
    //产生的验证码
    private String realCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot);

        et_phoneCode = (EditText) findViewById(R.id.et_phoneCodes);
        Button but_toSetCode = (Button) findViewById(R.id.but_forgetpass_toSetCodes);
        but_toSetCode.setOnClickListener(this);
        iv_showCode = (ImageView) findViewById(R.id.iv_showCode);
        //将验证码用图片的形式显示出来
        iv_showCode.setImageBitmap(Code.getInstance().createBitmap());
        //生成验证码的小写值（用于对比确认）
        realCode = Code.getInstance().getCode().toLowerCase();
        iv_showCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_showCode:
                iv_showCode.setImageBitmap(Code.getInstance().createBitmap());
                realCode = Code.getInstance().getCode().toLowerCase();
                Log.v(TAG,"realCode"+realCode);
                break;
            case R.id.but_forgetpass_toSetCodes:
                String phoneCode = et_phoneCode.getText().toString().toLowerCase();
                String msg = "生成的验证码："+realCode+"输入的验证码:"+phoneCode;
                Toast.makeText(ForgetActivity.this,msg,Toast.LENGTH_LONG).show();

                if (phoneCode.equals(realCode)) {
                    Toast.makeText(ForgetActivity.this, phoneCode + "验证码正确", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(ForgetActivity.this,LogonActivity.class);
                    i.putExtra("account","taiz");
                    i.putExtra("password","12345");
                    ForgetActivity.this.setResult(RESULT_OK,i);

                    ForgetActivity.this.finish();

                } else {
                    Toast.makeText(ForgetActivity.this, phoneCode + "验证码错误", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}
