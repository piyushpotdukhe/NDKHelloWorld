package com.androndk.ndkhelloworld;


public class JNILib {

	//docs.oracle.com/javase/6/docs/technotes/guides/jni/specs/types.html
	static {
		System.loadLibrary("com_androndk_ndkhelloworld_JNILib");
	}
	
	public native String getMessage();
	public native String writeToFileInCNDK();
	public native String readFromFileInCNDK();
	public native String createFileInCNDK();

}
