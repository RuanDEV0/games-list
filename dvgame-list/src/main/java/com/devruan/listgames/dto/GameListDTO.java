package com.devruan.listgames.dto;

import com.devruan.listgames.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO(){}


    public GameListDTO(GameList gameList){
        id = gameList.getId();
        name = gameList.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
