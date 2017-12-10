package com.algha.boshuk.activity;

import com.algha.boshuk.App;
import com.algha.boshuk.R;
import com.algha.boshuk.widget.Header;
import com.algha.boshuk.widget.MyEditText;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class ActivityLogin extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        InitializationView();
    }
    
    private void InitializationView() {
		LinearLayout titleLayout = (LinearLayout)findViewById(R.id.title);
		Header header = new Header(ActivityLogin.this);
		header.setListener(new clickListener());
		header.setTextTitle("سېستىمىغا كىرىش");
		header.setLeftTextButton("تىزىملىتىش");
		header.leftTextButton.setPadding(App.getPixelFromDp(5), App.getPixelFromDp(5), App.getPixelFromDp(5), App.getPixelFromDp(5));
		header.leftTextButton.setTextColor(getResources().getColor(R.color.boshuk_white));
		header.setRightButton(R.drawable.back_right);
		titleLayout.addView(header);
		
		MyEditText phone = (MyEditText)findViewById(R.id.phone);
		phone.setHint("يانفون نومۇرىڭىزنى كىرگۈزۈڭ...");
		MyEditText password = (MyEditText)findViewById(R.id.password);
		password.setHint("مەخپىي نومۇرىڭىزنى كىرگۈزۈڭ...");
		
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
			case 3:
				Intent intent = new Intent(ActivityLogin.this,ActivityRegister.class);
				startActivity(intent);
				break;
			
			default:
				break;
			}
		}
	}
}
