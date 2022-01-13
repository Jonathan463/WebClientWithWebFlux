package com.example.resttemplate.controller;

import com.example.resttemplate.model.Questione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class ConsumeWebServiceWebClient {

    WebClient webClient;
    Questione question;

    @Autowired
    public ConsumeWebServiceWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping()
    public Flux<Object> findAll()
    {
        return webClient.get().uri("/questions").retrieve().bodyToFlux(Object.class);
    }


}
