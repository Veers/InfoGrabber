package tests;

import org.junit.Test;
import ru.core.Core;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CoreTest {
    private Core core;
    public CoreTest()
    {
        setCore(new Core());
    }
    @Test
    public void testLoadServicesTypes() {
        assertSame(ArrayList.class, getCore().loadAllServices().getClass());
    }

    @Test
    public void testLoadServicesCount()
    {
        assertTrue(getCore().loadAllServices().size() > 0);
    }

    @Test
    public void testAliveChecker()
    {
        assertTrue(getCore().isAliveServices(getCore().loadAllServices()));
    }

    public Core getCore() {
        return core;
    }

    public void setCore(Core core) {
        this.core = core;
    }
}
