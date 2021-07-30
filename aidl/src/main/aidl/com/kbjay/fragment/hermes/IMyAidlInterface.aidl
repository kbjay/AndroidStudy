package com.kbjay.fragment.hermes;

import com.kbjay.fragment.hermes.bean.Request;
import com.kbjay.fragment.hermes.bean.Response;

interface IMyAidlInterface {
    Response request(in Request request);
}