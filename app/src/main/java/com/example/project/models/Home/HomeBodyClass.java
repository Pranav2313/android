package com.example.project.models.Home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeBodyClass {
    @SerializedName("lang_id")
    @Expose
    String lang_id ;

    public HomeBodyClass(String lang_id) {
        this.lang_id = lang_id;
    }
}
