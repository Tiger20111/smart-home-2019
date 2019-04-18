package ru.sbt.mipt.oop.adapter;



import ru.sbt.mipt.oop.commands.eventstypes.SensorEventType;
import ru.sbt.mipt.oop.house.SensorEvent;
import ru.sbt.mipt.oop.interfacesishouse.EventProducer;
import ru.sbt.mipt.oop.objectshome.subjects.alarm.Code;

class RandomEventProducer implements EventProducer {
  @Override
  public SensorEvent getNextSensorEvent() {
    // pretend like we're getting the events from physical world, but here we're going to just generate some random events
    if (Math.random() < 0.05) return null; // null means end of event stream
    if (Math.random() > 0.8) {
      Code code = new Code();
      code.setCode("" + (((int) (2 * Math.random()))));
      SensorEventType sensorEventType = SensorEventType.values()[(int) (6 + 2 * Math.random())];
      return new SensorEvent(sensorEventType, "1", code);
    } else {
      SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
      String objectId = "" + (int) (10 * Math.random());
      return new SensorEvent(sensorEventType, objectId, null);
    }
  }
}
