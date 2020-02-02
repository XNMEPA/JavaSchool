package ru.malychev.jstasks.serializingproxy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by "XNMEPA" on 01.02.2020.
 * Определение условий кеширования результатов методов {@link Cache}
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    /**
     * @return Требуется ли кешировать результаты метода
     */
    boolean cache() default true;

    /**
     * @return тип кеширования: в память или в файл
     */
    CacheType cacheType() default CacheType.IN_MEMORY;

    /**
     *
     * @return имя кеш-файла по умолчанию
     */
    String fileName() default "./DataCache.obj";

    /**
     * @return Требуется ли сжимать кеш-файл
     */
    boolean zip() default true;

    /**
     * @return Ограничение на размер кешируемого списка
     */
    long listSize() default 100_000L;

    /**
     * @return Перечень существенных аргументов метода
     *         для определения уникальность результата
     */
    Class[] identityBy() default {};
}

/**
 * Определение возможных типов кеширования результатов {@link CacheType}
 */
enum CacheType {IN_MEMORY, FILE}
