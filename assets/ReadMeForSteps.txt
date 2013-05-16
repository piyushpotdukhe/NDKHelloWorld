1.	Create JNIActivity.java and JNILib.java
2.	Create "jni" folder under main project directory
3.	traverse to project main folder through shell and compile and create javah header file using the below command
		D:\Eclipse\WorkSpace\WS_2\NdkHelloWorld> javah -jni -classpath D:\Eclipse\WorkSpace\WS_2\NdkHelloWorld\bin\classes\ 
		-d D:\Eclipse\WorkSpace\WS_2\NdkHelloWorld\jni\ com.androndk.ndkhelloworld.JNILib	
	This will create a .h file in jni folder.
5.	create a .c file with same name as of header, import the created header file and define the function in .c file
6.	create Android.mk file in jni folder (refer the file contents for details)
7.	build the project using JNI to create library file using the below command
		D:\Eclipse\WorkSpace\WS_2\NdkHelloWorld> ndk-build
	This will generate the .so/.dll file which was loaded in JNILib.java file
8.	everything is ready now -> run the project.