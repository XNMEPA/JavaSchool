package ru.malychev.jstasks.proxy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CacheIt {
    boolean cache();
}
