package eu.spond.asteroiddetailsretriever.comparators;

import eu.spond.asteroiddetailsretriever.dto.AsteroidDetails;

import java.util.Comparator;

public class NearEarthObjectsLargestComparator implements Comparator<AsteroidDetails> {

    @Override
    public int compare(AsteroidDetails nearEarthObjects1, AsteroidDetails nearEarthObjects2) {
        return Double.compare(nearEarthObjects1.estimated_diameter.kilometers.estimated_diameter_max, nearEarthObjects2.estimated_diameter.kilometers.estimated_diameter_max);
    }

}
