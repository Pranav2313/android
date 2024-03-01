//package com.example.project.Register;
//
//import android.content.Context;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.example.project.Baseclass;
//import com.example.project.Endinterface;
//import com.google.gson.JsonObject;
//
//import org.json.JSONException;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//
//public class RegController implements IRegisterCall {
//
//    Context context;
//    IRegisterCallback iRegisterCallback;
//
//    public RegController(Context context, IRegisterCallback iRegisterCallback) {
//        this.context = context;
//        this.iRegisterCallback = iRegisterCallback;
//    }
//
//    @Override
//    public void getRegisterData(String name, String email, String phone, String password) {
//        Log.d("register", "getRegisterData" + name + email + phone + password);
//
//        Retrofit retrofit = Baseclass.getClient2();
//        Endinterface endinterface = retrofit.create(Endinterface.class);
//        endinterface.registration(name, email, phone, password).enqueue(new Callback<JsonObject>() {
//            @Override
//            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                if (response.isSuccessful()) {
//                    Log.d("Data", response.body().toString());
//                    JsonObject jsonObject = response.body();
//                    String msg = jsonObject.get("message").getAsString();
//
//                    if (msg.equals("successfully registered")) {
//                        JsonObject obj = jsonObject.getAsJsonObject("user");
//                        int id = Integer.parseInt(String.valueOf(obj.getAsInt()));
//                        String name = obj.get("name").getAsString();
//                        String email = obj.get("email").getAsString();
//                        String phone = obj.get("phone").getAsString();
//                        String password = obj.get("password").getAsString();
//                        iRegisterCallback.getResponse2(msg, id, name, email, phone, password);
//                    } else {
//
//                        Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else {
//                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
//                }
//
//
////    @Override
////    public void getRegisterData(String name, String email, String mobile, String password) {
////
////        Log.d("register","getRegisterData" + name + email + mobile + password);
////
////        Retrofit retrofit = RetrofitClass2.getClient2();
////        ApiServiceInterface service = retrofit.create(ApiServiceInterface.class);
////        service.datapost2(name, email, mobile, password).enqueue(new Callback<JsonObject>() {
////            @Override
////            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
////
////                if (response.isSuccessful()) {
////                    Log.d("Data",response.body().toString());
////
////                    JsonObject jsonObject = response.body();
////                    String msg = jsonObject.get("message").getAsString();
////
////                    JsonObject obj = jsonObject.getAsJsonObject("data");
////                    String name = obj.get("name").getAsString();
////                    String email = obj.get("email").getAsString();
////                    String mobile = obj.get("mobile").getAsString();
////                    String password = obj.get("password").getAsString();
////                    iRegisterCallback.getResponse2(name, email, mobile, password);
////
////                }
////                else {
////                    Log.d("Error.....","error");
////                }
////            }
////
////            @Override
////            public void onFailure(Call<JsonObject> call, Throwable t) {
////
////            }
////
////        });
//            }
//
//            @Override
//            public void onFailure(Call<JsonObject> call, Throwable t) {
//
//                Toast.makeText(context, "Server error", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}

