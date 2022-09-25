package eu.spond.asteroiddetailsretriever;

import eu.spond.asteroiddetailsretriever.dto.AsteroidDetailsResponse;

import java.util.HashMap;
import java.util.Map;

public class LargestAsteriodDetailsCache {

    private Map<Integer,AsteroidDetailsResponse> largestAsteriodOfEachYearMap=new HashMap<Integer,AsteroidDetailsResponse>();

    public AsteroidDetailsResponse getLargestAsteriodDetailsOfYear(int year){
        return largestAsteriodOfEachYearMap.get(year);
    }

    public AsteroidDetailsResponse setLargestAsteriodDetailsOfYear(int year,AsteroidDetailsResponse asteroidDetailsResponse){
        return largestAsteriodOfEachYearMap.put(year,asteroidDetailsResponse);
    }

    public void setLargestAsteriodOfEachYearMap(Map<Integer, AsteroidDetailsResponse> largestAsteriodOfEachYearMap) {
        this.largestAsteriodOfEachYearMap = largestAsteriodOfEachYearMap;
    }
}
