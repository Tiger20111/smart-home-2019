package ru.sbt.mipt.oop.enventshome;

import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;

import static ru.sbt.mipt.oop.sensor.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.sensor.SensorEventType.ALARM_DEACTIVATE;

public class AlarmEventProcessor implements EventProcessor {

  public AlarmEventProcessor() {
    commandAlarm = new SensorEventType[2];
    commandAlarm[0] = ALARM_ACTIVATE;
    commandAlarm[1] = ALARM_DEACTIVATE;
  }

  @Override
  public void processEvent(SmartHome smartHome, SensorEvent event) {
    if (hasEventAlarm(event)) {
      if (event.getType() == ALARM_ACTIVATE) {
        Code newCode = new Code();
        newCode.setCode(event.getObjectId());
        smartHome.activateAlarm(newCode);
      } else {
        Code password = new Code();
        password.setCode(event.getObjectId());
        smartHome.deactivateAlarm(password);
      }
    }
  }

  private boolean hasEventAlarm(SensorEvent event) {
    for (SensorEventType aCommandAlarm : commandAlarm) {
      if (event.getType() == aCommandAlarm)
        return true;
    }
    return false;
  }

  private SensorEventType commandAlarm[];


}