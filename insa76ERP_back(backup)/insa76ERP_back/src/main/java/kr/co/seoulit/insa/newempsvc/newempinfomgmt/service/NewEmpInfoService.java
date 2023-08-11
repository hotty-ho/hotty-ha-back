package kr.co.seoulit.insa.newempsvc.newempinfomgmt.service;

import kr.co.seoulit.insa.newempsvc.newempinfomgmt.to.ApplicantTO;
import kr.co.seoulit.insa.newempsvc.newempinfomgmt.to.NewResumeTO;
import kr.co.seoulit.insa.newempsvc.newempinfomgmt.to.PersonalityInterviewTO;

import java.util.ArrayList;
import java.util.HashMap;

public interface NewEmpInfoService {
	
	public ArrayList<NewResumeTO> findresumeList(int year, String half,String workplaceCode);
	
	public ArrayList<PersonalityInterviewTO> findPInewempList(HashMap<String, Object> map);

	public ArrayList<ApplicantTO> FindAllSuccessApplicant(int year, String half,String workplaceCode);

	public void updateresumeNewemp(NewResumeTO nemp);

	public String produceNewcode(int year, int half);

	public void insertResumeAndPI(NewResumeTO resume, PersonalityInterviewTO pi);

	public void insertResume(NewResumeTO resume);
}
