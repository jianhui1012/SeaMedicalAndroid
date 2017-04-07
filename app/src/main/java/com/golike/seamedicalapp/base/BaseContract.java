package com.golike.seamedicalapp.base;

/**
 * Created by admin on 2017/4/7.
 */
public interface BaseContract {

    interface BasePresenter<T> {

        void attachView(T view);

        void detachView();
    }

    interface BaseView {

        void showError();

        void complete();

    }
}
