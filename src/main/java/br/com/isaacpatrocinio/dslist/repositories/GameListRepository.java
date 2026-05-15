package br.com.isaacpatrocinio.dslist.repositories;

import br.com.isaacpatrocinio.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
