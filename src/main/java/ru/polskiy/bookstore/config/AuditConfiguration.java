package ru.polskiy.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import ru.polskiy.bookstore.BookStoreApplication;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
@EnableEnversRepositories(basePackageClasses = BookStoreApplication.class)
public class AuditConfiguration {
    @Bean
    public AuditorAware<String> auditorAware(){
        return ()-> Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getName);
    }
}
