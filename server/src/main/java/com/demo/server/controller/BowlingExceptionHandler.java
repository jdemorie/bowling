package com.demo.server.controller;

import com.demo.kata.bowling.BowlingException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Singleton
@Requires(classes = {BowlingException.class})
public class BowlingExceptionHandler implements ExceptionHandler<BowlingException, HttpResponse<String>> {
  @Override
  public HttpResponse<String> handle(HttpRequest request, BowlingException exception) {
    return HttpResponse.serverError(exception.getMessage());
  }
}

