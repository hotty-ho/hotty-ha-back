package kr.co.seoulit.insa.attdsvc.attdappvl.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.attdsvc.attdappvl.service.AttdAppvlService;
import kr.co.seoulit.insa.attdsvc.attdmgmt.to.RestAttdTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;

@RestController
@RequestMapping("/attdappvl/*")
public class AttendanceApprovalController {

	@Autowired
	private AttdAppvlService attdAppvlService;
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	

	//근태외신청목록조회 
	@RequestMapping("attnd-approval")
	public ModelMap findRestAttdListByDept(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception{

		System.out.println("========<<<<<  근태외신청목록조회 시작  >>>>>>========");
		String startDate = reqData.getVariable("startDate").getString();
		String endDate = reqData.getVariable("endDate").getString();
		String empName = reqData.getVariable("empName").getString();
	

		ArrayList<RestAttdTO> restAttdList = attdAppvlService.findRestAttdListByDept(empName, startDate, endDate);
		System.out.println(restAttdList.toString());
		
		datasetBeanMapper.beansToDataset(resData,restAttdList,RestAttdTO.class);
		System.out.println("========<<<<<  근태외신청목록조회 끝   >>>>>>========");
		return null;
	}

	//근태외신청 확정
	@RequestMapping("attnd-approval2")
	public ModelMap modifyRestAttdList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception {
		
		System.out.println("☆★☆★근태외신청 확정☆★☆★");
		ArrayList<RestAttdTO> restAttdList = (ArrayList<RestAttdTO>) datasetBeanMapper.datasetToBeans(reqData,RestAttdTO.class);
		attdAppvlService.modifyRestAttdList(restAttdList);

		return null;
	}

	//초과근무 관리 리스트 가져오기
	@RequestMapping("/overtimeApploval")
	public ModelMap overtimeFindList (@RequestAttribute("reqData") PlatformData reqData,
									  @RequestAttribute("resData") PlatformData resData) throws Exception{

		String requestDate = reqData.getVariable("requestDate").getString();
		String restTypeCode = reqData.getVariable("restTypeCode").getString();
		System.out.println("requestDate =========== " + requestDate);
		System.out.println("restTypeCode =========== " + restTypeCode);

		ArrayList<RestAttdTO> restAttdList = attdAppvlService.overtimeFindList(requestDate, restTypeCode);

		datasetBeanMapper.beansToDataset(resData,restAttdList,RestAttdTO.class);

		return null;
	}

	@RequestMapping("/overtimeApplovalSave")
	public ModelMap overtimeApplovalSave(@RequestAttribute("reqData") PlatformData reqData,
	@RequestAttribute("resData") PlatformData resData) throws Exception{

		System.out.println("☆★☆★초과근무 관리 시작~~☆★☆★");
		ArrayList<RestAttdTO> restAttdList = (ArrayList<RestAttdTO>) datasetBeanMapper.datasetToBeans(reqData,RestAttdTO.class);
		attdAppvlService.overtimeApplovalSave(restAttdList);

		System.out.println("☆★☆★초과근무 관리 끝~~☆★☆★");
		return null;
	}
}