package com.bestxty.junit.order.spring;

import com.bestxty.junit.order.TestOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author xty
 * create at 2018/4/3
 */
@RunWith(OrderedSpringRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class OrderedSpringRunnerTest {

    @Autowired
    private TestBean testBean;

    @Test
    public void testHello() {
        testBean.hello("hello1");
    }

    @TestOrder
    @Test
    public void testHello2() {
        testBean.hello("hello2");
    }

}