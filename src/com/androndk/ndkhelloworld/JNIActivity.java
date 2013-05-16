package com.androndk.ndkhelloworld;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class JNIActivity extends Activity {

	JNILib JNILibObj = new JNILib();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_jni);
		
		
	}
	
	public void BTN_showTextFromCFile_onClick(View V) {
		Toast.makeText((JNIActivity.this), (""+JNILibObj.getMessage()), (Toast.LENGTH_SHORT)).show();		
	}
	
	public void BTN_readFromFile_onClick(View V) {
		Toast.makeText((JNIActivity.this), ("Not Implemented Yet !!"), (Toast.LENGTH_SHORT)).show();
	}
	
	public void BTN_writeToFile_onClick(View V) {
		Toast.makeText(JNIActivity.this, ("Not Implemented Yet !!"), (Toast.LENGTH_SHORT)).show();
	}
	

}
