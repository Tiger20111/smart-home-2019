package ru.sbt.mipt.oop.randomenvents;
import ru.sbt.mipt.oop.EnventChoosingStratagy;

public class RandomChoosingStratagy implements EnventChoosingStratagy {
  @Override
  public int Randomizer() {
    return (int) (10 * Math.random());
  }
}
