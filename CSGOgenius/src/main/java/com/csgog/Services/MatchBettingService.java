package com.csgog.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csgog.Entities.BidEntity;
import com.csgog.Forms.BidForm;
import com.csgog.Objects.Team;
import com.csgog.Repositories.BidRepository;

@Service
public class MatchBettingService {
	
	private static MatchBettingService instance;
	
	@Autowired
	BidRepository bidRepository;
	
	private List<String> names=new ArrayList<String>();
	private List<Team> match = new ArrayList<Team>();
	
	public MatchBettingService() {
		names.add("Astralis");
		names.add("BIG");
		names.add("FaZe Clan");
		names.add("FURIA");
		names.add("G2");
		names.add("Heroic");
		names.add("mousesports");
		names.add("OG");
		names.add("Team Vitality");
		names.add("Virtus.pro");
	}
	
	public List<Team> generateTeams() {
		match.clear();
		Random generator;
	for(int i=0; i<6; i++) {
		Team team = new Team();
		generator = new Random();
		int which= generator.nextInt(10);
		team.setName(names.get(which));
		team.setWhich(i);
		double random = 1 + Math.random() * (5 - 1);
		team.setMultipiler(Math.round(random*100.0)/100.0);
		team.setSrc("../images/" + names.get(which) + ".png");
		match.add(team);
	}

		return match;
	}
	
	public String makeBid(BidForm bidForm) {
		BidEntity bidEntity = new BidEntity();
		bidEntity.setAmount(bidForm.getAmount());
		bidEntity.setGame("MATCHBETTING");
		bidEntity.setType(bidForm.getType());
		bidEntity.setMultipiler(bidForm.getMultipiler());
		
		double random = 1 + Math.random() * (100 - 1);
		if(random>50) { 
			bidEntity.setBalClass("text-success"); 
			bidEntity.setSbalance("+" + Double.toString(bidForm.getMultipiler()*bidForm.getAmount()));
			}
		else { bidEntity.setBalClass("text-danger"); 
		bidEntity.setSbalance("-" + Integer.toString(bidForm.getAmount()));
		}
		bidRepository.save(bidEntity);
		
		return "wszystko git";
	}
	
	public List<BidEntity> bids(){
		List<BidEntity> bids = bidRepository.findAllByGame("MATCHBETTING");
		return bids;
	}
	
	public static MatchBettingService getInstance() {
		if(instance==null) {
			instance = new MatchBettingService();
		}
		return instance;
	}
}
