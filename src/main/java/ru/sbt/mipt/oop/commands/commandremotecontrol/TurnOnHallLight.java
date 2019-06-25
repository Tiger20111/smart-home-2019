package ru.sbt.mipt.oop.commands.commandremotecontrol;

import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.objectshome.subjects.infrastructure.Light;
import ru.sbt.mipt.oop.objectshome.subjects.infrastructure.Room;

import java.util.Collection;

public class TurnOnHallLight implements Command{
  private SmartHome smartHome;

  public TurnOnHallLight(SmartHome smartHome) {
    this.smartHome = smartHome;
  }

  @Override
  public void executeCommand() {
    smartHome.execute(object -> {
      if(object instanceof Room && ((Room) object).getName().equals("hall")){
        for (Light light : ((Room) object).getLights())
          light.setOn(true);
      }
    });
  }
}
