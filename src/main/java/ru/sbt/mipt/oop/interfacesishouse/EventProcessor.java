package ru.sbt.mipt.oop.interfacesishouse;

import ru.sbt.mipt.oop.house.SensorEvent;

public interface EventProcessor {
  void processEvent(SensorEvent event);
}
