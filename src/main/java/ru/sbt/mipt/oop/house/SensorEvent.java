package ru.sbt.mipt.oop.house;

import ru.sbt.mipt.oop.commands.eventstypes.SensorEventType;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;

public class SensorEvent {
  private final SensorEventType type;
  private String objectId;
  private Code code;

  public SensorEvent(SensorEventType type, String objectId) {
    this.type = type;
    this.objectId = objectId;
  }
  public SensorEvent(SensorEventType type, Code code) {
    this.type = type;
    this.code = code;
  }

  public SensorEventType getType() {
    return type;
  }

  public String getObjectId() {
    return objectId;
  }

  public Code getCode() {
    return code;
  }

  @Override
  public String toString() {
    return "SensorEvent{" +
            "type=" + type +
            ", objectId='" + objectId + '\'' +
            '}';
  }

}
