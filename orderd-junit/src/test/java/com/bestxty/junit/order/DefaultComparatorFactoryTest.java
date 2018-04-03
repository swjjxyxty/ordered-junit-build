package com.bestxty.junit.order;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xty
 * create at 2018/4/3
 */
public class DefaultComparatorFactoryTest {

    @Test
    public void test1() {
        ComparatorFactory factory = new DefaultComparatorFactory();
        Comparator<Method> comparator = factory.getMethodComparator();

        Class<?> clazz = TestBean.class;

        Method[] methods = clazz.getDeclaredMethods();

        Arrays.sort(methods, comparator);

        Object[] expectOrder = new Object[]{"test3", "test2", "test1"};
        Object[] actualOrder = new Object[methods.length];

        for (int index = 0; index < methods.length; index++) {
            actualOrder[index] = methods[index].getName();
        }

        Assert.assertArrayEquals(expectOrder, actualOrder);

    }

    @Test
    public void test2() {
        ComparatorFactory factory = new DefaultComparatorFactory();
        Comparator<Method> comparator = factory.getMethodComparator();

        Class<?> clazz = TestBean2.class;

        Method[] methods = clazz.getDeclaredMethods();

        Arrays.sort(methods, comparator);

        Object[] expectOrder = new Object[]{"test3", "test1", "test2"};
        Object[] actualOrder = new Object[methods.length];

        for (int index = 0; index < methods.length; index++) {
            actualOrder[index] = methods[index].getName();
        }

        Assert.assertArrayEquals(expectOrder, actualOrder);

    }
}