package net.bill99.service.impl;

import net.bill99.entity.Light;
import net.bill99.service.Command;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
public class LightOnCommand implements Command {

    @Resource
    private Light light;

    @Override
    public void execute() {
        light.lightOn();
    }
}
