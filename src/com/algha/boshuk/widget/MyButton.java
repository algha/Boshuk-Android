package com.algha.boshuk.widget;

import com.algha.boshuk.App;
import com.algha.boshuk.util.Syntax;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class MyButton extends Button {
	
	private String NAME_SPACE = "http://schemas.android.com/apk/res/android";
	
	public MyButton(Context context) {
		super(context);
		initialize(null);
	}

	public MyButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(attrs);
	}

	public MyButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		initialize(attrs);
	}

	private void initialize(AttributeSet attrs) {
		if (attrs != null) {
			String textvalue = attrs.getAttributeValue(NAME_SPACE, "text");
			if (textvalue != null) {
				if (textvalue.startsWith("@")) {
					int textresid = attrs.getAttributeResourceValue(NAME_SPACE,"text", 0);
					textvalue = App.RESOURCES.getString(textresid);
				}
				setText(textvalue);
				setHint(textvalue);
			}
		}
		super.setTypeface(App.TYPE_FACE);
	}
	
	
	public void setText(String str) {
		super.setText(Syntax.getUyPFStr(str));
	}

	
}
