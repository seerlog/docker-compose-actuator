package com.example.worldgoldassociation.controller;

import com.example.worldgoldassociation.dto.GoldStatusRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("")
public class GoldStatusController {

    @PostMapping
    public ResponseEntity collectWorldGoldStatus(@RequestBody GoldStatusRequest goldStatusRequest) {

        return new ResponseEntity(HttpStatus.OK);
    }
}
