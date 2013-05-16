#include "com_androndk_ndkhelloworld_JNILib.h"
#include <jni.h>


JNIEXPORT jstring JNICALL Java_com_androndk_ndkhelloworld_JNILib_getMessage(JNIEnv *env, jobject jobj) {

	return (*env)->NewStringUTF(env, "PIYUSh: This string is from C-File-NDK");
}
