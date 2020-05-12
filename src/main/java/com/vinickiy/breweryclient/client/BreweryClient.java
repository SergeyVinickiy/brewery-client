package com.vinickiy.breweryclient.client;

import com.vinickiy.breweryclient.web.model.BeerDto;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@Setter
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    private final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apihost;

    private final RestTemplate restTemplate;

    public BeerDto getBeerById(UUID beerId)
    {
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + beerId.toString(), BeerDto.class );
    }

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
}
