package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.house.SensorEvent;
import ru.sbt.mipt.oop.interfacesishouse.EventProcessor;

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
