package br.com.isaacpatrocinio.dslist.services;

import br.com.isaacpatrocinio.dslist.dto.GameListDTO;
import br.com.isaacpatrocinio.dslist.entities.GameList;
import br.com.isaacpatrocinio.dslist.repositories.GameListRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private GameListRepository gameListRepository;

    public GameListService(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(obj -> new GameListDTO(obj)).toList();
    }
}
