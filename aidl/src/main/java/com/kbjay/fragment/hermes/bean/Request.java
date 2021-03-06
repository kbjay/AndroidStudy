package com.kbjay.fragment.hermes.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Request implements Parcelable {
    public String data;

    public Request(String data) {
        this.data = data;
    }

    protected Request(Parcel in) {
        data = in.readString();
    }

    public static final Creator<Request> CREATOR = new Creator<Request>() {
        @Override
        public Request createFromParcel(Parcel in) {
            return new Request(in);
        }

        @Override
        public Request[] newArray(int size) {
            return new Request[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(data);
    }
}
