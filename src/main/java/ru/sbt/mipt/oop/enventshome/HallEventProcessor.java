package ru.sbt.mipt.oop.enventshome;

import ru.sbt.mipt.oop.commands.eventstypes.CommandType;
import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.interfacesishouse.EventProcessor;
import ru.sbt.mipt.oop.objectshome.subjects.infrastructure.Room;
import ru.sbt.mipt.oop.objectshome.subjects.infrastructure.Door;
import ru.sbt.mipt.oop.objectshome.subjects.infrastructure.Light;
import ru.sbt.mipt.oop.commands.eventstypes.SensorCommand;
import ru.sbt.mipt.oop.house.SensorEvent;
import ru.sbt.mipt.oop.commands.eventstypes.SensorEventType;

import static ru.sbt.mipt.oop.commands.eventstypes.SensorEventType.DOOR_CLOSED;

public class HallEventProcessor implements EventProcessor {

  public HallEventProcessor(SmartHome smartHome) {
    this.smartHome = smartHome;
    commandHall = new SensorEventType[2];
    commandHall[0] = DOOR_CLOSED;
  }

  @Override
  public void processEvent(SensorEvent event) {
    if (hasEventLight(event)) {
      closeHall(smartHome, event);
    }
  }

  private boolean hasEventLight(SensorEvent event) {
    for (SensorEventType aCommandHall : commandHall) {
      if (event.getType() == aCommandHall)
        return true;
    }
    return false;
  }

  private boolean needCloseHome (SmartHome smartHome, SensorEvent event) {
    for (Room homeRoom : smartHome.getRooms()) {
      if (homeRoom.getName().equals("hall")) {
        for (Door door : homeRoom.getDoors()) {
          if (door.getId().equals(event.getObjectId()))
            return true;
        }
      }
    }
    return false;
  }

  private void closeHall(SmartHome smartHome, SensorEvent event) {
    if (needCloseHome(smartHome, event)) {
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

  private SensorEventType commandHall[];
  private final SmartHome smartHome;
}


//пока не придумал как корректно обработать.