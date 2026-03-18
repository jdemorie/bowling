package com.demo.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingLineOutputFormatter {
  public List<String> getOutputLine(BowlingLine line) {
    List<String> output = new ArrayList<>();
    List<BowlingTurn> turnList = line.getTurns();
    for (BowlingTurn turn : turnList) {
      output.add(getOutputLine(turn));
    }
    return output;
  }

  private String getOutputLine(BowlingTurn turn) {
    if (turn.isStrike()) {
      return "X";
    }
    int firstDownPins = turn.getFirstDownPins();
    if (turn.isSpare()) {
      return firstDownPins + "/";
    }
    int secondDownPins = turn.getSecondDownPins();
    if (turn.isComplete()) {
      return getPinsOrMissed(firstDownPins) + getPinsOrMissed(secondDownPins);
    }
    return firstDownPins + "" + secondDownPins;
  }

  private String getPinsOrMissed(int numberOfPins) {
    return numberOfPins == 0 ? "-" : String.valueOf(numberOfPins);
  }
}
