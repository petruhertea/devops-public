package com.petruth.dockerhello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String helloDocker() {
        return "Hello, Docker World!";
    }

    @GetMapping("/lotto")
    public String getLottoResult() {
        Random random = new Random();

        // Tonight's Lotto ticket
        int[] winning = new int[5];
        // User Lotto ticket
        int[] user = new int[5];

        for (int i = 0; i < 5; i++) {
            winning[i] = random.nextInt(1, 50);
            user[i] = random.nextInt(1, 50);
        }

        // Compare how many numbers match
        int matches = 0;
        for (int w : winning) {
            for (int u : user) {
                if (w == u) {
                    matches++;
                }
            }
        }

        boolean won = matches == 5;

        return "Winning numbers: " + formatArray(winning) +
                "\nYour numbers: " + formatArray(user) +
                "\nMatches: " + matches +
                "\n" + (won ? "You won! 🎉" : "You lost. Try again!");
    }

    private String formatArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int nr : arr) {
            sb.append(nr).append(" ");
        }
        return sb.toString().trim();
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello, " + name;
    }
}
