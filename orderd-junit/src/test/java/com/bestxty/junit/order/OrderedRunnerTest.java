package com.bestxty.junit.order;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author xty
 * create at 2018/4/3
 */
@RunWith(OrderedRunner.class)
public class OrderedRunnerTest {


    @TestOrder(1)
    @Test
    public void test2() {
        System.out.println("OrderedRunnerTest.test2");
    }


    @TestOrder(2)
    @Test
    public void test1() {
        System.out.println("OrderedRunnerTest.test1");
    }
}