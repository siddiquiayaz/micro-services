package com.microservice.repsoitory;

import com.microservice.model.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieInfoRepository extends JpaRepository<MovieInfo,Long> {
}
