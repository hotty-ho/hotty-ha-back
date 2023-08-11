package kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.service;

import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpCalcTO;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface DailyEmpPayCalcService {
    public ArrayList<DailyEmpTO> findDailyCalcList();

    public ArrayList<DailyEmpCalcTO> registerDailyCalc(HashMap<String, Object> map);
}
