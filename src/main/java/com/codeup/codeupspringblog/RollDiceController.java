package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDiceForm() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    @ResponseBody
    public String rolledDice(@PathVariable int n) {

        int dice2 = (int) (Math.random()*6+1);

        if(n == dice2){
           return "The dice rolled " + dice2 + ". YOU GUESSED RIGHT!";
        } else {
            return "The dice rolled " +  dice2 + ". You guessed wrong.";
        }

    }

}
