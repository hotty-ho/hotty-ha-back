package kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.mapper;

import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface DailyEmpPayCalcMapper {

    public ArrayList<DailyEmpTO> selectDailyCalcList();

    public HashMap<String, Object> registerDailyCalc(HashMap<String, Object> map);
}
