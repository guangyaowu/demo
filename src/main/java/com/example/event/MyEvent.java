package com.example.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author guangyao.wu@ucarinc.com
 * @description TODO
 * @date 2018/11/23 9:42
 **/
public class MyEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvent(Object source) {
        super(source);
    }
}
