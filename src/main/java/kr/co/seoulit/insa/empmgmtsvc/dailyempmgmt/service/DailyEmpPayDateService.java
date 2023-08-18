package kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.service;

import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpPayDateTO;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpPayTO;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpTO;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpTargetTO;

import java.util.ArrayList;
import java.util.List;

public interface DailyEmpPayDateService {
    public void insertDailyEmpPayDate(List<DailyEmpPayDateTO> list);

    public void deleteDailyEmpPayDate();

    public ArrayList<DailyEmpPayDateTO> findDailyPayList();

    public void batchInsertDailyPayDateListProcess(ArrayList<DailyEmpPayDateTO> list);

    public void batchUpdateDailyPayDateListProcess(ArrayList<DailyEmpPayDateTO> list);

    public void batchDeleteDailyPayDateListProcess(ArrayList<DailyEmpPayDateTO> list);

    public void updateDailyPayDate(List<DailyEmpTO> list);

}
