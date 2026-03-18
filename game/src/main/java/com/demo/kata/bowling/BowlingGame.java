package com.demo.kata.bowling;

public class BowlingGame {
  private final BowlingScore score;
  private final BowlingLineWriter lineWriter;
  private int attempts;

  public BowlingGame(BowlingLineReader lineReader, BowlingLineWriter lineWriter, String... players) {
    this.score = lineReader.read(players);
    this.lineWriter = lineWriter;
    attempts = 0;
  }

  public BowlingScore getScore() {
    return score;
  }

  public BowlingLine getCurrentLine(String player) {
    return score.get(player);
  }

  public int getRemainingPins(String player) {
    int currentTurn = attempts / 2;
    BowlingLine line = score.get(player);
    if (line.getTurns().size() <= currentTurn) {
      return 10;
    }
    BowlingTurn turn = line.getTurn(currentTurn);
    return 10 - turn.getFirstDownPins();
  }

  public boolean gameIsOver(String player) {
    return checkGameIsOver(player);
  }

  public void pinsDown(String player, int numberOfDownPins) throws BowlingException {
    if (checkGameIsOver(player)) {
      throw new BowlingException("Game is over for player " + player);
    }
    if (numberOfDownPins == 10) {
      attempts++;
    }
    int currentTurn = attempts / 2;
    score.get(player).pinsDown(currentTurn, numberOfDownPins);
    attempts++;
    lineWriter.write(score);
  }

  private boolean checkGameIsOver(String player) {
    if (attempts < 20) {
      return false;
    }
    int currentTurn = attempts / 2;
    if (attempts == 20) {
      BowlingLine line = score.get(player);
      BowlingTurn turn = line.getTurn(currentTurn - 1);
      return !turn.isStrike() && !turn.isSpare();
    }
    if (attempts == 21) {
      BowlingLine line = score.get(player);
      BowlingTurn turn = line.getTurn(currentTurn - 2);
      return !turn.isStrike();
    }
    return attempts != 22;
  }
}
