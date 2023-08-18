package kr.co.seoulit.insa.empmgmtsvc.documentmgmt.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.service.DocumentMgmtService;
import kr.co.seoulit.insa.empmgmtsvc.documentmgmt.to.DocumentsTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;


@RequestMapping("/documentmgmt/*")
@RestController
public class DocumentsApprovalController {

    @Autowired
    private DocumentMgmtService documentMgmtService;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;


//    날짜로 document 전체조회
    @RequestMapping("/documentmgmt/documentsList-inquiry")
    public ModelMap documentsLookupList(@RequestAttribute("reqData") PlatformData reqData,
                                        @RequestAttribute("resData") PlatformData resData) throws Exception {

        String empCode = reqData.getVariable("empCode").getString();
        String startDate = reqData.getVariable("startDate").getString();
        String endDate = reqData.getVariable("endDate").getString();

        ArrayList<DocumentsTO> documents = documentMgmtService.documentsListInquiry(empCode, startDate, endDate);

        datasetBeanMapper.beansToDataset(resData, documents, DocumentsTO.class);

        return null;

    }

    //승인상태 확정
    @RequestMapping("/documentmgmt/document-approval")
    public ModelMap modifyProofList(@RequestAttribute("reqData") PlatformData reqData,
                                    @RequestAttribute("resData") PlatformData resData) throws Exception{

        ArrayList<DocumentsTO> documentsList = (ArrayList<DocumentsTO>)datasetBeanMapper.datasetToBeans(reqData, DocumentsTO.class);

        documentMgmtService.modifyDocumentList(documentsList);

        return null;
    }

}
