package kr.co.seoulit.insa.empmgmtsvc.documentmgmt.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.service.DocumentMgmtService;
import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.to.proofTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;


@RequestMapping("/documentmgmt/*")
@RestController
public class ReceiptProofController {

	@Autowired
	private DocumentMgmtService documentMgmtService;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	ModelMap map = null;

	@RequestMapping("/documentmgmt/receipt-proof")
	public ModelMap proofRequest(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{

		proofTO proof= datasetBeanMapper.datasetToBean(reqData, proofTO.class);

		documentMgmtService.proofRequest(proof);

		return null;
	}


	@RequestMapping("/documentmgmt/receipt-proof-inquiry")
	public ModelMap proofLookupList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{

		String empCode = reqData.getVariable("empCode").getString();
		String startDate = reqData.getVariable("startDate").getString();
		String endDate = reqData.getVariable("endDate").getString();
		String code = reqData.getVariable("code").getString();

		ArrayList<proofTO> proof = documentMgmtService.proofLookupList(empCode,code,startDate, endDate);

		datasetBeanMapper.beansToDataset(resData, proof, proofTO.class);

		return null;
	}

	@RequestMapping("/documentmgmt/receipt-proof-elimination")
	public ModelMap removeProofAttdList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{

		ArrayList<proofTO> proofList = (ArrayList<proofTO>)datasetBeanMapper.datasetToBeans(reqData, proofTO.class);

		documentMgmtService.removeProofRequest(proofList);

		return null;
	}

}
