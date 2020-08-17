package arustamov.context;

import arustamov.context.condition.StartAppiumServiceCondition;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("arustamov")
@PropertySource("classpath:context-config.properties")
public class ContextConfig {

    @Bean
    @Conditional(StartAppiumServiceCondition.class)
    public AppiumDriverLocalService appiumService() {
        return AppiumDriverLocalService.buildDefaultService();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
            .configure(JsonParser.Feature.ALLOW_COMMENTS, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
//                .setDefaultPropertyInclusion(
//                        JsonInclude.Value.construct(JsonInclude.Include.ALWAYS, JsonInclude.Include.NON_NULL))
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}

