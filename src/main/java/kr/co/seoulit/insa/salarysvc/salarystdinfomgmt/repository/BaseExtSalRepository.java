package kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.to.BaseExtSalTO;


public interface BaseExtSalRepository extends JpaRepository<BaseExtSalTO,String>{


}
