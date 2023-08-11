package kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.controller;

import java.util.ArrayList;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.service.SalaryStdInfoMgmtService;
import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.to.SocialInsTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;

@RequestMapping("/salarystdinfomgmt/*")
@RestController
@RequiredArgsConstructor
public class SocialInsController {

	//✅생성자 주입 방식 변경 후_23.08.07.ha
	private SalaryStdInfoMgmtService salaryStdInfoMgmtService;
	private DatasetBeanMapper datasetBeanMapper;
	ModelMap map = null;
	
	@RequestMapping("social1")
	public void findBaseInsureList(@RequestAttribute("reqData") PlatformData reqData,
			  					@RequestAttribute("resData") PlatformData resData) throws Exception{	
		    
			String year = reqData.getVariable("year").getString();
			ArrayList<SocialInsTO> baseInsureList = salaryStdInfoMgmtService.findBaseInsureList(year);
			datasetBeanMapper.beansToDataset(resData, baseInsureList, SocialInsTO.class);
			SocialInsTO emptyBean = new SocialInsTO();
			emptyBean.setStatus("insert");                     

	}
	
	
	@RequestMapping("social2")
	public void updateInsureData(@RequestAttribute("reqData") PlatformData reqData,
							@RequestAttribute("resData") PlatformData resData) throws Exception{	
		
			ArrayList<SocialInsTO> baseInsureList = (ArrayList<SocialInsTO>)datasetBeanMapper.datasetToBeans(reqData, SocialInsTO.class);
			salaryStdInfoMgmtService.updateInsureData(baseInsureList);
	}
	
	
	@RequestMapping("social3")
	public void deleteInsureData(@RequestAttribute("reqData") PlatformData reqData,
								@RequestAttribute("resData") PlatformData resData) throws Exception{	
		
			String year = reqData.getVariable("year").getString();
			salaryStdInfoMgmtService.deleteInsureData(year);

	}
	
	
}