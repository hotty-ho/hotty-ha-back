package kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.to.BaseSalaryTO;


public interface BaseSalRepository extends JpaRepository<BaseSalaryTO,String>{


}
