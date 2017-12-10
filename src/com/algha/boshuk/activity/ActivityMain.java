package com.algha.boshuk.activity;

import com.algha.boshuk.R;
import com.algha.boshuk.fragment.FragmentCategory;
import com.algha.boshuk.fragment.FragmentCricle;
import com.algha.boshuk.fragment.FragmentHome;
import com.algha.boshuk.fragment.FragmentKnowlege;
import com.algha.boshuk.fragment.FragmentMe;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityMain extends Activity {

	private LinearLayout TabsView;
	
	private FragmentHome fragmentHome;
	private FragmentCategory fragmentCategory;
	private FragmentCricle fragmentCricle;
	private FragmentKnowlege fragmentKnowlege;
	private FragmentMe fragmentMe;	
	private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        fragmentManager = getFragmentManager();
        
        initView();
        setTabSelection(0);
    }
    
    private void initView() {
		TabsView = (LinearLayout) findViewById(R.id.TabsView);
		for (int i = 0; i < TabsView.getChildCount(); i++) {
			LinearLayout tab = (LinearLayout) TabsView.getChildAt(i);
			tab.setOnClickListener(new TabClickListener());
		}
		SetSelected(R.id.home);
	}
    
	public class TabClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			SetSelected(v.getId());
			setTabSelection(Integer.parseInt(v.getTag().toString()));
		}
	}
	
	public void SetSelected(int id) {
		int images[] = {R.drawable.me,R.drawable.knowlege,R.drawable.cricle,R.drawable.category,R.drawable.home};
		int heightlight[] = {R.drawable.me_selected,R.drawable.knowlege_selected,R.drawable.cricle_selected,R.drawable.category_selected,R.drawable.home_selected};
		for (int i = 0; i < TabsView.getChildCount(); i++) {
			LinearLayout tab = (LinearLayout) TabsView.getChildAt(i);
			
			ImageView imageView = (ImageView)tab.getChildAt(0);
			imageView.setImageResource(images[i]);
			TextView textView = (TextView)tab.getChildAt(1);
			textView.setTextColor(Color.parseColor("#3c3c3c"));
			if (tab.getId() == id) {
				imageView.setImageResource(heightlight[i]);
				textView.setTextColor(Color.parseColor("#ff4965"));
			}
		}
	}
	
	private void setTabSelection(int index) {

		FragmentTransaction transaction = fragmentManager.beginTransaction();

		hideFragments(transaction);

		switch (index) {
		case 0:
			if (fragmentHome == null) {
				fragmentHome = new FragmentHome();
				transaction.add(R.id.Content, fragmentHome);
			} else {
				transaction.show(fragmentHome);
			}
			break;
		case 1:
			if (fragmentCategory == null) {
				fragmentCategory = new FragmentCategory();
				transaction.add(R.id.Content, fragmentCategory);
			} else {
				transaction.show(fragmentCategory);
			}
			break;
		case 2:
			if (fragmentCricle == null) {
				fragmentCricle = new FragmentCricle();
				transaction.add(R.id.Content, fragmentCricle);
			} else {
				transaction.show(fragmentCricle);
			}
			break;
		case 3:
			if (fragmentKnowlege == null) {
				fragmentKnowlege = new FragmentKnowlege();
				transaction.add(R.id.Content, fragmentKnowlege);
			} else {
				transaction.show(fragmentKnowlege);
			}
		break;
		case 4:
			if (fragmentMe == null) {
				fragmentMe = new FragmentMe();
				transaction.add(R.id.Content, fragmentMe);
			} else {
				transaction.show(fragmentMe);
			}
		break;
	}
		transaction.commit();
	}

	private void hideFragments(FragmentTransaction transaction) {
		if (fragmentHome != null) {
			transaction.hide(fragmentHome);
		}
		if (fragmentCategory != null) {
			transaction.hide(fragmentCategory);
		}
		if (fragmentCricle != null) {
			transaction.hide(fragmentCricle);
		}
		if (fragmentKnowlege != null) {
			transaction.hide(fragmentKnowlege);
		}
		if (fragmentMe != null) {
			transaction.hide(fragmentMe);
		}
	}

}
