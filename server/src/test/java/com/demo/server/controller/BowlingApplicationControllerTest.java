package com.demo.server.controller;

import com.demo.server.model.ScoreBean;
import com.demo.server.model.TurnBean;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

@MicronautTest
public class BowlingApplicationControllerTest {
  @Inject
  EmbeddedApplication<?> application;
  @Inject
  @Client("/")
  HttpClient client;

  @Test
  void givenABowlingAreaWhenIStartGameThenTheScoreShouldBe() {
    List<ScoreBean> expectedScore = List.of(new ScoreBean("John", 0).turns(List.of(
        new TurnBean("00"),
        new TurnBean("00"),
        new TurnBean("00"),
        new TurnBean("00"),
        new TurnBean("00"),
        new TurnBean("00"),
        new TurnBean("00"),
        new TurnBean("00"),
        new TurnBean("00"),
        new TurnBean("00")
    )));
    BowlingApplicationScenario scenario = new BowlingApplicationScenario(client, application);
    scenario.givenABowlingServer()
        .whenIStartGame("John")
        .thenTheScoreShouldBe(expectedScore);
  }
}
