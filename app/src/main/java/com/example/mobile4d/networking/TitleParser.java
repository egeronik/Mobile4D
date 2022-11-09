package com.example.mobile4d.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TitleParser {
    Retrofit retrofit;
    private final TitleInterface proxy;

    public TitleParser() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        proxy = retrofit.create(TitleInterface.class);
    }

    public TitleInterface getProxy() {
        return proxy;
    }
}
