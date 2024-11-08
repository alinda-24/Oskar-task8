package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HumiditySensorTest {

    @Test
    public void testGetReading() {
        HumiditySensor sensor = new HumiditySensor(45.5);
        assertEquals(45.5, sensor.getReading(), 0.01);
    }

    @Test
    public void testSetReading() {
        HumiditySensor sensor = new HumiditySensor(45.5);
        sensor.setReading(55.5);
        assertEquals(55.5, sensor.getReading(), 0.01);
    }

    @Test
    public void testGetType() {
        HumiditySensor sensor = new HumiditySensor(45.5);
        assertEquals("Humidity", sensor.getType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructorArgument() {
        // Assuming constructor could have validation in actual practice
        HumiditySensor sensor = new HumiditySensor(-1); // Invalid reading
    }
}

// TemperatureSensorTest.java
import org.junit.Test;
import static org.junit.Assert.assertEquals;

