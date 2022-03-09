package com.marsraver.aspect.math;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SampleAdder {
  public int add(int[] values) {
    return Arrays.stream(values).sum();
  }
}
