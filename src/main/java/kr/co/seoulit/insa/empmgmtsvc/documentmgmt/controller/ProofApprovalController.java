package kr.co.seoulit.insa.empmgmtsvc.documentmgmt.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.service.DocumentMgmtService;
import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.to.proofTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;


@RequestMapping("/documentmgmt/*")
@RestController
public class ProofApprovalController {

	@Autowired
	private DocumentMgmtService documentMgmtService;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	@RequestMapping("/documentmgmt/proof-approval")
	public ModelMap modifyProofList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{

		ArrayList<proofTO> proofList = (ArrayList<proofTO>)datasetBeanMapper.datasetToBeans(reqData, proofTO.class);

		documentMgmtService.modifyProofList(proofList);

		return null;
	}
}
