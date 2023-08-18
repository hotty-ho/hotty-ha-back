package kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpEvalTO;

import java.util.ArrayList;
import java.util.List;

public interface EmpEvalRepository extends JpaRepository<EmpEvalTO,String>{

    List<EmpEvalTO> findAllByApplyDay(String year);

}
