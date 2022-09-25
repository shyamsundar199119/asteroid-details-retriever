package eu.spond.asteroiddetailsretriever.dto;

import java.util.ArrayList;

/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class AsteroidDetails {
    public Links links;
    public String id;
    public String neo_reference_id;
    public String name;
    public String nasa_jpl_url;
    public double absolute_magnitude_h;
    public EstimatedDiameter estimated_diameter;
    public boolean is_potentially_hazardous_asteroid;
    public ArrayList<CloseApproachDatum> close_approach_data;
    public boolean is_sentry_object;

    //TODO Add setter getter methods


}

