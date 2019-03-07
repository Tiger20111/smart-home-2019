package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.sensor.SensorEvent;

public interface EnventHome {
  void SwitchOn (SmartHome smartHome, SensorEvent event);
  void SwitchOff(SmartHome smartHome, SensorEvent event);
}
