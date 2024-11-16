package com.devruan.listgames.mapper;

import com.devruan.listgames.dto.GameDTO;
import com.devruan.listgames.entities.Game;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper {
    Game toGame(GameDTO gameDTO);
}
