package net.bill99.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBook {
    @Value("${mcs.url}")
    private String url;
    @Value("wsy")
    private String name;
    public void before(){
        System.out.println(name+" URL:"+url+" myBook before........");
    }

    public void error(){
        System.out.println("error.......");
    }
}
