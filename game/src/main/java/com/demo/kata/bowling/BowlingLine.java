package com.demo.kata.bowling;

import java.util.*;

public final class BowlingLine {
  private final List<BowlingTurn> turns;

  public BowlingLine(BowlingTurn... turns) {
    this.turns = new ArrayList<>();
    this.turns.addAll(Arrays.asList(turns));
  }

  public void pinsDown(int turnNumber, int numberOfDownPins) {
    BowlingTurn turn = getOrCreateTurn(turnNumber, numberOfDownPins);
    turn.pinsDown(numberOfDownPins);
  }

  public List<BowlingTurn> getTurns() {
    return Collections.unmodifiableList(turns);
  }

  public BowlingTurn getTurn(int turnIndex) {
    return turns.get(turnIndex);
  }

  public BowlingTurn getPreviousTurn(int turnIndex, int decrement) {
    if (turnIndex - decrement < 0 || turnIndex - decrement >= turns.size()) {
      return null;
    }
    return turns.get(turnIndex - decrement);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BowlingLine that = (BowlingLine) o;
    return Objects.deepEquals(turns, that.turns);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(turns.toArray());
  }

  @Override
  public String toString() {
    return "BowlingScore{" +
           "turns=" + Arrays.toString(turns.toArray()) +
           '}';
  }

  private BowlingTurn getOrCreateTurn(int turnNumber, int numberOfDownPins) {
    if (turnNumber >= turns.size()) {
      BowlingTurn turn = new BowlingTurn(numberOfDownPins, 0);
      turns.add(turn);
    }
    return turns.get(turnNumber);
  }
}
