package com.mright.spring.configuration;

import com.mright.spring.bean.Book;
import com.mright.spring.bean.Cat;
import com.mright.spring.bean.Dog;
import com.mright.spring.bean.Person;
import com.mright.spring.condition.LinuxCondition;
import com.mright.spring.condition.MacCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.mright.spring.bean")
public class ApplicationConfiguration {

    @Conditional({MacCondition.class})
    @Bean
    public Person mac() {
        return new Person("Mac");
    }

    @Conditional({LinuxCondition.class})
    @Bean
    public Person windows() {
        return new Person("Windows");
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Cat cat() {
        return new Cat();
    }

    @Bean
    public Dog dog() {
        return new Dog();
    }

    @Bean
    public Book book() {
        return new Book();
    }
}
