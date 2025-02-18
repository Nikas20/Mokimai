package lt.techin.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

@EnableWebSecurity
public class SecurityConfig {

    @Bean

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

                .csrf(c -> c.disable())

                .httpBasic(Customizer.withDefaults())

                .authorizeHttpRequests(authorize -> authorize

                        .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/users/{id}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.PUT, "/users/{id}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.DELETE, "/users/{id}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/users").permitAll()

                        .requestMatchers(HttpMethod.GET, "/cars").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/cars").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.PUT, "/cars/{id}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.DELETE, "/cars/{id}").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/rentals").hasRole("USER")

                        .requestMatchers(HttpMethod.GET, "/cars/available").permitAll()

                        .anyRequest().authenticated()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}