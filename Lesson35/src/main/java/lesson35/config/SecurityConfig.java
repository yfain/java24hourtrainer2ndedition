package lesson35.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and()
                                        .withUser("admin").password("adminpassword").roles("ADMIN", "USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
            csrf().disable().
            authorizeRequests().
                antMatchers("/quote", "/").hasRole("USER").
                antMatchers("/hiddenpage").hasRole("ADMIN").
                antMatchers("/resources/**").permitAll().
            and().
                formLogin().loginPage("/login").permitAll().
            and().
		logout().permitAll().logoutSuccessUrl("/login?logout");
    }
    
}
