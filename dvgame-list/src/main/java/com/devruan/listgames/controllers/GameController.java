package com.devruan.listgames.controllers;

import com.devruan.listgames.dto.GameDTO;
import com.devruan.listgames.dto.GameMinDTO;
import com.devruan.listgames.services.GameListService;
import com.devruan.listgames.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;
    @GetMapping
    public List<GameMinDTO> findAll(){
        return gameService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable long id){
        return gameService.findById(id);
    }


    @PostMapping
    public GameDTO save(@RequestBody GameDTO gameDTO){
        return gameService.save(gameDTO);
    }
}
