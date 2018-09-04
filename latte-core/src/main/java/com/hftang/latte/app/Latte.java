package com.hftang.latte.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * 创建时间：2018/9/3
 * 编写人：hftang
 * 功能描述：
 */
public final class Latte {


    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());

        return Configurator.getInstance();
    }


    private static WeakHashMap<String, Object> getConfigurations() {

        return Configurator.getInstance().getLatteConfigs();
    }


}
