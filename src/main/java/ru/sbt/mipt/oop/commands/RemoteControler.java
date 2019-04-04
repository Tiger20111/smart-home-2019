package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.commands.commandremotecontrol.*;
import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.interfacesishouse.RemoteControl;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;

import java.util.HashMap;

public class RemoteControler implements RemoteControl {

  public RemoteControler (SmartHome smartHome, Code code, RemoteControl remoteControlRegistr) {
    RemoteControlInizaliaton(smartHome);
    buttonCommands = RemoteControlInizaliaton(smartHome, code);
  }

  @Override
  public void onButtonPressed(String buttonCode, String rcId) {
    if (buttonCommands.containsKey(buttonCode)){
      (buttonCommands.get(buttonCode)).executeCommand();
    }
  }

  private HashMap <String, Command> RemoteControlInizaliaton(SmartHome smartHome, Code code) {
    HashMap<String, Command> buttonCommands = new HashMap<String, Command>();
    Command offHallDoor = new TurnOffHallDoor(smartHome);
    Command offHouseLight = new TurnOffHouseLight(smartHome);
    Command onHallLight = new TurnOnHallLight(smartHome);
    Command onHouseAlarm = new TurnOnHouseAlarm(smartHome,code);
    Command onHouseAlert = new TurnOnHouseAlert(smartHome);
    Command onHouseLight = new TurnOnHouseLight(smartHome);


    buttonCommands.put("A", offHallDoor);
    buttonCommands.put("B", offHouseLight);
    buttonCommands.put("C", onHallLight);
    buttonCommands.put("D", onHouseAlarm);
    buttonCommands.put("1", onHouseAlert);
    buttonCommands.put("2", onHouseLight);

    return buttonCommands;
  }

  private HashMap <String, Command>  buttonCommands;
  private  SmartHome smartHome;
}
