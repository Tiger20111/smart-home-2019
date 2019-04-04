package ru.sbt.mipt.oop.objectshome.subjects.alarm.decorators;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm.ActiveAlarmState;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm.AnxiousAlarmState;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.statesalarm.DeactiveAlarmState;
import ru.sbt.mipt.oop.CompositeEventProcessor;
import ru.sbt.mipt.oop.sensor.SensorEvent;

public class AlarmDecorator implements EventProcessor {

  public AlarmDecorator(SmartHome smartHome, CompositeEventProcessor newEventProcessor) {
    compositeEventProcessor = newEventProcessor;
    this.smartHome = smartHome;
  }

  @Override
  public void processEvent(SensorEvent event) {
    Alarm alarm = smartHome.getAlarm();


    if (alarm.getState() instanceof AnxiousAlarmState) {
      System.out.println("Fixed penetration.");
      return;
    }

    if (alarm.getState() instanceof DeactiveAlarmState) {
      compositeEventProcessor.processEvent(event);
      return;
    }


    if (alarm.getState() instanceof ActiveAlarmState) {
      compositeEventProcessor.processEvent(event);
      CommandHomeType allCommandHome = new CommandHomeType();
      if (allCommandHome.hasEnventCommandHome(event)) {
        alarm.turnOnAlert();
      }
      return;
    }
  }

  private CompositeEventProcessor compositeEventProcessor;
  private final SmartHome smartHome;

}
