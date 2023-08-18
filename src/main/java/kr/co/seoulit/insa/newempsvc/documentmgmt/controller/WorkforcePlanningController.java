package kr.co.seoulit.insa.newempsvc.documentmgmt.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.insa.newempsvc.documentmgmt.service.NDocumentMgmtService;
import kr.co.seoulit.insa.newempsvc.documentmgmt.to.ConditionTO;


@RequestMapping("/documentmgmt/*")
@RestController
public class WorkforcePlanningController {

	@Autowired
	private NDocumentMgmtService documentMgmtService;
	ModelMap map = null;

	@Autowired
	private DatasetBeanMapper datasetBeanMapper; //dataset을 받아 배열로 만듬

	@RequestMapping("/condition")
	public ModelMap registTerm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PlatformData reqData = (PlatformData)request.getAttribute("reqData");
		//PlatformData:데이터 보관하는 기본객체 / getAttribute:특정 요소노드 내 특정 속성값 가져옴
		//request를 reqData로 객체 생성한 것
		ConditionTO condition=datasetBeanMapper.datasetToBean(reqData, ConditionTO.class);
		//받은 dataset을 TO에 맞게 세팅
		documentMgmtService.registCondition(condition);
		return null;
	}

	@RequestMapping("/termslist")
	public ModelMap termList(@RequestAttribute("reqData") PlatformData reqData,
							 @RequestAttribute("resData") PlatformData resData) throws Exception { //request객체의 attribute를 갖고오는 annotation

		String workplaceCode = reqData.getVariable("workplaceCode").getString();
		//DataSet에 저장된 데이터:필요한 데이터 형식에 따른 메소드 이용하여 값 참조(getObject(),getString()) / getVariable:위치(index),식별자(name)에 해당하는 Variable 반환
		//파라미터로 넘어온 값을 string 형식으로 바꾼다
		ArrayList<ConditionTO> termlist = documentMgmtService.FindAllTermlist(workplaceCode);
		datasetBeanMapper.beansToDataset(resData, termlist, ConditionTO.class);
		//DataSet을 url에 보내는 것
		return null;
	}

	@RequestMapping("/deleteterms")
	public void removeTerms(@RequestAttribute("reqData") PlatformData reqData,
						   @RequestAttribute("resData") PlatformData resData) throws Exception {

		String workplaceCode = reqData.getVariable("workplaceCode").getString();
		Integer year = reqData.getVariable("year").getInt();
		String half = reqData.getVariable("half").getString();
		String dept = reqData.getVariable("dept").getString();
		ConditionTO conditionTO =new ConditionTO();
		conditionTO.setWorkplaceCode(workplaceCode);
		conditionTO.setYear(year);
		conditionTO.setHalf(half);
		conditionTO.setDept(dept);
		documentMgmtService.removeTerms(conditionTO);

	}

}