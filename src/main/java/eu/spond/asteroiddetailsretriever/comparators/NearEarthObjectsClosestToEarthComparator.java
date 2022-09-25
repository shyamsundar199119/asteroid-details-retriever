package eu.spond.asteroiddetailsretriever.comparators;

import eu.spond.asteroiddetailsretriever.dto.AsteroidDetails;

import java.util.Comparator;

public class NearEarthObjectsClosestToEarthComparator implements Comparator<AsteroidDetails> {

    @Override
    public int compare(AsteroidDetails nearEarthObjects1, AsteroidDetails nearEarthObjects2) {
        return Double.compare(nearEarthObjects2.close_approach_data.get(0).miss_distance.astronomical, nearEarthObjects1.close_approach_data.get(0).miss_distance.astronomical);
    }

}
