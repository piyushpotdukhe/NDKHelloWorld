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
----------------------------------------------------------------------------------
UPDATE: 2nd Commit
The above procedure is only to generate the library for ARM-Architecture devices.
For generating the library for all the supported architecture, please follow the below commands -
		D:\Eclipse\WorkSpace\WS_2\NdkHelloWorld> ndk-build clean				(this is to clean all the pre-existing built libraries.)
		D:\Eclipse\WorkSpace\WS_2\NdkHelloWorld> ndk-build APP_ABI=all		(actual command to build for all the supported ABI)
----------------------------------------------------------------------------------
UPDATE: 3rd Commit
As per the above procedure, we need to specify the ABI to be included in NDK-Build command.
We can force the future builds to generate the .so for all the architecture, by specifying it in Application.mk under jni folder.
So basically, the .mk files are as under:
	Android.mk		:	rules specific to the app
	Application.mk	:	rules specific to the global environment.

Just specify ( APP_ABI := all ) in Application.mk and then the below commands -
		D:\Eclipse\WorkSpace\WS_2\NdkHelloWorld> ndk-build clean				(this is to clean all the pre-existing built libraries.)
		D:\Eclipse\WorkSpace\WS_2\NdkHelloWorld> ndk-build					l		(this will now generate the ABIs as specified in Application.mk, in this case for ALL supported platforms.)
	