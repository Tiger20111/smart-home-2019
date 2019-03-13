package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.enventshome.EnventDoor;
import ru.sbt.mipt.oop.enventshome.EnventLight;
import ru.sbt.mipt.oop.sensor.SensorEvent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.sbt.mipt.oop.sensor.SensorEventType.*;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get("smart-home-1.js")));
        SmartHome smartHome = gson.fromJson(json, SmartHome.class);
        EnventLight homeLight = new EnventLight();
        EnventDoor homeDoor = new EnventDoor();
        ProduceNewEnvent produceEnvent = new ProduceNewEnvent();
        // начинаем цикл обработки событий
        SensorEvent event = produceEnvent.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);

            if (event.getType() == LIGHT_ON) {
                homeLight.SwitchOn(smartHome, event);
            }
            if (event.getType() == LIGHT_OFF) {
                homeLight.SwitchOff(smartHome, event);
            }

            if (event.getType() == DOOR_OPEN) {
             homeDoor.SwitchOn(smartHome, event);
            }

            if (event.getType() == DOOR_CLOSED) {
                homeDoor.SwitchOff(smartHome, event);
            }

            event = produceEnvent.getNextSensorEvent();
        }
    }

}
