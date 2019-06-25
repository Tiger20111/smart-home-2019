package ru.sbt.mipt.oop.adapter;

import ru.sbt.mipt.oop.commands.RemoteController;
import ru.sbt.mipt.oop.commands.commandremotecontrol.*;
import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;

public class MyRemoteController {
  RemoteController getMyRemoteController(SmartHome smartHome) {
    RemoteController myRemoteControl = new RemoteController();

    Code code = new Code();

    myRemoteControl.addCommand("A", new TurnOffHallDoor(smartHome));
    myRemoteControl.addCommand("B", new TurnOffHouseLight(smartHome));
    myRemoteControl.addCommand("C", new TurnOnHallLight(smartHome));
    myRemoteControl.addCommand("D", new TurnOnHouseAlarm(smartHome,code));
    myRemoteControl.addCommand("1", new TurnOnHouseAlert(smartHome));
    myRemoteControl.addCommand("2", new TurnOnHouseLight(smartHome));

    return myRemoteControl;
  }
}
