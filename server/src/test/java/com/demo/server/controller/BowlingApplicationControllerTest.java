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
import java.util.Random;

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
  
  @Test
  void test() {
    int count = 0;
    double bias = 0.2;
    int remainingPins = 10;
    int pinsDowns = (int) Math.round(Math.pow(new Random().nextDouble(), bias) * remainingPins);
    for (int i = 0; i < 100; i++) {
      if (pinsDowns == 10) {
        count++;
      }
      pinsDowns = (int) Math.round(Math.pow(new Random().nextDouble(), bias) * remainingPins);
    }
    System.out.println("Strike count: " + count);
  }
}
