package com.algha.boshuk.activity;

import com.algha.boshuk.R;
import com.algha.boshuk.alertview.AlertView;
import com.algha.boshuk.widget.Header;
import com.algha.boshuk.widget.MyEditText;
import com.algha.boshuk.widget.MyTextView;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class ActivityRegister_Verify extends Activity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_verify);
        
        InitializationView();
    }
    
    private void InitializationView() {
		LinearLayout titleLayout = (LinearLayout)findViewById(R.id.title);
		Header header = new Header(ActivityRegister_Verify.this);
		header.setListener(new clickListener());
		header.setTextTitle("دەلىللەش");
		header.setRightButton(R.drawable.back_right);
		titleLayout.addView(header);

		MyTextView sent_phone = (MyTextView)findViewById(R.id.sent_phone);
		sent_phone.setText("13899134949");
		
		MyEditText verify_code = (MyEditText)findViewById(R.id.verify_code);
		verify_code.setHint("تەستىق كودى...");
		
		MyEditText password = (MyEditText)findViewById(R.id.password);
		password.setHint("مەخپى نومۇر بېكىتىڭ...");
		
		MyEditText re_password = (MyEditText)findViewById(R.id.password_again);
		re_password.setHint("مەخپى نومۇرنى قايتىلاڭ...");
		
		findViewById(R.id.retry).setOnClickListener(new clickListener());
		findViewById(R.id.tamam).setOnClickListener(new clickListener());
		
		MyTextView time = (MyTextView)findViewById(R.id.time);
		time.setText("10s");
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
			case R.id.tamam:
				new AlertView("ئەسكەرتىش", "سىناق", null, new String[]{"بىلدىم"}, null, ActivityRegister_Verify.this, AlertView.Style.Alert, null).show();
				break;
			case R.id.retry:
				
				break;
			default:
				break;
			}
		}
	}

}
