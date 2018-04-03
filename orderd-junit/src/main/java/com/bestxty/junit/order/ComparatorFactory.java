package com.bestxty.junit.order;

import java.lang.reflect.Method;
import java.util.Comparator;

/**
 * @author xty
 * create at 2018/4/3
 */
public interface ComparatorFactory {


    /**
     * produce method comparator.
     *
     * @return comparator {@link Comparator}
     */
    Comparator<Method> getMethodComparator();

}
