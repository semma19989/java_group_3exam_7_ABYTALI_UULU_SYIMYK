package kg.attaractor.exam7.util;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public static PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity http) throws Exception{
        // Since we have a REST service, we don't need CSRF protection since we log in via the request header,
// we don't need a form for entering and exiting the site either. Using Http Basic authorization.
// User data is passed through the request header  Using Http Basic authorization.
// User data is passed through the request header  Using Http Basic authorization.
// User data is passed through the request header
        http.authorizeRequests().antMatchers("/order/*").fullyAuthenticated();
        http.authorizeRequests().antMatchers("/user/orders/*").fullyAuthenticated();
        http.authorizeRequests().anyRequest().permitAll();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.httpBasic();
        http.formLogin().disable().logout().disable();
        http.csrf().disable();
    }
}
