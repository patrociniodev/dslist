package br.com.isaacpatrocinio.dslist.services;

import br.com.isaacpatrocinio.dslist.dto.GameDTO;
import br.com.isaacpatrocinio.dslist.dto.GameMinDTO;
import br.com.isaacpatrocinio.dslist.entities.Game;
import br.com.isaacpatrocinio.dslist.projections.GameMinProjection;
import br.com.isaacpatrocinio.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(obj -> new GameMinDTO(obj)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(obj -> new GameMinDTO(obj)).toList();
    }
}
