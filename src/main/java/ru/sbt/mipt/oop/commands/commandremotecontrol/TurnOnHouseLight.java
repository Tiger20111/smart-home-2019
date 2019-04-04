package ru.sbt.mipt.oop.commands.commandremotecontrol;

import ru.sbt.mipt.oop.house.SensorEvent;
import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.objectshome.subjects.infrastructure.Light;

public class TurnOnHouseLight implements Command{

  public TurnOnHouseLight(SmartHome smartHome) {
    this.smartHome = smartHome;
  }

  @Override
  public void executeCommand() {


    smartHome.execute(object ->
    {
      if (object instanceof Light){
        ((Light)(object)).setOn(true);
      }
    });
  }


  private SmartHome smartHome;
}
