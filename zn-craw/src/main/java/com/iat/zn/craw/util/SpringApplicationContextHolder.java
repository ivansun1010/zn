package com.iat.zn.craw.util;

import org.springframework.context.ConfigurableApplicationContext;

public class SpringApplicationContextHolder {

    private static ConfigurableApplicationContext context;

    public static ConfigurableApplicationContext getContext() {
        return context;
    }

    public static void setContext(ConfigurableApplicationContext context) {
        SpringApplicationContextHolder.context = context;
    }
}
