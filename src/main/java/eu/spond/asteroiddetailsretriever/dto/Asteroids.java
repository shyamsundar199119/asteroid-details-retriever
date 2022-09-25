package eu.spond.asteroiddetailsretriever.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
import java.util.List;
import java.util.Map;


class Feet{
    public double estimated_diameter_min;
    public double estimated_diameter_max;
}

class Links{
    public String next;
    public String previous;
    public String self;
}

class Meters{
    public double estimated_diameter_min;
    public double estimated_diameter_max;
}

class Miles{
    public double estimated_diameter_min;
    public double estimated_diameter_max;
}

class RelativeVelocity{
    public String kilometers_per_second;
    public String kilometers_per_hour;
    public String miles_per_hour;
}

public class Asteroids{
    @JsonIgnore
    public Links links;

    public int element_count;

    @JsonProperty("near_earth_objects")
    public Map<String, List<AsteroidDetails>> asteroidDetailsMap;


    @Override
    public String toString() {
        return "Asteroids{" +
                "element_count='" + element_count + '\'' +
                ", NearEarthObjects=" + asteroidDetailsMap.keySet() +
                '}';
    }
}





