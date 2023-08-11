package kr.co.seoulit.insa.attdsvc.attdappvl.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.attdsvc.attdappvl.service.AttdAppvlService;
import kr.co.seoulit.insa.attdsvc.attdappvl.to.DayAttdMgtTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;

@RestController
@RequestMapping("/attdappvl/*")
public class DailyAttendanceMgtController {
	
	@Autowired
	private AttdAppvlService attdAppvlService;
	@Autowired
	DatasetBeanMapper datasetBeanMapper;
	
	ModelMap map = null;
	
	@RequestMapping("/attdappvl/day-attnd")
	public ModelMap findDayAttdMgtList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception{
		
		String applyDay = reqData.getVariable("applyDay").getString();
		String workplaceCode = reqData.getVariable("workplaceCode").getString();
		ArrayList<DayAttdMgtTO> dayAttdMgtList = attdAppvlService.findDayAttdMgtList(applyDay, workplaceCode);
		System.out.println("dayAttdMgtList ============================ " + dayAttdMgtList);
		datasetBeanMapper.beansToDataset(resData, dayAttdMgtList, DayAttdMgtTO.class);
		
		return null;
	}

	@RequestMapping("/attdappvl/day-attndPut")
	public ModelMap modifyDayAttdList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception{
		
		ArrayList<DayAttdMgtTO> dayAttdMgtList = (ArrayList<DayAttdMgtTO>)datasetBeanMapper.datasetToBeans(reqData, DayAttdMgtTO.class);
		
		attdAppvlService.modifyDayAttdMgtList(dayAttdMgtList);
		
		return null;
	}	

	// 일근태 단순 조회
	@RequestMapping("/daySearch")
	public ModelMap findAttdList(@RequestAttribute PlatformData reqData,
								 @RequestAttribute PlatformData resData) throws Exception{

		String applyDay = reqData.getVariable("applyDay").getString();

		ArrayList<DayAttdMgtTO> dayAttdList = attdAppvlService.findAttdList(applyDay);

		datasetBeanMapper.beansToDataset(resData, dayAttdList, DayAttdMgtTO.class);
		return null;
	}

	//일근태 저장
	@RequestMapping("/saveAttd")
	public ModelMap saveAttd(@RequestAttribute PlatformData reqData,
							 @RequestAttribute PlatformData resData) throws Exception {

		ArrayList<DayAttdMgtTO> dayAttdList = (ArrayList<DayAttdMgtTO>)datasetBeanMapper.datasetToBeans(reqData, DayAttdMgtTO.class);

		attdAppvlService.saveAttd(dayAttdList);

		return null;
	}
}
