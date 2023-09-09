package org.example.controller;

import org.example.utils.RedisUtils;
import org.example.utils.RedissonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Version v1.0
 * @Description:
 * @Author Lee
 * @Date 2023/9/4 17:06
 * @Copyright 李子木
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedissonUtils redissonUtils;

}
