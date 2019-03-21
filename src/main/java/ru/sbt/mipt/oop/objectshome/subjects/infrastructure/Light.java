package ru.sbt.mipt.oop.objectshome.subjects.infrastructure;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;

public class Light implements Actionable {

  @Override
  public void execute(Action action){
    action.execute(this);
  }

  public Light(String id, boolean isOn) {
    this.id = id;
    this.isOn = isOn;
  }

  public boolean isOn() {
    return isOn;
  }

  public String getId() {
    return id;
  }

  public void setOn(boolean on) {
    isOn = on;
  }

  private boolean isOn;
  private final String id;

}
