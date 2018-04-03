package com.bestxty.junit.order;

import org.junit.runners.MethodSorters;

import java.lang.reflect.Method;
import java.util.Comparator;

/**
 * default method comparator.
 *
 * @author xty
 * create at 2018/4/3
 * @see TestOrder
 */
public class DefaultComparatorFactory implements ComparatorFactory {

    public Comparator<Method> getMethodComparator() {
        return new Comparator<Method>() {
            public int compare(Method m1, Method m2) {
                TestOrder o1 = m1.getAnnotation(TestOrder.class);
                TestOrder o2 = m2.getAnnotation(TestOrder.class);

                if (o1 == null && o2 == null) {
                    return MethodSorters.DEFAULT.getComparator().compare(m1, m2);
                }

                if (o1 == null) return 1;
                if (o2 == null) return -1;

                if (o1.value() == o2.value()) {
                    return 0;
                }

                return o1.value() > o2.value() ? 1 : -1;
            }
        };
    }
}
