package kr.co.seoulit.insa.attdsvc.attdmgmt.controller;

import java.util.ArrayList;

import kr.co.seoulit.insa.attdsvc.attdmgmt.entity.RestAttd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.attdsvc.attdmgmt.service.AttdMgmtService;
import kr.co.seoulit.insa.attdsvc.attdmgmt.to.RestAttdTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;

@RestController
public class ExcusedAttendanceController {
	
	@Autowired
	private AttdMgmtService attdMgmtService;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	@RequestMapping("/attdmgmt/excused-attnd-create") // 근태신청
	public void registRestAttd(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{
		System.out.println("========== 근태신청 컨드롤러 시작===========");

		RestAttdTO restAttd = datasetBeanMapper.datasetToBean(reqData, RestAttdTO.class);

		attdMgmtService.registRestAttd(restAttd);

		System.out.println("========== 근태신청 컨드롤러 끝===========");
	}

	// 75기 새롬 만든것 JPA 사용
	@RequestMapping("/attdmgmt/excused-attnd-create-jpa")
	public void registRestAttd2(@RequestAttribute("reqData") PlatformData reqData,
							   @RequestAttribute("resData") PlatformData resData) throws Exception{
		System.out.println("========== 근태신청 컨드롤러 시작===========");

		RestAttd restAttd = datasetBeanMapper.datasetToBean(reqData, RestAttd.class);
		System.out.println("restAttd ============= " + restAttd);
		attdMgmtService.registRestAttdjpa(restAttd);

		System.out.println("========== 근태신청 컨드롤러 끝===========");
	}

	
	@RequestMapping("/attdmgmt/excused-attnd2") // 근태조회
	public void findRestAttdList(@RequestAttribute("reqData") PlatformData reqData,
									@RequestAttribute("resData") PlatformData resData) throws Exception{
		 
		String empCode = reqData.getVariable("empCode").getString();
		String startDate = reqData.getVariable("startDate").getString();
		String endDate = reqData.getVariable("endDate").getString();
		String code = reqData.getVariable("code").getString();
		ArrayList<RestAttdTO> restAttdList = attdMgmtService.findRestAttdList(empCode, startDate, endDate, code); // 테이블 분리 해놔야 될 거 같은데 존나 병신같음 이거
		datasetBeanMapper.beansToDataset(resData, restAttdList, RestAttdTO.class);

	}

	@RequestMapping("/attdmgmt/excused-attnd-elimination")
	public void removeRestAttdList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{

		System.out.println("========== 연차삭제 컨드롤러 끝===========");
		System.out.println("reqData ============== " + reqData);

		ArrayList<RestAttdTO> restAttdList = (ArrayList<RestAttdTO>)datasetBeanMapper.datasetToBeans(reqData, RestAttdTO.class);

		System.out.println("restAttdList ================ " + restAttdList);
		attdMgmtService.removeRestAttdList(restAttdList);

		System.out.println("========== 연차삭제 컨드롤러 끝===========");
	}
}