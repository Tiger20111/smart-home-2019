package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.sensor.SensorEvent;

public interface EventProducer {
  SensorEvent getNextSensorEvent();
}