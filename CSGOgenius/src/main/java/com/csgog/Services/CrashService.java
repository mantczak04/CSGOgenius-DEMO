package com.csgog.Services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csgog.Entities.BidEntity;
import com.csgog.Forms.BidForm;
import com.csgog.Repositories.BidRepository;

@Service
public class CrashService {
	
	@Autowired
	BidRepository bidRepository;
	
	private static CrashService instance;
	
	public static CrashService getInstance() {
		if(instance==null) {
			instance = new CrashService();
		}
		return instance;
	}
	
	public String makeBid(BidForm bidForm, double multipiler) {
			BidEntity bidEntity = new BidEntity();
			bidEntity.setAmount(bidForm.getAmount());
			bidEntity.setMultipiler(bidForm.getMultipiler());
			bidEntity.setGame("CRASH");
			
			if(bidForm.getMultipiler() <= multipiler) {
				bidEntity.setSbalance("+" + Double.toString(bidForm.getMultipiler()*bidForm.getAmount()));
				bidEntity.setBalClass("text-success");
			}
			else {
				bidEntity.setSbalance("-" + Integer.toString(bidForm.getAmount()));
				bidEntity.setBalClass("text-danger");
			}
			
			System.out.println(bidEntity.getSbalance());
			bidRepository.save(bidEntity);
			return "Bid was successfully made";
	}
	
	public List<BidEntity> bids(){
		List<BidEntity> bids = bidRepository.findAllByGame("CRASH");
		return bids;
	}
	
}
