package ru.sbt.mipt.oop.enventshome;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.objectshome.subjects.Door;
import ru.sbt.mipt.oop.objectshome.Room;
import ru.sbt.mipt.oop.sensor.SensorEvent;

import static ru.sbt.mipt.oop.sensor.SensorEventType.*;

public class EnventDoor implements EnventHome {
  @Override
  public void processEnvent(SmartHome smartHome, SensorEvent event) {
    if (event.getType() == DOOR_OPEN) {
      openDoor(smartHome, event);
    }

    if (event.getType() == DOOR_CLOSED) {
      closeDoor(smartHome, event);
    }
  }

  private void openDoor(SmartHome smartHome, SensorEvent event) {
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

  private void closeDoor(SmartHome smartHome, SensorEvent event) {
    for (Room room : smartHome.getRooms()) {
      for (Door door : room.getDoors()) {
        if (door.getId().equals(event.getObjectId())) {
          door.setOpen(false);
          System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
        }
      }
    }
  }


}


