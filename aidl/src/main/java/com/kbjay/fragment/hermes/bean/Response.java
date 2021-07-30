package com.kbjay.fragment.hermes.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Response implements Parcelable {
    public String data;

    public Response(String data){
        this.data = data;
    }

    protected Response(Parcel in) {
        data = in.readString();
    }

    public static final Creator<Response> CREATOR = new Creator<Response>() {
        @Override
        public Response createFromParcel(Parcel in) {
            return new Response(in);
        }

        @Override
        public Response[] newArray(int size) {
            return new Response[size];
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
