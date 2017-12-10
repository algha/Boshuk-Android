package com.algha.boshuk.activity;

import com.algha.boshuk.App;
import com.algha.boshuk.R;
import com.algha.boshuk.widget.Header;
import com.algha.boshuk.widget.MyEditText;
import com.algha.boshuk.widget.MyTextView;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class ActivityCriclePost extends Activity {
	MyEditText content;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricle_post);
        
        InitializationView();
    }
	
	private void InitializationView() {
		LinearLayout titleLayout = (LinearLayout)findViewById(R.id.title);
		Header header = new Header(ActivityCriclePost.this);
		header.setListener(new clickListener());
		header.setTextTitle("يازما يوللاش");
		header.setLeftTextButton("يوللاش");
		header.leftTextButton.setPadding(App.getPixelFromDp(10), App.getPixelFromDp(5), App.getPixelFromDp(10), App.getPixelFromDp(5));
		header.leftTextButton.setBackgroundResource(R.drawable.white_border);
		header.leftTextButton.setTextColor(getResources().getColor(R.color.boshuk_red));
		header.setRightButton(R.drawable.back_right);
		titleLayout.addView(header);
		
	    content = (MyEditText)findViewById(R.id.cricle_text);
	    content.setHintTextColor(App.RESOURCES.getColor(R.color.boshuk_gray));
		content.setHint(App.RESOURCES.getString(R.string.cricle_post_hint));
		
		
		MyTextView location = (MyTextView)findViewById(R.id.location);
		location.setText("شىنجاڭ ئۈرۈمچى");
		
		MyTextView alert = (MyTextView)findViewById(R.id.alert);
		String text = "<font color='red'>دىققەت: </font> يوللانغان ھەر قانداق تېما تەستىقلانغاندىن كىيىن كۆرۈنىدۇ، دۆلەت بىخەتەرلىكىگە مۇناسىۋەتلىك ھەر قانداق ئۇچۇر بىردەك سۈرۈشتە قىلىنىدۇ.";
		alert.setHtmlText(text);
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
