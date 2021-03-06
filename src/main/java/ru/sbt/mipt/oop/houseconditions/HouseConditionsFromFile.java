package ru.sbt.mipt.oop.houseconditions;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.interfacesishouse.HomeState;
import ru.sbt.mipt.oop.house.SmartHome;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HouseConditionsFromFile implements HomeState {
  @Override
  public SmartHome getHouseCondition(String path) throws IOException {
    Gson gson = new Gson();
    String json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
    return gson.fromJson(json, SmartHome.class);
  }
}
