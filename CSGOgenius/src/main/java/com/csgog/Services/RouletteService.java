package com.csgog.Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csgog.Entities.BidEntity;
import com.csgog.Forms.BidForm;
import com.csgog.Objects.Field;
import com.csgog.Repositories.BidRepository;

@Service
public class RouletteService {

	@Autowired
	private BidRepository bidRepository;
	
	private static RouletteService instance;
	private List<Field> fields;
	private Field winningField;
	
	public static RouletteService getInstance() {
		if(instance==null) {
			instance = new RouletteService();
		}
		return instance;
	}
	
	public List<Field> generateFields() {
		fields=new ArrayList<Field>();
		fields.clear();
		for(int i=0; i<11; i++) {
			Field field = new Field();
			if(i==5) { field.setHTMLclass(field.getHTMLclass()+" bg-warning"); winningField = field; }
			fields.add(field);
			
	}
		return fields;
	}

	public String makeBid(BidForm bidForm) {
		
		if(bidForm.getAmount() >=2 && bidForm.getType()!=null) {
			BidEntity bidEntity = new BidEntity();
			bidEntity.setAmount(bidForm.getAmount());
			bidEntity.setType(bidForm.getType());
			bidEntity.setGame("ROULETTE");

			if(bidEntity.getType().equals("RED")) bidEntity.setHclass("text-danger");
			else if(bidEntity.getType().equals("GREEN")) bidEntity.setHclass("text-success");
			else if(bidEntity.getType().equals("BLACK")) bidEntity.setHclass("text-secondary");
			
			System.out.println(bidEntity.getType());
			System.out.println(winningField.getColor());
			
			if(bidEntity.getType().equals(winningField.getColor())){
				if(winningField.getColor().equals("RED") || winningField.getColor().equals("BLACK")) bidEntity.setBalance(bidEntity.getAmount()*2);
				else if(winningField.getColor().equals("GREEN")) bidEntity.setBalance(bidEntity.getAmount()*14);
			}
			else bidEntity.setBalance(0-bidEntity.getAmount());
			
			
			if(bidEntity.getBalance()>0) { bidEntity.setSbalance("+" + Integer.toString(bidEntity.getBalance())); bidEntity.setBalClass("text-success"); }
			else { bidEntity.setSbalance(Integer.toString(bidEntity.getBalance())); bidEntity.setBalClass("text-danger"); }
			
			bidRepository.save(bidEntity);
			return bidForm.toString();
		}
		
		else return "Amount can't be less than 2 and type can't be null!";
	}
	
	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
	public List<BidEntity> bids(){
		List<BidEntity> bids = bidRepository.findAllByGame("ROULETTE");
		return bids;
	}
}
