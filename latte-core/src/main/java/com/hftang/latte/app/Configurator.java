package com.hftang.latte.app;

import java.util.WeakHashMap;

/**
 * 创建时间：2018/9/3
 * 编写人：hftang
 * 功能描述：
 */
public class Configurator {
    private static final WeakHashMap<String, Object> LATTE_CONFIGS = new WeakHashMap<>();

    public Configurator() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);

    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    public static WeakHashMap<String, Object> getLatteConfigs() {

        return LATTE_CONFIGS;
    }


    private static class Holder {

        private static final Configurator INSTANCE = new Configurator();

    }

    public final void configure() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is  not ready ,call configure");
        }
    }

    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }


}
