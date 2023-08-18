package kr.co.seoulit.insa.commsvc.foudinfomgmt.controller;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.commsvc.foudinfomgmt.service.FoudInfoMgmtService;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.PositionTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;


@RequestMapping("/foudinfomgmt/*")
@RestController
public class PositionListController {
	
	@Autowired
	private FoudInfoMgmtService foudInfoMgmtService;	
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	

	
	@GetMapping("positionlist")
	public ModelMap findPositionList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{

			ArrayList<PositionTO> positionList = foudInfoMgmtService.findPositionList();
			datasetBeanMapper.beansToDataset(resData, positionList, PositionTO.class); 
			
			return null;
	}
	
	@RequestMapping("positionlist2")
	public ModelMap modifyPosition(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{		
		
			ArrayList<PositionTO> positionList = (ArrayList<PositionTO>)datasetBeanMapper.datasetToBeans(reqData,PositionTO.class);
			foudInfoMgmtService.modifyPosition(positionList);
		
		return null;
	}	

}
