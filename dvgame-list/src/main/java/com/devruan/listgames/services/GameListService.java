package com.devruan.listgames.services;

import com.devruan.listgames.dto.GameDTO;
import com.devruan.listgames.dto.GameListDTO;
import com.devruan.listgames.dto.GameMinDTO;
import com.devruan.listgames.entities.Game;
import com.devruan.listgames.entities.GameList;
import com.devruan.listgames.repositorys.GameListRepository;
import com.devruan.listgames.repositorys.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
    }

}
