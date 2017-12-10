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
 
public class GamesAdapter extends BaseAdapter{
    private ArrayList<String> list;
    private Activity activity;
 
    public GamesAdapter(Activity activity) {
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
        public ImageView game_image;
        public MyTextView game_name;
        public MyTextView game_izahat;
        public MyTextView count;
        
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder view;
        LayoutInflater inflator = activity.getLayoutInflater();
 
        if(convertView==null){
            view = new ViewHolder();
            convertView = inflator.inflate(R.layout.layout_games_item, null);
            view.game_image = (ImageView) convertView.findViewById(R.id.game_image);
            view.game_name = (MyTextView) convertView.findViewById(R.id.game_name);
            view.game_izahat = (MyTextView) convertView.findViewById(R.id.izahat);
            view.count = (MyTextView) convertView.findViewById(R.id.count);
            convertView.setTag(view);
        }else{
            view = (ViewHolder) convertView.getTag();
        }
        view.game_name.setText("مۆكۈمۆكۈلەڭ ئويناش");
        view.game_izahat.setText("مۆكۈمۆكۈلەڭ ئويناش ناھايىتى ياخشى ئىش");
        view.count.setText("600 ئادەم ئوينىدى");

        return convertView;
    }
}