package kr.co.seoulit.insa.commsvc.systemmgmt.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.insa.commsvc.systemmgmt.entity.DetailCode;
import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.DetailCodeTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DetailCodeRepository extends JpaRepository<DetailCode, String>{

	ArrayList<DetailCode> findAllBycodeNumber(String codetype);
//
//
//	void deleteByDetailCodeNumberAndDetailCodeName(String detailCodeNumber, String detailCodeName);
//
//	void deleteByDetailCodeNumberAndDetailCodeNameAndCodeNumberAndDetailCodeNameusing(String detailCodeNumber,
//			String detailCodeName, String codeNumber, String detailCodeNameusing);
//
//	

}
