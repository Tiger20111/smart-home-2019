package ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm;

import ru.sbt.mipt.oop.Alarm;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.AlarmState;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;


public class ActiveAlarmState implements AlarmState {

  public ActiveAlarmState(Alarm alarmHouse, Code newCode){
    alarm = alarmHouse;
    code.setCode(newCode.getCode());
  }

  @Override
  public void activateAlarm(Code newCode) {
    code.setCode(newCode.getCode());
    System.out.println("Alarm is already activated");
  }

  @Override
  public void deactivateAlarm(Code password) {
    if ((code.getCode()).equals(password.getCode())){
      AlarmState newState = new DeactiveAlarmState(alarm);
      alarm.changeState(newState);
      System.out.println("Alarm has been deactivated");
    } else {
      System.out.println("The password is wrong!");
      AlarmState newState = new AnxiousAlarmState(alarm, code);
      alarm.changeState(newState);
      System.out.println("The alarm has been set to Anxiously State!");
    }
  }

  @Override
  public AlarmState getState() {
    return alarm.getState();
  }

  private Alarm alarm;
  private Code code;
}
