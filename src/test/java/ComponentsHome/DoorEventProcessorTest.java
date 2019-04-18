package ComponentsHome;

import org.junit.Test;
import ru.sbt.mipt.oop.commands.eventstypes.SensorEventType;
import ru.sbt.mipt.oop.enventshome.DoorEventProcessor;
import ru.sbt.mipt.oop.house.SensorEvent;
import ru.sbt.mipt.oop.house.SmartHome;
import ru.sbt.mipt.oop.houseconditions.HouseConditionsFromFile;
import ru.sbt.mipt.oop.interfacesishouse.HomeState;
import ru.sbt.mipt.oop.objectshome.subjects.infrastructure.Door;
import ru.sbt.mipt.oop.objectshome.subjects.infrastructure.Room;

import java.io.IOException;

import static org.junit.Assert.*;

public class DoorEventProcessorTest {


  @Test
  public void testOpeningDoorProcessor() throws IOException {
    assertTrue(testEventDoorProcessor(SensorEventType.DOOR_OPEN));
  }

  @Test
  public void testClosingDoorProcessor() throws IOException {
    assertFalse(testEventDoorProcessor(SensorEventType.DOOR_CLOSED));
  }

  private boolean testEventDoorProcessor (SensorEventType type) throws IOException {
    HomeState houseArchive = new HouseConditionsFromFile();
    SmartHome smartHome = houseArchive.getHouseCondition("smart-home-1.js");

    String doorId = "1";
    SensorEvent eventDoor = new SensorEvent(type, doorId, null);

    DoorEventProcessor doorProcessor = new DoorEventProcessor(smartHome);

    doorProcessor.processEvent(eventDoor);

    return isOpenDoor(smartHome, doorId);
  }

  private boolean isOpenDoor (SmartHome smartHome, String doorId){
    for (Room room : smartHome.getRooms()) {
      for (Door door : room.getDoors()) {
        if (door.getId().equals(doorId)){
          return door.isOpen();
        }
      }
    }
    return false;
  }
}
