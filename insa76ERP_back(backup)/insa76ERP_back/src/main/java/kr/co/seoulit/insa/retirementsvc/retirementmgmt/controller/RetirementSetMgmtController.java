package kr.co.seoulit.insa.retirementsvc.retirementmgmt.controller;

import com.nexacro17.xapi.data.PlatformData;
import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpEvalTO;
import kr.co.seoulit.insa.retirementsvc.retirementmgmt.service.RetirementMgmtService;
import kr.co.seoulit.insa.retirementsvc.retirementmgmt.to.RetirementSetMgmtTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/retirementmgmt/*")
@RestController
public class RetirementSetMgmtController {
    @Autowired
    private RetirementMgmtService retirementMgmtService;

    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    ModelMap map = null;

    @GetMapping("retirementmgmt")
    public ModelMap findRetirementSetMgmtDetail(@RequestAttribute("reqData") PlatformData reqData,
                                                @RequestAttribute("resData") PlatformData resData) throws Exception{

        RetirementSetMgmtTO retirementSetMgmtList = retirementMgmtService.findRetirementSetMgmtDetail();

        datasetBeanMapper.beanToDataset(resData, retirementSetMgmtList, RetirementSetMgmtTO.class);

        return null;
    }

    @PostMapping("modifyRetirementmgmt")
    public ModelMap modifyRetirementSetMgmt(@RequestAttribute("reqData") PlatformData reqData,
                                            @RequestAttribute("resData") PlatformData resData) throws Exception{

        RetirementSetMgmtTO retirementSetMgmtTO = datasetBeanMapper.datasetToBean(reqData, RetirementSetMgmtTO.class);
        retirementMgmtService.modifyRetirementSetMgmt(retirementSetMgmtTO);

        return null;
    }
}
