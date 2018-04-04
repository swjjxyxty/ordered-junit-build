# ordered-junit-build



支持自定义junit方法排序.



### Examples

```java
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
```

```
OrderedRunnerTest.test2
OrderedRunnerTest.test1
```

```java
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
```

```
四月 04, 2018 9:08:14 上午 org.springframework.test.context.support.DefaultTestContextBootstrapper getDefaultTestExecutionListenerClassNames
信息: Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener]
四月 04, 2018 9:08:14 上午 org.springframework.test.context.support.DefaultTestContextBootstrapper getTestExecutionListeners
信息: Using TestExecutionListeners: [org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@1d251891, org.springframework.test.context.support.DependencyInjectionTestExecutionListener@48140564, org.springframework.test.context.support.DirtiesContextTestExecutionListener@58ceff1]
四月 04, 2018 9:08:14 上午 org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
信息: Loading XML bean definitions from class path resource [spring.xml]
四月 04, 2018 9:08:14 上午 org.springframework.context.support.GenericApplicationContext prepareRefresh
信息: Refreshing org.springframework.context.support.GenericApplicationContext@7225790e: startup date [Wed Apr 04 09:08:14 CST 2018]; root of context hierarchy
hello2
hello1
四月 04, 2018 9:08:15 上午 org.springframework.context.support.GenericApplicationContext doClose
信息: Closing org.springframework.context.support.GenericApplicationContext@7225790e: startup date [Wed Apr 04 09:08:14 CST 2018]; root of context hierarchy
```

