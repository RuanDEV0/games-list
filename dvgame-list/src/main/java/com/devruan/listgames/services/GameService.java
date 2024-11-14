package com.devruan.listgames.services;

import com.devruan.listgames.dto.GameDTO;
import com.devruan.listgames.dto.GameMinDTO;
import com.devruan.listgames.entities.Game;
import com.devruan.listgames.repositorys.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game game = gameRepository.findById(id).get();
        return new GameDTO(game);
    }
}
