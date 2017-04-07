package com.golike.seamedicalapp.api;

import com.golike.seamedicalapp.model.SailorRecord;
import com.golike.seamedicalapp.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 提供海上医疗api接口
 * Created by admin on 2017/4/5.
 */
public interface SeaMedicalApiService {

    /***
     * 融云用户token获取
     * @param userId
     * @param name
     * @param portraitUri
     * @return
     */
    @FormUrlEncoded
    @POST("/user/getToken.json")
    Observable<User> getToken(@Field("userId") String userId,@Field("name") String name,@Field("portraitUri") String portraitUri);

    /***
     *  新增船员的受伤记录
     * @param sailorRecord
     * @return
     */
    Observable<SailorRecord> addSailorRecord(@Body SailorRecord sailorRecord);



}
