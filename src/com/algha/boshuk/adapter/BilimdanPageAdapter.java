package com.algha.boshuk.adapter;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class BilimdanPageAdapter  extends PagerAdapter {
	
	private ArrayList<View> pageList;
	
	public void setPageList(ArrayList<View> list) {
		pageList = list;
	}
	
	@Override
	public int getCount() {
		return pageList.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(pageList.get(position));
		return pageList.get(position);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(pageList.get(position));
	}


}
