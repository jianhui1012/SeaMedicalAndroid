package com.golike.seamedicalapp.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2017/4/6.
 */
@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }
}
