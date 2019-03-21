package ru.sbt.mipt.oop.objectshome.subjects.alarm;

public interface AlarmState {
  void activateAlarm(Code activatingCode);

  void deactivateAlarm(Code deactivatingCode);

  AlarmState getState();
}
