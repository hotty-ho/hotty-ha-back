package kr.co.seoulit.insa.commsvc.systemmgmt.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.commsvc.systemmgmt.service.SystemMgmtService;
import kr.co.seoulit.insa.commsvc.systemmgmt.to.AdminCodeTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;


@RequestMapping("/systemmgmt/*")
@RestController
public class AuthCodeMgtController {
	
	@Autowired
	private SystemMgmtService systemMgmtService;	
	
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	ModelMap map = null;
	
	public ModelMap	adminCodeList(HttpServletRequest request, HttpServletResponse response) {

		map = new ModelMap();
		
		try {
			ArrayList<AdminCodeTO> authCodeList = (ArrayList<AdminCodeTO>) systemMgmtService.adminCodeList();
			map.put("authCodeList", authCodeList);

		} catch (Exception e) {
			map.put("errorCode", -1);
			map.put("errorMsg", e.getMessage());
		}
		return map;
	}
	
	@RequestMapping("modifyauthcode")
	public ModelAndView modifyAuthority(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{		
		map = new ModelMap();		
		String empCode = reqData.getVariable("empCode").getString();
		String adminCode = reqData.getVariable("adminCode").getString();
		
			
				systemMgmtService.modifyAuthority(empCode , adminCode);
				
		
		return null;
	}
	
	
	@PostMapping("authcode")
	public ModelMap authadminCodeList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{		

		
		String empCode = reqData.getVariable("empCode").getString();
		
			ArrayList<AdminCodeTO> authadminCodeList = (ArrayList<AdminCodeTO>) systemMgmtService.authadminCodeList(empCode);
			datasetBeanMapper.beansToDataset(resData, authadminCodeList, AdminCodeTO.class);

		
		return null;
	}
	
	
}
