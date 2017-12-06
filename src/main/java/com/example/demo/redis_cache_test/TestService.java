package com.example.demo.redis_cache_test;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private Model commonOperate(long id) {
        System.out.println("Method - start -");
        Model m = new Model();
        m.setAddress("地址--" + id);
        m.setName("姓名--" + id);
        m.setTel("电话--" + id);
        System.out.println("Method - end -");
        return m;
    }

    @Cacheable(value = "cache-1", key = "#id")
    public Model cacheable(long id) {
        return commonOperate(id);
    }

    @CachePut(value = "cache-1", key = "#id")
    public Model cacheput(long id) {
        return commonOperate(id);
    }

    @CacheEvict(value = "cache-1", allEntries = true, key = "#id")
    public Model cacheevict(long id) {
        return commonOperate(id);
    }
}
