package kr.co.seoulit.insa.testdaylabr;

import com.nexacro17.xapi.data.PlatformData;
import kr.co.seoulit.insa.sys.mapper.DatasetBeanMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/daylabormgmt/*")
public class DayLaborController {

    @Autowired
    private DayLaborServiceImpl dayLaborService;
    @Autowired
    private DatasetBeanMapper datasetBeanMapper;

    @RequestMapping("register")
    public void registdaylabor(@RequestAttribute("reqData") PlatformData reqData,
                               @RequestAttribute("resData") PlatformData resData) throws Exception{
        log.info("registdaylabor 실행");

//        log.info("reqData={}",new Debugger().detail(reqData.getDataSetList().get(0)));
        DayLaborTO dl = datasetBeanMapper.datasetToBean(reqData, DayLaborTO.class);
        dayLaborService.registerDl(dl);
    }
}
