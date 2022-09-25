package eu.spond.asteroiddetailsretriever.dto;

import java.util.ArrayList;

public class AsteroidDetailsResponse {
    public String name;
    public double estimated_diameter;
    public String close_approached_date;

    public String getName() {
        return name;
    }

    public String getClose_approached_date() {
        return close_approached_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClose_approached_date(String close_approached_date) {
        this.close_approached_date = close_approached_date;
    }

    public double getEstimated_diameter() {
        return estimated_diameter;
    }

    public void setEstimated_diameter(double estimated_diameter) {
        this.estimated_diameter = estimated_diameter;
    }
}
