package ru.sbt.mipt.oop.commands.commandremotecontrol;

import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.objectshome.subjects.infrastructure.Light;

public class TurnOffHouseLight implements Command{
  public TurnOffHouseLight(SmartHome smartHome) {
    this.smartHome = smartHome;
  }

  @Override
  public void executeCommand() {


    smartHome.execute(object ->
    {
      if (object instanceof Light){
        ((Light)(object)).setOn(false);
      }
    });
  }


  private SmartHome smartHome;
}
