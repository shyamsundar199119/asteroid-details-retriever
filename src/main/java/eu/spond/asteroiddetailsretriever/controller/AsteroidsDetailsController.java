package eu.spond.asteroiddetailsretriever.controller;

import eu.spond.asteroiddetailsretriever.LargestAsteriodDetailsCache;
import eu.spond.asteroiddetailsretriever.dto.AsteroidDetailsResponse;
import eu.spond.asteroiddetailsretriever.dto.Asteroids;
import eu.spond.asteroiddetailsretriever.util.AsteroidsUtilClass;
import eu.spond.asteroiddetailsretriever.dto.AsteroidDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/asteroids")
public class AsteroidsDetailsController {

    private static final Logger log = LoggerFactory.getLogger(AsteroidsDetailsController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AsteroidsUtilClass asteroidsUtilClass;

    @Autowired
    LargestAsteriodDetailsCache largestAsteriodDetailsCache;

    @GetMapping(value = "/getClosestTenAsteroidsBetween")
    public @ResponseBody
        List<AsteroidDetails> getClosestTenAsteroidsBetween(@RequestParam("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
                                                            @RequestParam("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {

        //TODO Move the common url to properties file
        //TODO Create a class to make the REST template call and throw all http errors from that method
        //TODO Add error handling

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String url="https://api.nasa.gov/neo/rest/v1/feed?start_date="+formatter.format(fromDate)+"&end_date="+formatter.format(toDate)+"&api_key=SAUa6rdvkorPfLnFOWbK3wCb0VyPrz3bHt7enzzw";
        Asteroids asteroidsInboundResponse = restTemplate.getForObject(url, Asteroids.class);
        //TODO Massage the details to be provided only the details required for the user
        return asteroidsUtilClass.getClosestTenAsteriods(asteroidsInboundResponse);

    }

    @GetMapping(value = "/getLargestAsteroidDetailsDuringTheYear")
    public @ResponseBody
    AsteroidDetailsResponse getLargestAsteroidDuringTheYear(@RequestParam("year") Integer year) {
        log.info("Enters getLargestAsteroidDuringTheYear method");
        if(null == largestAsteriodDetailsCache.getLargestAsteriodDetailsOfYear(year)) {
            log.info("Not found in cache");
            String url = "https://api.nasa.gov/neo/rest/v1/feed?start_date=" + year + "-09-07&end_date=" + year + "-09-08&api_key=SAUa6rdvkorPfLnFOWbK3wCb0VyPrz3bHt7enzzw";
            Asteroids asteroidsInboundResponse = restTemplate.getForObject(url, Asteroids.class);
            AsteroidDetailsResponse asteroidDetailsResponse=asteroidsUtilClass.getLargestAsteriods(asteroidsInboundResponse);
            largestAsteriodDetailsCache.setLargestAsteriodDetailsOfYear(year,asteroidDetailsResponse);
            return asteroidDetailsResponse;
        } else {
            log.info("Retreieves from cache");
            return largestAsteriodDetailsCache.getLargestAsteriodDetailsOfYear(year);
        }

    }
}
