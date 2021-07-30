package com.kbjay.fragment.hermes.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import com.kbjay.fragment.hermes.IMyAidlInterface;
import com.kbjay.fragment.hermes.bean.Request;
import com.kbjay.fragment.hermes.bean.Response;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new IMyAidlInterface.Stub() {
            @Override
            public Response request(Request request) throws RemoteException {
                if (request.data.equals("1")){
                    return new Response("1_1");
                }else {
                    return new Response("2_1");
                }
            }
        };
    }
}
