package ru.sbt.mipt.oop.enventshome;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.objectshome.Room;
import ru.sbt.mipt.oop.objectshome.subjects.Light;
import ru.sbt.mipt.oop.sensor.SensorCommand;
import ru.sbt.mipt.oop.sensor.SensorEvent;

import static ru.sbt.mipt.oop.sensor.SensorEventType.DOOR_CLOSED;

public class EnventHall implements EnventHome{
  @Override
  public void processEnvent(SmartHome smartHome, SensorEvent event) {
    if (event.getType() == DOOR_CLOSED) {
      closeHall(smartHome);
    }
  }
  private boolean needCloseHome (SmartHome smartHome) {
    for (Room homeRoom : smartHome.getRooms()) {
      if (homeRoom.getName().equals("hall"))
        return true;
    }
    return false;
  }

  private void closeHall(SmartHome smartHome) {
    if (needCloseHome(smartHome)) {
      for (Room homeRoom : smartHome.getRooms()) {
        for (Light light : homeRoom.getLights()) {
          light.setOn(false);
          SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
          sendCommand(command);
        }
      }
    }
  }

  private static void sendCommand(SensorCommand command) {
    System.out.println("Pretent we're sending command " + command);
  }
}
