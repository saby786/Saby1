package com.example.saby7.retrofit2;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by saby7 on 24-01-2018.
 */

public interface RequestInterface {
    @GET("contacts")
    Call<Saby> getJSON();
}
