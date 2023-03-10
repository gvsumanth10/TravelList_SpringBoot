package com.webapp.demo.traveldao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.webapp.demo.travel.Travel;

import jakarta.transaction.Transactional;


public interface TravelDao extends JpaRepository<Travel, Integer> {
	
	@Query(value="select * from travel_list where id=?1",nativeQuery = true)
	List<Travel> listById(int id);
	
	@Modifying
	@Transactional
	@Query(value="update travel_list set description=?2 where id=?1",nativeQuery = true)
	void update(int id,String desc);
}