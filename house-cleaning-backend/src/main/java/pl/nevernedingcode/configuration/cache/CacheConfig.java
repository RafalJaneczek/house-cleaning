package pl.nevernedingcode.configuration.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("users", "dictionaries");
    }

    @CacheEvict(value = "users", allEntries = true)
    @Scheduled(fixedDelay = 3600000)
    public void emptyUsersCache() {
        log.info("Emptying users cache");
    }

    @CacheEvict(value = "dictionaries", allEntries = true)
    @Scheduled(fixedDelay = 900000)
    public void emptyDictionariesCache() {
        log.info("Emptying dictionaries cache");
    }

}
