package br.com.isaacpatrocinio.dslist.services;

import br.com.isaacpatrocinio.dslist.dto.GameMinDTO;
import br.com.isaacpatrocinio.dslist.entities.Game;
import br.com.isaacpatrocinio.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        return games.stream().map(obj -> new GameMinDTO(obj)).toList();
    }
}
