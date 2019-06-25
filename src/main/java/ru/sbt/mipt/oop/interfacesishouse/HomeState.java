package ru.sbt.mipt.oop.interfacesishouse;

import ru.sbt.mipt.oop.house.SmartHome;

import java.io.IOException;

public interface HomeState {
  SmartHome getHouseCondition(String path) throws IOException;
}
