package kr.co.seoulit.insa.newempsvc.newempinfomgmt.mapper;

import kr.co.seoulit.insa.newempsvc.newempinfomgmt.to.ApplicantTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface SuccessApplicantMapper {
	public ArrayList<ApplicantTO> FindAllSuccessApplicant(HashMap<String, Object> map);
}
