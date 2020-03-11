package com.ucm.ucmempire.configuration;

import com.ucm.ucmempire.dal.servicedal.PlayerDalServiceImpl;
import com.ucm.ucmempire.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling()
                .and()
                .formLogin()
                //.loginPage("/login") // custom login page
                //.loginProcessingUrl("/login") // url to submit the username and password to
                // on peut avoir en + : defaultSuccessUrl()  &  failureUrl
//                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .invalidateHttpSession(true)
                .and()

                .authorizeRequests()

                .antMatchers("/user*").permitAll()
//                .antMatchers("/product/new").authenticated()
//                .antMatchers("/product").permitAll()
                // ATTENTION !!! en DB, le role devra se nommer 'ROLE_ADMIN'
                // ATTENTION !!! mettre ce antMatcher là après les deux du dessus
                // sinon on y aura pas accès !!!
                //.antMatchers("/product/**").hasRole("ADMIN")


                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // POUR AVOIR ACCES A LA CONSOLE H2
                .headers().frameOptions().disable()
                .and()
                //@formatter:on
                .apply(new JwtConfigurer(jwtTokenProvider))
                .and()
                .httpBasic()
                .disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }
}
