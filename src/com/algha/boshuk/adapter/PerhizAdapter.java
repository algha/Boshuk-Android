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
 
public class PerhizAdapter extends BaseAdapter
{
    private ArrayList<String> list;
    private Activity activity;
 
    public PerhizAdapter(Activity activity) {
        super();
        list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
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
 
    public static class ViewHolder{
        public ImageView image;
        public MyTextView name;
        
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder view;
        LayoutInflater inflator = activity.getLayoutInflater();
 
        if(convertView==null){
            view = new ViewHolder();
            convertView = inflator.inflate(R.layout.layout_perhiz_item, null);
            view.image = (ImageView) convertView.findViewById(R.id.image);
            view.name = (MyTextView) convertView.findViewById(R.id.name);
            
            convertView.setTag(view);
        }else{
            view = (ViewHolder) convertView.getTag();
        }
        view.name.setText("ئۇششاق يىمەكلىك");

        return convertView;
    }
}