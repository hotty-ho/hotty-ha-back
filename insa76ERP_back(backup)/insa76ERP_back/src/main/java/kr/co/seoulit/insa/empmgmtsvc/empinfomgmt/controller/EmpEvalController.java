package kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.controller;

import java.util.ArrayList;

import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.WorkInfoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.service.EmpInfoService;
import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpEvalTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;


@RequestMapping("/empinfomgmt/*")
@RestController
public class EmpEvalController {

	@Autowired
	private EmpInfoService empInfoService;

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	ModelMap map = null;

	@PostMapping("/registevaluation")
	public ModelMap registEmpEval(@RequestAttribute("reqData") PlatformData reqData,
								  @RequestAttribute("resData") PlatformData resData) throws Exception{

		EmpEvalTO empevalto = datasetBeanMapper.datasetToBean(reqData,EmpEvalTO.class);
		System.out.println("@@@@@@@@@@@실행");
		System.out.println("@@@@@@@@@@@emp" + empevalto);

		String workInfo = reqData.getDataSetList().get(0).getString(0, 26);
		System.out.println("@@@@@@@@@@@workInfo"+ workInfo);
		empInfoService.registEmpEval(empevalto,workInfo);
		System.out.print("registEmpEval실행!!!!!!!!!!!!!!!!!!!!!!!!");


		return null;
	}


	@GetMapping("/evaluation")
	public ModelMap findEmpEval(@RequestAttribute("reqData") PlatformData reqData,
								@RequestAttribute("resData") PlatformData resData) throws Exception{

		ArrayList<EmpEvalTO> empevalList = empInfoService.findEmpEval();
		datasetBeanMapper.beansToDataset(resData, empevalList, EmpEvalTO.class);

		return null;
	}

	@PostMapping("/removalevaluation")
	public ModelMap removeEmpEvalList(@RequestAttribute("reqData") PlatformData reqData,
									  @RequestAttribute("resData") PlatformData resData) throws Exception{

		String emp_code = reqData.getVariable("empCode").getString();
		String apply_day = reqData.getVariable("applyDay").getString();
		System.out.println(apply_day+"@@@@@@@@");
		System.out.println(emp_code+"@@@@@@@");
		empInfoService.removeEmpEvalList(emp_code, apply_day);

		return null;
	}
}