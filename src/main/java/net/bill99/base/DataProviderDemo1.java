package net.bill99.base;

import org.testng.annotations.Test;
import java.util.Map;

public class DataProviderDemo1 extends BaseTest {

    @Test(dataProvider="data")
    public void interfaceTest(Map<String,String> map){
        String caseName=map.get("用例名称");
        String xieyi = map.get("协议");
        System.out.println("caseName:"+caseName+"  xieyi:"+xieyi);
    }
}
