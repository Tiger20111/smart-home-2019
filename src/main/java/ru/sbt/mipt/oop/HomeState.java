package ru.sbt.mipt.oop;

import java.io.IOException;

public interface HomeState {
  SmartHome getHouseCondition(String path) throws IOException;
}
