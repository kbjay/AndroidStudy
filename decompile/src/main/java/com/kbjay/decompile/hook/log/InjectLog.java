package com.kbjay.decompile.hook.log;

import android.util.Log;

public class InjectLog {
    public static void printFunc(){
        Thread cur_thread = Thread.currentThread();
        StackTraceElement stack[] = cur_thread.getStackTrace();
        Log.d("kbjay_test", stack[3].toString() + "[" + cur_thread.getId() + "]");
    }
}
