package kr.co.seoulit.insa.commsvc.foudinfomgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.PositionTO;

import java.util.List;

public interface PositionRepository extends JpaRepository<PositionTO,String>{

    List<PositionTO> findAllByPositionCode(String positionCode);

}
