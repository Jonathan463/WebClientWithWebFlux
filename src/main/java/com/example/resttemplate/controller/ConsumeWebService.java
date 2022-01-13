package com.example.resttemplate.controller;

import com.example.resttemplate.model.Questione;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Slf4j
@RestController
public class  ConsumeWebService {

    RestTemplate restTemplate;

    @Autowired
    public ConsumeWebService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/template/questions", method = RequestMethod.GET)
    public ResponseEntity<Object> getQuestions() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8890/questions", HttpMethod.GET, entity, Object.class);
    }

//    @RequestMapping(value = "/template/questions/{id}/answers")
//    public String getAnswers(@PathVariable(name = "id") long id) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//
//        return restTemplate.exchange("http://localhost:8080/questions/"+id+"/answers", HttpMethod.GET, entity, String.class).getBody();
//    }
//
//    @RequestMapping(value = "/template/questions", method = RequestMethod.POST)
//    public String createQuestions(@RequestBody Questione question) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<Questione> entity = new HttpEntity<Questione>(question,headers);
//
//        return restTemplate.exchange(
//                "http://localhost:8080/questions", HttpMethod.POST, entity, String.class).getBody();
//    }
//    @RequestMapping(value = "/template/questions/{id}", method = RequestMethod.PUT)
//    public String updateQuestions(@PathVariable("id") String id, @RequestBody Questione question) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<Questione> entity = new HttpEntity<Questione>(question,headers);
//
//        return restTemplate.exchange(
//                "http://localhost:8080/questions/"+id, HttpMethod.PUT, entity, String.class).getBody();
//    }
//    @RequestMapping(value = "/template/questions/{id}", method = RequestMethod.DELETE)
//    public String deleteQuestions(@PathVariable("id") String id) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<Questione> entity = new HttpEntity<Questione>(headers);
//
//        return restTemplate.exchange(
//                "http://localhost:8080/questions/"+id, HttpMethod.DELETE, entity, String.class).getBody();
//    }
}
