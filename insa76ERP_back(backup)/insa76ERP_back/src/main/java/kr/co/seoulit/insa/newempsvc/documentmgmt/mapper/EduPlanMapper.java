package kr.co.seoulit.insa.newempsvc.documentmgmt.mapper;


import kr.co.seoulit.insa.newempsvc.documentmgmt.to.EduPlanTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EduPlanMapper {
    public void registEdu(EduPlanTO plan);
}
