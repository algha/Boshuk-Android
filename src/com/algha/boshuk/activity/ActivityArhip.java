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
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ActivityArhip extends Activity {

	private MyEditText sign;
	private TextView sign_count;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arhip);
        
        InitializationView();
    }
	
	private void InitializationView() {
		LinearLayout titleLayout = (LinearLayout)findViewById(R.id.title);
		Header header = new Header(ActivityArhip.this);
		header.setListener(new clickListener());
		header.setTextTitle("ئارخىپىم");
		header.setLeftTextButton("ساقلاش");
		header.leftTextButton.setPadding(App.getPixelFromDp(10), App.getPixelFromDp(5), App.getPixelFromDp(10), App.getPixelFromDp(5));
		header.leftTextButton.setBackgroundResource(R.drawable.white_border);
		header.leftTextButton.setTextColor(getResources().getColor(R.color.boshuk_red));
		header.setRightButton(R.drawable.back_right);
		titleLayout.addView(header);
		
		
		MyTextView avatar = (MyTextView)getChild(R.id.avatar,1);
		avatar.setText("باش رەسىمىڭىز");
		//ImageView avatar_image = (ImageView)getChild(R.id.avatar,0);
		
		MyTextView name = (MyTextView)getChild(R.id.name,1);
		name.setText("ئىسمىڭىز");
		MyTextView name_info = (MyTextView)getChild(R.id.name,0);
		name_info.setText("خەلچىگۈل يۈسۈپ");
		
		MyTextView jinsingiz = (MyTextView)getChild(R.id.jins,1);
		jinsingiz.setText("جىنسىڭىز");
		MyTextView jinsingiz_info = (MyTextView)getChild(R.id.jins,0);
		jinsingiz_info.setText("ئاپىسى");
		
		MyTextView birthday = (MyTextView)getChild(R.id.birthday,1);
		birthday.setText("تۇغۇلغان ۋاقتىڭىز");
		MyTextView birthday_info = (MyTextView)getChild(R.id.birthday,0);
		birthday_info.setText("1990-يىلى 1-ئاينىڭ 6-كۈنى");
		
		//bala
		MyTextView bala_name = (MyTextView)getChild(R.id.balaismi,1);
		bala_name.setText("بالىڭىزنىڭ ئىسمى");
		MyTextView bala_name_info = (MyTextView)getChild(R.id.balaismi,0);
		bala_name_info.setText("قەلبىنۇر");
		
		MyTextView bala_jinsi = (MyTextView)getChild(R.id.bala_jinsi,1);
		bala_jinsi.setText("جىنسى");
		MyTextView bala_jinsi_info = (MyTextView)getChild(R.id.bala_jinsi,0);
		bala_jinsi_info.setText("قىز");
		
		MyTextView bala_birthday = (MyTextView)getChild(R.id.bala_birthday,1);
		bala_birthday.setText("تۇغۇلغان ۋاقتى");
		MyTextView bala_birthday_info = (MyTextView)getChild(R.id.bala_birthday,0);
		bala_birthday_info.setText("2014-يىلى 1-ئاينىڭ 6-كۈنى");
		
		sign = (MyEditText)findViewById(R.id.sign);
		sign.setHint("بۇ يەرگە ئۆزىڭىز ياخشى كۆرىدىغان سۆزلەرنى يېزىڭ، بۇ ئۇچۇر شەخسى بېتىڭىزدە كۆرۈنۈپ تۇرىدۇ.");
		sign_count = (TextView)findViewById(R.id.sign_count);
		sign_count.setText("200/0");
	}
	
	private View getChild(int id,int index) {
		RelativeLayout layout = (RelativeLayout)findViewById(id);
		layout.setOnClickListener(new clickListener());
		return layout.getChildAt(index);
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
