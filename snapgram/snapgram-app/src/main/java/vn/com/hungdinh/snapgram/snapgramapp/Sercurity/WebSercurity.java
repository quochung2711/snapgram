package vn.com.hungdinh.snapgram.snapgramapp.Sercurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
@EnableWebSecurity
public class WebSercurity extends WebSecurityConfiguration {
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web)-> web.ignoring()
                          .requestMatchers("/**");
    }
}
