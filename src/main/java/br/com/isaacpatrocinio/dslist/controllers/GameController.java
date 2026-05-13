package br.com.isaacpatrocinio.dslist.controllers;

import br.com.isaacpatrocinio.dslist.dto.GameMinDTO;
import br.com.isaacpatrocinio.dslist.entities.Game;
import br.com.isaacpatrocinio.dslist.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> findAll() {
        List<GameMinDTO> gamesDTO = gameService.findAll();
        return ResponseEntity.ok().body(gamesDTO);
    }
}
