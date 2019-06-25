package ru.sbt.mipt.oop.interfacesishouse;

public interface EventsManager {
  void runEvents();
  void setEventProcessor(EventProcessor eventProcessor);
  void setEventProducer(EventProducer eventProducer);
}
