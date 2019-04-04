package ru.sbt.mipt.oop.commands.commandremotecontrol;

import ru.sbt.mipt.oop.house.Alarm;
import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.AlarmState;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm.AnxiousAlarmState;

public class TurnOnHouseAlert implements Command {

  public TurnOnHouseAlert(SmartHome smartHome) {
    this.smartHome = smartHome;
  }

  @Override
  public void executeCommand() {
    Alarm alarm = smartHome.getAlarm();
    alarm.turnOnAlert();
    }

  private SmartHome smartHome;
}
