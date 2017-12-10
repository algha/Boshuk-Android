package com.algha.boshuk.adapter;

import java.util.ArrayList;

import com.algha.boshuk.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class CategoryAdapter extends BaseAdapter
{
    private ArrayList<String> list;
    private Activity activity;
 
    public CategoryAdapter(Activity activity,int max) {
        super();
        list = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
    		list.add("this is str: "+i);
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
 
    public static class ViewHolder
    {
        public ImageView good_image;
        public TextView good_name;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder view;
        LayoutInflater inflator = activity.getLayoutInflater();
 
        if(convertView==null)
        {
            view = new ViewHolder();
            convertView = inflator.inflate(R.layout.layout_category_item, null);
 
            view.good_name = (TextView) convertView.findViewById(R.id.good_name);
            convertView.setTag(view);
        }
        else
        {
            view = (ViewHolder) convertView.getTag();
        }
 
        view.good_name.setText("گېرمانىيە ئاپتامىل ئوغۇز سۈتى");
 
        return convertView;
    }
}