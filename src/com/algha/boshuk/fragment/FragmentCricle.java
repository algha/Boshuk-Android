package com.algha.boshuk.fragment;

import com.algha.boshuk.R;
import com.algha.boshuk.activity.ActivityCriclePost;
import com.algha.boshuk.adapter.CricleAdapter;
import com.algha.boshuk.widget.CricleListView;
import com.algha.boshuk.widget.Header;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FragmentCricle extends Fragment {

	private LinearLayout rootView;
	private Activity context;
	private CricleListView listView;
	private CricleAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = (LinearLayout)inflater.inflate(R.layout.fragment_cricle, null); 
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
		
	}

	private void InitalizationView() {
		// TODO Auto-generated method stub
		LinearLayout titleLayout = (LinearLayout)rootView.findViewById(R.id.title);
		Header header = new Header(context);
		header.setListener(new clickListener());
		header.setTextTitle("ئانىلار چەمبىرىكى");
		header.setLeftButton(R.drawable.message);
		header.setRightButton(R.drawable.camera);
		titleLayout.addView(header);
		
		listView = (CricleListView)rootView.findViewById(R.id.cricle);
		adapter = new CricleAdapter(context);
		listView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		
	}

	public class clickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case 1:
				Intent post = new Intent(context,ActivityCriclePost.class);
				startActivity(post);
				break;
			case 2:
				Toast.makeText(context, "left", Toast.LENGTH_SHORT).show();
				break;

			default:
				break;
			}
		}
	}
}
