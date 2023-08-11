package kr.co.seoulit.insa.commsvc.foudinfomgmt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.DeptTO;

import java.util.List;


public interface DeptRepository extends JpaRepository<DeptTO, String>{
   DeptTO findByDeptCode(String deptCode);

}
