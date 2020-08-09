package com.yjn.crowd.api;

import com.yjn.crowd.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yjn
 * @Date: 2020/7/20 11:14
 */
@FeignClient("yjn-crowd-redis")
public interface RedisRemoteService {

    /**
     * 存储
     * @param key 键
     * @param value 值
     * @return
     */
    @RequestMapping("/set/redis/key/value/remote")
    ResultEntity<String> setRedisKeyValueRemote(
            @RequestParam("key") String key,
            @RequestParam("value") String value
            );

    @RequestMapping("/set/redis/key/value/remote/with/timeout")
    ResultEntity<String> setRedisKeyValueRemoteWithTimeout(
            @RequestParam("key") String key,
            @RequestParam("value") String value,
            @RequestParam("time") long time,
            @RequestParam("timeUnit")TimeUnit timeUnit
            );

    @RequestMapping("/get/redis/string/value/by/key")
    ResultEntity<String> getRedisStringValueByKeyRemote(@RequestParam("key") String key);

    @RequestMapping("/remove/redis/key/remote")
    ResultEntity<String> removeRedisKeyRemote(@RequestParam("key") String key);
}
