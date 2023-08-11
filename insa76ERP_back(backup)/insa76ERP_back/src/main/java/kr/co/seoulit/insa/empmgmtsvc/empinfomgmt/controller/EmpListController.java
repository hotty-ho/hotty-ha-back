package kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.service.EmpInfoService;
import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;


@RequestMapping("/empinfomgmt/*")
@RestController
public class EmpListController {
	
	@Autowired
	private EmpInfoService empInfoService;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	@RequestMapping("/emplist")
	public void emplist(@RequestAttribute("resData") PlatformData resData,
						@RequestAttribute("reqData") PlatformData reqData) throws Exception {
		
			String value = reqData.getVariable("value").getString();
			System.out.println(value);
			ArrayList<EmpTO> list = empInfoService.findEmpList(value);
			System.out.println("list");
			
			datasetBeanMapper.beansToDataset(resData, list, EmpTO.class);
			
	}	
	
}