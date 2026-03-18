package com.demo.server.controller;

import com.demo.server.model.PlayerBean;
import com.demo.server.model.ScoreBean;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.EmbeddedApplication;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingApplicationScenario {
  private final HttpClient client;
  private final EmbeddedApplication<?> application;
  private String response;

  public BowlingApplicationScenario(HttpClient client, EmbeddedApplication<?> application) {
    this.client = client;
    this.application = application;
  }

  public BowlingApplicationScenario givenABowlingServer() {
    assertTrue(application.isRunning());
    return this;
  }

  public BowlingApplicationScenario whenIStartGame(String... playerNames) {
    List<PlayerBean> playerBeanList = Arrays.stream(playerNames).map(PlayerBean::new).toList();
    HttpRequest<?> request = HttpRequest.POST("/server/start", playerBeanList);
    response = client.toBlocking().retrieve(request, String.class);
    assertNotNull(response);
    return this;
  }

  public BowlingApplicationScenario thenTheScoreShouldBe(List<ScoreBean> expectedScore) {
    HttpRequest<?> request = HttpRequest.GET("/server/score");
    List<ScoreBean> response = client.toBlocking().retrieve(request, Argument.listOf(ScoreBean.class));
    assertNotNull(response);
    assertArrayEquals(expectedScore.toArray(), response.toArray());
    return this;
  }
}
