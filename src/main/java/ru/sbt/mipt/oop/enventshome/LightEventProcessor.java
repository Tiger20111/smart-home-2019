package ru.sbt.mipt.oop.enventshome;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.objectshome.subjects.infrastructure.Light;
import ru.sbt.mipt.oop.sensor.SensorEvent;
import ru.sbt.mipt.oop.sensor.SensorEventType;

import static ru.sbt.mipt.oop.sensor.SensorEventType.*;

public class LightEventProcessor implements EventProcessor {

  public LightEventProcessor() {
    commandLight = new SensorEventType[2];
    commandLight[0] = LIGHT_ON;
    commandLight[1] = LIGHT_OFF;
  }

  @Override
  public void processEvent(SmartHome smartHome, SensorEvent event) {
    if (hasEventLight(event)) {
      smartHome.execute(object -> {
                if (object instanceof Light)
                  actionLight((Light) object, event);
              }
      );
    }
  }

  private boolean hasEventLight(SensorEvent event) {
    for (SensorEventType aCommandLight : commandLight) {
      if (event.getType() == aCommandLight)
        return true;
    }
    return false;
  }

  private void actionLight(Light light, SensorEvent event) {
    switch (event.getType()) {
      case LIGHT_ON:
        switchOn(light, event);
        break; //не уверен, что нужно, вдруг DOOR_OPEN == DOOR_CLOSE = 1
      case DOOR_CLOSED:
        switchOff(light, event);
        break;
      default:
        break;
    }
  }

  private void switchOn(Light light, SensorEvent event) {
    if (light.getId().equals(event.getObjectId())) {
      light.setOn(true);
      System.out.println("Light " + light.getId() + " was turned on.");
    }
  }


  private void switchOff(Light light, SensorEvent event) {
    if (light.getId().equals(event.getObjectId())) {
      light.setOn(false);
      System.out.println("Light " + light.getId() + " was turned off.");
    }
  }

  private SensorEventType commandLight[];
}