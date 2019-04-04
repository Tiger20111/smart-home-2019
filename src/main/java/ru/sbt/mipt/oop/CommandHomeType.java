package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;

import static ru.sbt.mipt.oop.sensor.SensorEventType.*;

public class CommandHomeType {
  public CommandHomeType() {
    commandHome = new SensorEventType[4];
    commandHome[0] = DOOR_OPEN;
    commandHome[1] = DOOR_CLOSED;
    commandHome[2] = LIGHT_ON;
    commandHome[3] = LIGHT_OFF;
  }

  public boolean hasEnventCommandHome(SensorEvent event) {
    for (SensorEventType sensorEventType : commandHome) {
      if (event.getType() == sensorEventType)
        return true;
    }
    return false;
  }
  private SensorEventType commandHome[];
}
