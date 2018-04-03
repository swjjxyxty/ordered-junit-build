package com.bestxty.junit.order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xty
 * create at 2018/4/3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestOrder {

    /**
     * order
     *
     * @return order value.
     */
    int value() default Integer.MIN_VALUE;

}
