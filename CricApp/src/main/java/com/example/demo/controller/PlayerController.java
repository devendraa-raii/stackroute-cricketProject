package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Player;
import com.example.demo.service.PlayerService;

@RestController
@CrossOrigin(origins="http://localhost:4200",maxAge=3600)
@RequestMapping("/api/v1")
public class PlayerController {
	
	@Autowired
	PlayerService playerService;
	public PlayerController(PlayerService playerService) {
		// TODO Auto-generated constructor stub
		this.playerService=playerService;
	}
	
	@GetMapping("/players/{userName}")
	public ResponseEntity<?> getAllPlayers(@PathVariable String userName){
		List<Player> list=this.playerService.getPlayersByUser(userName);
		return new ResponseEntity<List<Player>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/players")
	public ResponseEntity<?> addPlayer(@RequestBody Player player){
		boolean res=this.playerService.addPlayer(player);
		Map<String,Boolean> map=new HashMap<String,Boolean>();
		map.put("message", res);
		return new ResponseEntity<Map<String,Boolean>>(map,HttpStatus.OK);
	}
	
	@DeleteMapping("/players/{pid}/{userName}")
	public ResponseEntity<?> deletePlayer(@PathVariable("pid") int pid,@PathVariable("userName") String userName){
		boolean res=this.playerService.deletePlayer(pid, userName);
		Map<String,Boolean> map=new HashMap<String,Boolean>();
		map.put("message", res);
		return new ResponseEntity<Map<String,Boolean>>(map,HttpStatus.OK);
	}

}
