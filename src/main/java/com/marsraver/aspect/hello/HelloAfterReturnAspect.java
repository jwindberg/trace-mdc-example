package com.marsraver.aspect.hello;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Aspect
@Component
public class HelloAfterReturnAspect {

  @AfterReturning(
      pointcut = "execution(* com.marsraver.aspect.hello.HelloService+.*(..))",
      returning = "returnValue")
  public void afterReturn(Object returnValue) throws Throwable {
    String uuid = UUID.randomUUID().toString();
    log.info("value return was {}, uuid was {}", returnValue, uuid);
  }
}
