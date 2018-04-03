package com.bestxty.junit.order;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.TestClass;

/**
 * @author xty
 * create at 2018/4/3
 */
@FixMethodOrder
public class OrderedRunner extends BlockJUnit4ClassRunner {


    /**
     * Creates a BlockJUnit4ClassRunner to run {@code klass}
     *
     * @param klass
     * @throws InitializationError if the test class is malformed.
     */
    public OrderedRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected TestClass createTestClass(Class<?> testClass) {
        return new OrderedTestClass(testClass);
    }
}
