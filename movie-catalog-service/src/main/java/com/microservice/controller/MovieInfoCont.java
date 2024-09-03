package com.microservice.controller;

import com.microservice.model.MovieInfo;
import com.microservice.repsoitory.MovieInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moviesInfo")
public class MovieInfoCont {
    @Autowired
    private MovieInfoRepository movieInfoRepository;

    @PostMapping("/saveMovieInfo")
    public ResponseEntity<List<MovieInfo>> saveMovieInfoAll(@RequestBody List<MovieInfo> movieInfoList) {
        return ResponseEntity.ok(this.movieInfoRepository.saveAll(movieInfoList));
    }

    @GetMapping("/getMovieInfo")
    public ResponseEntity<List<MovieInfo>> getMovieInfo() {
        return ResponseEntity.ok(this.movieInfoRepository.findAll());
    }
    @DeleteMapping("deleteMovie/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id){
        this.movieInfoRepository.deleteById(id);
        return  ResponseEntity.ok("movie deleted");
    }
    @GetMapping("/find-path-by-id/{movieInfoId}")
    public String findPathById(@PathVariable Long movieInfoId){
        var videoOptional = this.movieInfoRepository.findById(movieInfoId);
          return videoOptional.map(MovieInfo::getPath).orElse(null);

    }


}
