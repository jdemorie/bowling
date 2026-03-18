package com.demo.kata.bowling;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BowlingScore {
  private final Map<String, BowlingLine> lines = new HashMap<>();

  public BowlingLine get(String player) {
    return lines.get(player);
  }

  public void add(String player, BowlingLine bowlingLine) {
    lines.put(player, bowlingLine);
  }

  public void forEach(BiConsumer<String, BowlingLine> consumer) {
    lines.forEach(consumer);
  }
}
