package com.example.test.configuration;

import com.example.test.security.JwtCsrfFilter;
import com.example.test.security.JwtTokenRepository;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService service;

    @Autowired
    private JwtTokenRepository jwtTokenRepository;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Bean
    public PasswordEncoder devPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /**
                 * отключаем генерацию сессии
                 */
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER)

                /**
                 * указываем созданный нами фильтр JwtCsrfFilter в расположение стандартного фильтра,
                 * при этом игнорируем обработку стандартного
                 */
                .and()
                .addFilterAt(new JwtCsrfFilter(jwtTokenRepository, resolver), CsrfFilter.class)
                .csrf().ignoringAntMatchers("/**")

                .and()

                /**
                 * Для запроса /auth/login выполняем авторизацию силами security. Что бы не было двойной валидации
                 * (по токену и базовой), запрос был добавлен в исключение к классу JwtCsrfFilter
                 */
                .authorizeRequests()
                .antMatchers("/auth/login")

                .authenticated()
                .and()

                /**
                 * ошибки базовой авторизации отправляем в обработку GlobalExceptionHandler
                 */
                .httpBasic()
                .authenticationEntryPoint(((request, response, e) -> resolver.resolveException(request, response, null, e)));
    }

    /**
     * Реализуем метод configure(AuthenticationManagerBuilder auth), в класс AuthenticationManagerBuilder устанавливаем
     * сервис UserService, для того что бы Spring Security при выполнении базовой авторизации мог получить из
     * репозитория данные пользователя по логину.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.service);
    }

}
