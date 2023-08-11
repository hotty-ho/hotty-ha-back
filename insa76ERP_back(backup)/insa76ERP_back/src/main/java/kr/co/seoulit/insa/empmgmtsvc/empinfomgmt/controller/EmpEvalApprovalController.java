package kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.service.EmpInfoService;
import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpEvalTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;

import javax.servlet.http.HttpServletRequest;


@RequestMapping("/empinfomgmt/*")
@RestController
public class EmpEvalApprovalController {

	@Autowired
	private EmpInfoService empInfoService;

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	@PostMapping("/evaluation-approval")
	public ModelMap findEmpEvalAppoList(@RequestAttribute("reqData") PlatformData reqData,
										@RequestAttribute("resData") PlatformData resData) throws Exception{
		String dept = reqData.getVariable("deptName").getString();
		String year = reqData.getVariable("year").getString();
		System.out.println(dept+"@@@@@@@@@@@@@@");
		System.out.println(year+"############");

		ArrayList<EmpEvalTO> empEvalList = empInfoService.findEmpEval(dept,year);
		datasetBeanMapper.beansToDataset(resData, empEvalList, EmpEvalTO.class);


		return null;
	}

	@PostMapping("/evaluation-approval2")
	public ModelMap modifyEmpEvalList(@RequestAttribute("reqData") PlatformData reqData,
									@RequestAttribute("resData") PlatformData resData) throws Exception{

		ArrayList<EmpEvalTO> empevalList = (ArrayList<EmpEvalTO>)datasetBeanMapper.datasetToBeans(reqData, EmpEvalTO.class);
		empInfoService.modifyEmpEvalList(empevalList);

		return null;
	}
}
