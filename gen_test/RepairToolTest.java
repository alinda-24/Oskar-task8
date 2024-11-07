package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RepairToolTest {
    private RepairTool repairTool = new RepairTool("Hammer", "Fixes stuff");

    @Test
    public void testRepairToolName() {
        assertEquals("Hammer", repairTool.getName());
    }

    @Test
    public void testRepairToolFunctionality() {
        assertEquals("Fixes stuff", repairTool.getFunctionality());
    }

    @Test
    public void testSetRepairToolName() {
        repairTool.setName("Wrench");
        assertEquals("Wrench", repairTool.getName());
    }

    @Test
    public void testSetRepairToolFunctionality() {
        repairTool.setFunctionality("Tightens bolts");
        assertEquals("Tightens bolts", repairTool.getFunctionality());
    }
}