package ru.sbt.mipt.oop.enventshome;

import ru.sbt.mipt.oop.interfacesishouse.EventProcessor;
import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;
import ru.sbt.mipt.oop.house.SensorEvent;
import ru.sbt.mipt.oop.commands.eventstypes.SensorEventType;

import static ru.sbt.mipt.oop.commands.eventstypes.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.commands.eventstypes.SensorEventType.ALARM_DEACTIVATE;

public class AlarmEventProcessor implements EventProcessor {

  public AlarmEventProcessor(SmartHome smartHome) {
    this.smartHome = smartHome;
    commandAlarm = new SensorEventType[2];
    commandAlarm[0] = ALARM_ACTIVATE;
    commandAlarm[1] = ALARM_DEACTIVATE;
  }

  @Override
  public void processEvent(SensorEvent event) {
    if (hasEventAlarm(event)) {
      if (event.getType() == ALARM_ACTIVATE) {
        Code newCode = event.getCode();
        smartHome.activateAlarm(newCode);
      } else {
        Code password;
        password = event.getCode();
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

  private final SmartHome smartHome;

}