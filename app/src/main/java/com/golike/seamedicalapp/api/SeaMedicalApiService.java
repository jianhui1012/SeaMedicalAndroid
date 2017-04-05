package com.golike.seamedicalapp.api;

import com.golike.seamedicalapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 提供海上医疗api接口
 * Created by admin on 2017/4/5.
 */
public interface SeaMedicalApiService {

    @GET("user/{id}/info")
    Call<List<User>> listuser(@Path("id") int id);


}
