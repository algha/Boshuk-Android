package com.algha.boshuk.widget;

import com.algha.boshuk.App;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;

public class Header extends RelativeLayout {
	
	public MyTextView leftTextButton;
	private OnClickListener listener;

	public Header(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		setBackgroundColor(Color.parseColor("#ff4965"));
		setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
	}
	
	public Header(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public Header(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public void setTextTitle(String title) {
		MyTextView textView = new MyTextView(getContext());
		textView.setText(title);
		textView.setTextSize(14);
		textView.setGravity(Gravity.CENTER);
		textView.setTextColor(Color.parseColor("#ffffff"));
		addView(textView);
		
		RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)textView.getLayoutParams();
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
		textView.setLayoutParams(layoutParams);
	}
	
	public void setImageTitle() {
		
	}

	public void setIconTite() {
		
	}
	
	public void setLeftTextButton(String text){
		leftTextButton = new MyTextView(getContext());
		leftTextButton.setText(text);
		leftTextButton.setId(3);
		leftTextButton.setTextSize(10);
		leftTextButton.setGravity(Gravity.CENTER);
		addView(leftTextButton);
		
		RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)leftTextButton.getLayoutParams();
		layoutParams.leftMargin = App.getPixelFromDp(5);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
		leftTextButton.setLayoutParams(layoutParams);
		
		if (listener != null) {
			leftTextButton.setOnClickListener(listener);
		}
	}
	
	public void setLeftButton(int Resource){
		ImageButton button = new ImageButton(getContext());
		button.setImageResource(Resource);
		button.setScaleType(ScaleType.FIT_CENTER);
		button.setPadding(5, 10, 5, 10);
		button.setId(2);
		button.setBackgroundColor(Color.TRANSPARENT);
		addView(button);
		
		RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)button.getLayoutParams();
		layoutParams.leftMargin = App.getPixelFromDp(5);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
		button.setLayoutParams(layoutParams);
		
		if (listener != null) {
			button.setOnClickListener(listener);
		}
	}
	
	public void setRightButton(int Resource){
		ImageButton button = new ImageButton(getContext());
		button.setScaleType(ScaleType.FIT_CENTER);
		button.setPadding(5, 10, 5, 10);
		button.setId(1);
		button.setImageResource(Resource);
		button.setBackgroundColor(Color.TRANSPARENT);
		addView(button);
		
		RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)button.getLayoutParams();
		layoutParams.rightMargin = App.getPixelFromDp(5);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
		layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
		button.setLayoutParams(layoutParams);
		
		if (listener != null) {
			button.setOnClickListener(listener);
		}
	}
	
	public void setListener(OnClickListener mListener) {
		listener = mListener;
	}
}
