package kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.service.EmpInfoService;
import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpAppointmentInfoTO;
import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpAppointmentTO;
import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpAppointmentTypeTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;


@RequestMapping("/empinfomgmt/*")
@RestController
public class EmpAppointmentController {
	
	@Autowired
	private EmpInfoService empInfoService;
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	@RequestMapping("/appointment")
	public void registAppointment(@RequestAttribute("reqData") PlatformData reqData,
								  @RequestAttribute("resData") PlatformData resData) throws Exception{	
			EmpAppointmentTO emp = datasetBeanMapper.datasetToBean(reqData, EmpAppointmentTO.class);
			EmpAppointmentTypeTO empType = datasetBeanMapper.datasetToBean(reqData, EmpAppointmentTypeTO.class);
			String type = reqData.getVariable("type").getString();
			HashMap<String, Object> map = new HashMap<String, Object>();
			System.out.println(type+"@@@@@@@@@@@@@@@");
			map.put("empCode", emp.getEmpCode());
			map.put("hosu", emp.getHosu());
			map.put("appointNext", empType.getNextDept());
			map.put("sDate", empType.getRetirementDate());
			map.put("tDate", empType.getReinstatementDate());
			map.put("type", type);
			
			empInfoService.registAppoint(map,emp);
	}
	@RequestMapping("/appointment2")
	public void updateAppoint(@RequestAttribute("reqData") PlatformData reqData,
								  @RequestAttribute("resData") PlatformData resData) throws Exception{	
		
			ArrayList<EmpAppointmentTypeTO> type = (ArrayList<EmpAppointmentTypeTO>)datasetBeanMapper.datasetToBeans(reqData, EmpAppointmentTypeTO.class);
			empInfoService.updateAppoint(type);
	}
	@RequestMapping("/appointment3")
	public void generateHosu(@RequestAttribute("reqData") PlatformData reqData,
								  @RequestAttribute("resData") PlatformData resData) throws Exception{	
		

		    EmpAppointmentInfoTO empAppointmentInfoTO = empInfoService.generateHosu();

			datasetBeanMapper.beanToDataset(resData, empAppointmentInfoTO, EmpAppointmentInfoTO.class);
	}

	/*
	 * @RequestMapping("/appointment4") public void
	 * registAppointmentinfo(@RequestAttribute("reqData") PlatformData reqData,
	 * 
	 * @RequestAttribute("resData") PlatformData resData) throws Exception{
	 * 
	 * EmpAppointmentInfoTO empAppointmentInfoTO =
	 * datasetBeanMapper.datasetToBean(reqData, EmpAppointmentInfoTO.class);
	 * ArrayList<EmpAppointmentTO>
	 * empAppointmentlist=(ArrayList<EmpAppointmentTO>)datasetBeanMapper.
	 * datasetToBeans(reqData, EmpAppointmentTO.class);
	 * 
	 * 
	 * empAppointmentInfoTO.setAppointmentDate(empAppointmentInfoTO.
	 * getAppointmentDate().substring(0,8));
	 * 
	 * 
	 * empInfoService.registAppointmentinfo(empAppointmentInfoTO,
	 * empAppointmentlist);
	 * 
	 * }
	 */
	
	@RequestMapping("/appointment4")
	public void registAppointmentinfo(@RequestAttribute("reqData") PlatformData reqData,
								  @RequestAttribute("resData") PlatformData resData) throws Exception{	
		
			EmpAppointmentInfoTO empAppointmentInfoTO = datasetBeanMapper.datasetToBean(reqData, EmpAppointmentInfoTO.class);
			
			System.out.println(empAppointmentInfoTO.getAppointmentDate()+"@@@@@@@@@@@");


			empInfoService.registAppointmentinfo(empAppointmentInfoTO);

	}
	
	@RequestMapping("/appointment5")
	public void findAppointmentinfo(@RequestAttribute("reqData") PlatformData reqData,
								  @RequestAttribute("resData") PlatformData resData) throws Exception{	
		
		String searchType = reqData.getVariable("searchType").getString();
		
		ArrayList<EmpAppointmentInfoTO> empAppointmentInfoTO = empInfoService.findAppointmentinfo(searchType);
		
		datasetBeanMapper.beansToDataset(resData, empAppointmentInfoTO, EmpAppointmentInfoTO.class);
	}
	@RequestMapping("/appointment6")
	public void findAppointmentinfoEmp(@RequestAttribute("reqData") PlatformData reqData,
								@RequestAttribute("resData") PlatformData resData) throws Exception{
		
		String hosu = reqData.getVariable("hosu").getString();
		String type = reqData.getVariable("type").getString();
		System.out.println(hosu+"@@@"+type+"@@@");
		
		ArrayList<EmpAppointmentTypeTO> empAppointmentTypeTO = empInfoService.findAppointmentinfoEmp(hosu,type);
		datasetBeanMapper.beansToDataset(resData, empAppointmentTypeTO, EmpAppointmentTypeTO.class);
	}
	@RequestMapping("/appointment7")
	public void findAppointmentEmp(@RequestAttribute("reqData") PlatformData reqData,
								@RequestAttribute("resData") PlatformData resData) throws Exception{
		
		String empCode = reqData.getVariable("empCode").getString();
		
		ArrayList<EmpAppointmentTypeTO> empAppointmentTypeTO = empInfoService.findAppointmentEmp(empCode);
		datasetBeanMapper.beansToDataset(resData, empAppointmentTypeTO, EmpAppointmentTypeTO.class);
	}
	@RequestMapping("/appointment8")
	public void countAppointmentEmp(@RequestAttribute("reqData") PlatformData reqData,
								@RequestAttribute("resData") PlatformData resData) throws Exception{
		
		String hosu = reqData.getVariable("hosu").getString();
		ArrayList<EmpAppointmentTypeTO> empAppointmentTypeTO = empInfoService.findAllAppointEmp(hosu);
		EmpAppointmentTO empAppointmentTO = empInfoService.countAppointmentEmp(hosu);
		datasetBeanMapper.beansToDataset(resData, empAppointmentTypeTO, EmpAppointmentTypeTO.class);
		datasetBeanMapper.beanToDataset(resData, empAppointmentTO, EmpAppointmentTO.class);
	}
}
