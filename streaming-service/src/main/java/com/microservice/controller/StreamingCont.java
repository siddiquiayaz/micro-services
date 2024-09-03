package com.microservice.controller;

import com.microservice.service.MovieCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class StreamingCont {
    private static final Logger log = Logger.getLogger(StreamingCont.class.getName());
    @Autowired
   private MovieCatalogService movieCatalogService;
  public static final String VIDEO_DIRECTORY ="E:\\streamingdata\\";

    @GetMapping("/streaming/{videoPath}")
    public ResponseEntity<InputStreamResource> streamVideo(@PathVariable ("videoPath") String videoPath) throws FileNotFoundException {
        File file = new File(VIDEO_DIRECTORY+videoPath);
        if (file.exists()) {
            InputStreamResource streamReader = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("video/mp4"))
                    .body(streamReader);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
   @GetMapping("/streaming/streamWith-id/{videoId}")
    public ResponseEntity<InputStreamResource> getVideioPath(@PathVariable Long videoId) throws FileNotFoundException {
        String moviePath = this.movieCatalogService.getMoviePath(videoId);
        log.log(Level.INFO , "resolve moviepath ={0}" ,moviePath);
             return this.streamVideo(moviePath);
    }




}
