package eu.spond.asteroiddetailsretriever;

import eu.spond.asteroiddetailsretriever.util.AsteroidsUtilClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AsteroidDetailsRetrieverApplication {
	public static void main(String[] args) {
		SpringApplication.run(AsteroidDetailsRetrieverApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public AsteroidsUtilClass asteroidsUtilClass() {
		return new AsteroidsUtilClass();
	}

	@Bean
	public LargestAsteriodDetailsCache largestAsteriodDetailsCache() {
		return new LargestAsteriodDetailsCache();
	}
	//TODO write factory method to load largestASteriodDetailsfromDB during start up
}
