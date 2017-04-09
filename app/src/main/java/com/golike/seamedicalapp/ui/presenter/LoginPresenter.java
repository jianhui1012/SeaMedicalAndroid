package com.golike.seamedicalapp.ui.presenter;

import android.widget.Toast;

import com.golike.seamedicalapp.api.RongYunApiService;
import com.golike.seamedicalapp.api.SeaMedicalApiService;
import com.golike.seamedicalapp.base.RxPresenter;
import com.golike.seamedicalapp.model.ResponseResult;
import com.golike.seamedicalapp.model.SeaUser;
import com.golike.seamedicalapp.model.User;
import com.golike.seamedicalapp.ui.contract.LoginContract;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2017/4/7.
 */
public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter<LoginContract.View> {

    private SeaMedicalApiService seaMedicalApiService;
    private RongYunApiService yunApiService;

    @Inject
    public LoginPresenter(SeaMedicalApiService seaMedicalApiService, RongYunApiService yunApiService) {
        this.seaMedicalApiService = seaMedicalApiService;
        this.yunApiService = yunApiService;
    }


    @Override
    public void login(String uid, String pwd, String platform) {
        SeaUser seaUser = new SeaUser();

        Subscription rxSubscription = seaMedicalApiService.login(seaUser).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseResult>() {
                    @Override
                    public void onNext(ResponseResult data) {
                        if (data != null && mView != null) {
                            mView.loginSuccess();
                        }
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public void gettoken(String uid, String pwd) {
        Subscription rxSubscription = yunApiService.getRongYunToken("", "", "").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onNext(User data) {
                        if (data != null && mView != null) {
                            if (data.code == 200)
                                mView.gettokenCompleted(data.token);
                        }
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
        addSubscrebe(rxSubscription);
    }

}
