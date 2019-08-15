package net.bill99.book;

import org.springframework.stereotype.Component;

@Component
public class Book {
    public void add(){
        System.out.println("add........");
    }
    public int division(int number1,int number2){
        int result = 0;
        try {
            System.out.println("division.......");
            result = number1/number2;
        } catch (Exception e) {
            System.out.println("除数不能为0");
        }
        return result;
    }
}
