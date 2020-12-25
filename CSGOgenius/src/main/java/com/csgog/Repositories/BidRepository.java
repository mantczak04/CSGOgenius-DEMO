package com.csgog.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csgog.Entities.BidEntity;

public interface BidRepository extends JpaRepository<BidEntity, Long>{
	List<BidEntity> findAllByGame(String game);
}
