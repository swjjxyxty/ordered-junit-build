package com.bestxty.junit.order.spring;

import com.bestxty.junit.order.OrderedTestClass;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.TestClass;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xty
 * create at 2018/4/3
 */
public class OrderedSpringRunner extends SpringJUnit4ClassRunner {

    public OrderedSpringRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    protected TestClass createTestClass(Class<?> testClass) {
        return new OrderedTestClass(testClass);
    }
}
