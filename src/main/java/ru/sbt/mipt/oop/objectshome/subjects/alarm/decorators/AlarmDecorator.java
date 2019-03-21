package ru.sbt.mipt.oop.objectshome.subjects.alarm.decorators;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm.ActiveAlarmState;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm.AnxiousAlarmState;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm.DeactiveAlarmState;
import ru.sbt.mipt.oop.sensor.SensorEvent;

public class AlarmDecorator implements EventProcessor {

  public AlarmDecorator(CompositeEventProcessor newEventProcessor) {
    compositeEventProcessor = newEventProcessor;
  }

  @Override
  public void processEvent(SmartHome smartHome, SensorEvent event) {
    Alarm alarm = smartHome.getAlarm();


    if (alarm.getState() instanceof AnxiousAlarmState) {
      System.out.println("Fixed penetration.");
      return;
    }

    if (alarm.getState() instanceof DeactiveAlarmState) {
      compositeEventProcessor.processEvent(smartHome, event);
      return;
    }


    if (alarm.getState() instanceof ActiveAlarmState) {
      compositeEventProcessor.processEvent(smartHome, event);
      CommandHomeType allCommandHome = new CommandHomeType();
      if (allCommandHome.hasEnventCommandHome(event)) {
        alarm.turnOnAlert();
      }
      return;
    }
  }

  private CompositeEventProcessor compositeEventProcessor;

}
