package ru.sbt.mipt.oop.objectshome.subjects.infrastructure;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Actionable;

import java.util.Collection;

public class Room implements Actionable {

  @Override
  public void execute(Action action) {
    action.execute(this);

    lights.forEach(light -> light.execute(action));
    doors.forEach(door -> door.execute(action));
  }

  public Room(Collection<Light> lights, Collection<Door> doors, String name) {
    this.lights = lights;
    this.doors = doors;
    this.name = name;
  }

  public Collection<Light> getLights() {
    return lights;
  }

  public Collection<Door> getDoors() {
    return doors;
  }

  public String getName() {
    return name;
  }

  private Collection<Light> lights;
  private Collection<Door> doors;
  private String name;

}
