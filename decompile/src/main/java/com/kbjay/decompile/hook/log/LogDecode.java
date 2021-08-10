package com.kbjay.decompile.hook.log;

import android.util.Log;

public class LogDecode {
    public static String logParamsAndReturn(long j){
        InjectLog.printLong(j);
        String test = test(j);
        InjectLog.printString(test);
        return test;
    }

    public static String test(long j){
        return j+"";
    }
}
