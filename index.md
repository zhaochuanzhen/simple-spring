# index

# 初始化和销毁方法

## 1、指定init和destroy方法

```java
@Bean(initMethod = "init", destroyMethod = "destroy")
public Cat cat() {
	return new Cat();
}	
```

## 2、实现InitializingBean和DisposableBean

```java
public class Dog implements InitializingBean, DisposableBean {

    public Dog() {
        System.out.println("Dog constructor");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Dog init afterPropertiesSet");
    }

    public void destroy() throws Exception {
        System.out.println("Dog destroy method");
    }
}
```

## 3、PostConstruct和PreDistroy

> **PostConstruct：所有bean加载完、并且初始化完成执行**
>
> **PreDistroy：在容器销毁之前通知执行**

```java
public class Book {

    public Book() {
        System.out.println("Book constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("Book init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Book destroy method");
    }
}
```

# 后置处理器

```java
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化前：" + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化后：" + beanName);
        return bean;
    }
}
```

# 属性赋值



