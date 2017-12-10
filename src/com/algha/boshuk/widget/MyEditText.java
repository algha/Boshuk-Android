package com.algha.boshuk.widget;

import com.algha.boshuk.App;
import com.algha.boshuk.util.Syntax;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class MyEditText extends EditText {
	
	private String NAME_SPACE = "http://schemas.android.com/apk/res/android";
	
	public MyEditText(Context context) {
		super(context);
		initialize(null);
	}

	public MyEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(attrs);
	}

	public MyEditText(Context context, AttributeSet attrs, int defStyle) {
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
	
	
	
	public void setHint(String str) {
		super.setHint(Syntax.getUyPFStr(str));
	}
	
	
	
	
	public void setText(String str) {
		super.setText(Syntax.getUyPFStr(str));
	}

	public String getMyText(){
		return getText().toString();
	}
	
}
