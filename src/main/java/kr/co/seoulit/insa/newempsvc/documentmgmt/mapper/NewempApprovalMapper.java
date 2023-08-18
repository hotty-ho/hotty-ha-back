package kr.co.seoulit.insa.newempsvc.documentmgmt.mapper;

import com.sun.net.httpserver.Authenticator;
import kr.co.seoulit.insa.newempsvc.documentmgmt.to.RecruitmentTO;
import kr.co.seoulit.insa.newempsvc.documentmgmt.to.SuccessEmpTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Mapper
public interface NewempApprovalMapper {

//선발 대상자 조회
    ArrayList<RecruitmentTO> findnewempcruiTh(@Param("year") int year, @Param("half") String half);

//확정
    void updateCertificateRec(RecruitmentTO certificate);

//합격자 조회
	ArrayList<SuccessEmpTO> findNewEmpSuccess(HashMap<String, Object> map);
}
