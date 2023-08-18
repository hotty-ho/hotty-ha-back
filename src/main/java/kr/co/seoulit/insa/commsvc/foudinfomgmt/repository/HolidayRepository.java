package kr.co.seoulit.insa.commsvc.foudinfomgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.HolidayTO;

public interface HolidayRepository extends JpaRepository<HolidayTO,String>{

	
}
