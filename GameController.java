package com.lojaGames.games.controller;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lojaGames.games.model.GamesModel;
import com.lojaGames.games.repository.GameRepository;


@RestController
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private GameRepository repositoryG;
	
	@GetMapping("/todas")
	public List<GamesModel> gamesGetAll(){
		return repositoryG.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<GamesModel> getById(@PathVariable int id){
		return repositoryG.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<GamesModel> communityPost(@RequestBody GamesModel GamesM) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryG.save(GamesM));
	}
	
	@PutMapping
	public ResponseEntity<GamesModel> communityPut(@RequestBody GamesModel gamesM) {
		return ResponseEntity.status(HttpStatus.OK).body(repositoryG.save(gamesM));
	}
	
	@DeleteMapping("/delete/{gameId}")
	public void communityDelete(@PathVariable int gameId) {
		repositoryG.deleteById(gameId);
	}


	
	
}
