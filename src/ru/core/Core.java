package ru.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.String;
import java.util.*;

public class Core {
    private String EMPTYSTRING = "";
    private ArrayList<Object> services;
    public Core()
    {
        System.out.println("Init core..");
        setServices(loadAllServices());
        isAliveServices(getServices());
    }

    public Core(String argument)
    {
        if (argument.equalsIgnoreCase(this.EMPTYSTRING))
            new Core();
        else
            System.out.println("Init core with arg: "+argument);
    }

    public ArrayList<Object> loadAllServices()
    {
        ArrayList<Object> servicesList = new ArrayList<Object>();
        try {
            servicesList.addAll(loadServiceValuesFromProperties());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return servicesList;
    }

    public Collection<String> loadServiceValuesFromProperties() throws IOException {
        Properties prop = new Properties();
        String propFileName = "resources.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);
        if (inputStream == null) {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }

        String rambler_props = prop.getProperty("RAMBLER");
        String yandex_props = prop.getProperty("YANDEX");

        Collection<String> result = new ArrayList<String>();
        result.add(rambler_props);
        result.add(yandex_props);

        return result;
    }

    public ArrayList<Object> getServices() {
        return services;
    }

    /**
     * change bool to reason phrase
     */
    public boolean isAliveServices(ArrayList<Object> services) {
        /* TODO */
        return true;
    }

    public void setServices(ArrayList<Object> services) {
        this.services = services;
    }
}
