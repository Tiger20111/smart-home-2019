package ru.sbt.mipt.oop.commands.eventstypes;

import ru.sbt.mipt.oop.house.SensorEvent;

import static ru.sbt.mipt.oop.commands.eventstypes.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.commands.eventstypes.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.commands.eventstypes.SensorEventType.LIGHT_ON;

public class CommandHomeType {
  public CommandHomeType() {
    commandHome = new SensorEventType[4];
    commandHome[0] = SensorEventType.DOOR_OPEN;
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
