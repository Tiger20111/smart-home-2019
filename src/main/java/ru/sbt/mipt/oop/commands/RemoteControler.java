package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.commands.commandremotecontrol.*;
import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.interfacesishouse.RemoteControl;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;

import java.util.HashMap;

public class RemoteControler implements RemoteControl {

  public RemoteControler (SmartHome smartHome, Code code, RemoteControl remoteControlRegistr) {
    RemoteControlInizaliaton(smartHome, code);
    buttonCommands = RemoteControlInizaliaton(smartHome, code);
  }

  @Override
  public void onButtonPressed(String buttonCode, String rcId) {
    if (buttonCommands.containsKey(buttonCode)){
      (buttonCommands.get(buttonCode)).executeCommand();
    }
  }

  private HashMap <String, Command> RemoteControlInizaliaton(SmartHome smartHome, Code code) {
    HashMap<String, Command> buttonCommands = new HashMap<>();

    buttonCommands.put("A", new TurnOffHallDoor(smartHome));
    buttonCommands.put("B", new TurnOffHouseLight(smartHome));
    buttonCommands.put("C", new TurnOnHallLight(smartHome));
    buttonCommands.put("D", new TurnOnHouseAlarm(smartHome,code));
    buttonCommands.put("1", new TurnOnHouseAlert(smartHome));
    buttonCommands.put("2", new TurnOnHouseLight(smartHome));

    return buttonCommands;
  }

  private HashMap <String, Command>  buttonCommands;
}
