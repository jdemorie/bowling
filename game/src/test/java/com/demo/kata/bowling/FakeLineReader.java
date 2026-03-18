package com.demo.kata.bowling;

public class FakeLineReader implements BowlingLineReader {
  @Override
  public BowlingScore read(String... players) {
    BowlingScore score = new BowlingScore();
    for (String player : players) {
      score.add(player, create());
    }
    return score;
  }

  private BowlingLine create() {
    return new BowlingLine(new BowlingTurn(0, 0),
                           new BowlingTurn(0, 0),
                           new BowlingTurn(0, 0),
                           new BowlingTurn(0, 0),
                           new BowlingTurn(0, 0),
                           new BowlingTurn(0, 0),
                           new BowlingTurn(0, 0),
                           new BowlingTurn(0, 0),
                           new BowlingTurn(0, 0),
                           new BowlingTurn(0, 0));
  }

}
