package ru.sbt.mipt.oop.enventshome;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.objectshome.subjects.Door;
import ru.sbt.mipt.oop.objectshome.Room;
import ru.sbt.mipt.oop.sensor.SensorEvent;

public class EnventDoor implements EnventHome {

  @Override
  public void SwitchOn (SmartHome smartHome, SensorEvent event) {
    // событие от двери
    for (Room room : smartHome.getRooms()) {
      for (Door door : room.getDoors()) {
        if (door.getId().equals(event.getObjectId())) {
            door.setOpen(true);
            System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
        }
      }
    }
  }

  public void SwitchOff (SmartHome smartHome, SensorEvent event) {
    EnventHall hall = new EnventHall();
    for (Room room : smartHome.getRooms()) {
      for (Door door : room.getDoors()) {
        if (door.getId().equals(event.getObjectId())) {
          door.setOpen(false);
          System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
          // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
          // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
          if (room.getName().equals("hall")) {
            hall.HallClosing(smartHome);
          }
        }
      }
    }
  }
}


