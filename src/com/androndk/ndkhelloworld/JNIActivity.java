package com.androndk.ndkhelloworld;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
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
		Toast.makeText((JNIActivity.this),  (""+JNILibObj.readFromFileInCNDK()), (Toast.LENGTH_SHORT)).show();
		//JNILibObj.readFromFileInCNDK();
	}
	
	public void BTN_writeToFile_onClick(View V) {
		Toast.makeText(JNIActivity.this, (""+JNILibObj.writeToFileInCNDK()), (Toast.LENGTH_SHORT)).show();
	}
	
	public void BTN_createFileInJava_onClick(View V) {
		String FILENAME = "NDKfile.txt";
		String string = "PKON";

		FileOutputStream fos = null;
		try {
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			if(fos==null) {
				Toast.makeText(JNIActivity.this, ("FileCreationFailedInJava !!"), (Toast.LENGTH_SHORT)).show();
			} else {
				Toast.makeText(JNIActivity.this, ("FileCreatedInJava !!"), (Toast.LENGTH_SHORT)).show();
			}
		} catch (FileNotFoundException e) {
			Toast.makeText(JNIActivity.this, ("FileNotFoundException-create !!"), (Toast.LENGTH_SHORT)).show();
			e.printStackTrace();
		}
		try {
			fos.write(string.getBytes());
		} catch (IOException e) {
			Toast.makeText(JNIActivity.this, ("IOException-write !!"), (Toast.LENGTH_SHORT)).show();
			e.printStackTrace();
		}
		try {
			fos.close();
		} catch (IOException e) {
			Toast.makeText(JNIActivity.this, ("IOException-close !!"), (Toast.LENGTH_SHORT)).show();
			e.printStackTrace();
		}
	}
	
	public void BTN_createFileInNDK_onClick(View V) {
		Toast.makeText((JNIActivity.this), (""+JNILibObj.createFileInCNDK()), (Toast.LENGTH_SHORT)).show();		
	}
	

}
