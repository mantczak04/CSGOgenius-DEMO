package com.csgog.Entities;

import javax.persistence.*;

@Entity
@Table(name="BID")
public class BidEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="game")
	private String game;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="type")
	private String type;
	
	@Column(name="multipiler")
	private double multipiler;
	
	private int balance;
	private String Sbalance;
	
	private String Hclass;
	private String balClass;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHclass() {
		return Hclass;
	}

	public void setHclass(String hclass) {
		Hclass = hclass;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getBalClass() {
		return balClass;
	}

	public void setBalClass(String balClass) {
		this.balClass = balClass;
	}

	public String getSbalance() {
		return Sbalance;
	}

	public void setSbalance(String sbalance) {
		Sbalance = sbalance;
	}

	public double getMultipiler() {
		return multipiler;
	}

	public void setMultipiler(double multipiler) {
		this.multipiler = multipiler;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	
	
}
