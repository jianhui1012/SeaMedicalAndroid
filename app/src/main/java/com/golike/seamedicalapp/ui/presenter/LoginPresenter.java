package com.golike.seamedicalapp.ui.presenter;

import com.golike.seamedicalapp.base.RxPresenter;
import com.golike.seamedicalapp.ui.contract.LoginContract;

/**
 * Created by admin on 2017/4/7.
 */
public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter<LoginContract.View> {
    @Override
    public void login(String uid, String token, String platform) {
    }

    @Override
    public void gettoken() {
    }

}
