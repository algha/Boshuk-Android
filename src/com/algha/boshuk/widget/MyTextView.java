package com.algha.boshuk.widget;

import com.algha.boshuk.App;
import com.algha.boshuk.util.Syntax;
import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

public class MyTextView extends TextView {
	private String NAME_SPACE = "http://schemas.android.com/apk/res/android";

	public MyTextView(Context context) {
		super(context);
		initialize(null);
	}

	public MyTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(attrs);
	}

	public MyTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize(attrs);
	}

	private void initialize(AttributeSet attrs) {
		if (attrs != null) {
			String textvalue = attrs.getAttributeValue(NAME_SPACE, "text");
			if (textvalue != null) {
				Log.d("text", textvalue);
				if (textvalue.startsWith("@")) {
					int textresid = attrs.getAttributeResourceValue(NAME_SPACE,"text", 0);
					textvalue = App.RESOURCES.getString(textresid);
				}
				setText(textvalue);
			}
		}
		super.setTypeface(App.TYPE_FACE);
	}

	public void setText(String str) {
		super.setText(Syntax.getUyPFStr(str));
	}
	
	public void setHtmlText(String str) {
		super.setText(Html.fromHtml(Syntax.getUyPFStr(str)), TextView.BufferType.SPANNABLE);
	}
	
	
	public String getMyText(){
		return getText().toString();
	}
	
	public String getMyTag(){
		return getTag().toString();
	}
}
