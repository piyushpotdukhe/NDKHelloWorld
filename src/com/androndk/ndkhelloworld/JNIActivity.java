package com.androndk.ndkhelloworld;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class JNIActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		JNILib JNILibObj = new JNILib();
		
		setContentView(R.layout.activity_jni);
		TextView TV_msg = (TextView)findViewById(R.id.tv_msg);
		TV_msg.setText(""+JNILibObj.getMessage());
	}
}
