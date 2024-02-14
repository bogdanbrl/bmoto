package com.doubleb.bmoto.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> {
            csrf.csrfTokenRepository(new HttpSessionCsrfTokenRepository());
            csrf.csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler());
        });

        http    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));

        http    .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/index", "/shop", "/shop/**", "/products", "/products/**", "/cart", "/cart/**", "/contact").permitAll()
                .requestMatchers("/css/**", "/lib/**", "/images/**", "/styles/**", "/mail/**", "/js/**", "/scss/**", "/fonts/**").permitAll()
                .requestMatchers("/auth/**", "/rest/**", "/logout", "/login").permitAll()
                .requestMatchers("/dashboard/**").hasRole("MANAGER")
                .requestMatchers("/dashboard/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                );

        http    .exceptionHandling().accessDeniedPage("/auth/access-denied");

        http    .formLogin(login -> {
                                    login.loginPage("/auth/login");
                                    login.loginProcessingUrl("/auth/authenticate");
                                    login.defaultSuccessUrl("/shop");
                                    login.failureUrl("/auth/login?error");
        });

        http   .logout(logout -> {
                                    logout.permitAll();
                                    logout.invalidateHttpSession(true);
                                    logout.clearAuthentication(true);
                                    logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
                                    logout.logoutSuccessUrl("/auth/login?logout");
        });

        return http.build();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager(AuthenticationConfiguration authConfig) throws Exception{
        return authConfig.getAuthenticationManager();
    }

}
