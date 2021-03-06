package com.example.zheyutong;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * 
 * 圆角ListView
 *
 */
public class CornerListView extends ListView {

	public CornerListView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public CornerListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public CornerListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch(ev.getAction()){
        case MotionEvent.ACTION_DOWN:  
            int x = (int) ev.getX();  
            int y = (int) ev.getY();  
            int itemnum = pointToPosition(x, y);  
            if (itemnum == AdapterView.INVALID_POSITION)  
                break;  
            else {  
                if (itemnum == 0) {  
                    if (itemnum == (getAdapter().getCount() - 1)) {  
                        //只有一项  
                        setSelector(R.drawable.lv_only);  
                    } else {  
                        //第一项  
                        setSelector(R.drawable.lv_first);  
                    }  
                } else if (itemnum == (getAdapter().getCount() - 1))  
                    //最后一项  
                    setSelector(R.drawable.lv_last);  
                else {  
                    //中间项  
                    setSelector(R.drawable.lv_center);  
                }  
            }  
            break;  
        case MotionEvent.ACTION_UP:  
            break;  
        }

		
		return super.onInterceptTouchEvent(ev);
	}

}
