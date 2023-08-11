package kr.co.seoulit.insa.commsvc.systemmgmt.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.CodeTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CodeRepository extends JpaRepository<CodeTO, String>{


}
