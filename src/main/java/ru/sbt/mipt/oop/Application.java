package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.enventshome.EnventDoor;
import ru.sbt.mipt.oop.enventshome.EnventHall;
import ru.sbt.mipt.oop.enventshome.EnventLight;
import ru.sbt.mipt.oop.houseconditions.HouseConditionsFromFile;
import ru.sbt.mipt.oop.sensor.SensorEvent;

import java.io.IOException;

public class Application {

  public static void main(String... args) throws IOException {
    HouseCondition houseArchive = new HouseConditionsFromFile();
    SmartHome smartHome = houseArchive.getHouseCondition("smart-home-1.js");

    EnventHome homeLight = new EnventLight();
    EnventHome homeDoor = new EnventDoor();
    EnventHome homeHall = new EnventHall();

    EnventHandler handler = new EnventHandler();
    handler.addEnvent(homeDoor);
    handler.addEnvent(homeLight);
    handler.addEnvent(homeHall);

    runEnvents(handler, smartHome);
  }


  private static void runEnvents(EnventHandler handler, SmartHome smartHome) {
    ProducerInvents produceEnvent = new ProduceNewEnventRandomly();
    SensorEvent event = produceEnvent.getNextSensorEvent();
    while (event != null) {
      System.out.println("Got event: " + event);
      handler.processEnvent(smartHome, event);
      event = produceEnvent.getNextSensorEvent();
    }
  }

}
