package com.csgog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csgog.Objects.Field;
import com.csgog.Services.RouletteService;

@Controller
public class RouletteController {
	
	@RequestMapping(value="/roulette", method=RequestMethod.GET)
	public String displayRoulette(Model model) {
		
		RouletteService rouletteService = RouletteService.getInstance();
		rouletteService.generateFields();
		model.addAttribute("fields", rouletteService.getFields());
		
		return "/roulette/roulette";
	}
}
