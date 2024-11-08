package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TemperatureSensorTest {

    @Test
    public void testGetReading() {
        TemperatureSensor sensor = new TemperatureSensor(20.5);
        assertEquals(20.5, sensor.getReading(), 0.01);
    }

    @Test
    public void testSetReading() {
        TemperatureSensor sensor = new TemperatureSensor(20.5);
        sensor.setReading(25.5);
        assertEquals(25.5, sensor.getReading(), 0.01);
    }

    @Test
    public void testGetType() {
        TemperatureSensor sensor = new TemperatureSensor(20.5);
        assertEquals("Temperature", sensor.getType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructorArgument() {
        // Assuming constructor could have validation in actual practice
        TemperatureSensor sensor = new TemperatureSensor(-273.16); // Below absolute zero
    }
}

// WeatherStationSensorFactoryTest.java
import org.junit.Test;
import static org.junit.Assert.assertTrue;

