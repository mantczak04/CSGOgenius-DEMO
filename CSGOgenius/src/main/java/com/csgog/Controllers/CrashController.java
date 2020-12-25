package com.csgog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csgog.Forms.BidForm;
import com.csgog.Objects.Multipiler;
import com.csgog.Services.CrashService;

@Controller
public class CrashController {
	
	@Autowired
	CrashService crashService;

	Multipiler multipiler;
	
	@RequestMapping(value="/crash", method=RequestMethod.GET)
	public String displayCrash(@ModelAttribute("bidForm") BidForm bidForm, Model model) {
		multipiler = new Multipiler();
		
		System.out.println(multipiler.getMultipiler());
		
		model.addAttribute("currentBid", bidForm.getAmount());
		model.addAttribute("crash", multipiler);
		model.addAttribute("bids", crashService.bids());
		
		return "crash/crash";
	}
	
	@RequestMapping(value="/crash", method=RequestMethod.POST)
	public String bidCrash(@ModelAttribute("bidForm") BidForm bidForm, Model model) {
		
		multipiler = new Multipiler();
		System.out.println(crashService.makeBid(bidForm, multipiler.getMultipiler()));
		
		model.addAttribute("currentBid", bidForm.getAmount());
		model.addAttribute("crash", multipiler);
		model.addAttribute("bids", crashService.bids());
		
		return "crash/crash";
	}
	
}
