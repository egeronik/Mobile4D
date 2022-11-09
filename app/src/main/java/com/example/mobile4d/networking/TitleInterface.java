package com.example.mobile4d.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TitleInterface {
    @GET("breed/{br}/images/random/{num}")
    Call<Title> getByBreedAndCount(@Path("br") String breed, @Path("num") int number);
}
