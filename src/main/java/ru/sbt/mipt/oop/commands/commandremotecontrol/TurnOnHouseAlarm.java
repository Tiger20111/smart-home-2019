package ru.sbt.mipt.oop.commands.commandremotecontrol;

import ru.sbt.mipt.oop.house.Alarm;
import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;


public class TurnOnHouseAlarm implements Command {

  public TurnOnHouseAlarm(SmartHome smartHome, Code extremeCode) {
    alarm = smartHome.getAlarm();
    password = extremeCode;
  }

  @Override
  public void executeCommand() {
    alarm.activateAlarm(password);
  }


  private Code password;
  private Alarm alarm;
}
