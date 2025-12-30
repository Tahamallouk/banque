package ma.formations.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {

    @Value("${customer.service.default.location:Casablanca}")
    private String defaultLocation;

    @Value("${customer.service.default.language:Arabic}")
    private String defaultLanguage;

    @Value("${customer.service.default.currency:MAD}")
    private String defaultCurrency;

    @GetMapping("/configTest")
    public Map<String, String> config() {
        return Map.of(
                "defaultLocation", defaultLocation,
                "defaultLanguage", defaultLanguage,
                "defaultCurrency", defaultCurrency
        );
    }
}
