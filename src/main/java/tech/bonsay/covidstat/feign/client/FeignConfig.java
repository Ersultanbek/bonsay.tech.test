package tech.bonsay.covidstat.feign.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class FeignConfig {
//
//    @Bean
//    public Encoder feignEncoder() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        HttpMessageConverter jacksonConverter = new AbstractGenericHttpMessageConverter(MediaType.APPLICATION_JSON);
//
//        ObjectFactory objectFactory = () -> new HttpMessageConverters(jacksonConverter);
//
//        return new SpringEncoder(objectFactory);
//    }

}
