package kr.co.seoulit.insa.newempsvc.documentmgmt.mapper;

import kr.co.seoulit.insa.newempsvc.documentmgmt.to.ConditionTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ConditionMapper {

	public void registCondition(ConditionTO condition);

	public ArrayList<ConditionTO> FindAllTermlist(String workplaceCode);

//	public void deleteTerms(String workplaceCode, Integer year, String half, String dept);

	public void deleteTerms(ConditionTO condition);



}
