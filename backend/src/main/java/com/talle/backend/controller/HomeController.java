package com.talle.backend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Bienvenido a Talle I - Backend API");
        response.put("version", "1.0.0");
        response.put("status", "running");
        response.put("endpoints", Map.of(
            "hello", "/api/hello",
            "health", "/actuator/health"
        ));
        response.put("frontend", "http://localhost:4200");
        response.put("documentation", "Ver README.md para más información");
        return response;
    }
}

