package net.bill99.entity;

import net.bill99.base.BaseTest;
import net.bill99.book.Book;
import net.bill99.service.impl.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import javax.annotation.Resource;

public class RemoteControlTest extends BaseTest {

    @Resource
    private RemoteControl control;
    @Autowired
    private PropertiesUtils propertiesUtils;
    @Resource
    private Book book;

    @Test
    public void test1(){
        control.buttonPress();
    }

    @Test
    public  void test2(){
        System.out.println(propertiesUtils.getPropertyValue("mcs.name"));
    }

    @Test
    public void test3(){
        book.add();
    }
}
