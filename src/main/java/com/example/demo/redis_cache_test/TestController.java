package com.example.demo.redis_cache_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class TestController {

    @Autowired
    private TestService service;

    /**
     * 测试Cacheable注解
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/test-cacheable/{id}", method = RequestMethod.GET)
    public Model Cacheable(@PathVariable long id) {
        return service.cacheable(id);
    }

    /**
     * 测试CachePut注解
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/test-cacheput/{id}", method = RequestMethod.GET)
    public Model CachePut(@PathVariable long id) {
        return service.cacheput(id);
    }

    /**
     * 测试CacheEvict注解
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/test-cacheevict/{id}", method = RequestMethod.GET)
    public Model CacheEvict(@PathVariable long id) {
        return service.cacheevict(id);
    }

}
