package com.example.event.listener;

import com.example.event.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author guangyao.wu
 * @description TODO
 * @date 2018/11/23 9:43
 **/
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println(event.getSource());
    }
}
