package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.enventshome.AlarmEventProcessor;
import ru.sbt.mipt.oop.enventshome.DoorEventProcessor;
import ru.sbt.mipt.oop.enventshome.HallEventProcessor;
import ru.sbt.mipt.oop.enventshome.LightEventProcessor;
import ru.sbt.mipt.oop.house.SensorEvent;
import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.houseconditions.HouseConditionsFromFile;
import ru.sbt.mipt.oop.interfacesishouse.EventProcessor;
import ru.sbt.mipt.oop.interfacesishouse.EventProducer;
import ru.sbt.mipt.oop.interfacesishouse.HomeState;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.decorators.AlarmDecorator;

import java.io.IOException;

public class Application {

  public static void main(String... args) throws IOException {
    HomeState houseArchive = new HouseConditionsFromFile();
    SmartHome smartHome = houseArchive.getHouseCondition("smart-home-1.js");

    EventProcessor homeLight = new LightEventProcessor(smartHome);
    EventProcessor homeDoor = new DoorEventProcessor(smartHome);
    EventProcessor homeHall = new HallEventProcessor(smartHome);
    EventProcessor homeAlarm = new AlarmEventProcessor(smartHome);

    CompositeEventProcessor handl = new CompositeEventProcessor();
    handl.addEnvent(homeDoor);
    handl.addEnvent(homeLight);
    handl.addEnvent(homeHall);
    handl.addEnvent(homeAlarm);

    EventProcessor handler = new AlarmDecorator(smartHome, handl);

    runEnvents(handler, smartHome);
  }


  private static void runEnvents(EventProcessor handler, SmartHome smartHome) {
    EventProducer produceEnvent = new RandomEventProducer();
    SensorEvent event = produceEnvent.getNextSensorEvent();
    while (event != null) {
      System.out.println("Got event: " + event);
      handler.processEvent(event);
      event = produceEnvent.getNextSensorEvent();
    }
  }

}
