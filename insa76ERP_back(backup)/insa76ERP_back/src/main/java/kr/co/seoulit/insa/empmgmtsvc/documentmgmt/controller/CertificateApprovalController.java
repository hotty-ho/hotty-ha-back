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
public class CertificateApprovalController {

	@Autowired
	private DocumentMgmtService documentMgmtService;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	@RequestMapping("/documentmgmt/certificate-approval")
	public ModelMap findCertificateListByDept(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{

		String deptName = reqData.getVariable("deptName").getString();
		String startDate = reqData.getVariable("startDate").getString();
		String endDate = reqData.getVariable("endDate").getString();

		ArrayList<CertificateTO> certificateList = documentMgmtService.findCertificateListByDept(deptName, startDate, endDate);
		datasetBeanMapper.beansToDataset(resData, certificateList, CertificateTO.class);
		return null;
	}

	@RequestMapping("/documentmgmt/certificate-confirmation")
	public ModelMap modifyCertificateList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{

		ArrayList<CertificateTO> certificateList=(ArrayList<CertificateTO>) datasetBeanMapper.datasetToBeans(reqData,CertificateTO.class);

		documentMgmtService.modifyCertificateList(certificateList);
		System.out.println("재직증명서 확정 = " + certificateList);

		return null;
	}

}
