package net.bill99.entity;

import net.bill99.service.impl.LightOnCommand;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RemoteControl {
    @Resource
    private LightOnCommand lightOnCommand;
    public void buttonPress(){
        lightOnCommand.execute();
    }
}
