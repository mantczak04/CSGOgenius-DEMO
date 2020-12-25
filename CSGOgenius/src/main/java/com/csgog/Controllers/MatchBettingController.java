package com.csgog.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csgog.Forms.BidForm;
import com.csgog.Objects.Team;
import com.csgog.Services.MatchBettingService;

@Controller
public class MatchBettingController {
	
	@Autowired
	MatchBettingService matchBettingService;
	
	List<Team> match = new ArrayList<Team>();
	
	@RequestMapping(value="/matchbetting", method = RequestMethod.GET)
	public String displayMatchBetting(@ModelAttribute("bidForm") BidForm bidForm, Model model) {
		
		match = matchBettingService.generateTeams();
		model.addAttribute("currentBid", bidForm.getAmount());
		model.addAttribute("teams", match);
		model.addAttribute("bids", matchBettingService.bids());

		return "matchbetting/matchbetting";
	}
	
	@RequestMapping(value="/matchbetting", method = RequestMethod.POST)
	public String betMatch(@ModelAttribute("bidForm") BidForm bidForm, Model model) {
		
		match = matchBettingService.generateTeams();
		
		bidForm.setType(match.get(bidForm.getWhich()).getName());
		bidForm.setMultipiler(match.get(bidForm.getWhich()).getMultipiler());
		System.out.println(matchBettingService.makeBid(bidForm));
		
		
		model.addAttribute("currentBid", bidForm.getAmount());
		model.addAttribute("teams", match);
		model.addAttribute("bids", matchBettingService.bids());
		
		return "matchbetting/matchbetting";
	}
	
}
