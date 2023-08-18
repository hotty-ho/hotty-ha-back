package kr.co.seoulit.insa.empmgmtsvc.documentmgmt.service;


import java.util.ArrayList;

import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.to.CertificateTO;
import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.to.proofTO;
import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.to.DocumentsTO;


public interface DocumentMgmtService {

	public void registRequest(CertificateTO certificate);
	public ArrayList<CertificateTO> findCertificateList(String empCode, String startDate, String endDate);
	public void removeCertificateRequest(ArrayList<CertificateTO> certificateList);
	public ArrayList<CertificateTO> findCertificateListByDept(String deptName, String startDate, String endDate);
	public void modifyCertificateList(ArrayList<CertificateTO> certificateList);
	public void proofRequest(proofTO proof);
	public ArrayList<proofTO> proofLookupList(String empCode, String Code,String startDate, String endDate);
	public void removeProofRequest(ArrayList<proofTO> proofList);
	public ArrayList<proofTO> findProofListByDept(String deptName, String startDate, String endDate);
	public void modifyProofList(ArrayList<proofTO> proofList);
	public void rsgistProofImg(String cashCode,String proofImg);


	void documentsRequest(DocumentsTO proof);
	ArrayList<DocumentsTO> documentsLookupList(String empCode, String code, String startDate, String endDate);
	public void removeDocumentList(ArrayList<DocumentsTO> proofList);

	//날짜로전체조회
	ArrayList<DocumentsTO> documentsListInquiry(String empCode, String startDate, String endDate);
	public void modifyDocumentList(ArrayList<DocumentsTO> proofList);


}
