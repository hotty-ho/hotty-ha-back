package kr.co.seoulit.insa.attdsvc.attdappvl.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.attdsvc.attdappvl.service.AttdAppvlService;
import kr.co.seoulit.insa.attdsvc.attdappvl.to.MonthAttdMgtTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;

@RestController
@RequestMapping("/attdappvl/*")
public class MonthlyAttendanceMgtController {
	
	@Autowired
	private AttdAppvlService attdAppvlService;
	@Autowired
	DatasetBeanMapper datasetBeanMapper;
	
	ModelMap map = null;
	
	@RequestMapping("/attdappvl/month-attnd")
	public ModelMap findMonthAttdMgtList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception{
		
		String applyYearMonth = reqData.getVariable("applyYearMonth").getString();
		String workplaceCode = reqData.getVariable("workplaceCode").getString();

		System.out.println("applyYearMonth =============== " + applyYearMonth);
		System.out.println("workplaceCode =============== " + workplaceCode);

		ArrayList<MonthAttdMgtTO> monthAttdMgtList = attdAppvlService.findMonthAttdMgtList(applyYearMonth, workplaceCode);
		
		datasetBeanMapper.beansToDataset(resData, monthAttdMgtList, MonthAttdMgtTO.class);
		return null;
	}

	
	@RequestMapping("/attdappvl/month-attndPut")
	public ModelMap modifyMonthAttdList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception{
		
		ArrayList<MonthAttdMgtTO> monthAttdMgtList = (ArrayList<MonthAttdMgtTO>)datasetBeanMapper.datasetToBeans(reqData, MonthAttdMgtTO.class);

		attdAppvlService.modifyMonthAttdMgtList(monthAttdMgtList);
		
		return null;
	} 

}
