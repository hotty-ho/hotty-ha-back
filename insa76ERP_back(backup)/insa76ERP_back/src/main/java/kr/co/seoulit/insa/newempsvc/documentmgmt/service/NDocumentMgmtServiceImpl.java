package kr.co.seoulit.insa.newempsvc.documentmgmt.service;

import kr.co.seoulit.insa.attdsvc.attdmgmt.to.DayAttdTO;
import kr.co.seoulit.insa.newempsvc.documentmgmt.mapper.ConditionMapper;
import kr.co.seoulit.insa.newempsvc.documentmgmt.mapper.NewempApprovalMapper;
import kr.co.seoulit.insa.newempsvc.documentmgmt.to.ConditionTO;
import kr.co.seoulit.insa.newempsvc.documentmgmt.to.RecruitmentTO;
import kr.co.seoulit.insa.newempsvc.documentmgmt.to.SuccessEmpTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class NDocumentMgmtServiceImpl implements NDocumentMgmtService {

	@Autowired
	private ConditionMapper conditionMapper;

	@Autowired
	private NewempApprovalMapper approvalMapper;

	@Override
	public void registCondition(ConditionTO condition) {
		conditionMapper.registCondition(condition);
	}


	@Override
	public ArrayList<ConditionTO> FindAllTermlist(String workplaceCode) {

		return conditionMapper.FindAllTermlist(workplaceCode);
	}

	@Override
	public void removeTerms(ConditionTO conditionTO) {

		conditionMapper.deleteTerms(conditionTO);
	}

	// 선발 대상자 조회
	@Override
	public ArrayList<RecruitmentTO> FindNewemprecruitTh(int year, String half) {
		System.out.println("선발대상자 조회");

		ArrayList<RecruitmentTO> list = null;
		System.out.println(list);
		System.out.println(approvalMapper.findnewempcruiTh(year, half));
		list = approvalMapper.findnewempcruiTh(year, half);
		return list;
	}
	// 선발 대상자 승인관리
	@Override
	public void modifyCertificateListRec(ArrayList<RecruitmentTO> certificateList) {
		System.out.println("확정 버튼: 업데이트");
		for (RecruitmentTO certificate : certificateList){
			if(certificate.getStatus().equals("update")){
				approvalMapper.updateCertificateRec(certificate);
			}
		}
	}

	// 합격자조회
	@Override
	public ArrayList<SuccessEmpTO> findNewEmpSuccess(int year, String half) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("year", year);
		map.put("half", half);
		//map.put("workplaceCode", workplaceCode);
		approvalMapper.findNewEmpSuccess(map);
		ArrayList<SuccessEmpTO> list = (ArrayList<SuccessEmpTO>) map.get("result");
		System.out.println(list);
		return list;
	}

}
