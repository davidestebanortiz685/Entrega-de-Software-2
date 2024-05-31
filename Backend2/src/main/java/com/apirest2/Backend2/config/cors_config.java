package com.apirest2.Backend2.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class cors_config implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("http://localhost:5174")//Escribir la Url del proyecto front a conectar
        .allowedMethods("*")//PODEMOS ESPECIFICAR LOS METODOS A PERMITIR DESDE EL FRONT,GET,POST,PUT,DELETE
         .allowCredentials(true);
    }
}
