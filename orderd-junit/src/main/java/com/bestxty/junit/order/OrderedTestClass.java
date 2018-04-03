package com.bestxty.junit.order;

import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author xty
 * create at 2018/4/3
 */
public class OrderedTestClass extends TestClass {
    /**
     * Creates a {@code TestClass} wrapping {@code clazz}. Each time this
     * constructor executes, the class is scanned for annotations, which can be
     * an expensive process (we hope in future JDK's it will not be.) Therefore,
     * try to share instances of {@code TestClass} where possible.
     *
     * @param clazz
     */
    public OrderedTestClass(Class<?> clazz) {
        super(clazz);
    }

    @Override
    protected void scanAnnotatedMembers(Map<Class<? extends Annotation>, List<FrameworkMethod>> methodsForAnnotations, Map<Class<? extends Annotation>, List<FrameworkField>> fieldsForAnnotations) {
        super.scanAnnotatedMembers(methodsForAnnotations, fieldsForAnnotations);
        //clear
        methodsForAnnotations.clear();

        Class<?> clazz = getJavaClass();

        for (Class<?> eachClass : getSuperClasses(clazz)) {
            for (Method eachMethod : getDeclaredMethods(eachClass)) {
                addToAnnotationLists(new FrameworkMethod(eachMethod), methodsForAnnotations);
            }
        }
    }

    protected static Comparator<Method> getMethodSorter(Class<?> clazz) {
        FixMethodOrder fixMethodOrder = clazz.getAnnotation(FixMethodOrder.class);
        ComparatorFactory factory = new DefaultComparatorFactory();
        if (fixMethodOrder != null) {
            try {
                factory = fixMethodOrder.value().newInstance();
            } catch (Exception e) {
                throw new Error(e);
            }
        }
        return factory.getMethodComparator();
    }

    protected static Method[] getDeclaredMethods(Class<?> clazz) {
        Comparator<Method> sorter = getMethodSorter(clazz);
        Method[] methods = clazz.getDeclaredMethods();
        if (sorter != null) {
            Arrays.sort(methods, sorter);
        }

        return methods;
    }

    protected static List<Class<?>> getSuperClasses(Class<?> testClass) {
        ArrayList<Class<?>> results = new ArrayList<Class<?>>();
        Class<?> current = testClass;
        while (current != null) {
            results.add(current);
            current = current.getSuperclass();
        }
        return results;
    }
}
