package com.demo.kata.bowling;

import java.util.List;

public class BowlingScoreComputer {
  public int computeScore(BowlingLine line) {
    int score = 0;
    BowlingBonusCalculator bonusCalculator = new BowlingBonusCalculator(line);
    List<BowlingTurn> turns = line.getTurns();
    for (int i = 0; i < turns.size(); i++) {
      BowlingTurn turn = turns.get(i);
      bonusCalculator.computeBonusForTurn(i);
      score += turn.getFirstDownPins() + turn.getSecondDownPins();
    }
    return score + bonusCalculator.getBonus();
  }
}
