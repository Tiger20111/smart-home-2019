package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.sensor.SensorEvent;

public interface EnventHome {
  void processEnvent(SmartHome smartHome, SensorEvent event);
}
