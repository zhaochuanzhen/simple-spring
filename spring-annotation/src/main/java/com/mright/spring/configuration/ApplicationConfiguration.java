package com.mright.spring.configuration;

import com.mright.spring.bean.Cat;
import com.mright.spring.bean.Person;
import com.mright.spring.condition.LinuxCondition;
import com.mright.spring.condition.MacCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Conditional({MacCondition.class})
    @Bean
    public Person mac() {
        return new Person("Mac");
    }

    @Conditional({LinuxCondition.class})
    @Bean
    public Person linux() {
        return new Person("linux");
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Cat cat() {
        return new Cat();
    }
}
