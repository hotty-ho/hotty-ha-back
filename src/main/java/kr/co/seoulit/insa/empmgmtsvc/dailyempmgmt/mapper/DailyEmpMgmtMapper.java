package kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.mapper;

import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Mapper
public interface DailyEmpMgmtMapper {
    public ArrayList<DailyEmpTO> selectDailyEmpList();
    public ArrayList<DailyEmpTO> selectDailyEmpListWithConditions(Map<String, String> map);
    public void insertDailyEmp(DailyEmpTO dailyEmpTO);
    public void updateDailyEmp(DailyEmpTO dailyEmpTO);
    public void deleteDailyEmp(DailyEmpTO dailyEmpTO);
    public ArrayList<DailyEmpTO> selectDailyEmpPayList(HashMap<String, String> map);
    public ArrayList<DailyEmpTO> selectDailyEmpTargetDataList(HashMap<String, String> map);
    public ArrayList<DailyEmpTO> selectDailyEmpExceptDateList();
    public ArrayList<DailyEmpTO> selectDailyEmpTargetList();
}
