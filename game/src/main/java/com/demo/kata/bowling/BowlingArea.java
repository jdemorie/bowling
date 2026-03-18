package com.demo.kata.bowling;

import java.util.List;

public class BowlingArea {
  private final BowlingLineReader scoreReader;
  private final BowlingLineWriter scoreWriter;

  public BowlingArea(BowlingLineReader scoreReader, BowlingLineWriter scoreWriter) {
    this.scoreReader = scoreReader;
    this.scoreWriter = scoreWriter;
  }

  public BowlingGame start(String... players) {
    return new BowlingGame(scoreReader, scoreWriter, players);
  }

  public int computeScore(BowlingLine currentLine) {
    BowlingScoreComputer scoreComputer = new BowlingScoreComputer();
    return scoreComputer.computeScore(currentLine);
  }

  public List<String> getOutputLine(BowlingLine currentLine) {
    BowlingLineOutputFormatter outputFormatter = new BowlingLineOutputFormatter();
    return outputFormatter.getOutputLine(currentLine);
  }
}
