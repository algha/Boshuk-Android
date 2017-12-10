package com.algha.boshuk.activity;

import com.algha.boshuk.R;
import com.algha.boshuk.widget.Header;
import com.algha.boshuk.widget.MyEditText;
import com.algha.boshuk.widget.MyTextView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class ActivityRegister extends Activity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        InitializationView();
    }
	

    
    private void InitializationView() {
		LinearLayout titleLayout = (LinearLayout)findViewById(R.id.title);
		Header header = new Header(ActivityRegister.this);
		header.setListener(new clickListener());
		header.setTextTitle("تىزىملىتىش");
		header.setRightButton(R.drawable.back_right);
		titleLayout.addView(header);

		MyEditText phone = (MyEditText)findViewById(R.id.phone);
		phone.setHint("يانفون نومۇرىڭىزنى كىرگۈزۈڭ...");
		
		MyTextView licence = (MyTextView)findViewById(R.id.licence);
		String text = "تىزىملىتىش بىلەن بىرگە <font color='red'>《بۆشۈك ئابونتلار تىزىملىتىش قوللانمىسى》</font> گە رىئايە قىلىشىڭىز كىرەك.بۆشۈك ئانا-بالىلار ئەپى ھەر بىر ئابونت مەخپىيەتلىكىنى قاتتىق ساقلايدۇ.";
		licence.setHtmlText(text);
		
		findViewById(R.id.next_step).setOnClickListener(new clickListener());
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
			case R.id.next_step:
				Intent verify = new Intent(ActivityRegister.this,ActivityRegister_Verify.class);
				startActivity(verify);
				break;
			default:
				break;
			}
		}
	}

}
