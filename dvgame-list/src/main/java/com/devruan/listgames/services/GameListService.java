package com.devruan.listgames.services;

import com.devruan.listgames.dto.GameListDTO;
import com.devruan.listgames.entities.GameList;
import com.devruan.listgames.mapper.GameListMapper;
import com.devruan.listgames.projections.GameMinProjection;
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
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameListMapper gameListMapper;
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void moveGameInList(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);
        toUpdateGameMoveListInDataBase(list, listId, sourceIndex, destinationIndex);
    }
    @Transactional
    void toUpdateGameMoveListInDataBase(List<GameMinProjection> list, Long listId, int sourceIndex, int destinationIndex){
        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

    @Transactional
    public GameListDTO save(GameListDTO gameListDTO){
        GameList gameListsaved = gameListRepository.save(gameListMapper.toGameList(gameListDTO));
        return new GameListDTO(gameListsaved);
    }
}
