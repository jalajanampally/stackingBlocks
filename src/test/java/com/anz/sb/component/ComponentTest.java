package com.anz.sb.component;

import com.anz.sb.StackingBlocksApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@SpringBootTest(classes = StackingBlocksApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public @interface ComponentTest {
}
