package com.algha.boshuk.activity;

import java.util.ArrayList;

import com.algha.boshuk.R;
import com.algha.boshuk.adapter.BilimdanAdapter;
import com.algha.boshuk.adapter.BilimdanPageAdapter;
import com.algha.boshuk.adapter.CategoryAdapter;
import com.algha.boshuk.widget.Header;
import com.algha.boshuk.widget.MyTextView;
import com.algha.boshuk.xlistview.XListView;
import com.algha.boshuk.xlistview.XListView.IXListViewListener;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Pair;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

public class ActivityKnowlege extends Activity {

	private ViewPager viewPager;
	private LinearLayout category_list;
	private LayoutInflater inflater;
	private ArrayList<Pair<String, String>> category;
	private String[] colors = {"#baf2cc","#ff0000","#0c5565","#2e1c1e","#bac1f2"};
	
	private ArrayList<View> pageList;
	private BilimdanPageAdapter pageAdapter;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowlege);
        
        inflater = LayoutInflater.from(this);
		
		pageList = new ArrayList<View>();
		pageAdapter = new BilimdanPageAdapter();
		pageAdapter.setPageList(pageList);

		category = new ArrayList<Pair<String,String>>();
		category.add(0, new Pair<String, String>("1", "بارلىق"));
		category.add(0, new Pair<String, String>("1", "تەۋسىيەلىك"));
		category.add(0, new Pair<String, String>("1", "تۇرمۇش يىتەكچىسى"));
		category.add(0, new Pair<String, String>("1", "ھامىلدارلىق"));
		category.add(0, new Pair<String, String>("1", "قوشۇمچە"));
		

        
        InitializationView();
        
        Initialization();
    }
	
	private void InitializationView() {
		LinearLayout titleLayout = (LinearLayout)findViewById(R.id.title);
		Header header = new Header(ActivityKnowlege.this);
		header.setListener(new clickListener());
		header.setTextTitle("بىلىمدان");
		header.setRightButton(R.drawable.back_right);
		titleLayout.addView(header);
		
		category_list = (LinearLayout)findViewById(R.id.category_list);
		
		viewPager = (ViewPager)findViewById(R.id.viewPager);
		viewPager.setAdapter(pageAdapter);
		
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
//				changeTab(position, true);
//				if (!entryMap.containsKey(position)) {
//					appendTopData(position, true);
//				}
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
		});


	}
	
	private void Initialization(){
		for (int i = 0; i < category.size(); i++) {
			
			Pair<String, String> p = category.get(i);
			
			MyTextView textView = new MyTextView(ActivityKnowlege.this);
			textView.setText(p.second);
			textView.setGravity(Gravity.CENTER);
			textView.setTextSize(10);
			textView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT));
			textView.setPadding(20, 10, 20, 10);
			category_list.addView(textView);
			
			View v = inflater.inflate(R.layout.xlist_view, null);
			
			final int idx = i;
			
			final XListView listview = (XListView) v.findViewById(R.id.listView);
			listview.setBackgroundColor(Color.parseColor(colors[i]));
			listview.setPullRefreshEnable(true);
			listview.setXListViewListener(new IXListViewListener() {
				@Override
				public void onRefresh() {
					listview.setPullLoadEnable(false);
					//entryMap.remove(idx);
//					appendTopData(idx);
				}

				@Override
				public void onLoadMore() {
					//appendData(idx, false);
				}
			});
			pageList.add(v);
			appendTopData(idx);
		}
		viewPager.setCurrentItem(pageList.size() - 1);
		pageAdapter.setPageList(pageList);
		pageAdapter.notifyDataSetChanged();

	}

	private void appendTopData(int idx){
		XListView list = (XListView) pageList.get(idx).findViewById(R.id.listView);
		ListAdapter adapter = list.getAdapter();
		
		if (adapter == null) {
			list.setAdapter(new BilimdanAdapter(ActivityKnowlege.this));
		} else {
			((CategoryAdapter) adapter).notifyDataSetChanged();
		}
	}
	
	public class clickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case 1:
				onBackPressed();
				finish();
				break;
			case 2:
				
				break;

			default:
				break;
			}
		}
	}
	
}
