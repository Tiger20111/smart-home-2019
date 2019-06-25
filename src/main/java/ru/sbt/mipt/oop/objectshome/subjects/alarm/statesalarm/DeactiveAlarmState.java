package ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm;

import ru.sbt.mipt.oop.house.Alarm;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.AlarmState;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;

public class DeactiveAlarmState implements AlarmState {

  public DeactiveAlarmState(Alarm alarmHouse){
    alarm = alarmHouse;
  }


  @Override
  public void activateAlarm(Code newCode) {
    AlarmState newState = new ActiveAlarmState(alarm, newCode);
    alarm.changeState(newState);
    System.out.println("Alarm activated");
  }

  @Override
  public void deactivateAlarm(Code password) {
    System.out.println("Alarm is already deactivated");
  }

  @Override
  public AlarmState getState() {
    return alarm.getState();
  }

  private Alarm alarm;
  private Code code;
}
