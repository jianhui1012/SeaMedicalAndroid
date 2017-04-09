package com.golike.seamedicalapp.api;

import com.golike.seamedicalapp.model.User;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2017/4/8 0008.
 */

public interface RongYunApiService {

    /***
     * 融云用户token获取
     *
     * @param userId
     * @param name
     * @param portraitUri
     * @return
     */
    @FormUrlEncoded
    @POST("/user/getToken.json")
    Observable<User> getRongYunToken(@Field("userId") String userId, @Field("name") String name, @Field("portraitUri") String portraitUri);
}
