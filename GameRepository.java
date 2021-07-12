package com.lojaGames.games.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lojaGames.games.model.GamesModel;

@Repository
public interface GameRepository extends JpaRepository<GamesModel, Integer>  {
	
	public Optional<GamesModel> findAllById(int id);
	public Optional<GamesModel> findByNome(String nome);

}
