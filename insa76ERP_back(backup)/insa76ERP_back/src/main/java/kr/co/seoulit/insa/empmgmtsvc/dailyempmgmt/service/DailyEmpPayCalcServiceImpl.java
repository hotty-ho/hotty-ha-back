package kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.service;

import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.mapper.DailyEmpPayCalcMapper;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpCalcTO;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class DailyEmpPayCalcServiceImpl implements DailyEmpPayCalcService{

    @Autowired
    private DailyEmpPayCalcMapper dailyEmpPayCalcMapper;
    @Override
    public ArrayList<DailyEmpTO> findDailyCalcList() {
        return dailyEmpPayCalcMapper.selectDailyCalcList();
    }

    @Override
    public ArrayList<DailyEmpCalcTO> registerDailyCalc(HashMap<String, Object> map) {

        System.out.println("여기까진");
        dailyEmpPayCalcMapper.registerDailyCalc(map);
        System.out.println(map.get("totalResult"));

        ArrayList<DailyEmpCalcTO> valueList = (ArrayList<DailyEmpCalcTO>)map.get("totalResult");

        return valueList;
    }
}
