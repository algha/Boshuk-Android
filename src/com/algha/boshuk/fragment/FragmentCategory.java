package com.algha.boshuk.fragment;

import com.algha.boshuk.R;
import com.algha.boshuk.activity.ActivityCategory;
import com.algha.boshuk.adapter.CategoryAdapter;
import com.algha.boshuk.widget.Header;
import com.algha.boshuk.widget.MyGridView;
import com.algha.boshuk.widget.MyTextView;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class FragmentCategory extends Fragment {

	private LinearLayout rootView,category;
	private Activity context;
	private MyTextView cat_info;
	private MyGridView gridView;
	private CategoryAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = (LinearLayout)inflater.inflate(R.layout.fragment_category, null); 
		return rootView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		context = getActivity();
		
		InitalizationView();
		
		Initalization();
		
	}

	private void Initalization() {
		// TODO Auto-generated method stub
		String[] cat = {"سۈت پاراشوگ","تېرە ئاسراش","ئۇششاق چۈششەك","سۈت پاراشوگ","ھامىلدار","سۈت پاراشوگ","سۈت پاراشوگ","سۈت پاراشوگ"};
		for (String string : cat) {
			MyTextView textView = new MyTextView(context);
			textView.setGravity(Gravity.CENTER);
			textView.setOnClickListener(new clickListener());
			textView.setText(string);
			textView.setTextSize(11);
			textView.setId(111);
			textView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
			textView.setPadding(0, 15, 0, 15);
			category.addView(textView);
		}
	}

	private void InitalizationView() {
		// TODO Auto-generated method stub
		LinearLayout titleLayout = (LinearLayout)rootView.findViewById(R.id.title);
		Header header = new Header(context);
		header.setTextTitle("تۈرلەر");
		header.setLeftButton(R.drawable.message);
		header.setRightButton(R.drawable.search);
		titleLayout.addView(header);
		
		category = (LinearLayout)rootView.findViewById(R.id.category);
		
		cat_info = (MyTextView)rootView.findViewById(R.id.cat_info);
		cat_info.setText("ئانا سۈتى بېرىشىڭىزنى تەۋسىيە قىلىمىز");
		
		gridView = (MyGridView)rootView.findViewById(R.id.goods);
		adapter = new CategoryAdapter(context,10);
		gridView.setAdapter(adapter);
	}

	public class clickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case 111:
				Intent intent = new Intent(context,ActivityCategory.class);
				startActivity(intent);
				break;

			default:
				break;
			}
		}
		
	}
}
