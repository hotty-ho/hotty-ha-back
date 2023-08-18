package kr.co.seoulit.insa.attdsvc.attdmgmt.repository;


import kr.co.seoulit.insa.attdsvc.attdmgmt.to.DeptListTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DeptsRepository extends JpaRepository<DeptListTO, String>{


}
