package kr.co.seoulit.insa.commsvc.foudinfomgmt.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.commsvc.foudinfomgmt.service.FoudInfoMgmtService;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.HolidayTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;

@RequestMapping("/foudinfomgmt/*")
@RestController
public class HolidayListController {
	
	@Autowired
	private FoudInfoMgmtService foudInfoMgmtService;	
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	ModelMap map = null;

	@GetMapping("holiday")
	public ModelMap findHolidayList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{
		
			ArrayList<HolidayTO> holidayList = foudInfoMgmtService.findHolidayList();
			datasetBeanMapper.beansToDataset(resData, holidayList, HolidayTO.class); 
			
		return null;
	}

	@GetMapping("holidayweek")
	public ModelMap findWeekDayCount(HttpServletRequest request, HttpServletResponse response) {
		map = new ModelMap();
		response.setContentType("application/json; charset=UTF-8");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		try {
			String weekdayCount = foudInfoMgmtService.findWeekDayCount(startDate, endDate);
			map.put("weekdayCount", weekdayCount);
			map.put("errorMsg", "success");
			map.put("errorCode", 0);
			
		} catch (Exception dae) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", dae.getMessage());
		}
		return map;
	}

	@RequestMapping("regitCodeList")
	public ModelMap batchHolidayProcess(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception{		


		ArrayList<HolidayTO> holidayList = (ArrayList<HolidayTO>) datasetBeanMapper.datasetToBeans(reqData, HolidayTO.class);
		
		foudInfoMgmtService.batchHolidayProcess(holidayList);
			
		return null;
	}

}
