package com.marsraver.aspect.hello;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("hello")
public class HelloController {

  private HelloService helloService;

  @GetMapping
  public ResponseEntity<String> hello() {
    try {
      return ResponseEntity.ok(helloService.hello());
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return ResponseEntity.internalServerError().body("blah");
    }
  }
}
