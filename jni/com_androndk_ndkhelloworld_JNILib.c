#include "com_androndk_ndkhelloworld_JNILib.h"
#include <jni.h>
#include <android/log.h>
#include <stdio.h>
#include <string.h>

JNIEXPORT jstring JNICALL Java_com_androndk_ndkhelloworld_JNILib_createFileInCNDK(JNIEnv *env, jobject jobj) {

	FILE* file = fopen("/data/data/com.androndk.ndkhelloworld/NDKfileN.txt","w+");

	if (file == NULL){
		return (*env)->NewStringUTF(env, "PIYUSh: ERROR: File creation FAILED in C-NDK");
	} else {
		return (*env)->NewStringUTF(env, "PIYUSh: File created in C-NDK (FileName=NDKfileN.txt)");
	}

}

JNIEXPORT jstring JNICALL Java_com_androndk_ndkhelloworld_JNILib_getMessage(JNIEnv *env, jobject jobj) {
	__android_log_write(ANDROID_LOG_DEBUG, "dotC File", "RETURNING THE STRING FROM C-FILE");
	return (*env)->NewStringUTF(env, "PIYUSh: This string is from C-File-NDK");
}

JNIEXPORT jstring JNICALL Java_com_androndk_ndkhelloworld_JNILib_readFromFileInCNDK(JNIEnv *env, jobject jobj) {
		__android_log_write(ANDROID_LOG_DEBUG, "dotC File", "READING FILE IN C.");
		FILE* file = fopen("/data/data/com.androndk.ndkhelloworld/files/NDKfile.txt","r");
		char buff[100]={'0'};
		if (file == NULL) {
			return (*env)->NewStringUTF(env, "PIYUSh: fopen()=FAILED");
		} else {
			__android_log_write(ANDROID_LOG_DEBUG, "dotC File", "fopen()=SUCCESS.");
			fgets(buff, 4, file);
			return (*env)->NewStringUTF(env, buff);
			//fclose(file);
		}
		__android_log_write(ANDROID_LOG_DEBUG, "dotC File", "READ FILE COMPLETE IN C.");
}

JNIEXPORT jstring JNICALL Java_com_androndk_ndkhelloworld_JNILib_writeToFileInCNDK(JNIEnv *env, jobject jobj) {
	__android_log_write(ANDROID_LOG_DEBUG, "dotC File", "WRITING TO FILE IN C.");
	FILE* file = fopen("/data/data/com.androndk.ndkhelloworld/files/NDKfile.txt","w+");
	if (file != NULL) {
		fputs("PIYUSH\n", file);
	    //fflush(file);
	    fclose(file);
	} else {
		return (*env)->NewStringUTF(env, "PIYUSh: fopen()=FAILED");
	}
	__android_log_write(ANDROID_LOG_DEBUG, "dotC File", "WROTE TO CREATED FILE IN C.");
	return (*env)->NewStringUTF(env, "PIYUSh: WriteSuccess");
}
