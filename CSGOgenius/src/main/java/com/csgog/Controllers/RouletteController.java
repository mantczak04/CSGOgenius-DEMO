package com.csgog.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csgog.Entities.BidEntity;
import com.csgog.Forms.BidForm;
import com.csgog.Objects.Field;
import com.csgog.Repositories.BidRepository;
import com.csgog.Services.RouletteService;

@Controller
public class RouletteController {
	
	@Autowired
	RouletteService rouletteService;
	
	List<Field> fields = new ArrayList<Field>();
	
	@RequestMapping(value="/roulette", method = RequestMethod.GET)
	public String displayRoulette(@ModelAttribute("bidForm") BidForm bidForm, Model model) {
			
		model.addAttribute("fields", fields);
		model.addAttribute("currentBid", bidForm.getAmount());
		model.addAttribute("bids", rouletteService.bids());
		
		return "/roulette/roulette";
	}
	
	@RequestMapping(value="/roulette", method = RequestMethod.POST)
	public String bidRoulette(@ModelAttribute("bidForm") BidForm bidForm, Model model) {
		
		
		fields = rouletteService.generateFields();	
		System.out.println(rouletteService.makeBid(bidForm));
		
		model.addAttribute("fields", fields);
		model.addAttribute("currentBid", bidForm.getAmount());
		model.addAttribute("bids", rouletteService.bids());
		
		return "roulette/roulette";
	}
	
}
