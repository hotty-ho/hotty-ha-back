package kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.service;

import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DailyEmpMgmtService {
    public ArrayList<DailyEmpTO> findDailyEmpList();
    public ArrayList<DailyEmpTO> findDailyEmpListWithConditions(Map<String, String> map);
    public void registerDailyEmp(DailyEmpTO dailyEmpTO);
    public void modifyDailyEmp(DailyEmpTO dailyEmpTO);
    public void removeDailyEmp(DailyEmpTO dailyEmpTO);
    public void batchInsertDailyEmpListProcess(List<DailyEmpTO> list);
    public void batchUpdateDailyEmpListProcess(List<DailyEmpTO> list);
    public void batchDeleteDailyEmpListProcess(List<DailyEmpTO> list);
    public ArrayList<DailyEmpTO> findDailyEmpPayDateList(HashMap<String, String> map);
    public ArrayList<DailyEmpTO> findDailyEmpTargetDataList(HashMap<String, String> map);
    public ArrayList<DailyEmpTO> findDailyEmpListExceptDate();
    public ArrayList<DailyEmpTO> findDailyEmpTargetList();
}
