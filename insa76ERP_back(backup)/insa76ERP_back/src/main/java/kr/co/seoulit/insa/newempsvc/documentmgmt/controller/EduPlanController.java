package kr.co.seoulit.insa.newempsvc.documentmgmt.controller;


import com.nexacro17.xapi.data.PlatformData;
import kr.co.seoulit.insa.newempsvc.documentmgmt.service.EduPlanService;
import kr.co.seoulit.insa.newempsvc.documentmgmt.to.EduPlanTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/documentmgmt")
@RestController
public class EduPlanController {

    @Autowired
    EduPlanService service;

    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    ModelMap map = null;

  @RequestMapping("/eduPlan")
    public ModelMap register(@RequestAttribute("resData") PlatformData resData,
                             @RequestAttribute("reqData") PlatformData reqData)throws Exception{

      EduPlanTO plan = datasetBeanMapper.datasetToBean(reqData , EduPlanTO.class);
        System.out.println(plan);
      service.register(plan);

        return null;
  }
}
