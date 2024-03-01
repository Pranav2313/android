package com.example.project;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface endinterface {
    @FormUrlEncoded // annotation used in POST type requests
    @POST("register")
        // API's endpoints
    Call<ModelClass> registration(@Field("name") String name,
                             @Field("email") String email,
                             @Field("phone") String phone,
                             @Field("alternative_phone") String alternative_phone,
                             @Field("gender") String gender,
                             @Field("password") String password);

    @FormUrlEncoded // annotation used in POST type requests
    @POST("login")
        // API's endpoints
    Call<ModelClass2> SignIn(@Field("email") String email,
                             @Field("password") String password);

    @FormUrlEncoded // annotation used in POST type requests
    @POST("add-address")
        // API's endpoints
    Call<DeliveryAddressModelClass> deliveryaddress(@Field("governorate_id") String governorate_id,
                                               @Field("area") String area,
                                               @Field("avenue") String avenue,
                                               @Field("street") String street,
                                               @Field("building") String building,
                                               @Field("floor") String floor,
                                               @Field("appartment") String appartment,
                                               @Field("block") String block);

    @FormUrlEncoded
    @POST("update-password")

    Call<Change_Pass_Response> passwordresponse(@Field("password") String newpass,
                                                @Field("confirm_password") String confirmpass);

    
}
