package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDiceForm() {
        return "roll-dice";
    }

    @GetMapping ("/roll-dice/{n}")
    public String rolledDice(@PathVariable int n, Model model) {

        int dice = 0;
        ArrayList<Integer> listOfGuesses = new ArrayList<Integer>();
        long correctGuesses = 0;
        long incorrectGuesses = 0;

        for (int i = 0; i < 10; i++) {

            dice = (int) (Math.random()*6+1);
            listOfGuesses.add(dice);

            if (n == dice) {
                correctGuesses += 1;
            } else {
                incorrectGuesses += 1;
            }

        }

        model.addAttribute("listOfGuesses", listOfGuesses);

        return "Out of 10 guesses, you got " + correctGuesses + " correct and " + incorrectGuesses + " incorrect.";

    }

}
