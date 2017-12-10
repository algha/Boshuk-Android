package com.algha.boshuk.activity;

import com.algha.boshuk.R;
import com.algha.boshuk.widget.Header;
import com.algha.boshuk.widget.MyTextView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ActivitySettings extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        
        InitalizationView();
    }
    

	private void InitalizationView() {
		// TODO Auto-generated method stub
		LinearLayout titleLayout = (LinearLayout)findViewById(R.id.title);
		Header header = new Header(ActivitySettings.this);
		header.setTextTitle("تەڭشەك");
		header.setListener(new clickListener());
		header.setRightButton(R.drawable.back_right);
		titleLayout.addView(header);
		
		MyTextView arhip = (MyTextView)getChild(R.id.arhip_ozgertish,2);
		arhip.setText("ئارخىپ");
		MyTextView arhip_info = (MyTextView)getChild(R.id.arhip_ozgertish,1);
		arhip_info.setText("ئۇچۇر تولۇق ئەمەس");
		
		MyTextView parol = (MyTextView)getChild(R.id.parol,2);
		parol.setText("مەخپىي نومۇر ئۆزگەرتىش");
		MyTextView parol_info = (MyTextView)getChild(R.id.parol,1);
		parol_info.setText("چىڭ ساقلاڭ");

		MyTextView address = (MyTextView)getChild(R.id.address,2);
		address.setText("ئادرىس ئۆزگەرتىش");
		MyTextView address_info = (MyTextView)getChild(R.id.address,1);
		address_info.setText("قوشۇلغان ئادرىس يوق");
		
		MyTextView isim = (MyTextView)getChild(R.id.isim,2);
		isim.setText("ھەقىقىي ئىسىم تەستىقى");
		MyTextView isim_info = (MyTextView)getChild(R.id.isim,1);
		isim_info.setText("قىلىپ بولغان");
		
		MyTextView tarih = (MyTextView)getChild(R.id.tarih,1);
		tarih.setText("زىيارەت تارىخىنى تازىلاش");
		MyTextView tarih_info = (MyTextView)getChild(R.id.tarih,0);
		tarih_info.setText("23 تال ئۇچۇر.");
		
		MyTextView yardem = (MyTextView)getChild(R.id.yardem,1);
		yardem.setText("ياردەم تەلەپ قىلىش");
		MyTextView yardem_info = (MyTextView)getChild(R.id.yardem,0);
		yardem_info.setText("QQ,Weixin: 52038320");
		
		MyTextView izahat = (MyTextView)getChild(R.id.izahat,1);
		izahat.setText("ئىزاھاتنامە");
		MyTextView izahat_info = (MyTextView)getChild(R.id.izahat,0);
		izahat_info.setText("چوقۇم ئوقۇڭ");

		MyTextView baha = (MyTextView)getChild(R.id.baha,1);
		baha.setText("باھا بېرىڭ");
		MyTextView baha_info = (MyTextView)getChild(R.id.baha,0);
		baha_info.setText("ئازراق ۋاقىت چىقرىپ باھا بېرىڭ.");
		
		
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
			case R.id.arhip_ozgertish:
					startActivity(new Intent(ActivitySettings.this,ActivityArhip.class));		
				break;
			case R.id.parol:
				startActivity(new Intent(ActivitySettings.this,ActivityChangePassword.class));
				break;
			case R.id.address:
				startActivity(new Intent(ActivitySettings.this,ActivityAddAddress.class));
				break;
			case R.id.isim:
				startActivity(new Intent(ActivitySettings.this,ActivityVerifyName.class));
				break;
			case R.id.tarih:
					
				break;
			case R.id.yardem:
						
				break;
			case R.id.izahat:
						
				break;
			case R.id.baha:
				startActivity(new Intent(ActivitySettings.this,ActivityBaha.class));	
				break;

			default:
				break;
			}
		}
	}

}
