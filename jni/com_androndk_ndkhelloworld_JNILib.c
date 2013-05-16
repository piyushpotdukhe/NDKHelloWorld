#include "com_androndk_ndkhelloworld_JNILib.h"
#include <jni.h>
#include <android/log.h>


JNIEXPORT jstring JNICALL Java_com_androndk_ndkhelloworld_JNILib_getMessage(JNIEnv *env, jobject jobj) {

	__android_log_write(ANDROID_LOG_DEBUG, "dotC File", "RETURNING THE STRING FROM HERE");
	return (*env)->NewStringUTF(env, "PIYUSh: This string is from C-File-NDK");
}
