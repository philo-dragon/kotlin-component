package com.topzuqiu.lib_common.di;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.topzuqiu.lib_common.converter.StringConverter;
import com.topzuqiu.lib_common.imageloader.BaseImageLoaderStrategy;
import com.topzuqiu.lib_common.imageloader.ImageLoader;
import com.topzuqiu.lib_common.imageloader.glide.GlideImageLoaderStrategy;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rocky on 2017/12/28.
 */

@Module
public class AppModule {

    private Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(String.class, new StringConverter());//把Null转换成""字符串
        return builder.create();
    }

    @Provides
    @Singleton
    BaseImageLoaderStrategy provideBaseImageLoaderStrategy() {
        return new GlideImageLoaderStrategy();
    }

    @Provides
    @Singleton
    ImageLoader provideImageLoader(BaseImageLoaderStrategy imageLoaderStrategy) {
        return new ImageLoader(imageLoaderStrategy);
    }

}
