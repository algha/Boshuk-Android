package com.algha.boshuk.adapter;

import java.util.ArrayList;

import com.algha.boshuk.R;
import com.algha.boshuk.widget.MyTextView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class BilimdanAdapter extends BaseAdapter
{
    private ArrayList<String> list;
    private Activity activity;
 
    public BilimdanAdapter(Activity activity) {
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
        public ImageView imgViewThumb;
        public MyTextView txtViewTitle;
        public MyTextView txtViewCategory;
        public TextView txtViewClick;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder view;
        LayoutInflater inflator = activity.getLayoutInflater();
        if(convertView==null){
            view = new ViewHolder();
            convertView = inflator.inflate(R.layout.layout_bilimdan_item, null);
 
            view.imgViewThumb = (ImageView) convertView.findViewById(R.id.thumb);
            view.txtViewTitle = (MyTextView) convertView.findViewById(R.id.item_title);
            view.txtViewCategory = (MyTextView) convertView.findViewById(R.id.item_category);
            view.txtViewClick = (TextView) convertView.findViewById(R.id.item_click);
            convertView.setTag(view);
        }else{
            view = (ViewHolder) convertView.getTag();
        }
 
        
        view.txtViewTitle.setText("بالىلارغا تاماق يىگۈزەلمەسلىك مەسلىسىنى قانداق ھەل قىلسىڭىز ئەڭ ئۈنۈملۈك بولىدۇ؟");
        view.txtViewCategory.setText("تۇرمۇش يىتەكچىسى");
        view.txtViewClick.setText("122342");
 
        return convertView;
    }
}