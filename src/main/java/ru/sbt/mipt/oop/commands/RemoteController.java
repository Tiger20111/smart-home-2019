package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.commands.commandremotecontrol.*;
import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;

import java.util.HashMap;

public class RemoteController {

  public void onButtonPressed(String buttonCode) {

    if (buttonCommands.containsKey(buttonCode)){
      (buttonCommands.get(buttonCode)).executeCommand();
    }
  }


  public void addCommand(String buttonCode, Command command) {
    buttonCommands.put(buttonCode, command);
  }

  private HashMap<String, Command> buttonCommands;
}
