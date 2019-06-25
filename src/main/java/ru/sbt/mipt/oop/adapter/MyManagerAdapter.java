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
  public void runEvents() {
    EventProducer produceEvent = new RandomEventProducer();
    SensorEvent event = eventProducer.getNextSensorEvent();
    while (event != null) {
      System.out.println("Got event: " + event);

      for (EventProcessor processor : eventProcessors) {
        processor.processEvent(event);
      }

      event = eventProducer.getNextSensorEvent();
    }
  }

  @Override
  public void setEventProcessor(EventProcessor eventProcessor) {
    eventProcessors.add(eventProcessor);
  }


  @Override
  public void setEventProducer(EventProducer eventProducer) {
    this.eventProducer = eventProducer;
  }

  private EventProducer eventProducer;
  private List<EventProcessor> eventProcessors;
}
