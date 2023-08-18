package kr.co.seoulit.insa.attdsvc.attdappvl.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.attdsvc.attdappvl.service.AttdAppvlService;
import kr.co.seoulit.insa.attdsvc.attdappvl.to.AnnualLeaveMgtTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;

@RestController
@RequestMapping("/attdappvl/*")
public class AnnualLeaveMgtController {
	
   @Autowired
   private AttdAppvlService attdAppvlService;
   
   @Autowired
   private DatasetBeanMapper datasetBeanMapper;
   ModelMap map = null;
   
   @PostMapping("/annual-leaveMgt")
   public ModelMap findAnnualVacationMgtList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{

      String applyYearMonth = reqData.getVariable("applyYearMonth").getString();
      String workplaceCode = reqData.getVariable("workplaceCode").getString();
    
      ArrayList<AnnualLeaveMgtTO> annualVacationMgtList = attdAppvlService.findAnnualVacationMgtList(applyYearMonth, workplaceCode);
      datasetBeanMapper.beansToDataset(resData, annualVacationMgtList, AnnualLeaveMgtTO.class); 
     
      return null;
   }
   
   
   @RequestMapping("/annual-leaveMgt/1")
   public ModelMap modifyAnnualVacationMgtList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{
	   
     ArrayList<AnnualLeaveMgtTO> annualVacationMgtList = (ArrayList<AnnualLeaveMgtTO>)datasetBeanMapper.datasetToBeans(reqData, AnnualLeaveMgtTO.class);
     attdAppvlService.modifyAnnualVacationMgtList(annualVacationMgtList);
      return null;
   } 
   
   
   @PutMapping("/annual-leaveMgt/2")
   public ModelMap cancelAnnualVacationMgtList(HttpServletRequest request, HttpServletResponse response){
	   map = new ModelMap();
      String sendData = request.getParameter("sendData");
      response.setContentType("application/json; charset=UTF-8");
      try {
         Gson gson = new Gson();
         ArrayList<AnnualLeaveMgtTO> annualVacationMgtList = gson.fromJson(sendData, new TypeToken<ArrayList<AnnualLeaveMgtTO>>(){}.getType());
         attdAppvlService.cancelAnnualVacationMgtList(annualVacationMgtList);
         map.put("errorMsg","success");
         map.put("errorCode", 0);
         
      }catch (Exception dae){
    	  map.clear();
    	  map.put("errorCode", -1);
    	  map.put("errorMsg", dae.getMessage());
      }
      return map;
   } 
   

}