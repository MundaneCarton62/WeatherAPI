package com.example.WeatherAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;

@Configuration
@SuppressWarnings("unused")
public class RedisConfig {

    @Bean
    @SuppressWarnings("unused")
    public RedisCacheConfiguration cacheConfiguration(){
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(15));
    }
}
