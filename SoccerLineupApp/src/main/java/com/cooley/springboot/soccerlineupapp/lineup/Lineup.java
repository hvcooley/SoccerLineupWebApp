package com.cooley.springboot.soccerlineupapp.lineup;

import java.util.ArrayList;
import java.util.List;

public class Lineup {
	
	private int id;
	private String owner;
	private List<Player> players;
	private int playerCount = 0;
	
	public Lineup(int id, String user) {
		this(id, user, new ArrayList<Player>(), 0);
	}
	
	public Lineup(int id, String user, List<Player> players) {
		this(id, user, players, players.size());
	}
	
	public Lineup(int id, String owner, List<Player> players, int playerCount) {
		this.id = id;
		this.owner = owner;
		this.players = players;
		this.playerCount = playerCount;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}

	public void addPlayer(int id, String name, String position, int number, String team) {
		Player player = new Player(id, name, position, number, team);
		
		players.add(player);
		playerCount++;
	}

}
