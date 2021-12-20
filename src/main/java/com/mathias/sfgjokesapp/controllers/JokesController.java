package com.mathias.sfgjokesapp.controllers;

import com.mathias.sfgjokesapp.services.JokeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {
    Logger logger = LoggerFactory.getLogger(JokesController.class);
    private final JokeService jokeService;

    public JokesController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping("/")
    public String getJoke(Model model) {
        String joke = jokeService.getJoke();
        logger.info("Got joke {}", joke);
        model.addAttribute("joke", jokeService.getJoke());
        return "jokes/joke";
    }
}
