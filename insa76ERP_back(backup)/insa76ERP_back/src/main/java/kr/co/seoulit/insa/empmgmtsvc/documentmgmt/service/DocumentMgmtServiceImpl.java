package kr.co.seoulit.insa.empmgmtsvc.documentmgmt.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.mapper.CertificateMapper;
import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.mapper.ProofCertificateMapper;
import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.to.CertificateTO;
import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.to.proofTO;
import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.to.DocumentsTO;
import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.mapper.DocumentsMapper;


@Service
public class DocumentMgmtServiceImpl implements DocumentMgmtService {

	@Autowired
	private CertificateMapper certificateMapper;
	@Autowired
	private ProofCertificateMapper proofCertificateMapper;
	@Autowired
	private  DocumentsMapper documentsMapper;



	@Override
	public void registRequest(CertificateTO certificate) {

		certificateMapper.insertCertificateRequest(certificate);

	}

	@Override
	public ArrayList<CertificateTO> findCertificateList(String empCode, String startDate, String endDate) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("empCode", empCode);
		map.put("startDate", startDate);
		map.put("endDate", endDate);

		ArrayList<CertificateTO> certificateList=null;
		certificateList = certificateMapper.selectCertificateList(map);
		return certificateList;

	}

	@Override
	public void removeCertificateRequest(ArrayList<CertificateTO> certificateList) {

			for (CertificateTO certificate : certificateList) {
				certificateMapper.deleteCertificate(certificate);
			}

	}

	@Override
	public ArrayList<CertificateTO> findCertificateListByDept(String deptName, String startDate, String endDate) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("deptName", deptName);
		map.put("startDate", startDate);
		map.put("endDate", endDate);

		ArrayList<CertificateTO> certificateList = null;
			if (deptName.equals("모든부서")) {
				certificateList = certificateMapper.selectCertificateListByAllDept(startDate);
			} else {
				certificateList = certificateMapper.selectCertificateListByDept(map);
			}
		return certificateList;

	}

	@Override
	public void modifyCertificateList(ArrayList<CertificateTO> certificateList) {

			for (CertificateTO certificate : certificateList) {


				//if (certificate.getStatus().equals("update")) {
					certificateMapper.updateCertificate(certificate);
				//}
			}

	}

	public void proofRequest(proofTO proof) {

		proofCertificateMapper.insertProofCertificateRequest(proof);

	}

	@Override
	public ArrayList<proofTO> proofLookupList(String empCode, String Code, String startDate, String endDate) {
		HashMap<String, String> map = new HashMap<>();
		map.put("empCode", empCode);
		map.put("proofTypeCode", Code);
		map.put("startDate", startDate.substring(0,4)+"/"+startDate.substring(4,6)+"/"+startDate.substring(6,8));
		System.out.println(startDate.substring(0,4)+"/"+startDate.substring(4,6)+"/"+startDate.substring(6,8));
		map.put("endDate", endDate.substring(0,4)+"/"+endDate.substring(4,6)+"/"+endDate.substring(6,8));
		ArrayList<proofTO> proofLookupList=null;

		proofLookupList = proofCertificateMapper.selectProofCertificateList(map);
		return proofLookupList;

	}

	@Override
	public void removeProofRequest(ArrayList<proofTO> proofList) {

			for (proofTO proof : proofList) {
				proofCertificateMapper.deleteProof(proof);
			}

	}

	@Override
	public ArrayList<proofTO> findProofListByDept(String deptName, String startDate, String endDate) {
		HashMap<String, String> map = new HashMap<>();
		map.put("deptName", deptName);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		ArrayList<proofTO> proofList = null;

		if (deptName.equals("모든부서")) {
			proofList = proofCertificateMapper.selectProofListByAllDept(startDate);
		} else {
			proofList = proofCertificateMapper.selectProofListByDept(map);
		}
		return proofList;
	}

	@Override
	public void modifyProofList(ArrayList<proofTO> proofList) {

		for (proofTO proof : proofList) {
				proofCertificateMapper.updateProof(proof);
				System.out.println(proof.getApplovalStatus());
				System.out.println(proof.getEmpCode());
				System.out.println(proof.getApplovalStatus());
				System.out.println(proof.getApplovalStatus());
		}
	}

	public void rsgistProofImg(String cashCode, String proofImg) {
		HashMap<String, String> map = new HashMap<>();
		map.put("cashCode", cashCode);
		map.put("proofImg", proofImg);

		proofCertificateMapper.updateProofImg(map);

	}

	public void documentsRequest(DocumentsTO proof) {

		documentsMapper.insertDocumentsRequest(proof);

	}

	@Override
	public ArrayList<DocumentsTO> documentsLookupList(String empCode, String Code, String startDate, String endDate) {
		HashMap<String, String> map = new HashMap<>();
		map.put("empCode", empCode);
		map.put("proofTypeCode", Code);
		map.put("startDate", startDate.substring(0,4)+"/"+startDate.substring(4,6)+"/"+startDate.substring(6,8));
		System.out.println(startDate.substring(0,4)+"/"+startDate.substring(4,6)+"/"+startDate.substring(6,8));
		map.put("endDate", endDate.substring(0,4)+"/"+endDate.substring(4,6)+"/"+endDate.substring(6,8));
		ArrayList<DocumentsTO> documentsLookupList=null;

		documentsLookupList = documentsMapper.selectDocumentsList(map);
		return documentsLookupList;

	}

	@Override
	public void removeDocumentList(ArrayList<DocumentsTO> proofList) {

		for (DocumentsTO proof : proofList) {
			documentsMapper.deleteDocument(proof);
		}

	}


	@Override
	public ArrayList<DocumentsTO> documentsListInquiry(String empCode, String startDate, String endDate) {
		HashMap<String, String> map = new HashMap<>();
		map.put("empCode", empCode);
		map.put("startDate", startDate.substring(0,4)+"/"+startDate.substring(4,6)+"/"+startDate.substring(6,8));
		System.out.println(startDate.substring(0,4)+"/"+startDate.substring(4,6)+"/"+startDate.substring(6,8));
		map.put("endDate", endDate.substring(0,4)+"/"+endDate.substring(4,6)+"/"+endDate.substring(6,8));
		ArrayList<DocumentsTO> documentsLookupList=null;

		documentsLookupList = documentsMapper.selectDocumentsList1(map);
		return documentsLookupList;

	}

	@Override
	public void modifyDocumentList(ArrayList<DocumentsTO> proofList) {

		for (DocumentsTO proof : proofList) {
			documentsMapper.updateDocument(proof);
			System.out.println(proof.getApplovalStatus());
			System.out.println(proof.getEmpCode());
			System.out.println(proof.getApplovalStatus());
		}
	}

}
