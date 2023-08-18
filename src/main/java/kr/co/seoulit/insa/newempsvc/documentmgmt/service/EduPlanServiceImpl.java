package kr.co.seoulit.insa.newempsvc.documentmgmt.service;


import kr.co.seoulit.insa.newempsvc.documentmgmt.mapper.EduPlanMapper;
import kr.co.seoulit.insa.newempsvc.documentmgmt.to.EduPlanTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EduPlanServiceImpl implements EduPlanService {

    @Autowired
    EduPlanMapper mapper;

    @Override
    public void register(EduPlanTO plan){
        mapper.registEdu(plan);

    }
}
