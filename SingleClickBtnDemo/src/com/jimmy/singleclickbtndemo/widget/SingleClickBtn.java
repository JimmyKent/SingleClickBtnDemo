package com.jimmy.singleclickbtndemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class SingleClickBtn extends Button {
	private long mLastTime = 0L;
	private final int TIME_GAP = 1000;//ms
	
	public SingleClickBtn(Context context) {
		super(context);
	}

	public SingleClickBtn(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public SingleClickBtn(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

@Override
public boolean onTouchEvent(MotionEvent event) {
	switch (event.getAction()) {
	case MotionEvent.ACTION_DOWN:
		long current_time = System.currentTimeMillis();
		long d_time = current_time - mLastTime;
		if (d_time < TIME_GAP) {
			mLastTime = current_time;
			return true;
		} else {
			mLastTime = current_time;
		}
		break;
	}
	return super.onTouchEvent(event);
}

}
