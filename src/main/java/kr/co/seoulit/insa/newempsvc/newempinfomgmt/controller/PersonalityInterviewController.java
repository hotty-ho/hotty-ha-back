package kr.co.seoulit.insa.newempsvc.newempinfomgmt.controller;

import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.VariableList;
import kr.co.seoulit.insa.newempsvc.newempinfomgmt.service.NewEmpInfoService;
import kr.co.seoulit.insa.newempsvc.newempinfomgmt.to.PersonalityInterviewTO;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequestMapping("/newempinfomgmt/*")
@RestController
public class PersonalityInterviewController
{
	@Autowired
	private NewEmpInfoService newempInfoService;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	@PostMapping("piresultnewemp")
	public void PersonalityInterview(@RequestAttribute("reqData") PlatformData reqData,
									 @RequestAttribute("resData") PlatformData resData) throws Exception {

		VariableList varList = reqData.getVariableList();
		List<String> keys = varList.keyList();

		HashMap<String, Object> map = new HashMap<>();

		for(String key : keys){
			String value = varList.get(key).getString();
				map.put(key, value);
		}

		ArrayList<PersonalityInterviewTO> list = newempInfoService.findPInewempList(map);
		datasetBeanMapper.beansToDataset(resData, list, PersonalityInterviewTO.class);
	}
}
