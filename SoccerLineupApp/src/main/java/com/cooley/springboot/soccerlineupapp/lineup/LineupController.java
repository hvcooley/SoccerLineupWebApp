package com.cooley.springboot.soccerlineupapp.lineup;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class LineupController {

	private LineupService lineupService;
	
	
	public LineupController(LineupService lineupService) {
		super();
		this.lineupService = lineupService;
	}



	@RequestMapping("lineup-list-view")
	public String listLineup(ModelMap model) {
		
		//change this to like getLineup
		List<Player> lineup = lineupService.findByUserName("Cooley");
		
		//model.put("todos", todos);
		model.addAttribute("lineup", lineup);
		
		return "lineupListView";
	}
	
	//Two way binding. Form is bound to bean and vice versa
	@RequestMapping(value = "add-player", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		
		Player player = new Player(0, "", "", 0, "");
		model.put("player", player);
		
		return "addPlayer";
	}
	
	@RequestMapping(value = "add-player", method = RequestMethod.POST)
	//Bind directly to the Todo bean
	public String addNewPlayer(ModelMap model, @Valid Player player, BindingResult result) {
		//if there are any validation errors
		if (result.hasErrors()) {
			return "addPlayer";
		}
		
		lineupService.addPlayer(player.getName(), player.getPosition(), player.getNumber(), "New York Boys F.C.");
		return "redirect:lineup-list-view";
	}
	
	@RequestMapping("delete-player")
	public String deletePlayer(@RequestParam int id) {
		
		lineupService.deleteById(id);
		
		return "redirect:lineup-list-view";
	}
	
	@RequestMapping(value = "update-player", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		
		
		Player player = lineupService.findById(id);
		model.addAttribute("player", player);
		
		return "addPlayer";
	}
	
	@RequestMapping(value = "update-player", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Player player, BindingResult result) {
		
		if (result.hasErrors()) {
			return "addPlayer";
		}
		
		lineupService.updatePlayer(player.getId(), player.getName(), player.getPosition(), player.getNumber(), player.getTeam());
		
		return "redirect:lineup-list-view";
	}
	
}