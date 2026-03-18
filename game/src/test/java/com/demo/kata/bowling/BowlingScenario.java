package com.demo.kata.bowling;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingScenario {
  private BowlingArea bowlingArea;
  private BowlingGame bowlingGame;

  public BowlingScenario givenABowlingArea() {
    bowlingArea = new BowlingArea(new FakeLineReader(), new FakeLineWriter());
    return this;
  }

  public BowlingScenario whenIStartAGame(String... players) {
    bowlingGame = bowlingArea.start(players);
    return this;
  }

  public BowlingScenario thenTheTurnShouldBe(String player, BowlingLine expectedScore) {
    BowlingLine currentScore = bowlingGame.getCurrentLine(player);
    assertEquals(expectedScore, currentScore);
    return this;
  }

  public BowlingScenario whenIDownPins(String player, int numberOfDownPins) throws BowlingException {
    bowlingGame.pinsDown(player, numberOfDownPins);
    return this;
  }

  public BowlingScenario thenTheScoreShouldBe(String player, int expectedScore) {
    assertEquals(expectedScore, bowlingArea.computeScore(bowlingGame.getCurrentLine(player)));
    return this;
  }

  public BowlingScenario thenTheOutputLineShouldBe(String player, String expectedLine) {
    assertEquals(expectedLine, String.join(" ", bowlingArea.getOutputLine(bowlingGame.getCurrentLine(player))));
    return this;
  }

  public BowlingScenario thenTheRemainingPinsShouldBe(String player, int expectedRemainingPins) {
    assertEquals(expectedRemainingPins, bowlingGame.getRemainingPins(player));
    return this;
  }

  public BowlingScenario thenTheGameIsOver(String player) {
    assertTrue(bowlingGame.gameIsOver(player));
    return this;
  }

  public BowlingScenario thenTheGameIsNotOver(String player) {
    assertFalse(bowlingGame.gameIsOver(player));
    return this;
  }
}
