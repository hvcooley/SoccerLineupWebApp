package com.cooley.springboot.soccerlineupapp.lineup;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class LineupService {

	//private static List<Player> lineup = new ArrayList<Player>();
	
	private static List<Lineup> allLineups = new ArrayList<Lineup>();
	
	private static int lineupCount = 0;
	
	private static int playerCount = 0;
	
	static {
		
		Lineup harrisonsLineup = new Lineup(lineupCount++, "Harrison");
		harrisonsLineup.addPlayer(++playerCount, "Matt Katz", "Right Mid", 7, "New York Boys F.C.");
		harrisonsLineup.addPlayer(++playerCount, "Jonathan Freedman", "Striker", 21, "New York Boys F.C.");
		harrisonsLineup.addPlayer(++playerCount, "Benjamin Rampelt", "Left Mid", 11, "New York Boys F.C.");
		harrisonsLineup.addPlayer(++playerCount, "Harrison Cooley", "Center Attacking Mid", 10, "New York Boys F.C.");
		harrisonsLineup.addPlayer(++playerCount, "Steven Hadley", "Center Mid", 13, "New York Boys F.C.");
		harrisonsLineup.addPlayer(++playerCount, "Leo Cooley", "Holding Mid", 39, "New York Boys F.C.");
		harrisonsLineup.addPlayer(++playerCount, "Brendan Keefe", "Left Back", 15, "New York Boys F.C.");
		harrisonsLineup.addPlayer(++playerCount, "Jordan Peck", "Center Back", 3, "New York Boys F.C.");
		harrisonsLineup.addPlayer(++playerCount, "Andrew Carolan", "Center Back", 16, "New York Boys F.C.");
		harrisonsLineup.addPlayer(++playerCount, "Eric Hsieh", "Right Back", 4, "New York Boys F.C.");
		harrisonsLineup.addPlayer(++playerCount, "Andrew Garafalo", "Goalie", 1, "New York Boys F.C.");
		
		allLineups.add(harrisonsLineup);
		
//		lineup.add(new Player(++playerCount, "Matt Katz", "Right Mid", 7, "New York Boys F.C."));
//		lineup.add(new Player(++playerCount, "Jonathan Freedman", "Striker", 21, "New York Boys F.C."));
//		lineup.add(new Player(++playerCount, "Benjamin Rampelt", "Left Mid", 11, "New York Boys F.C."));
//		
//		lineup.add(new Player(++playerCount, "Harrison Cooley", "Center Attacking Mid", 10, "New York Boys F.C."));
//		lineup.add(new Player(++playerCount, "Steven Hadley", "Center Mid", 13, "New York Boys F.C."));
//		lineup.add(new Player(++playerCount, "Leo Cooley", "Holding Mid", 39, "New York Boys F.C."));
//		
//		lineup.add(new Player(++playerCount, "Brendan Keefe", "Left Back", 15, "New York Boys F.C."));
//		lineup.add(new Player(++playerCount, "Jordan Peck", "Center Back", 3, "New York Boys F.C."));
//		lineup.add(new Player(++playerCount, "Andrew Carolan", "Center Back", 16, "New York Boys F.C."));
//		lineup.add(new Player(++playerCount, "Eric Hsieh", "Right Back", 4, "New York Boys F.C."));
//		lineup.add(new Player(++playerCount, "Andrew Garafalo", "Goalie", 1, "New York Boys F.C."));
		
	}
	
	public List<Player> getPlayersFromLineupByUsername(String username){
		
		for (Lineup lineup: allLineups) {
			if (lineup.getOwner().equals(username)) {
				return lineup.getPlayers();
			}
		}
	
		System.out.println("Unable to find a lineup for the user " + username);
		return new ArrayList<Player>();
		
	}
	
	//Need to find a way to return the lineup for a person's profile
	public Lineup getLineupByUsername(String username){
		
		for (Lineup lineup: allLineups) {
			if (lineup.getOwner().equals(username)) {
				return lineup;
			}
		}
	
		System.out.println("Unable to find a lineup for the user " + username);
		return new Lineup(lineupCount++, username);
		
	}
	

	
	public void addPlayer(String currentUsername, String name, String position, int number, String team) {
		
		Lineup lineup = getLineupByUsername(currentUsername);
		
		//Player player = new Player(++playerCount, name, position, number, team);
		
		lineup.addPlayer(++playerCount, name, position, number, team);
	}
	
	public void deleteById(String currentUsername, int id){
		
		Lineup lineup = getLineupByUsername(currentUsername);
		
		Predicate<? super Player> predicate = player -> player.getId() == id;
		lineup.getPlayers().removeIf(predicate);
		
		//My version, uses linear search for the todo you are deleting
		
//		Integer delIndex = null;
//		
//		for (int i = 0; i < todosCount; i++) {
//			if (todos.get(i).getId() == id) {
//				delIndex = i;
//			}
//			
//		}
//		
//		
//		if (delIndex != null) {
//			System.out.println("Found index to delete: " + delIndex);
//			todos.remove((int) delIndex);
//		}
//		else {
//			//print some error message
//			System.out.println("Could not find todo to delete");
//			return;
//		}
		
		
	}

	public Player findById(String currentUsername, int id) {
		
		Predicate<? super Player> predicate = player -> player.getId() == id;
		
		Player player = getPlayersFromLineupByUsername(currentUsername).stream().filter(predicate).findFirst().get();
		
		return player;
		
	}

	//the parameter name also needs to match the bean path
	public void updatePlayer(String currentUsername, int id, String name, String position, int number, String team) {
		// TODO Auto-generated method stub
		Predicate<? super Player> predicate = player -> player.getId() == id;
		
		Player player = getPlayersFromLineupByUsername(currentUsername).stream().filter(predicate).findFirst().get();
		
		
		//reason why the description error crashes the webpage is bc the @Size tag likely only can handle an error in the constructor. I used the setters here
		player.setName(name);
		player.setPosition(position);
		player.setNumber(number);
		
		//In the tutorial he uses a naive implementation of deleting existing todo and adding a new todo with updated details
		
	}
	
}
