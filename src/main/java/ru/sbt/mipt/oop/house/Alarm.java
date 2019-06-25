package ru.sbt.mipt.oop.house;

import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.AlarmState;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm.AnxiousAlarmState;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm.DeactiveAlarmState;

public class Alarm {
  private AlarmState state;
  private Code code;

  public Alarm(){
    this.state = new DeactiveAlarmState(this);
  }

  public AlarmState getState(){
    return state;
  }

  public void setCode(Code newCode){
    code = newCode;
  }

  public Code getCode(){
    return code;
  }

  public void changeState(AlarmState newState){
    state = newState;
  }

  public void activateAlarm(Code code){
    state.activateAlarm(code);
  }

  public void deactivateAlarm(Code code){
    state.deactivateAlarm(code);
  }

  public void turnOnAlert() {
    System.out.println("Fixed penetration.");
    AlarmState newState = new AnxiousAlarmState(this, code);
    this.changeState(newState);
    System.out.println("The alarm has been set to Anxiously State!");
  }
}
