package kr.co.seoulit.insa.salarysvc.salaryinfomgmt.controller;

import java.util.ArrayList;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.service.SalaryInfoMgmtService;
import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.to.RetirementSalaryTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;


@RequestMapping("/salaryinfomgmt/*")
@RestController
@RequiredArgsConstructor
public class RetirementSalController {

   //✅생성자 주입 방식 변경 후_23.08.07.ha
   private final SalaryInfoMgmtService salaryInfoMgmtService;
   private final DatasetBeanMapper datasetBeanMapper;

   @PostMapping("retirement")
   public void retirementSalaryList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {

      String empCode = reqData.getVariable("empCode").getString();
      
      ArrayList<RetirementSalaryTO> retirementSalaryList = salaryInfoMgmtService.findretirementSalaryList(empCode);
      
      datasetBeanMapper.beansToDataset(resData, retirementSalaryList, RetirementSalaryTO.class);
   }
}