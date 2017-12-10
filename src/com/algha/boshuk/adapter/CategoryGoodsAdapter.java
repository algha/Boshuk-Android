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
 
public class CategoryGoodsAdapter extends BaseAdapter
{
    private ArrayList<String> list;
    private Activity activity;
 
    public CategoryGoodsAdapter(Activity activity) {
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
        public ImageView good_image;
        public ImageView good_flag;
        public TextView good_name;
        public TextView good_country;
        public TextView good_izahat;
        public TextView good_discount;
        public TextView good_price;
        public TextView good_original_price;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder view;
        LayoutInflater inflator = activity.getLayoutInflater();
 
        if(convertView==null){
            view = new ViewHolder();
            convertView = inflator.inflate(R.layout.layout_goods_item, null);
            
            view.good_flag = (ImageView) convertView.findViewById(R.id.flag);
            view.good_image = (ImageView) convertView.findViewById(R.id.good_image);
            
            view.good_name = (TextView) convertView.findViewById(R.id.good_name);
            view.good_country = (TextView) convertView.findViewById(R.id.country);
            view.good_izahat = (TextView) convertView.findViewById(R.id.izahat);
            
            view.good_discount = (TextView) convertView.findViewById(R.id.discount);
            view.good_price = (TextView) convertView.findViewById(R.id.price);
            view.good_original_price = (TextView) convertView.findViewById(R.id.original_price);
            
            convertView.setTag(view);
        }else{
            view = (ViewHolder) convertView.getTag();
        }
        view.good_name.setText("گېرمانىيە ئاپتامىل ئوغۇز سۈتى");
        view.good_country.setText("گېرمانىيە مەھسۇلاتى");
        view.good_izahat.setText("(6~12) ئايقىغچە2-باسقۇچ");
        
        view.good_discount.setText("20% ئېتىبار");
        view.good_price.setText("500¥");
        view.good_original_price.setText("680¥");
        
        
        return convertView;
    }
}