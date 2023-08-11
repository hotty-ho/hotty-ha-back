package kr.co.seoulit.insa.newempsvc.documentmgmt.service;

import kr.co.seoulit.insa.newempsvc.documentmgmt.to.ConditionTO;
import kr.co.seoulit.insa.newempsvc.documentmgmt.to.RecruitmentTO;
import kr.co.seoulit.insa.newempsvc.documentmgmt.to.SuccessEmpTO;

import java.util.ArrayList;


public interface NDocumentMgmtService {

	public void registCondition(ConditionTO condition);

	public ArrayList<ConditionTO> FindAllTermlist(String workplaceCode);

	public void removeTerms(ConditionTO conditionTO);
	//신규채용 대상자 조회
	ArrayList<RecruitmentTO> FindNewemprecruitTh(int year, String half);

	//신규채용 update
	void modifyCertificateListRec(ArrayList<RecruitmentTO> certificateList);

	//합격자 조회
	ArrayList<SuccessEmpTO> findNewEmpSuccess(int year, String half);

}
