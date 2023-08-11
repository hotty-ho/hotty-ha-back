package kr.co.seoulit.insa.testdaylabr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DayLaborServiceImpl {

    @Autowired
    private DayLaborRepository dayLaborRepository;
    public void registerDl(DayLaborTO dayLaborTO) {
        log.info("registerDl={}",dayLaborTO);
        dayLaborRepository.save(dayLaborTO);
    }
}
