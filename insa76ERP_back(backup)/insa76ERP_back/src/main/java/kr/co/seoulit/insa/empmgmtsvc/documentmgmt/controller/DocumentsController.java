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
import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.to.DocumentsTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;

@RequestMapping("/documentmgmt/*")
@RestController
public class DocumentsController {

    @Autowired
    private DocumentMgmtService documentMgmtService;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    ModelMap map = null;

    //documents 추가
    @RequestMapping("/documentmgmt/documents")
    public ModelMap documentsRequest(@RequestAttribute("reqData") PlatformData reqData,
                                     @RequestAttribute("resData") PlatformData resData) throws Exception{

        DocumentsTO documents= datasetBeanMapper.datasetToBean(reqData, DocumentsTO.class);

        documentMgmtService.documentsRequest(documents);

        return null;
    }

    // documents 조회
    @RequestMapping("/documentmgmt/documents-inquiry")
    public ModelMap documentsLookupList(@RequestAttribute("reqData") PlatformData reqData,
                                        @RequestAttribute("resData") PlatformData resData) throws Exception {

        String empCode = reqData.getVariable("empCode").getString();
        String startDate = reqData.getVariable("startDate").getString();
        String endDate = reqData.getVariable("endDate").getString();
        String code = reqData.getVariable("code").getString();

        ArrayList<DocumentsTO> documents = documentMgmtService.documentsLookupList(empCode, code, startDate, endDate);

        datasetBeanMapper.beansToDataset(resData, documents, DocumentsTO.class);

        return null;

    }

    @RequestMapping("/documentmgmt/document-elimination")
    public ModelMap removeDocumentList(@RequestAttribute("reqData") PlatformData reqData,
                                        @RequestAttribute("resData") PlatformData resData) throws Exception{

        ArrayList<DocumentsTO> documentsList = (ArrayList<DocumentsTO>)datasetBeanMapper.datasetToBeans(reqData, DocumentsTO.class);

        documentMgmtService.removeDocumentList(documentsList);

        return null;
    }


}
