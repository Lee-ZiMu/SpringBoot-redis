package org.example.utils;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Version v1.0
 * @Description:
 * @Author Lee
 * @Date 2023/9/9 13:43
 * @Copyright 李子木
 */
@Service
public class RedissonUtils {

    private final RedisTemplate<String, Object> redisTemplate;
    private final RedissonClient redissonClient;

    private static final String TEST_LOCK_1 = "TEST_LOCK_1";
    private static final String TEST_LOCK_2 = "TEST_LOCK_2";

    public RedissonUtils(RedisTemplate<String, Object> redisTemplate, RedissonClient redissonClient) {
        this.redisTemplate = redisTemplate;
        this.redissonClient = redissonClient;
    }

    public void test1(Integer guidanceTimeId) {
        // 获取 Redisson 的分布式锁
        RLock lock = redissonClient.getLock(TEST_LOCK_1);
        try {
            // 尝试获取锁
            lock.lock();
            // 业务代码
//            String key = test1;
//            redisTemplate.opsForValue().decrement(key);

        } catch (Exception e) {
          e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    public void test2(Integer guidanceTimeId) {
        // 获取 Redisson 的分布式锁
        RLock lock = redissonClient.getLock(TEST_LOCK_2);
        try {
            // 尝试获取锁
            lock.lock();
            // 业务代码
//            String key = test2;
//            redisTemplate.opsForValue().increment(key);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }
}
