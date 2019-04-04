package ru.sbt.mipt.oop.house;

import ru.sbt.mipt.oop.interfacesishouse.Action;
import ru.sbt.mipt.oop.interfacesishouse.Actionable;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;
import ru.sbt.mipt.oop.objectshome.subjects.infrastructure.Room;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable {

  @Override
  public void execute(Action action){
    action.execute(this);

    for (Room room : rooms) {
      room.execute(action);
    }

  }

  public SmartHome() {
    rooms = new ArrayList<>();
    alarm = new Alarm();
  }

  public SmartHome(Collection<Room> rooms) {
    this.rooms = rooms;
  }

  public void addRoom(Room room) {
    rooms.add(room);
  }

  public Collection<Room> getRooms() {
    return rooms;
  }


  public void activateAlarm(Code code){

    alarm.activateAlarm(code);
  }

  public void deactivateAlarm(Code code){

    alarm.deactivateAlarm(code);
  }

  public Alarm getAlarm(){
    return alarm;
  }

  Collection<Room> rooms;
  private Alarm alarm;
}
