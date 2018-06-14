package com.topzuqiu.lib_common.di;

import android.app.Application;


import com.topzuqiu.lib_common.http.RetrofitService;
import com.topzuqiu.lib_common.imageloader.ImageLoader;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mertsimsek on 13/01/17.
 */

@Singleton
@Component(modules = {NetworkModule.class, AppModule.class})
public interface AppComponent {

    Application getApplication();

    RetrofitService getRetrofitService();

    ImageLoader getImageLoader();


}