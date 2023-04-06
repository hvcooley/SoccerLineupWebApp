package com.cooley.springboot.soccerlineupapp.lineup;

public class Player {

	private int id;
	private String name;
	private String position;
	private int number;
	private String team;
	
	public Player(int id, String name, String position, int number, String team) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.number = number;
		this.team = team;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", position=" + position + ", number=" + number + ", team="
				+ team + "]";
	}
	
	
	
}
