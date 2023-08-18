package kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.controller;

import java.util.ArrayList;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexacro17.xapi.data.PlatformData;

import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.service.SalaryStdInfoMgmtService;
import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.to.BaseExtSalTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;


@RequestMapping("/salarystdinfomgmt/*")
@RestController
@RequiredArgsConstructor
public class BaseExtSalController {
	
	private final SalaryStdInfoMgmtService salaryStdInfoMgmtService;
	private final DatasetBeanMapper datasetBeanMapper;
	//👇ModelMap은 스프링 프레임워크에서 사용되는 클래스로
	//  컨트롤러에서 뷰(View)에 데이터를 전달하는 데에 사용
	//  컨트롤러의 메서드에서 ModelMap 객체를 인자로 받아서 데이터를 담고,
	//  이후에 뷰로 전달하거나 다른 컴포넌트에게 넘겨주는 등의 작업을 수행

	//✅(체크해봐야될 사항)
	// ModelMap map = null;은 BaseExtSalController 클래스 내에서 멤버 변수로 선언되었습니다.
	// 그러나 해당 변수는 사용되지 않으며, 컨트롤러 메서드에서 리턴값으로 ModelMap을 반환하지 않기 때문에
	// 실제로는 사용되지 않는 변수입니다. 코드에서 불필요한 부분으로 보입니다.
	//
	// ModelMap 객체는 메서드의 인자로 넘겨받거나,
	// 메서드에서 리턴값으로 반환하거나, 메서드 내에서 @ModelAttribute 어노테이션을
	// 이용하여 선언하여 사용할 수 있습니다.
	//
	// 그러나 해당 코드에서는 선언만 되고 실제로
	// 사용되지 않았기 때문에 해당 코드는 삭제해도 문제가 없을 것
	ModelMap map = null;

	@RequestMapping("/salarystdinfomgmt/over-sal")
	public ModelMap findBaseExtSalList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{

		ArrayList<BaseExtSalTO> baseExtSalList = salaryStdInfoMgmtService.findBaseExtSalList();
		
		datasetBeanMapper.beansToDataset(resData, baseExtSalList, BaseExtSalTO.class);
		return map;
	}

	
	@RequestMapping("/salarystdinfomgmt/over-sal-create")
	public ModelMap modifyBaseExtSalList(@RequestAttribute("reqData") PlatformData reqData,
			@RequestAttribute("resData") PlatformData resData) throws Exception{
		
		ArrayList<BaseExtSalTO> baseExtSalList = (ArrayList<BaseExtSalTO>)datasetBeanMapper.datasetToBeans(reqData, BaseExtSalTO.class);
		
		salaryStdInfoMgmtService.modifyBaseExtSalList(baseExtSalList);
		
		return null;
	}
	
}
