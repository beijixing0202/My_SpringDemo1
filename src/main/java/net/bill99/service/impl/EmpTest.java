package net.bill99.service.impl;

import net.bill99.base.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class EmpTest extends BaseTest {
    @Autowired
    private EmpServiceImpl empService;

    @Test
    public void test1(){
        System.out.println("总的记录数："+empService.getEmpCout());
    }
}
