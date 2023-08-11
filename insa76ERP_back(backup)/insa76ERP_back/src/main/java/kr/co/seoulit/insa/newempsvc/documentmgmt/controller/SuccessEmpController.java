package kr.co.seoulit.insa.newempsvc.documentmgmt.controller;

import com.nexacro17.xapi.data.PlatformData;
import kr.co.seoulit.insa.newempsvc.documentmgmt.service.NDocumentMgmtService;
import kr.co.seoulit.insa.newempsvc.documentmgmt.to.SuccessEmpTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/documentmgmt/*")
@RestController
public class SuccessEmpController {
	@Autowired
	private NDocumentMgmtService documentMgmtService;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;

	//@RequestMapping("newempSuccess")
	@PostMapping("newempSuccess")
	public void findNewEmpSuccess(@RequestAttribute("resData") PlatformData resData,
							  @RequestAttribute("reqData") PlatformData reqData) throws Exception{

		int year = reqData.getVariable("year").getInt();
		String half = reqData.getVariable("half").getString();
		//String workplaceCode = reqData.getVariable("value").getString();
		System.out.println(year + half);
		ArrayList<SuccessEmpTO> list = documentMgmtService.findNewEmpSuccess(year, half);
		System.out.println(list);

		datasetBeanMapper.beansToDataset(resData, list, SuccessEmpTO.class);
	}
}
