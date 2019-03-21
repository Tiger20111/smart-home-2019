package ru.sbt.mipt.oop.objectshome.subjects.alarm.decorators;

import ru.sbt.mipt.oop.Alarm;
import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.AlarmState;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm.ActiveAlarmState;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm.AnxiousAlarmState;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm.DeactiveAlarmState;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.CommandHomeType;

public class AlarmDecorator implements EventProcessor {
  private EventProcessor eventProcessor;

  @Override
  public void processEvent(SmartHome smartHome, SensorEvent event) {
    Alarm alarm = smartHome.getAlarm();


    if (alarm.getState() instanceof AnxiousAlarmState) {
      return;

      if (alarm.getState() instanceof DeactiveAlarmState) {
        eventProcessor.processEvent(smartHome, event);
        return;
      }


      if (alarm.getState() instanceof ActiveAlarmState) {
        eventProcessor.processEvent(smartHome, event);
        CommandHomeType allCommandHome = new CommandHomeType();
        if (allCommandHome.hasEnventCommandHome(event)) {
          alarm.turnOnAlert();
        }
        return;
      }
    }
  }


}
