package br.com.isaacpatrocinio.dslist.controllers;

import br.com.isaacpatrocinio.dslist.dto.GameListDTO;
import br.com.isaacpatrocinio.dslist.services.GameListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    private GameListService gameListService;

    public GameListController(GameListService gameListService) {
        this.gameListService = gameListService;
    }

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return ResponseEntity.ok().body(result);
    }
}
