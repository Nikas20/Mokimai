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
                    .requestMatchers(HttpMethod.POST, "/api/events").hasRole("ADMIN")

                    .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll()

                    .requestMatchers(HttpMethod.DELETE, "/api/events/**").hasRole("ADMIN")

                    .requestMatchers(HttpMethod.POST, "/api/events").hasRole("USER")

                    .requestMatchers(HttpMethod.POST, "/api/events/*/register").hasRole("USER")

                    .requestMatchers(HttpMethod.POST, "/api/events/*/participants").hasRole("ADMIN")

                    .anyRequest().authenticated()
            );

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
