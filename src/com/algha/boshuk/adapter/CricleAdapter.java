package com.algha.boshuk.adapter;

import java.util.ArrayList;
import com.algha.boshuk.R;
import com.algha.boshuk.widget.MyTextView;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CricleAdapter extends BaseAdapter {
	private ArrayList<String> list;
	private Activity activity;

	public CricleAdapter(Activity activity) {
		super();
		list = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			list.add("this is str: " + i);
		}
		this.activity = activity;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static class ViewHolder {
		public ImageView avatar;
		public LinearLayout content;
		public MyTextView follow_button;
		public MyTextView name;
		public MyTextView time_place;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder view;
		LayoutInflater inflator = activity.getLayoutInflater();

		if (convertView == null) {
			view = new ViewHolder();
			convertView = inflator.inflate(R.layout.layout_cricle_item, null);
			
			view.avatar = (ImageView) convertView.findViewById(R.id.avatar);
			view.follow_button = (MyTextView) convertView.findViewById(R.id.follow_button);
			view.name = (MyTextView) convertView.findViewById(R.id.name);
			view.time_place = (MyTextView) convertView.findViewById(R.id.time_place);
			
			view.content = (LinearLayout) convertView.findViewById(R.id.content);
			
			convertView.setTag(view);
		} else {
			view = (ViewHolder) convertView.getTag();
			view.content.removeAllViews();
		}
		view.follow_button.setText("ئەگەشكەن");
		view.name.setText("ئائىشە مۇھەممەد");
		view.time_place.setText("01-17 12:10 شىنجاڭ ئۈرۈمچى");
		
		view.content.addView(setTextView("ئەمدى ياپۇنىيەگە ئىچىم ئاغرىپ قىلىۋاتىدۇيا  .  ئەمەلىيەتتە تەڭسىز شەرتنامە ئەمەسكەنغۇ  ئۇ  . چىدىماسلىق دىسە مۇشۇنى دىسە بولىدىكەن ئەمدى ياپۇنىيەگە ئىچىم ئاغرىپ قىلىۋاتىدۇيا  .  ئەمەلىيەتتە تەڭسىز شەرتنامە ئەمەسكەنغۇ  ئۇ  . چىدىماسلىق دىسە مۇشۇنى دىسە بولىدىكەن "));
		
		
		return convertView;
	}
	
	public MyTextView setTextView(String text) {
		MyTextView textView = new MyTextView(activity);
		textView.setText(text);
		textView.setTextSize(14);
		textView.setGravity(Gravity.RIGHT);
		textView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		return textView;
	}
}
