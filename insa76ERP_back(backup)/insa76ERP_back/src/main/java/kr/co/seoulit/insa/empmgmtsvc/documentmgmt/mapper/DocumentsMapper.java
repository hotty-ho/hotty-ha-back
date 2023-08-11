package kr.co.seoulit.insa.empmgmtsvc.documentmgmt.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.to.DocumentsTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DocumentsMapper {

    public void insertDocumentsRequest(DocumentsTO proof);
    ArrayList<DocumentsTO> selectDocumentsList(HashMap<String, String> map);
    public void deleteDocument(DocumentsTO proof);

    //증빙승인관리 조회,저장
    ArrayList<DocumentsTO> selectDocumentsList1(HashMap<String, String> map);
    public void updateDocument(DocumentsTO proof);
}
