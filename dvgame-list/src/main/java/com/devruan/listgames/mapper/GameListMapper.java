package com.devruan.listgames.mapper;

import com.devruan.listgames.dto.GameListDTO;
import com.devruan.listgames.entities.GameList;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameListMapper {
    GameList toGameList(GameListDTO gameListDTO);
}
