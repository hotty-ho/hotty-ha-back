package kr.co.seoulit.insa.commsvc.foudinfomgmt.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.commsvc.foudinfomgmt.service.FoudInfoMgmtService;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.BaseWorkTimeTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;

@RequestMapping("/foudinfomgmt/*")
@RestController
public class BaseWorkTimeController {

   @Autowired
   private FoudInfoMgmtService foudInfoMgmtService;
   @Autowired
   private DatasetBeanMapper datasetBeanMapper;

   @GetMapping("basetime")
   public void findTimeList(@RequestAttribute("reqData") PlatformData reqData,
         @RequestAttribute("resData") PlatformData resData) throws Exception {

         ArrayList<BaseWorkTimeTO> baseWorkTimeTO = foudInfoMgmtService.findTimeList();
         
         datasetBeanMapper.beansToDataset(resData, baseWorkTimeTO, BaseWorkTimeTO.class);
   }
   
   @RequestMapping("putbasetime")
   public void batchTimeProcess(@RequestAttribute("reqData") PlatformData reqData,
         @RequestAttribute("resData") PlatformData resData) throws Exception {
      

      ArrayList<BaseWorkTimeTO> baseWorkTimeTO = (ArrayList<BaseWorkTimeTO>)datasetBeanMapper.datasetToBeans(reqData, BaseWorkTimeTO.class);

      foudInfoMgmtService.batchTimeProcess(baseWorkTimeTO);
   }
}