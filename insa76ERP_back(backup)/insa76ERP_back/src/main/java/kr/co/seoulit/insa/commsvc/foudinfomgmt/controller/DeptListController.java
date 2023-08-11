package kr.co.seoulit.insa.commsvc.foudinfomgmt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.commsvc.foudinfomgmt.service.FoudInfoMgmtService;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.DeptTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;

@RestController
public class DeptListController {

	@Autowired
	private FoudInfoMgmtService foudInfoMgmtService;
	@Autowired
	DatasetBeanMapper datasetBeanMapper;

	@RequestMapping("/foudinfomgmt/deptList-create")
	public ModelMap batchDeptProcess(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{

		ArrayList<DeptTO> deptTO = (ArrayList<DeptTO>)datasetBeanMapper.datasetToBeans(reqData, DeptTO.class);

		foudInfoMgmtService.batchDeptProcess(deptTO);

		return null;
	}


	@RequestMapping("/foudinfomgmt/deptlist")
	public ModelMap findDeptList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{

		List<DeptTO> list = foudInfoMgmtService.findDeptList();

		datasetBeanMapper.beansToDataset(resData, list, DeptTO.class);

		return null;
	}
}
