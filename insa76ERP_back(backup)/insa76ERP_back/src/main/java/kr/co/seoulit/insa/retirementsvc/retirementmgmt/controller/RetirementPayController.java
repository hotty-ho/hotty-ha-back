package kr.co.seoulit.insa.retirementsvc.retirementmgmt.controller;

import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.VariableList;
import kr.co.seoulit.insa.retirementsvc.retirementmgmt.service.RetirementMgmtService;
import kr.co.seoulit.insa.retirementsvc.retirementmgmt.to.RetirementPayTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RequestMapping("/retirementmgmt/*")
@RestController
public class RetirementPayController {
    @Autowired
    private RetirementMgmtService retirementMgmtService;

    @Autowired
    private DatasetBeanMapper datasetBeanMapper;


//    @GetMapping("retirementpay")
//    public ModelMap findRetirementPay(@RequestParam String empCode) {
//        map = new ModelMap();
//        HashMap<String, Object> hashMap = retirementMgmtService.findRetirementPay(empCode);
//        ArrayList<RetirementPayTO> retirementPayList = (ArrayList<RetirementPayTO>) hashMap.get("result");
//        map.put("retirementPay", retirementPayList);
//        map.put("errorCode", hashMap.get("errorCode"));
//        map.put("errorMsg", hashMap.get("errorMsg"));
//
//        return map;
//    }

    @PostMapping("retirementpay")
    public void findRetirementPay(@RequestAttribute("reqData") PlatformData reqData,
                                      @RequestAttribute("resData") PlatformData resData) throws Exception {

        String empCode = reqData.getVariable("empCode").getString();

         HashMap<String, Object> map = retirementMgmtService.findRetirementPay(empCode);
         if(((String)map.get("errorCode")).equals("0")) {
             RetirementPayTO retirementPayTO = ((ArrayList<RetirementPayTO>) map.get("result")).get(0);
             datasetBeanMapper.beanToDataset(resData, retirementPayTO, RetirementPayTO.class);
         }else{
             VariableList var = resData.getVariableList();
             var.add("errorCode", (String)map.get("errorCode"));
             var.add("errorMsg", (String)map.get("errorMsg"));
         }
    }
}