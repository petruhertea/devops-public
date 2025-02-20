package com.petruth.dockerhello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String helloDocker(){
        return "Hello, Docker World!";
    }

    @GetMapping("/lotto")
    public String getLottoWinner(){
        Random randomNumber = new Random();

        StringBuilder lottoNumbers = new StringBuilder();

        lottoNumbers.append("The numbers for this round are: ");

        for (int i = 0; i < 5; i++) {
            lottoNumbers.append(randomNumber.nextInt(1,50));
            lottoNumbers.append(" ");
        }

        return lottoNumbers.toString();
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name){
        return "Hello, "+name;
    }
}
