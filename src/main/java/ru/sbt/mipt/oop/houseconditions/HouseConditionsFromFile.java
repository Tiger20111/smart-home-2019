package ru.sbt.mipt.oop.houseconditions;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.HouseCondition;
import ru.sbt.mipt.oop.SmartHome;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HouseConditionsFromFile implements HouseCondition {
  @Override
  public SmartHome getHouseCondition(String path) throws IOException {
    Gson gson = new Gson();
    String json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
    return gson.fromJson(json, SmartHome.class);
  }
}
