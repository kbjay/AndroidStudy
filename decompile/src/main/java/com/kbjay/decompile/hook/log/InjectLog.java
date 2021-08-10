package com.kbjay.decompile.hook.log;

import android.util.Log;

public class InjectLog {
    public static void printFunc() {
        Thread cur_thread = Thread.currentThread();
        StackTraceElement stack[] = cur_thread.getStackTrace();
        Log.d("kbjay_test", stack[3].toString() + "[" + cur_thread.getId() + "]");
    }

    public static void printLong(long a) {
        Log.d("kbjay_test_decode", a + "");
    }

    public static void printString(String a) {
        Log.d("kbjay_test_decode", a);
    }
}
