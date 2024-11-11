package functional.java_8_map_vs_flatmap;

import java.util.List;

public class Institute
{
    String name;

    List<String> locations;

    public Institute(String name, List<String> locations)
    {
        this.name = name;
        this.locations = locations;
    }

    public String getName()
    {
        return name;
    }

    public List<String> getLocations()
    {
        return locations;
    }
}
