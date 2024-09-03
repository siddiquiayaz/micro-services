package com.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieCatalogService {
    private static final String Catalog_Service="http://movie-catalog-service";
    @Autowired
    private RestTemplate restTemplate;

    public String getMoviePath(Long movieId) {
        var response = this.restTemplate.getForEntity(Catalog_Service+"/moviesInfo/find-path-by-id/{movieInfoId}", String.class ,movieId);
           return response.getBody();
    }

}
