package kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.controller;

import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.VariableList;


import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.service.DailyEmpMgmtService;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.service.DailyEmpPayCalcService;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpCalcTO;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpTO;
import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/dailycalc/*")
public class DailyEmpPayCalcMgmtController {

    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @Autowired
    private DailyEmpMgmtService dailyEmpMgmtService;

    @Autowired
    private DailyEmpPayCalcService dailyEmpPayCalcService;

    @GetMapping("calclist")
    public void searchDayEmpCalcList(
            @RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
        ArrayList<DailyEmpTO> list = dailyEmpPayCalcService.findDailyCalcList();
        datasetBeanMapper.beansToDataset(resData, list, DailyEmpTO.class);
    }

    @PostMapping("dailycalc")
    public void calcDayEmp(
            @RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
        String dempCode = reqData.getVariable("dempCode").getString();
        String paystatcode = reqData.getVariable("paystatcode").getString();
        String isTaxfree = reqData.getVariable("isTaxfree").getString();
        String isEmpinsurance = reqData.getVariable("isEmpinsurance").getString();
        String isNationalannuity = reqData.getVariable("isNationalannuity").getString();
        String isHealthinsurance = reqData.getVariable("isHealthinsurance").getString();String sumTax = reqData.getVariable("sumTax").getString();
        String sumTaxAdd = reqData.getVariable("sumTaxAdd").getString();
        String sumTaxExt = reqData.getVariable("sumTaxExt").getString();
        String sumTaxFree = reqData.getVariable("sumTaxFree").getString();
        String sumTaxOth = reqData.getVariable("sumTaxOth").getString();

        HashMap<String, Object> map = new HashMap<>();
        map.put("dempCode", dempCode);
        map.put("paystatcode", paystatcode);
        map.put("isTaxfree", isTaxfree);
        map.put("isEmpinsurance", isEmpinsurance);
        map.put("isNationalannuity", isNationalannuity);
        map.put("isHealthinsurance", isHealthinsurance);
        map.put("sumTax", sumTax);
        map.put("sumTaxAdd", sumTaxAdd);
        map.put("sumTaxExt", sumTaxExt);
        map.put("sumTaxFree", sumTaxFree);
        map.put("sumTaxOth", sumTaxOth);

        for(String key : map.keySet()) {
            System.out.println(key +" : "+ map.get(key));
        }
        ArrayList<DailyEmpCalcTO> list = dailyEmpPayCalcService.registerDailyCalc(map);
        datasetBeanMapper.beansToDataset(resData, list, DailyEmpCalcTO.class);
    }
}
