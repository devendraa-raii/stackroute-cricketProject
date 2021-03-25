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

import com.example.demo.model.Match;
import com.example.demo.service.MatchService;

@RestController
@CrossOrigin(origins="http://localhost:4200",maxAge=3600)
@RequestMapping("/api/v1")
public class MatchController {

	
	@Autowired
	MatchService matchService;
	public MatchController(MatchService matchService) {
		this.matchService=matchService;
	}
	
	@GetMapping("/isAuthenticated")
	public ResponseEntity<?> isAuthenticated(){
		Map<String,Boolean> map=new HashMap<String,Boolean>();
		map.put("message", true);
		return new ResponseEntity<Map<String,Boolean>>(map,HttpStatus.OK);
	}
	
	@GetMapping("/matches/{userName}")
	public ResponseEntity<?> getAllMatches(@PathVariable String userName){
		List<Match> list=this.matchService.getAllMatches(userName);
		return new ResponseEntity<List<Match>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/matches")
	public ResponseEntity<?> addMatch(@RequestBody Match match){
		boolean res=this.matchService.addMatch(match);
		Map<String,Boolean> map=new HashMap<String,Boolean>();
		map.put("message", res);
		return new ResponseEntity<Map<String,Boolean>>(map,HttpStatus.OK);
	}
	
	@DeleteMapping("/matches/{pid}/{userName}")
	public ResponseEntity<?> deletePlayer(@PathVariable("pid") int pid,@PathVariable("userName") String userName){
		boolean res=this.matchService.deleteMatch(pid, userName);
		Map<String,Boolean> map=new HashMap<String,Boolean>();
		map.put("message", res);
		return new ResponseEntity<Map<String,Boolean>>(map,HttpStatus.OK);
	}

}
