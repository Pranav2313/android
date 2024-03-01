package com.example.project.network;

import com.example.project.models.Home.HomeBodyClass;
import com.example.project.models.Home.HomeResponse;
import com.example.project.models.MealPlanInfo.MealPlanInfoResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {
    @POST("api/v1/get-mealcategories")
    @FormUrlEncoded
    Call<HomeResponse> getmealCategories(@FieldMap Map<String,String> params);

    @POST()
    @FormUrlEncoded
    Call<MealPlanInfoResponse> getMealPlanInfo(@Url String url,
                                               @FieldMap Map<String,String> params);

}



