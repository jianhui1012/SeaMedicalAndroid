package com.golike.seamedicalapp.api;

import com.golike.seamedicalapp.model.ResponseResult;
import com.golike.seamedicalapp.model.SailorRecord;
import com.golike.seamedicalapp.model.SeaUser;
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
     *  新增船员的受伤记录
     * @param sailorRecord
     * @return
     */
    Observable<ResponseResult> addSailorRecord(@Body SailorRecord sailorRecord);

    Observable<ResponseResult> login(@Body SeaUser seaUser);

}
