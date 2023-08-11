package kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.controller;

import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.VariableList;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.service.DailyEmpMgmtService;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.service.DailyEmpMgmtServiceImpl;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.service.DailyEmpPayDateService;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpPayDateTO;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpPayTO;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpTO;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpTargetTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/dailyempdate/*")
public class DailyEmpPayDateMgmtController {

    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @Autowired
    private DailyEmpPayDateService dailyEmpPayDateService;

    @Autowired
    private DailyEmpMgmtService dailyEmpMgmtService;

    @GetMapping("selectList")
    public void findDailyEmpList(
            @RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {

        ArrayList<DailyEmpTO> list = dailyEmpMgmtService.findDailyEmpListExceptDate();
        datasetBeanMapper.beansToDataset(resData, list, DailyEmpTO.class);

    }

    @GetMapping("selectTargetList")
    public void findDailyEmpTargetList(
            @RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {

        ArrayList<DailyEmpTO> list = dailyEmpMgmtService.findDailyEmpTargetList();
        datasetBeanMapper.beansToDataset(resData, list, DailyEmpTO.class);

    }

    @PostMapping("selectTargetDataList")
    public void findDailyEmpTargetDataList(
            @RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {

        VariableList varList = reqData.getVariableList();
        List<String> keys = varList.keyList();

        HashMap<String, String> map = new HashMap<>();

        for(String key : keys){
            System.out.println(key);
            System.out.println(varList.get(key).getString());
            String value = varList.get(key).getString();
            if(value.equals("undefined") || value.trim().length() == 0 || value.equals("all")){
                map.put(key, null);
            }else{
                map.put(key, value);
            }
        }
        ArrayList<DailyEmpTO> list = dailyEmpMgmtService.findDailyEmpTargetDataList(map);
        datasetBeanMapper.beansToDataset(resData, list, DailyEmpTO.class);

    }

    @PostMapping("savepaydatelist")
    public void saveDailyEmpPayDateList(
            @RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
        List<DailyEmpPayDateTO> list = datasetBeanMapper.datasetToBeans(reqData, DailyEmpPayDateTO.class);
        ArrayList<DailyEmpPayDateTO> insertList = new ArrayList<>();
        ArrayList<DailyEmpPayDateTO> updateList = new ArrayList<>();
        ArrayList<DailyEmpPayDateTO> deleteList = new ArrayList<>();

        for(DailyEmpPayDateTO to : list){
            System.out.println(to.getStatus());
            switch(to.getStatus()){
                case "insert" : insertList.add(to); break;
                case "update" : updateList.add(to); break;
                case "delete" : deleteList.add(to); break;
            }
            System.out.println(to);
        }
        if(!insertList.isEmpty()){
//            for(DailyEmpTO to : insertList)
//                dailyEmpMgmtService.registerDailyEmp(to);
            dailyEmpPayDateService.batchInsertDailyPayDateListProcess(insertList);
        }

        if(!updateList.isEmpty()) {
//            for(DailyEmpTO to : updateList)
//                dailyEmpMgmtService.modifyDailyEmp(to);
            dailyEmpPayDateService.batchUpdateDailyPayDateListProcess(updateList);
        }

        if(!deleteList.isEmpty()) {
//            for(DailyEmpTO to : deleteList)
//                dailyEmpMgmtService.removeDailyEmp(to);
            dailyEmpPayDateService.batchDeleteDailyPayDateListProcess(deleteList);
        }
    }
    @PostMapping("searchpayemplist")
    public void selectDailyEmpPayDateList(
            @RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
        VariableList varList = reqData.getVariableList();
        List<String> keys = varList.keyList();

        HashMap<String, String> map = new HashMap<>();

        for(String key : keys){
            System.out.println(key);
            System.out.println(varList.get(key).getString());
            String value = varList.get(key).getString();
            if(value.equals("undefined") || value.trim().length() == 0 || value.equals("all")){
                map.put(key, null);
            }else{
                map.put(key, value);
            }
        }
        ArrayList<DailyEmpTO> list = dailyEmpMgmtService.findDailyEmpPayDateList(map);
        datasetBeanMapper.beansToDataset(resData, list, DailyEmpTO.class);
    }
    @GetMapping("searchpaydatelist")
    public void findDailyPayEmpList(
            @RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {

        ArrayList<DailyEmpPayDateTO> list = dailyEmpPayDateService.findDailyPayList();
        datasetBeanMapper.beansToDataset(resData, list, DailyEmpPayDateTO.class);

    }
    @PostMapping("savelist")
    public void updateEmpPayTargetList(
            @RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
        List<DailyEmpTO> savelist = datasetBeanMapper.datasetToBeans(reqData, DailyEmpTO.class);
        dailyEmpPayDateService.updateDailyPayDate(savelist);
    }
}
