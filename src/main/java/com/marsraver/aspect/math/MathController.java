package com.marsraver.aspect.math;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("math")
public class MathController {

  private SampleAdder sampleAdder;

  @GetMapping("add")
  public ResponseEntity<Integer> add(@RequestParam("value") int[] values) {
    return ResponseEntity.ok(sampleAdder.add(values));
  }
}
