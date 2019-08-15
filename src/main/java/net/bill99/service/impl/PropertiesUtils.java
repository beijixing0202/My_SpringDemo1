package net.bill99.service.impl;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class PropertiesUtils implements EmbeddedValueResolverAware {
    private StringValueResolver stringValueResolver;
    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.stringValueResolver = stringValueResolver;
    }
    public String getPropertyValue(String name){
        name="${"+ name +"}";
        return stringValueResolver.resolveStringValue(name);
    }
}
