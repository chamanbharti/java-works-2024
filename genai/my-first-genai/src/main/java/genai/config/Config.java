package genai.config;

import genai.service.MockWeatherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration

public class Config {
    @Bean
    @Description("Get the weather in location")
    public Function<MockWeatherService.Request,MockWeatherService.Response> getWeather(){
        return new MockWeatherService();
    }
}
