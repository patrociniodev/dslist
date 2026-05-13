package br.com.isaacpatrocinio.dslist.repositories;

import br.com.isaacpatrocinio.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
