package ru.sbt.mipt.oop.commands.commandremotecontrol;

import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.objectshome.subjects.infrastructure.Door;
import ru.sbt.mipt.oop.objectshome.subjects.infrastructure.Room;

public class TurnOffHallDoor implements Command {

  public TurnOffHallDoor(SmartHome smartHome) {
    this.smartHome = smartHome;
  }

  @Override
  public void executeCommand() {
    smartHome.execute(obj -> {
      if(obj instanceof Room && ((Room) obj).getName().equals("hall")){
        for (Door door : ((Room) obj).getDoors())
          door.setOpen(false);
      }
    });
  }

  private SmartHome smartHome;
}
