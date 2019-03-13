package ru.sbt.mipt.oop.enventshome;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.objectshome.subjects.Light;
import ru.sbt.mipt.oop.objectshome.Room;
import ru.sbt.mipt.oop.sensor.SensorCommand;

public class EnventHall {
  public void HallClosing (SmartHome smartHome) {
    for (Room homeRoom : smartHome.getRooms()) {
      for (Light light : homeRoom.getLights()) {
        light.setOn(false);
        SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
        sendCommand(command);
      }
    }
  }
  private static void sendCommand(SensorCommand command) {
    System.out.println("Pretent we're sending command " + command);
  }
}
