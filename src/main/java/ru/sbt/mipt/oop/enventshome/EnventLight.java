package ru.sbt.mipt.oop.enventshome;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.objectshome.subjects.Light;
import ru.sbt.mipt.oop.objectshome.Room;
import ru.sbt.mipt.oop.sensor.SensorEvent;

import static ru.sbt.mipt.oop.sensor.SensorEventType.*;

public class EnventLight implements EnventHome {

  @Override
  public void processEnvent(SmartHome smartHome, SensorEvent event) {
    if (event.getType() == LIGHT_ON) {
      switchOn(smartHome, event);
    }

    if (event.getType() == LIGHT_OFF) {
      switchOff(smartHome, event);
    }
  }

  private void switchOn(SmartHome smartHome, SensorEvent event) {
    for (Room room : smartHome.getRooms()) {
      for (Light light : room.getLights()) {
        if (light.getId().equals(event.getObjectId())) {
          light.setOn(true);
          System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
        }
      }
    }
  }

  private void switchOff(SmartHome smartHome, SensorEvent event) {
    for (Room room : smartHome.getRooms()) {
      for (Light light : room.getLights()) {
        if (light.getId().equals(event.getObjectId())) {
          light.setOn(false);
          System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
        }
      }
    }
  }
}