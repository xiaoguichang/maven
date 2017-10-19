package com.xiaogch.maven.wechat.config;

import com.xiaogch.maven.common.redis.JedisService;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

@Configuration
public class RedisConfiguration {

    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private short port;
    @Value("${redis.maxIdle:500}")
    private int maxIdle;
    @Value("${redis.minIdle:100}")
    private int minIdle;
    @Value("${redis.maxTotal:5000}")
    private int maxTotal;

    @Bean(name = "jedisService")
    public JedisService getJedisService() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMinIdle(minIdle);
        JedisPool jedisPool = new JedisPool(poolConfig , host , port);
        return new JedisService(jedisPool);
    }
}
