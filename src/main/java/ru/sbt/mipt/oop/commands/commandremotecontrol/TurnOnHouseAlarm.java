package ru.sbt.mipt.oop.commands.commandremotecontrol;

import ru.sbt.mipt.oop.house.Alarm;
import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;


public class TurnOnHouseAlarm implements Command {

  public TurnOnHouseAlarm(SmartHome smartHome, Code extremeCode) {
    this.smartHome = smartHome;
    password = extremeCode;
  }

  @Override
  public void executeCommand() {
    Alarm alarm = smartHome.getAlarm();
    alarm.activateAlarm(password);
  }


  private SmartHome smartHome;
  private Code password;
}
