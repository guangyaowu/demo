package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication {

    public static void main(String[] args) {

//        SpringApplication.run(DemoApplication.class, args);

        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.addListeners(new ApplicationListener<ContextRefreshedEvent>() {
            @Override
            public void onApplicationEvent(ContextRefreshedEvent event) {
                System.out.println(event.getSource() + "Spring Context 启动完成");
            }
        });
        app.run(args);



        /*new SpringApplicationBuilder()
                .sources(Parent.class)
                .child(DemoApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);*/

    }
}
