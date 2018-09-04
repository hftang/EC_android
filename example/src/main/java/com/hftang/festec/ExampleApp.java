package com.hftang.festec;

import android.app.Application;

import com.hftang.latte.app.Latte;

/**
 * 创建时间：2018/9/3
 * 编写人：hftang
 * 功能描述：
 */
public class ExampleApp  extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1")
                .configure();

    }
}
