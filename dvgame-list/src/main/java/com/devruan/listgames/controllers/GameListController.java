package com.devruan.listgames.controllers;

import com.devruan.listgames.dto.GameListDTO;
import com.devruan.listgames.dto.GameMinDTO;
import com.devruan.listgames.dto.ReplacementDTO;
import com.devruan.listgames.services.GameListService;
import com.devruan.listgames.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findGames(@PathVariable long listId){
        return gameService.findByGamesList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
