package com.algha.boshuk.fragment;

import java.util.ArrayList;
import com.algha.boshuk.R;
import com.algha.boshuk.activity.ActivityAdvice;
import com.algha.boshuk.activity.ActivityBook;
import com.algha.boshuk.activity.ActivityGame;
import com.algha.boshuk.activity.ActivityKnowlege;
import com.algha.boshuk.activity.ActivityPerhiz;
import com.algha.boshuk.adapter.BilimdanAdapter;
import com.algha.boshuk.widget.Header;
import com.algha.boshuk.widget.MyListView;
import com.algha.boshuk.widget.MyTextView;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class FragmentKnowlege extends Fragment {

	private LinearLayout rootView;
	private Activity context;
	//private ScrollView parent_scroll;
	private ArrayList<Pair<String, String>> category;
	private LinearLayout category_list;
	private MyListView listView;
	private BilimdanAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = (LinearLayout)inflater.inflate(R.layout.fragment_knowlege, null); 
		return rootView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		context = getActivity();
		

		category = new ArrayList<Pair<String,String>>();
		category.add(0, new Pair<String, String>("1", "بارلىق"));
		category.add(0, new Pair<String, String>("1", "تەۋسىيەلىك"));
		category.add(0, new Pair<String, String>("1", "تۇرمۇش يىتەكچىسى"));
		category.add(0, new Pair<String, String>("1", "ھامىلدارلىق"));
		category.add(0, new Pair<String, String>("1", "قوشۇمچە"));
				
		InitalizationView();
		
		Initalization();
	}

	private void Initalization() {
		// TODO Auto-generated method stub
		for (int i = 0; i < category.size(); i++) {
			
			Pair<String, String> p = category.get(i);
			
			MyTextView textView = new MyTextView(context);
			textView.setText(p.second);
			textView.setGravity(Gravity.CENTER);
			textView.setTextSize(10);
			textView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT));
			textView.setPadding(20, 10, 20, 10);
			textView.setId(111);
			textView.setOnClickListener(new clickListener());
			category_list.addView(textView);
		}
		
		
	}
	
	private void InitalizationView() {
		// TODO Auto-generated method stub
		LinearLayout titleLayout = (LinearLayout)rootView.findViewById(R.id.title);
		Header header = new Header(context);
		header.setListener(new clickListener());
		header.setTextTitle("بىلىمدان");
		header.setRightButton(R.drawable.search);
		titleLayout.addView(header);
		
		rootView.findViewById(R.id.book).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.game).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.perhiz).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.haletlirim).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.advice).setOnClickListener(new clickListener());
		
		setText(R.id.q_title,"بالىلارنىڭ دەسلەپكى پىسخىكىسى");
		setText(R.id.q_name_type,"<font color='#000000' size='18px'>ئامىنە دوختۇر</font>(ئىككىنچى دەرىجىلىك بالىلار بۆلىمى)");
		setText(R.id.q_content,"بالىلارنىڭ دەسلەپكى پىسخىكا ساۋات بويىچە دەرىس ئۆتۈلىدۇ.");
		setText(R.id.q_waqti,"دەرىس سۆزلەش ۋاقتى: 15:00-18:00(ئۈرۈمچى ۋاقتى)");
		
		//parent_scroll = (ScrollView)rootView.findViewById(R.id.parent_scroll);
		
		category_list = (LinearLayout)rootView.findViewById(R.id.category_list);
		
		listView = (MyListView)rootView.findViewById(R.id.listView);
		adapter = new BilimdanAdapter(context);
		listView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
	
	private void setText(int id,String text) {
		MyTextView textView = (MyTextView)rootView.findViewById(id);
		textView.setHtmlText(text);
	}
	
	
	public class clickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.book:
				startActivity(new Intent(context,ActivityBook.class));
				break;
			case R.id.perhiz:
				startActivity(new Intent(context,ActivityPerhiz.class));
				break;
			case R.id.haletlirim:
				
				break;
			case R.id.game:
				startActivity(new Intent(context,ActivityGame.class));
				break;
			case R.id.advice:
				startActivity(new Intent(context,ActivityAdvice.class));
				break;
			case 111:
				startActivity(new Intent(context,ActivityKnowlege.class));
				break;
			default:
				break;
			}
		}
		
	}

}
