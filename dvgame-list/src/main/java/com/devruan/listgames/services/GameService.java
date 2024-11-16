package com.devruan.listgames.services;

import com.devruan.listgames.dto.GameDTO;
import com.devruan.listgames.dto.GameMinDTO;
import com.devruan.listgames.entities.Game;
import com.devruan.listgames.mapper.GameMapper;
import com.devruan.listgames.projections.GameMinProjection;
import com.devruan.listgames.repositorys.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameMapper gameMapper;
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game game = gameRepository.findById(id).get();
        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByGamesList(long listId){
        return gameRepository.searchByList(listId).stream().map(GameMinDTO::new).toList();
    }

    @Transactional
    public GameDTO save(GameDTO gameDTO){
        Game gameSaved = gameRepository.save(gameMapper.toGame(gameDTO));
        return new GameDTO(gameSaved);
    }
}
