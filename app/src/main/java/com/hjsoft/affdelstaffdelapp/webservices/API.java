package com.hjsoft.affdelstaffdelapp.webservices;

import com.google.gson.JsonObject;
import com.hjsoft.affdelstaffdelapp.model.Pojo;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by hjsoft on 23/11/16.
 */
public interface API {

    @POST("Login/Checklogin")
    Call<Pojo> sendLoginDetails(@Body JsonObject v);

    @POST("ChangePassword/Updatepassword")
    Call<Pojo> changePassword(@Body JsonObject v);

    @POST("IMEI/UpdateIMEI")
    Call<Pojo> updateIMEI(@Body JsonObject v);


}
