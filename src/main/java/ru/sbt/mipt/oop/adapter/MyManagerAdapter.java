package ru.sbt.mipt.oop.adapter;

import ru.sbt.mipt.oop.house.SensorEvent;
import ru.sbt.mipt.oop.interfacesishouse.EventProcessor;
import ru.sbt.mipt.oop.interfacesishouse.EventProducer;
import ru.sbt.mipt.oop.interfacesishouse.EventsManager;

import java.util.ArrayList;
import java.util.List;

public class MyManagerAdapter implements EventsManager {

  public MyManagerAdapter() {
    eventProcessors = new ArrayList<>();
  }

  @Override
  public void runEnvents() {
    EventProducer produceEnvent = new RandomEventProducer();
    SensorEvent event = produceEnvent.getNextSensorEvent();
    while (event != null) {
      System.out.println("Got event: " + event);

      for (EventProcessor processor : eventProcessors) {
        processor.processEvent(event);
      }

      event = produceEnvent.getNextSensorEvent();
    }
  }

  @Override
  public void setEventProcessor(EventProcessor eventProcessor) {
    eventProcessors.add(eventProcessor);
  }

  private List<EventProcessor> eventProcessors;
}
