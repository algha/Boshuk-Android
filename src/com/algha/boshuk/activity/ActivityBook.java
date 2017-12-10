package com.algha.boshuk.activity;

import com.algha.boshuk.R;
import com.algha.boshuk.adapter.BooksAdapter;
import com.algha.boshuk.widget.Header;
import com.algha.boshuk.widget.MyGridView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.AdapterView.OnItemClickListener;

public class ActivityBook extends Activity {

	private MyGridView gridView;
	private BooksAdapter adapter;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        
        InitializationView();
    }
	
	private void InitializationView() {
		LinearLayout titleLayout = (LinearLayout)findViewById(R.id.title);
		Header header = new Header(ActivityBook.this);
		header.setListener(new clickListener());
		header.setTextTitle("كىتابخانا");
		header.setRightButton(R.drawable.back_right);
		titleLayout.addView(header);
		
		
		gridView = (MyGridView)findViewById(R.id.books);
		adapter = new BooksAdapter(ActivityBook.this);
		gridView.setAdapter(adapter);
		
		gridView.setOnItemClickListener(new itemClicListener());
	}
	
	
	public class itemClicListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(ActivityBook.this,ActivityBook.class);
			startActivity(intent);
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
