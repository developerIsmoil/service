package com.terminal.forsecuritynew.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@EnableCaching
@Configuration
public class CachingConfig {

    //    @Lazy
    @Bean("customKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new CustomKeyGenerator();
    }

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<Cache> caches = new ArrayList<Cache>();
        caches.add(new ConcurrentMapCache("application123"));
        cacheManager.setCaches(caches);
        return cacheManager;
    }

    public class CustomKeyGenerator implements KeyGenerator {

        public Object generate(Object target, Method method, Object... params) {
            return target.getClass().getSimpleName() + "_" + method.getName() + "_" + StringUtils.arrayToDelimitedString(params, "_");
        }
    }
}