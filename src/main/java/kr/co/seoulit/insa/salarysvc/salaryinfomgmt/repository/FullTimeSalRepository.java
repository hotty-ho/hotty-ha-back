package kr.co.seoulit.insa.salarysvc.salaryinfomgmt.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.to.FullTimeSalTO;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FullTimeSalRepository extends JpaRepository<FullTimeSalTO, String>{


}
