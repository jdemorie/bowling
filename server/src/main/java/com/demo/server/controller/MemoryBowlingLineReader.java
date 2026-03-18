package com.demo.server.controller;

import com.demo.kata.bowling.BowlingLine;
import com.demo.kata.bowling.BowlingLineReader;
import com.demo.kata.bowling.BowlingScore;
import com.demo.kata.bowling.BowlingTurn;

public class MemoryBowlingLineReader implements BowlingLineReader {
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
