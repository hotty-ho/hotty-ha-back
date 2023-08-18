package kr.co.seoulit.insa.empmgmtsvc.documentmgmt.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.service.DocumentMgmtService;
import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.to.CertificateTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;

@RestController
public class CertificateController {
	
	@Autowired
	private DocumentMgmtService documentMgmtService;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	ModelMap map = null;

	@RequestMapping("/documentmgmt/certificate")
	public ModelMap registRequest(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception{
		CertificateTO certificate = datasetBeanMapper.datasetToBean(reqData, CertificateTO.class);
		documentMgmtService.registRequest(certificate);
		
		return null;
	}
	
	@RequestMapping("/documentmgmt/certificatecheck")
	public ModelMap findCertificateList(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception{
		
		String empCode = reqData.getVariable("empCode").getString();
		String startDate = reqData.getVariable("startDate").getString();
		String endDate = reqData.getVariable("endDate").getString();
		
		ArrayList<CertificateTO> certificateList = documentMgmtService.findCertificateList(empCode, startDate, endDate);
		datasetBeanMapper.beansToDataset(resData,certificateList,CertificateTO.class);

		return null;
	}
	
	@RequestMapping("/documentmgmt/applicationcancellation")
	public ModelMap removeCertificateRequest(@RequestAttribute("reqData") PlatformData reqData,
            @RequestAttribute("resData") PlatformData resData) throws Exception {
		
		ArrayList<CertificateTO> certificateList = (ArrayList<CertificateTO>)datasetBeanMapper.datasetToBeans(reqData, CertificateTO.class);
		documentMgmtService.removeCertificateRequest(certificateList);
		
		return null;
	}
}