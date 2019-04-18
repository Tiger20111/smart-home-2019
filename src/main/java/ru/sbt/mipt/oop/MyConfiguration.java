package ru.sbt.mipt.oop;

import com.sun.org.glassfish.gmbal.Description;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.adapter.EventProcessorCreator;
import ru.sbt.mipt.oop.adapter.MyManagerAdapter;
import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.houseconditions.HouseConditionsFromFile;
import ru.sbt.mipt.oop.interfacesishouse.EventsManager;
import ru.sbt.mipt.oop.interfacesishouse.HomeState;

import java.io.IOException;

@Configuration
public class MyConfiguration {

  public MyConfiguration() throws IOException {
    HomeState houseArchive = new HouseConditionsFromFile();
    SmartHome smartHome = houseArchive.getHouseCondition("smart-home-1.js");
    this.smartHome = smartHome;

    EventProcessorCreator eventProcessorCreator = new EventProcessorCreator();

    eventsManager = new MyManagerAdapter();
    eventsManager.setEventProcessor(eventProcessorCreator.createMyCompositeEventProcessor(smartHome));
  }

  @Bean
  @Description("smarthome")
  SmartHome getSmartHome() {
    return smartHome;
  }

  @Bean
  @Description("eventsManager")
  EventsManager getEventsManager() {
    return eventsManager;
  }


  private SmartHome smartHome;
  private EventsManager eventsManager;

}