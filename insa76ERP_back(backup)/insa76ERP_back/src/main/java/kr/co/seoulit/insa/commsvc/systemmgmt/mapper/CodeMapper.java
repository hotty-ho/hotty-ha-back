package kr.co.seoulit.insa.commsvc.systemmgmt.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import kr.co.seoulit.insa.commsvc.systemmgmt.to.CodeTO;

@Mapper
public interface CodeMapper {
	
	   public ArrayList<CodeTO> selectCode();
	   
}
