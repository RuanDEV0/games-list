package com.devruan.listgames.services;

import com.devruan.listgames.dto.GameMinDTO;
import com.devruan.listgames.repositorys.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    public List<GameMinDTO> findAll(){
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }
}
