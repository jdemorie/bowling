package com.demo.kata.bowling;

import java.util.Objects;

public final class BowlingTurn {
  private int first;
  private int second;
  private int attempts = 0;

  public BowlingTurn(int first, int second) {
    this.first = first;
    this.second = second;
  }

  public void pinsDown(int numberOfDownPins) {
    if (attempts == 0) {
      first = numberOfDownPins;
    } else {
      second = Math.min(numberOfDownPins, 10 - first);
    }
    attempts++;
  }

  public int getFirstDownPins() {
    return first;
  }

  public int getSecondDownPins() {
    return second;
  }

  public boolean isSpare() {
    return second != 0 && first + second == 10;
  }

  public boolean isStrike() {
    return second == 0 && first == 10;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BowlingTurn that = (BowlingTurn) o;
    return Objects.equals(first, that.first) && Objects.equals(second, that.second);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, second);
  }

  @Override
  public String toString() {
    return "BowlingTurnScore{" +
           "first='" + first + '\'' +
           ", second='" + second + '\'' +
           '}';
  }

  public boolean isComplete() {
    return attempts == 2 || isStrike();
  }
}
