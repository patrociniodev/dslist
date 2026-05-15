package br.com.isaacpatrocinio.dslist.controllers;

import br.com.isaacpatrocinio.dslist.dto.GameListDTO;
import br.com.isaacpatrocinio.dslist.dto.GameMinDTO;
import br.com.isaacpatrocinio.dslist.services.GameListService;
import br.com.isaacpatrocinio.dslist.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    private GameListService gameListService;
    private GameService gameService;

    public GameListController(GameListService gameListService, GameService gameService) {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findGamesByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return ResponseEntity.ok().body(result);
    }
}
