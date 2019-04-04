package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.sensor.SensorEvent;

import java.util.ArrayList;
import java.util.Collection;

public class CompositeEventProcessor implements EventProcessor {
  CompositeEventProcessor() {
    eventProcesses = new ArrayList<>();
  }

  public void addEnvent(EventProcessor newEnvent) {
    eventProcesses.add(newEnvent);
  }

  @Override
  public void processEvent(SensorEvent event) {
    for (EventProcessor eventProcessor : eventProcesses) {
      eventProcessor.processEvent(event);
    }
  }

  private Collection<EventProcessor> eventProcesses;
}
