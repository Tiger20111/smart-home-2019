package ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm;

import ru.sbt.mipt.oop.house.Alarm;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.AlarmState;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;

public class ActiveAlarmState implements AlarmState {

  public ActiveAlarmState(Alarm alarmHouse, Code newCode){
    alarm = alarmHouse;
    alarm.setCode(newCode);
  }

  @Override
  public void activateAlarm(Code newCode) {
    alarm.setCode(newCode);
    System.out.println("Alarm is already activated");
  }

  @Override
  public void deactivateAlarm(Code password) {
    if ((alarm.getCode()).equals(password.getCode())){
      AlarmState newState = new DeactiveAlarmState(alarm);
      alarm.changeState(newState);
      System.out.println("Alarm has been deactivated");
    } else {
      System.out.println("The password is wrong!");
      AlarmState newState = new AnxiousAlarmState(alarm, alarm.getCode());
      alarm.changeState(newState);
      System.out.println("The alarm has been set to Anxiously State!");
    }
  }

  @Override
  public AlarmState getState() {
    return alarm.getState();
  }

  private Alarm alarm;
}
