package com.example.resttemplate.controller;

import com.example.resttemplate.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ConsumeWebServiceWebClient {

    @Autowired
    WebClient webClient;
    //ADD A POST AND DELETE
    //FLUX OR MONO
    @GetMapping(value = "/webclient/questions")
    public Mono<String> findAll()
    {
        return webClient.get().uri("/questions").retrieve().bodyToMono(String.class);
    }


}
