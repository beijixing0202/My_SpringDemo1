package net.bill99.book;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class TestDemo {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:qacontext/bean1.xml");
        Book book = (Book) context.getBean("book");
        book.add();
        book.division(2,1);
    }
}
