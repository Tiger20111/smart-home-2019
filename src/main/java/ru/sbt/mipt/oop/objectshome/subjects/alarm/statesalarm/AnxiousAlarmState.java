package ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm;

import ru.sbt.mipt.oop.Alarm;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.AlarmState;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;

public class AnxiousAlarmState implements AlarmState{

  public AnxiousAlarmState(Alarm alarmHouse, Code newCode) {
    alarm = alarmHouse;
    code.setCode(newCode.getCode());
  }

  @Override
  public void activateAlarm(Code newCode) {
    System.out.println("Alarm is already activated, alert is turned on!");
  }

  @Override
  public void deactivateAlarm(Code password) {
    if ((password.getCode()).equals(code.getCode())){
      AlarmState newState = new DeactiveAlarmState(alarm);
      alarm.changeState(newState);
      System.out.println("Alarm deactivated");
    } else {
      System.out.println("The password is wrong!");
    }
  }

  @Override
  public AlarmState getState() {
    return alarm.getState();
  }

  private Code code;
  private Alarm alarm;

}
