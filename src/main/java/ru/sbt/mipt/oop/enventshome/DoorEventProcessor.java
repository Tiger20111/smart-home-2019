package ru.sbt.mipt.oop.enventshome;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.objectshome.subjects.infrastructure.Door;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;

import static ru.sbt.mipt.oop.sensor.SensorEventType.*;

public class DoorEventProcessor implements EventProcessor {

  public DoorEventProcessor() {
    commandDoor = new SensorEventType[2];
    commandDoor[0] = DOOR_OPEN;
    commandDoor[1] = DOOR_CLOSED;
  }

  @Override
  public void processEvent(SmartHome smartHome, SensorEvent event) {
    if (haveEventDoor(event)) {
      smartHome.execute(object -> {
                if (object instanceof Door)
                  actionDoor((Door)object, event);
              }
      );
    }
  }

  private void actionDoor(Door door, SensorEvent event) {
    switch (event.getType()) {
      case DOOR_OPEN:
        openDoor(door, event);
        break; //не уверен, что нужно, вдруг DOOR_OPEN == DOOR_CLOSE = 1
      case DOOR_CLOSED:
        closeDoor(door, event);
        break;
      default:
        break;
    }
  }

  private boolean haveEventDoor(SensorEvent event) {
    for (SensorEventType aCommandDoor : commandDoor) {
      if (event.getType() == aCommandDoor)
        return true;
    }
    return false;
  }

  private void openDoor(Door door, SensorEvent event) {
    if (door.getId().equals(event.getObjectId())) {
        door.setOpen(true);
        System.out.println("Door " + door.getId() + " was opened.");
      }
    }


  private void closeDoor(Door door, SensorEvent event) {
    if (door.getId().equals(event.getObjectId())) {
      door.setOpen(false);
      System.out.println("Door " + door.getId() + " was closed.");
    }
  }

  private SensorEventType commandDoor[];

}


