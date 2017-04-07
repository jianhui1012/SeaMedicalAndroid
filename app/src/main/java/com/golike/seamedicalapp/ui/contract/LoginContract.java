package com.golike.seamedicalapp.ui.contract;

import com.golike.seamedicalapp.base.BaseContract;

/**
 * Created by admin on 2017/4/7.
 */
public interface LoginContract {

    interface View extends BaseContract.BaseView {

        void loginSuccess();

        void gettokenCompleted();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void login(String uid, String token, String platform);

        void gettoken();
    }

}
