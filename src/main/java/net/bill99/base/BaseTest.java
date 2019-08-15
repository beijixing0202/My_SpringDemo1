package net.bill99.base;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
@ContextConfiguration(locations = {"classpath:qacontext/applicationContext.xml"})
public class BaseTest extends AbstractTestNGSpringContextTests {
}
