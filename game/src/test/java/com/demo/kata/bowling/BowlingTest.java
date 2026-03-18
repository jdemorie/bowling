package com.demo.kata.bowling;

import org.junit.jupiter.api.Test;

public class BowlingTest {
  @Test
  void givenABowlingAreaWhenIStartAGameThenTheScoreShouldBeZero() {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "00 00 00 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 0);
  }

  @Test
  void givenABowlingAreaWhenIDown4PinsThenTheScoreShouldBe4() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 4)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(4, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "40 00 00 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 4);
  }

  @Test
  void givenABowlingAreaWhenIDown4PinsThen5PinsThenTheScoreShouldBe9() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 4)
        .whenIDownPins("player", 5)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(4, 5),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "45 00 00 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 9);
  }

  @Test
  void givenABowlingAreaWhenIDown3PinsOnSecondTurnThenTheScoreShouldBe9() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 4)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 3)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(4, 5),
                                                       new BowlingTurn(3, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "45 30 00 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 12);
  }

  @Test
  void givenABowlingAreaWhenIDownSomePinsThenTheRemainingPinsShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .thenTheRemainingPinsShouldBe("player", 10)
        .whenIDownPins("player", 4)
        .thenTheRemainingPinsShouldBe("player", 6)
        .whenIDownPins("player", 5)
        .thenTheRemainingPinsShouldBe("player", 10)
        .whenIDownPins("player", 10)
        .thenTheRemainingPinsShouldBe("player", 10)
        .thenTheOutputLineShouldBe("player", "45 X 00 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 19);
  }

  @Test
  void givenABowlingAreaWhenIMissedPinsOnSecondTurnThenTheScoreShouldBe9() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 4)
        .whenIDownPins("player", 0)
        .whenIDownPins("player", 3)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(4, 0),
                                                       new BowlingTurn(3, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "4- 30 00 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 7);
  }


  @Test
  void givenABowlingAreaWhenIMissedAllSecondPinsThenTheScoreShouldBe9() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 9)
        .whenIDownPins("player", 0)
        .whenIDownPins("player", 9)
        .whenIDownPins("player", 0)
        .whenIDownPins("player", 9)
        .whenIDownPins("player", 0)
        .whenIDownPins("player", 9)
        .whenIDownPins("player", 0)
        .whenIDownPins("player", 9)
        .whenIDownPins("player", 0)
        .whenIDownPins("player", 9)
        .whenIDownPins("player", 0)
        .whenIDownPins("player", 9)
        .whenIDownPins("player", 0)
        .whenIDownPins("player", 9)
        .whenIDownPins("player", 0)
        .whenIDownPins("player", 9)
        .whenIDownPins("player", 0)
        .whenIDownPins("player", 9)
        .whenIDownPins("player", 0)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(9, 0),
                                                       new BowlingTurn(9, 0),
                                                       new BowlingTurn(9, 0),
                                                       new BowlingTurn(9, 0),
                                                       new BowlingTurn(9, 0),
                                                       new BowlingTurn(9, 0),
                                                       new BowlingTurn(9, 0),
                                                       new BowlingTurn(9, 0),
                                                       new BowlingTurn(9, 0),
                                                       new BowlingTurn(9, 0)))
        .thenTheOutputLineShouldBe("player", "9- 9- 9- 9- 9- 9- 9- 9- 9- 9-")
        .thenTheScoreShouldBe("player", 90);
  }

  @Test
  void givenABowlingAreaWhenIDown4PinsThen6PinsThenTheScoreShouldBeSpare() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 4)
        .whenIDownPins("player", 6)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(4, 6),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "4/ 00 00 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 10);
  }

  @Test
  void givenABowlingAreaWhenIMakeSpareAndDown5PinsAfterThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 4)
        .whenIDownPins("player", 6)
        .whenIDownPins("player", 5)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(4, 6),
                                                       new BowlingTurn(5, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "4/ 50 00 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 20);
  }

  @Test
  void givenABowlingAreaWhenIMakeSpareAndDown5And3PinsAfterThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 4)
        .whenIDownPins("player", 6)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 3)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(4, 6),
                                                       new BowlingTurn(5, 3),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "4/ 53 00 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 23);
  }

  @Test
  void givenABowlingAreaWhenIMakeSpareAndDoAnotherSpareAfterThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 4)
        .whenIDownPins("player", 6)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(4, 6),
                                                       new BowlingTurn(5, 5),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "4/ 5/ 00 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 25);
  }

  @Test
  void givenABowlingAreaWhenIMakeSpareForAllTurnsThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .thenTheGameIsNotOver("player")
        .whenIDownPins("player", 5)
        .thenTheGameIsOver("player")
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(5, 5),
                                                       new BowlingTurn(5, 5),
                                                       new BowlingTurn(5, 5),
                                                       new BowlingTurn(5, 5),
                                                       new BowlingTurn(5, 5),
                                                       new BowlingTurn(5, 5),
                                                       new BowlingTurn(5, 5),
                                                       new BowlingTurn(5, 5),
                                                       new BowlingTurn(5, 5),
                                                       new BowlingTurn(5, 5),
                                                       new BowlingTurn(5, 0)))
        .thenTheOutputLineShouldBe("player", "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 50")
        .thenTheScoreShouldBe("player", 150);
  }

  @Test
  void givenABowlingAreaWhenIMakeTwoConsecutiveSparesAndDown4PinsAfterThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 4)
        .whenIDownPins("player", 6)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 5)
        .whenIDownPins("player", 4)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(4, 6),
                                                       new BowlingTurn(5, 5),
                                                       new BowlingTurn(4, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "4/ 5/ 40 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 33);
  }

  @Test
  void givenABowlingAreaWhenIDoAStrikeThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 10)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(10, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "X 00 00 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 10);
  }

  @Test
  void givenABowlingAreaWhenIDoAStrikeAfterPinsDownThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 1)
        .whenIDownPins("player", 2)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 7)
        .whenIDownPins("player", 1)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(1, 2),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(7, 1),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "12 X 71 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 29);
  }

  @Test
  void givenABowlingAreaWhenIDoAStrikeAndIDown4PinsThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 4)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(10, 0),
                                                       new BowlingTurn(4, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "X 40 00 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 14);
  }

  @Test
  void givenABowlingAreaWhenIDoAStrikeAndIDown4And2PinsThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 4)
        .whenIDownPins("player", 2)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(10, 0),
                                                       new BowlingTurn(4, 2),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "X 42 00 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 22);
  }

  @Test
  void givenABowlingAreaWhenIDoAStrikeAndIDownPinsOnNext2TurnsThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 4)
        .whenIDownPins("player", 2)
        .whenIDownPins("player", 6)
        .whenIDownPins("player", 2)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(10, 0),
                                                       new BowlingTurn(4, 2),
                                                       new BowlingTurn(6, 2),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "X 42 62 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 30);
  }

  @Test
  void givenABowlingAreaWhenIDoTwoConsecutiveStrikesThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "X X 00 00 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 20);
  }

  @Test
  void givenABowlingAreaWhenIDoTwoConsecutiveStrikesAndIDownPinsOnNext2TurnsThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 3)
        .whenIDownPins("player", 2)
        .whenIDownPins("player", 4)
        .whenIDownPins("player", 1)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(3, 2),
                                                       new BowlingTurn(4, 1),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "X X 32 41 00 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 48);
  }

  @Test
  void givenABowlingAreaWhenIDoThreeConsecutiveStrikesAndIDownPinsOnNext2TurnsThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 3)
        .whenIDownPins("player", 2)
        .whenIDownPins("player", 4)
        .whenIDownPins("player", 1)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(3, 2),
                                                       new BowlingTurn(4, 1),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "X X X 32 41 00 00 00 00 00")
        .thenTheScoreShouldBe("player", 78);
  }

  @Test
  void givenABowlingAreaWhenIDoFourConsecutiveStrikesAndIDownPinsOnNext2TurnsThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 3)
        .whenIDownPins("player", 2)
        .whenIDownPins("player", 4)
        .whenIDownPins("player", 1)
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(3, 2),
                                                       new BowlingTurn(4, 1),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "X X X X 32 41 00 00 00 00")
        .thenTheScoreShouldBe("player", 108);
  }

  @Test
  void givenABowlingAreaWhenIDoNineConsecutiveStrikesThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .thenTheGameIsNotOver("player")
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(0, 0),
                                                       new BowlingTurn(0, 0)))
        .thenTheOutputLineShouldBe("player", "X X X X X X X X 00 00")
        .thenTheScoreShouldBe("player", 200);
  }

  @Test
  void givenABowlingAreaWhenIDoTenConsecutiveStrikesThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .thenTheGameIsNotOver("player")
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0)))
        .thenTheOutputLineShouldBe("player", "X X X X X X X X X X")
        .thenTheScoreShouldBe("player", 260);
  }

  @Test
  void givenABowlingAreaWhenIDoAllStrikesThenTheScoreShouldBe() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .thenTheGameIsOver("player")
        .thenTheTurnShouldBe("player", new BowlingLine(new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0),
                                                       new BowlingTurn(10, 0)))
        .thenTheOutputLineShouldBe("player", "X X X X X X X X X X X X")
        .thenTheScoreShouldBe("player", 300);
  }

  @Test
  void givenABowlingAreaWhenIDoAllTurnwWithoutStrikeOrSpareForLatestThenTheGameIsOver() throws Exception {
    BowlingScenario bowlingScenario = new BowlingScenario();
    bowlingScenario.givenABowlingArea()
        .whenIStartAGame("player")
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 10)
        .whenIDownPins("player", 1)
        .whenIDownPins("player", 2)
        .thenTheGameIsOver("player")
        .thenTheOutputLineShouldBe("player", "X X X X X X X X X 12")
        .thenTheScoreShouldBe("player", 247);
  }
}
