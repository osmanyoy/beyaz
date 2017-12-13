package com.training.spring;

import javax.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @RequestMapping(method = RequestMethod.GET,
                    path = "/hello/{isim}/{soy}")
    public String hello(@PathVariable("isim") final String name,
                        @PathVariable("soy") final String surname,
                        @Min(1) @RequestParam(name = "yas",
                                              required = false) final int age) {
        return "hello";
    }

    @RequestMapping(method = RequestMethod.GET,
                    path = "/hello2")
    public String hello2(@RequestParam(name = "yas") final int age) {
        if (age > 20) {
            throw new IllegalArgumentException("Giremezsin");
        }
        return "hello";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleError(final IllegalArgumentException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                             .body("Giremezsin");
    }

}
