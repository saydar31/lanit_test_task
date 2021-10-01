package com.lanit.lanittesttask.controller;

import com.lanit.lanittesttask.service.ClearService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clear")
@RequiredArgsConstructor
public class ClearController {

    private final ClearService clearService;

    @GetMapping
    public ResponseEntity<Void> clear(){
        clearService.clear();
        return ResponseEntity.ok().build();
    }
}
