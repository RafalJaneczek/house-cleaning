package pl.nevernedingcode.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://192.168.0.14:4201", "http://localhost:4201")
                .allowedMethods("GET", "POST")
                .allowedHeaders("Authorization", "Cache-Control", "Content-Type")
                .allowCredentials(true);
    }
}
