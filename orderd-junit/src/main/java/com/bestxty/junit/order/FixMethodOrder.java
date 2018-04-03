package com.bestxty.junit.order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xty
 * create at 2018/4/3
 * @see org.junit.FixMethodOrder
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FixMethodOrder {

    Class<? extends ComparatorFactory> value() default DefaultComparatorFactory.class;
}
