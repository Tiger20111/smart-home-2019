package ru.sbt.mipt.oop.adapter;

import ru.sbt.mipt.oop.CompositeEventProcessor;
import ru.sbt.mipt.oop.enventshome.AlarmEventProcessor;
import ru.sbt.mipt.oop.enventshome.DoorEventProcessor;
import ru.sbt.mipt.oop.enventshome.HallEventProcessor;
import ru.sbt.mipt.oop.enventshome.LightEventProcessor;
import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.interfacesishouse.EventProcessor;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.decorators.AlarmDecorator;

public class EventProcessorCreator {
  public EventProcessor createMyCompositeEventProcessor (SmartHome smartHome) {
    EventProcessor homeLight = new LightEventProcessor(smartHome);
    EventProcessor homeDoor = new DoorEventProcessor(smartHome);
    EventProcessor homeHall = new HallEventProcessor(smartHome);
    EventProcessor homeAlarm = new AlarmEventProcessor(smartHome);

    CompositeEventProcessor processor = new CompositeEventProcessor();

    processor.addEnvent(homeDoor);
    processor.addEnvent(homeLight);
    processor.addEnvent(homeHall);
    processor.addEnvent(homeAlarm);

    EventProcessor handler = new AlarmDecorator(smartHome, processor);

    return handler;
  }
}
