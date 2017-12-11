package com.algha.boshuk;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

public class App extends Application {

	public static Context CONTEXT;
	public static Resources RESOURCES;
	public static Typeface TYPE_FACE;
	public static DisplayMetrics DISPLAY_METRICS;
	

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		CONTEXT = this;
		RESOURCES = CONTEXT.getResources();
		TYPE_FACE = Typeface.createFromAsset(CONTEXT.getAssets(), "ALKATIPTT.TTF");
		DISPLAY_METRICS = RESOURCES.getDisplayMetrics();
		
	}
	
	public static int getPixelFromSp(int size) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, size, App.DISPLAY_METRICS);
	}

	public static int getPixelFromDp(int size) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size, App.DISPLAY_METRICS);
	}
	
	
	public static void startLoadingAnimation(View view) {
		Animation animation = new RotateAnimation(0, 359, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
		animation.setInterpolator(new LinearInterpolator());
		animation.setRepeatMode(Animation.RESTART);
		animation.setRepeatCount(Animation.INFINITE);
		animation.setDuration(1000);
		view.startAnimation(animation);
	}
	
	public static class Preferences {
		static SharedPreferences preferences;
		static SharedPreferences.Editor editor;

		static {
			preferences = CONTEXT.getSharedPreferences("Sapar_Preferences", Context.MODE_PRIVATE);
			editor = preferences.edit();
		}

		public static int getInt(String flag){
			return preferences.getInt(flag, 0);
		}

		public static void setInt(String flag,int val) {
			editor.putInt(flag, val);
			editor.commit();
		}
		
		public static String getString(String flag) {
			return preferences.getString(flag, null);
		}
		
		public static void setString(String flag,String val) {
			editor.putString(flag, val);
			editor.commit();
		}
		
		public static boolean getBoolean(String flag) {
			return preferences.getBoolean(flag, false);
		}
		
		public static void setBoolean(String flag,boolean val) {
			editor.putBoolean(flag, val);
			editor.commit();
		}
	}

}
