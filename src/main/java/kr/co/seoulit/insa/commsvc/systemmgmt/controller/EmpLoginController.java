package kr.co.seoulit.insa.commsvc.systemmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.commsvc.systemmgmt.service.SystemMgmtService;
import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;


@RestController
public class EmpLoginController {
	
	@Autowired
	private SystemMgmtService systemMgmtService;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	@RequestMapping("/systemmgmt/login")
	public ModelMap empLogin(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{

		System.out.println(" ==========로그인 컨트롤러 시자악==========");

		String empName = reqData.getVariable("empName").getString();
		String empCode = reqData.getVariable("empCode").getString();
		
		EmpTO empto = systemMgmtService.findEmp(empName, empCode);
		datasetBeanMapper.beanToDataset(resData, empto, EmpTO.class);

		System.out.println(" ==========로그인 컨트롤러 끝==========");
		return null;
	}
}
