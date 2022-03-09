package com.marsraver.aspect;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Component
@Order(1)
public class TraceFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    String traceId = httpRequest.getHeader("traceId");
    if (traceId == null) {
      traceId = UUID.randomUUID().toString();
    }
    MDC.put("traceId", traceId);

    chain.doFilter(request, response);
  }
}
