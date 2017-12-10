package com.algha.boshuk.activity;

import com.algha.boshuk.R;
import com.algha.boshuk.widget.Header;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class ActivityEwetilgen extends Activity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ewetilgen);
        
        InitializationView();
    }
	
	private void InitializationView() {
		LinearLayout titleLayout = (LinearLayout)findViewById(R.id.title);
		Header header = new Header(ActivityEwetilgen.this);
		header.setListener(new clickListener());
		header.setTextTitle("ئەۋەتىلگەن");
		header.setRightButton(R.drawable.back_right);
		titleLayout.addView(header);
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
