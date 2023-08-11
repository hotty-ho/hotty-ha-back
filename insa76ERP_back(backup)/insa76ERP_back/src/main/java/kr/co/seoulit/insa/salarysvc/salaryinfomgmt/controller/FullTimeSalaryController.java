package kr.co.seoulit.insa.salarysvc.salaryinfomgmt.controller;

import java.util.ArrayList;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.service.SalaryInfoMgmtService;
import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.to.FullTimeSalTO;
import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.to.PayDayTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;


@RequestMapping("/salaryinfomgmt/*")
@RestController
@RequiredArgsConstructor
public class FullTimeSalaryController {

   //✅생성자 주입 방식 변경 후_23.08.07.ha
   private final SalaryInfoMgmtService salaryInfoMgmtService;
   private final DatasetBeanMapper datasetBeanMapper;
   
   @GetMapping("salary")
   public void AllMoneyList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
      
      String applyYearMonth = reqData.getVariable("date").toString();
      
      ArrayList<FullTimeSalTO> AllMoneyList = salaryInfoMgmtService.findAllMoney(applyYearMonth);
      
      datasetBeanMapper.beansToDataset(resData, AllMoneyList, FullTimeSalTO.class);
   }
   

   //📌급여조회 요청 시 전달되는 URL
   @PostMapping("/salary/empcode")
   public void selectSalary(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {      

      // 넥사크로 데이터 자바 단에 그대로 넘기면
      // 오류가 나기 때문에 그걸 방지하기 위해서 문자열로 날짜 데이터 저장
      String applyYearMonth = reqData.getVariable("apply_year_month").getString();
      String empCode = reqData.getVariable("empCode").getString();

      System.out.println("applyYearMonth = " + applyYearMonth);
      System.out.println("empCode = " + empCode);            

      //해당 기간과 사원 코드에 해당하는 월급여 정보를 조회
      //그 결과를 fullTimeSalaryList라는 ArrayList에 저장
      ArrayList<FullTimeSalTO> fullTimeSalaryList = salaryInfoMgmtService.findselectSalary(applyYearMonth,empCode);
      //datasetBeanMapper를 사용하여 fullTimeSalaryList에 저장된
      //월급여 정보를 resData 데이터셋으로 변환하여 클라이언트에게 반환
      datasetBeanMapper.beansToDataset(resData, fullTimeSalaryList, FullTimeSalTO.class);
   }

   @PostMapping("salary")
   public void modifyFullTimeSalary(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
      
      ArrayList<FullTimeSalTO> fullTimeSalary
      = (ArrayList<FullTimeSalTO>)datasetBeanMapper.datasetToBeans(reqData, FullTimeSalTO.class);

      salaryInfoMgmtService.modifyFullTimeSalary(fullTimeSalary);
      }
   
   public void paydayList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception  {
      
      ArrayList<PayDayTO> list = salaryInfoMgmtService.findPayDayList();
      
      datasetBeanMapper.beansToDataset(resData, list, PayDayTO.class);
   }
   
   
}
