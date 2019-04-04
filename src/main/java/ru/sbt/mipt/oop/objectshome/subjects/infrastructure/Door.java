package ru.sbt.mipt.oop.objectshome.subjects.infrastructure;

import ru.sbt.mipt.oop.interfacesishouse.Action;
import ru.sbt.mipt.oop.interfacesishouse.Actionable;

public class Door implements Actionable {

  @Override
  public void execute(Action action){
    action.execute(this);
  }

  public Door(boolean isOpen, String id) {
    this.isOpen = isOpen;
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setOpen(boolean open) {
    isOpen = open;
  }

  private final String id;
  private boolean isOpen;

}
