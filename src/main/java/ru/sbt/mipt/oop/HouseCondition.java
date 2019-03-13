package ru.sbt.mipt.oop;

import java.io.IOException;

public interface HouseCondition {
  SmartHome getHouseCondition(String path) throws IOException;
}
