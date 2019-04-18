package ru.sbt.mipt.oop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import ru.sbt.mipt.oop.interfacesishouse.EventsManager;

public class Application {

  public static void main(String... args) {
    AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
    EventsManager eventsManager = context.getBean(EventsManager.class);
    eventsManager.runEnvents();
  }
}
