package com.example.retrofit20;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by saby7 on 25-01-2018.
 */

public interface InterfacApi {
    @GET("contacts/")
    Call<Contacts> getContactDetails();
}
