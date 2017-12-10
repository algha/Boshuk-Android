package com.algha.boshuk.fragment;


import com.algha.boshuk.R;
import com.algha.boshuk.activity.ActivityArhip;
import com.algha.boshuk.activity.ActivityBaha;
import com.algha.boshuk.activity.ActivityEgishish;
import com.algha.boshuk.activity.ActivityEwetilgen;
import com.algha.boshuk.activity.ActivityIltimasim;
import com.algha.boshuk.activity.ActivityJughlanmam;
import com.algha.boshuk.activity.ActivityMalharwam;
import com.algha.boshuk.activity.ActivityPulTolenmigen;
import com.algha.boshuk.activity.ActivityQalduqum;
import com.algha.boshuk.activity.ActivityQayturulghan;
import com.algha.boshuk.activity.ActivitySaqlanma;
import com.algha.boshuk.activity.ActivitySettings;
import com.algha.boshuk.activity.ActivitySoalim;
import com.algha.boshuk.activity.ActivityTemilirim;
import com.algha.boshuk.activity.ActivityUserHalet;
import com.algha.boshuk.activity.ActivityUserHome;
import com.algha.boshuk.activity.ActivityZiyaret;
import com.algha.boshuk.widget.Header;
import com.algha.boshuk.widget.MyTextView;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class FragmentMe extends Fragment {

	private LinearLayout rootView;
	private Activity context;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		rootView = (LinearLayout)inflater.inflate(R.layout.fragment_me, null); 
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
		header.setTextTitle("مەن");
		header.setListener(new clickListener());
		header.setLeftButton(R.drawable.message);
		header.setRightButton(R.drawable.settings);
		titleLayout.addView(header);
		
		MyTextView name = (MyTextView)rootView.findViewById(R.id.name);
		name.setText("بۇخەلچەم ئىسمائىل");
		name.setOnClickListener(new clickListener());
		
		MyTextView halet = (MyTextView)rootView.findViewById(R.id.halet);
		halet.setOnClickListener(new clickListener());
		halet.setText("بالىڭىز بۈگۈن: 11 ئاي 25 كۈنلۈك");
		
		ImageView user_dvatar = (ImageView)rootView.findViewById(R.id.user_dvatar);
		user_dvatar.setOnClickListener(new clickListener());
		
		MyTextView my_home = (MyTextView)getChild(R.id.my_home,2);
		my_home.setText("شەخسى باش بېتىم");
		
		MyTextView my_home_info = (MyTextView)getChild(R.id.my_home,1);
		my_home_info.setText("ئوقۇلمىغان ئۇچۇر بار");
		
		
		MyTextView halet_list = (MyTextView)getChild(R.id.halet_list,2);
		halet_list.setText("ھالەت ئۆزگىرىش");
		
		rootView.findViewById(R.id.saqlanmilar).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.ziyaret_tarihi).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.qayturulghan).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.ewetilgen).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.pul_tolenmigen).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.baha_berix).setOnClickListener(new clickListener());

		rootView.findViewById(R.id.jughlanmam).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.qalduqum).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.mal_harwam).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.iltimasim).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.egeshkinim).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.egeshkuchilirim).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.temilirim).setOnClickListener(new clickListener());
		rootView.findViewById(R.id.soalim).setOnClickListener(new clickListener());
		
	}
	
	private View getChild(int id,int index) {
		RelativeLayout layout = (RelativeLayout)rootView.findViewById(id);
		layout.setOnClickListener(new clickListener());
		return layout.getChildAt(index);
	}
	
	public class clickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case 1:
				Intent settings = new Intent(context,ActivitySettings.class);
				startActivity(settings);
				break;
			case 2:
				
				break;
			case R.id.name:
				Intent arhip = new Intent(context,ActivityArhip.class);
				startActivity(arhip);
				break;
			case R.id.halet:
				Intent halet = new Intent(context,ActivityUserHalet.class);
				startActivity(halet);	
				break;
			case R.id.user_dvatar:
				startActivity(new Intent(context,ActivityArhip.class));	
				break;
			case R.id.my_home:
				startActivity(new Intent(context,ActivityUserHome.class));
				break;
			case R.id.halet_list:
				startActivity(new Intent(context,ActivityUserHalet.class));
				break;
			case R.id.saqlanmilar:
				startActivity(new Intent(context,ActivitySaqlanma.class));
				break;
			case R.id.ziyaret_tarihi:
				startActivity(new Intent(context,ActivityZiyaret.class));
				break;
			case R.id.qayturulghan:
				startActivity(new Intent(context,ActivityQayturulghan.class));
				break;
			case R.id.ewetilgen:
				startActivity(new Intent(context,ActivityEwetilgen.class));
				break;
			case R.id.pul_tolenmigen:
				startActivity(new Intent(context,ActivityPulTolenmigen.class));
				break;
			case R.id.baha_berix:
				startActivity(new Intent(context,ActivityBaha.class));
				break;
			case R.id.jughlanmam:
				startActivity(new Intent(context,ActivityJughlanmam.class));
				break;
			case R.id.qalduqum:
				startActivity(new Intent(context,ActivityQalduqum.class));
				break;
			case R.id.mal_harwam:
				startActivity(new Intent(context,ActivityMalharwam.class));
				break;
			case R.id.iltimasim:
				startActivity(new Intent(context,ActivityIltimasim.class));
				break;
			case R.id.egeshkinim:
				startActivity(new Intent(context,ActivityEgishish.class));
				break;
			case R.id.egeshkuchilirim:
				startActivity(new Intent(context,ActivityEgishish.class));
				break;
			case R.id.temilirim:
				startActivity(new Intent(context,ActivityTemilirim.class));
				break;
			case R.id.soalim:
				startActivity(new Intent(context,ActivitySoalim.class));
				break;	

			default:
				break;
			}
		}
	}
}
