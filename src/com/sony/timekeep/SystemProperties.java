package com.sony.timekeep;

import java.lang.reflect.Method;

// https://android-review.googlesource.com/c/platform/packages/apps/Camera2/+/971364

// This is bad bad bad...
public final class SystemProperties {
    public static String get(String key, String defaultValue) {
        String value = defaultValue;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method get = cls.getMethod("get", String.class, String.class);
            value = (String)(get.invoke(null, key, defaultValue));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    public static void set(String key, String val) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method set = cls.getMethod("set", String.class, String.class);
            set.invoke(null, key, val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private SystemProperties() {
    }
}
