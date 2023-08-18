package kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.mapper;

import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpPayDateTO;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface DailyEmpPayDateMapper {
    public void insertDailyEmpPayDate(List<DailyEmpPayDateTO> list);

    public void deleteDailyEmpPayDate();

    public ArrayList<DailyEmpPayDateTO> selectDailyPayDateList();

}
