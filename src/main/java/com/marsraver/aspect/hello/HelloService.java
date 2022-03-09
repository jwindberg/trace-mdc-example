package com.marsraver.aspect.hello;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class HelloService {
  public String hello() {
    log.info(MDC.get("traceId"));
    if (new Random().nextInt() % 2 == 0) {
      throw new RuntimeException("boom");
    }
    return "Hello!";
  }
}
