package kr.co.seoulit.insa.newempsvc.newempinfomgmt.controller;

import com.nexacro17.xapi.data.PlatformData;
import kr.co.seoulit.insa.newempsvc.newempinfomgmt.service.NewEmpInfoService;
import kr.co.seoulit.insa.newempsvc.newempinfomgmt.to.NewResumeTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RequestMapping("/newempinfomgmt/*")
@RestController
public class ResumeManagementController {
    @Autowired
    private NewEmpInfoService newempInfoService;

    @Autowired
    DatasetBeanMapper datasetBeanMapper;


    @RequestMapping("resumemgmt")
    public void resumeList(@RequestAttribute("reqData") PlatformData reqData,
                               @RequestAttribute("resData") PlatformData resData) throws Exception {
        System.out.println("resumemgmt 컨트롤러 실행");
        int year = reqData.getVariable("sendyear").getInt();
        String half = reqData.getVariable("half").getString();
        String workplaceCode = reqData.getVariable("workplaceCode").getString();
        System.out.println("year = " + year);
        ArrayList<NewResumeTO> resume = newempInfoService.findresumeList(year, half,workplaceCode);
        System.out.println("resume = " + resume);
        datasetBeanMapper.beansToDataset(resData, resume, NewResumeTO.class);
    }

    @RequestMapping("modifyresumemgmt")
    public void resumeUpdate(@RequestAttribute("reqData") PlatformData reqData) throws Exception {
        NewResumeTO newResumeTO = datasetBeanMapper.datasetToBean(reqData, NewResumeTO.class);
        newempInfoService.updateresumeNewemp(newResumeTO);
    }

    @RequestMapping("insertResume")
    public void insertResume(@RequestAttribute("reqData") PlatformData reqData) throws Exception {
        System.out.println("insert 컨트롤러실행");
        NewResumeTO newResumeTO = datasetBeanMapper.datasetToBean(reqData, NewResumeTO.class);
        newempInfoService.insertResume(newResumeTO);
    }
}
