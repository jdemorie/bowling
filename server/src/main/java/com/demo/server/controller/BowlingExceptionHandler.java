package com.demo.server.controller;

import com.demo.kata.bowling.BowlingException;
import com.demo.server.model.ErrorBean;
import com.demo.server.model.ErrorBeanErrorCode;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Singleton
@Requires(classes = {BowlingException.class})
public class BowlingExceptionHandler implements ExceptionHandler<BowlingException, HttpResponse<ErrorBean>> {
  @Override
  public HttpResponse<ErrorBean> handle(HttpRequest request, BowlingException exception) {
    ErrorBean errorBean = new ErrorBean(ErrorBeanErrorCode.GAME_OVER, exception.getMessage());
    return HttpResponse.serverError(errorBean);
  }
}

