package kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.controller;

import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.VariableList;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.service.DailyEmpMgmtServiceImpl;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/dailyemp/*")
public class DailyEmpMgmtController {

    @Autowired
    private DailyEmpMgmtServiceImpl dailyEmpMgmtService;

    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @GetMapping("list")
    public void findDailyEmpList(
            @RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {

        ArrayList<DailyEmpTO> list = dailyEmpMgmtService.findDailyEmpList();
        datasetBeanMapper.beansToDataset(resData, list, DailyEmpTO.class);

    }

    @PostMapping("searchlist")
    public void findDailyEmpListWithConditions(
            @RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {

        VariableList varList = reqData.getVariableList();
        List<String> keys = varList.keyList();

        HashMap<String, String> map = new HashMap<>();

        for(String key : keys){
//            System.out.println(key);
//            System.out.println(varList.get(key).getString());
            String value = varList.get(key).getString();
            if(value.equals("undefined") || value.trim().length() == 0 || value.equals("all")){
                map.put(key, null);
            }else{
                map.put(key, value);
            }
        }

        ArrayList<DailyEmpTO> list = dailyEmpMgmtService.findDailyEmpListWithConditions(map);
        datasetBeanMapper.beansToDataset(resData, list, DailyEmpTO.class);

    }

//    @PostMapping("register")
//    public void registerDailytEmp(
//            @RequestAttribute("reqData") PlatformData reqData,
//            @RequestAttribute("resData") PlatformData resData) throws Exception {
//
//        DailyEmpTO dailyEmpTO = datasetBeanMapper.datasetToBean(reqData, DailyEmpTO.class);
//        dailyEmpMgmtService.registerDailyEmp(dailyEmpTO);
//
//    };

    @PostMapping("save")
    public void batchDailyEmpListProcess(
            @RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {

        String workplaceCode = reqData.getVariable("workplaceCode").getString();
        List<DailyEmpTO> list = datasetBeanMapper.datasetToBeans(reqData, DailyEmpTO.class);

        ArrayList<DailyEmpTO> insertList = new ArrayList<>();
        ArrayList<DailyEmpTO> updateList = new ArrayList<>();
        ArrayList<DailyEmpTO> deleteList = new ArrayList<>();

        for(DailyEmpTO to : list){
            switch(to.getStatus()){
                case "insert" : to.setWorkplaceCode(workplaceCode); insertList.add(to); break;
                case "update" : updateList.add(to); break;
                case "delete" : deleteList.add(to); break;
            }
            System.out.println(to);
        }

        if(!insertList.isEmpty()){
            dailyEmpMgmtService.batchInsertDailyEmpListProcess(insertList);
        }

        if(!updateList.isEmpty()) {
            dailyEmpMgmtService.batchUpdateDailyEmpListProcess(updateList);
        }

        if(!deleteList.isEmpty()) {
            dailyEmpMgmtService.batchDeleteDailyEmpListProcess(deleteList);
        }
    }

}
