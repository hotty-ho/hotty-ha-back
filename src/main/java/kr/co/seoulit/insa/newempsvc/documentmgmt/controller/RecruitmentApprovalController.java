package kr.co.seoulit.insa.newempsvc.documentmgmt.controller;

import com.nexacro17.xapi.data.PlatformData;
import kr.co.seoulit.insa.newempsvc.documentmgmt.service.NDocumentMgmtService;
import kr.co.seoulit.insa.newempsvc.documentmgmt.to.RecruitmentTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequestMapping("/documentmgmt")
@RestController
public class RecruitmentApprovalController
{

	@Autowired
	private NDocumentMgmtService documentMgmtService;

	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	ModelMap map = null;
//조회
	@RequestMapping("/newemprecruit")
	public void findApplicant(@RequestAttribute("resData") PlatformData resData,
							  @RequestAttribute("reqData") PlatformData reqData) throws Exception {

		int year = reqData.getVariable("year").getInt();
		String half = reqData.getVariable("half").getString();
		//String workplaceCode = reqData.getVariable("value").getString();
		System.out.println(year + half);
		ArrayList<RecruitmentTO> list = documentMgmtService.FindNewemprecruitTh(year, half);
		System.out.println(list);

		for ( RecruitmentTO to : list ) {
			if ( to.getApprovalStatus().equals("W") )
				to.setApprovalStatus("대기");
			else if ( to.getApprovalStatus().equals("Y") )
				to.setApprovalStatus("승인");
			else if ( to.getApprovalStatus().equals("R") )
				to.setApprovalStatus("반려");
			else to.setApprovalStatus("승인취소");
		}
			datasetBeanMapper.beansToDataset(resData, list, RecruitmentTO.class);
	}
//확정
	@RequestMapping("/certificateConfirmation")
	public ModelMap modifyCertificateList(@RequestAttribute("reqData") PlatformData reqData,
										  @RequestAttribute("resData") PlatformData resData) throws Exception{
		ArrayList<RecruitmentTO> certificateListRec=(ArrayList<RecruitmentTO>) datasetBeanMapper.datasetToBeans(reqData,RecruitmentTO.class);

		for(RecruitmentTO to : certificateListRec) {
			if ( to.getApprovalStatus().equals("대기") )
				to.setApprovalStatus("W");
			else if ( to.getApprovalStatus().equals("승인") )
				to.setApprovalStatus("Y");
			else if ( to.getApprovalStatus().equals("반려") )
				to.setApprovalStatus("R");
			else
				to.setApprovalStatus("N");
		}
		documentMgmtService.modifyCertificateListRec(certificateListRec);
		return null;
	}
}
