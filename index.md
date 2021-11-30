# index

Spring事件监听
高内聚、低耦合是软件工程种好的代码的代名词，具备这个优点的代码往往具有更高的可扩展性！

一、案例分析
假设有这么一个需求，当收到用户下单成功的请求之后，需要触发短信服务给用户推送一条下单成功的短信。这看起来很容易实现，你也许会这么设计：
@Service
public class OrderService {
    
    public void order() {
        System.out.println("下单成功");
        System.out.println("调用短信服务、推送短信给用户");
    }
}

这样确实简单粗暴的实现了产品需求，但是这样就将短信相关逻辑放在了订单逻辑中，之后不管是订单逻辑的修改还是通知逻辑的修改都要动这段代码，这违背了单一职责原则。如果在二期迭代中、产品觉得短信通知还不够，还需要调用微信服务通知用户，这时候你还会继续这样写吗？
@Service
public class OrderService {

    public void order() {
        System.out.println("下单成功");
        System.out.println("调用短信服务、推送短信给用户");
        System.out.println("调用微信服务、推送微信消息给用户");
    }
}

讲道理，这样确实能达到产品需求的效果，但是并不利于后续需求的扩展，如果我们最开始没有考虑好系统设计和架构模式，那么在需求迭代、流量暴增下，最后你开发的需求极有可能出现不可预期的事故。
二、Spring事件监听实现
Spring提供了事件机制，可以通过事件的定义、发布以及监听事件来实现一些自定义的逻辑。比如下单后推送短信、推送微信消息这个需求，我们可以先定义一个下单成功的消息，然后在下单成功后发布下单成功的消息出来，在消息监听器中去实现推送短信和微信消息的功能。这样就可以将不属于下单的逻辑解耦合出来，大大提升系统的可扩展性。
- 项目基于Spring  4.3.12.RELEASE 版本，具体pom如下
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>4.3.12.RELEASE</version>
    </dependency>
    
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
</dependencies>

- 采用自动扫描包、自动维护Spring Bean的形式
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.mright.spring.framework")
public class ApplicationConfiguration {

}

- 首先定义下单成功的消息
消息对象需要继承 ApplicationEvent 抽象类
import org.springframework.context.ApplicationEvent;

public class OrderEvent extends ApplicationEvent {

    public OrderEvent(Object source) {
        super(source);
    }
}

- 在下单服务中发布消息出来
调用 ApplicationContext 的 publishEvent 方法
import com.mright.spring.framework.bean.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ApplicationContext applicationContext;

    public void order() {
        System.out.println("下单成功");
        applicationContext.publishEvent(new OrderEvent(this));
    }
}

- 定义发送短信的事件监听器
事件监听器需要实现 ApplicationListener 接口，这样在每一次 publishEvent 发布事件的时候都会执行事件监听器
import com.mright.spring.framework.bean.OrderEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class SmsService implements ApplicationListener<OrderEvent> {

    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        System.out.println("发送短信消息给用户");
    }
}

- 定义发送微信消息的事件监听器
import com.mright.spring.framework.bean.OrderEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class WechatService implements ApplicationListener<OrderEvent> {

    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        System.out.println("发送微信消息给用户");
    }
}

- 单元测试
import com.mright.spring.framework.service.OrderService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        OrderService orderService = context.getBean(OrderService.class);
        orderService.order();
    }
}

- 运行结果
下单成功
发送短信消息给用户
发送微信消息给用户

Process finished with exit code 0

如果此时需求变更为：下单成功后、推送短信和微信给用户、并且通知仓进行生产，那么我们只需要实现一个仓生产的监听器即可。
import com.mright.spring.framework.bean.OrderEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class ProductionService implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        System.out.println("通知仓生产");
    }
}

执行单元测试
下单成功
通知仓生产
发送短信消息给用户
发送微信消息给用户

Process finished with exit code 0

实际上这种监听器模式是同步执行的，下单服务需要等待短信服务、微信服务、仓服务都执行完成才算结束，这样可能并不是我们所希望的，Spring针对异步的需求提出了解决方案，需要我们在多播器实例化的时候指定一个线程池，这样消息监听的处理就是完全异步的了。
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class AsyncEventConfig {

    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster
                = new SimpleApplicationEventMulticaster();

        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return eventMulticaster;
    }
}

这种设计实际上是使用到了观察者模式，具备高内聚、低耦合的优点，在需求变更的情况下这种设计模式非常容易扩展。
观察者模式：当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。比如，当一个对象被修改时，则会自动通知依赖它的对象。观察者模式属于行为型模式。

三、源码分析

四、总结
