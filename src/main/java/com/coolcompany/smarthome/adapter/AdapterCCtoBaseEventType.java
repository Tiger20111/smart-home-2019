package com.coolcompany.smarthome.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.house.SensorEvent;
import ru.sbt.mipt.oop.commands.eventstypes.SensorEventType;

public class AdapterCCtoBaseEventType extends SensorEvent {

  public AdapterCCtoBaseEventType (CCSensorEvent event) {
    super(changeTypeEvent(event), event.getObjectId(), null);
  }

  private static SensorEventType changeTypeEvent (CCSensorEvent envent) {
    switch (envent.getEventType()) {
      case "LightIsOn":       return SensorEventType.LIGHT_ON;
      case "LightIsOff":      return SensorEventType.LIGHT_OFF;
      case "DoorIsOpen":      return SensorEventType.DOOR_OPEN;
      case "DoorIsClosed":    return SensorEventType.DOOR_CLOSED;
      case "DoorIsLocked":    return SensorEventType.DOOR_LOCKED;
      case "DoorIsUnLocked":  return SensorEventType.DOOR_UNLOCKED;
    }

    return null;
  }
  private CCSensorEvent ccSensorEvent;
}
