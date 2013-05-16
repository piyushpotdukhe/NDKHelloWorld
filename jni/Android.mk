LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_SRC_FILES := com_androndk_ndkhelloworld_JNILib.c
LOCAL_MODULE := com_androndk_ndkhelloworld_JNILib
include $(BUILD_SHARED_LIBRARY)