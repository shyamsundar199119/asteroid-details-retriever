package eu.spond.asteroiddetailsretriever.util;

import eu.spond.asteroiddetailsretriever.dto.AsteroidDetailsResponse;
import eu.spond.asteroiddetailsretriever.dto.Asteroids;
import eu.spond.asteroiddetailsretriever.dto.AsteroidDetails;
import eu.spond.asteroiddetailsretriever.comparators.NearEarthObjectsClosestToEarthComparator;
import eu.spond.asteroiddetailsretriever.comparators.NearEarthObjectsLargestComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public  class AsteroidsUtilClass {

    public List<AsteroidDetails> getClosestTenAsteriods(Asteroids asteroids){//List<NearEarthObjects> nearEarthObjects){
        //TODO : Improve the algorithm to reduce the whole process to 10 loops. Sorting is expensive Algorithm
        List<AsteroidDetails> asteroidDetails=new ArrayList<AsteroidDetails>();
        List<AsteroidDetailsResponse> asteroidDetailsResponseList=new ArrayList<AsteroidDetailsResponse>();
        asteroids.asteroidDetailsMap.forEach((k, v) ->asteroidDetails.addAll(v));
        NearEarthObjectsClosestToEarthComparator closestToEarthComparator = new NearEarthObjectsClosestToEarthComparator();
        Collections.sort(asteroidDetails, closestToEarthComparator);

        return asteroidDetails.size()>10 ? asteroidDetails.subList(0,10): asteroidDetails.subList(0,asteroidDetails.size()-1);
    }

    public AsteroidDetailsResponse getLargestAsteriods(Asteroids asteroids){

        //TODO : Improve the algorithm to reduce the whole process to 1 loops. Sorting is expensive Algorithm
        List<AsteroidDetails> asteroidDetails=new ArrayList<AsteroidDetails>();
        asteroids.asteroidDetailsMap.forEach((k, v) ->asteroidDetails.addAll(v));
        NearEarthObjectsLargestComparator largestAsteroidComparator = new NearEarthObjectsLargestComparator();
        Collections.sort(asteroidDetails, largestAsteroidComparator);
        return convertToAsteroidDetailsResponse(asteroidDetails.get(0));
    }

    public AsteroidDetailsResponse convertToAsteroidDetailsResponse(AsteroidDetails asteroidDetails){
        AsteroidDetailsResponse asteroidDetailsResponse=new AsteroidDetailsResponse();
        asteroidDetailsResponse.setName(asteroidDetails.name);
        asteroidDetailsResponse.setEstimated_diameter(asteroidDetails.estimated_diameter.kilometers.estimated_diameter_max);
        asteroidDetailsResponse.setClose_approached_date(asteroidDetails.close_approach_data.get(0).close_approach_date);
        return asteroidDetailsResponse;
    }
}
