package com.example.l2_20221.controller;

import com.example.l2_20221.Entity.Games;
import com.example.l2_20221.repository.GamesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class GamesController {
    final GamesRepository gamesRepository;

    public GamesController(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @GetMapping(value = "juegos/lista")
    public String listajuegos(Model model){
        model.addAttribute("lista", gamesRepository.findAll());
        return "juegos/lista";
    }

    @GetMapping(value = "juegos/editar")
    public String editarJuegos(Model model, @RequestParam("id") Integer id){
        Optional<Games> optionalGames = gamesRepository.findById(id);
        if(optionalGames.isPresent()){
            Games games = optionalGames.get();
            model.addAttribute("gm",games);
            return "juegos/editar";
        }else {
            return "redirect:/juegos/lista";
        }
    }

    @PostMapping(value = "juegos/guardar")
    public String guardar(Games games){
        gamesRepository.save(games);
        return "redirect:/juegos/lista";
    }


}
