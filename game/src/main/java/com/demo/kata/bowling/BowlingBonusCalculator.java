package com.demo.kata.bowling;

public class BowlingBonusCalculator {
  private final BowlingLine line;
  private int bonus;

  public BowlingBonusCalculator(BowlingLine line) {
    this.line = line;
  }

  public int getBonus() {
    return bonus;
  }

  public void computeBonusForTurn(int turnIndex) {
    BowlingTurn turn = line.getTurn(turnIndex);
    BowlingTurn previousTurn = line.getPreviousTurn(turnIndex, 1);
    if (previousTurn == null || turnIndex > 10) {
      return;
    }
    if (previousTurn.isSpare() && turnIndex < 10) {
      bonus += turn.getFirstDownPins();
      return;
    }
    if (previousTurn.isStrike()) {
      computeBonusForPreviousStrike(turnIndex, turn, previousTurn);
    }
  }

  private void computeBonusForPreviousStrike(int turnIndex, BowlingTurn turn, BowlingTurn previousTurn) {
    BowlingTurn previousAfterPreviousTurn = line.getPreviousTurn(turnIndex, 2);
    if (turn.isStrike()) {
      if (previousAfterPreviousTurn != null && previousAfterPreviousTurn.isStrike()) {
        bonus += previousAfterPreviousTurn.getFirstDownPins() + previousTurn.getFirstDownPins();
      }
      return;
    }
    if (turn.isComplete()) {
      bonus += turn.getFirstDownPins() + turn.getSecondDownPins();
      if (previousAfterPreviousTurn == null) {
        return;
      }
      if (previousAfterPreviousTurn.isStrike()) {
        bonus += turn.getFirstDownPins() + previousTurn.getFirstDownPins();
      }
      return;
    }
    if (previousAfterPreviousTurn == null) {
      return;
    }
    if (previousAfterPreviousTurn.isStrike()) {
      bonus += turn.getFirstDownPins();
    }
  }
}
