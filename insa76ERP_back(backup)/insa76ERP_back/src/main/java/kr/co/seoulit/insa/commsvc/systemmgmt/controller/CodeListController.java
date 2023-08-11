package kr.co.seoulit.insa.commsvc.systemmgmt.controller;

import java.util.ArrayList;

import io.swagger.v3.oas.annotations.Operation;
import kr.co.seoulit.insa.attdsvc.attdmgmt.service.AttdMgmtService;
import kr.co.seoulit.insa.attdsvc.attdmgmt.to.DeptListTO;
import kr.co.seoulit.insa.attdsvc.attdmgmt.to.EmpListTO;
import kr.co.seoulit.insa.commsvc.systemmgmt.dto.DetailCodeDTO;
import kr.co.seoulit.insa.commsvc.systemmgmt.entity.DetailCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.commsvc.systemmgmt.service.SystemMgmtService;
import kr.co.seoulit.insa.commsvc.systemmgmt.to.CodeTO;
import kr.co.seoulit.insa.commsvc.systemmgmt.to.DetailCodeTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;


@RequestMapping("/systemmgmt/*")
@RestController
public class CodeListController {

	@Autowired
	private SystemMgmtService systemMgmtService;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	@Autowired
	private AttdMgmtService attdMgmtService;

	ModelMap map = null;

	@RequestMapping("/systemmgmt/codelist") //   /systemmgmt/systemmgmt/codelist
	@Operation(summary = "모달", description = "모달창에서 나타날 item들을 가져오는 api 입니다")
	public ArrayList<DetailCodeTO> detailCodelist(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception{
		System.out.println("=============사원등록(부서검색) 모달창 오픈 컨트롤러 실행==============");
		long start1 = System.currentTimeMillis();
		System.out.println("reqData ====== " + reqData + "resData=======" + resData);
		System.out.println(reqData.getVariable("code"));
		System.out.println(reqData.getVariable("code").getString());

		String code = null;
		if(reqData.getVariable("code") != null)
			code = reqData.getVariable("code").getString();

		System.out.println("code = " + code);

		ArrayList<DetailCodeDTO> detailCodeList = systemMgmtService.findDetailCodeList(code);

		datasetBeanMapper.beansToDataset(resData, detailCodeList, DetailCodeDTO.class);

		System.out.println("detailCodeList ================ " + detailCodeList);
		long end1 = System.currentTimeMillis();
		System.out.println("걸린 시간" + (end1 - start1));
		System.out.println("=============사원등록(부서검색)  모달창 오픈 컨트롤러 종료==============");

		return null;
	}

	@RequestMapping("/deptlist")
	public void deptlist(@RequestAttribute("reqData") PlatformData reqData,
										@RequestAttribute("resData") PlatformData resData) throws Exception{
		System.out.println("=============사원조회(부서검색)  모달창 오픈 컨트롤러 실행==============");


		ArrayList<DeptListTO> deptList = attdMgmtService.findDeptList();

		datasetBeanMapper.beansToDataset(resData, deptList, DeptListTO.class);

		System.out.println("=============사원조회(부서검색) 모달창 오픈 컨트롤러 종료==============");

	}

	@RequestMapping("/emplist")
	public void emplist(@RequestAttribute("reqData") PlatformData reqData,
						@RequestAttribute("resData") PlatformData resData) throws Exception{
		System.out.println("=============사원조회(사원검색) 모달창 오픈 컨트롤러 실행==============");


		System.out.println("===reqData ====== " + reqData + "===resData=======" + resData);
		System.out.println(reqData.getVariable("deptName"));
		System.out.println(reqData.getVariable("deptName").getString());

		String deptName = null;
		if(reqData.getVariable("deptName") != null)
			deptName = reqData.getVariable("deptName").getString();

		ArrayList<EmpListTO> empList = attdMgmtService.findEmpList(deptName);

		datasetBeanMapper.beansToDataset(resData, empList, EmpListTO.class);

		System.out.println("=============사원조회(사원검색) 모달창 오픈 컨트롤러 종료==============");

	}



	@RequestMapping("code/rest")
	public ModelMap detailCodelistRest(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception {

		System.out.println("☆★☆★detailCodeList컨트롤러진입☆★☆★");

		String code1 = reqData.getVariable("code1").getString();
		String code2 = reqData.getVariable("code2").getString();
		String code3 = reqData.getVariable("code3").getString();

		ArrayList<DetailCodeTO> detailCodeList = systemMgmtService.findDetailCodeListRest(code1, code2, code3);

		datasetBeanMapper.beansToDataset(resData, detailCodeList, DetailCodeTO.class);

		return null;
	}

	
	@RequestMapping("codelist/all")
	public ModelMap codelist(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception {

		ArrayList<CodeTO> codeList = systemMgmtService.findCodeList();

		datasetBeanMapper.beansToDataset(resData, codeList, CodeTO.class);

		return null;
	}
}