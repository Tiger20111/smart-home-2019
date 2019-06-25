package ru.sbt.mipt.oop.commands;

import ru.sbt.mipt.oop.commands.commandremotecontrol.*;
import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.interfacesishouse.RemoteControl;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;

import java.util.HashMap;

public class RemoteControlers implements RemoteControl {

  public RemoteControlers(SmartHome smartHome, Code code, RemoteControl remoteControlRegistr) {
    remoteControllers = new HashMap<>();
  }

  @Override
  public void onButtonPressed(String buttonCode, String rcId) {
    if (remoteControllers.containsKey(rcId)) {
      (remoteControllers.get(rcId)).onButtonPressed(buttonCode);
    }
  }

  public void registerRemoteController(RemoteController remoteController, String rcId) {
    remoteControllers.put(rcId, remoteController);
  }

  private HashMap<String, RemoteController> remoteControllers;
}
